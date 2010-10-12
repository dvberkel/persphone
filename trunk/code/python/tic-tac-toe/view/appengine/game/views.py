from django.template import Context
from django.shortcuts import render_to_response

import uuid
from google.appengine.api import users
from view.appengine.game.models import GameModel
from view.appengine.game.models import PlyModel
from domain.replayablegame import ReplayableGame
from pattern.factory import piecefactory

symbolFor = {piecefactory.nought: 'O', piecefactory.cross: 'X', piecefactory.empty: '_'}

def new(request):
	gameModel = GameModel(owner=users.get_current_user(),uuid=str(uuid.uuid4()),over=False)
	gameModel.put()
	context = createContextFilling(gameModel.uuid)
	return render_to_response('game/history.html', context)

def overview(request):
	activeQuery = gameModelQuery(False)
	activeGames = activeQuery.fetch(100) # TODO pagination
	finishedQuery = gameModelQuery(True)
	finishedGames = finishedQuery.fetch(100) # TODO pagination
	context = Context({
		'activeGames': activeGames,
		'finishedGames': finishedGames
	})
	return render_to_response('game/overview.html', context)

def gameModelQuery(gameOver):
	query = GameModel.gql("WHERE owner = :owner "
	                      "AND over = :over "
	                      "ORDER BY created DESC",
	                      owner = users.get_current_user(),over = gameOver)
	return query

def history(request,game_uuid,ply=9):
	contextFilling = createContextFilling(game_uuid,ply)
	return render_to_response('game/history.html',Context(contextFilling))

def play(request,game_uuid,move):
	gameQuery = GameModel.all()
	gameQuery.filter('uuid = ', game_uuid)
	gameModel = gameQuery.get()
	if (gameModel):
		game, numberOfPlies = replayedGame(gameModel,10)
		if (move and game.toCell(move).playable()):
			plyModel = PlyModel(game_uuid = gameModel.uuid,index = numberOfPlies + 1, representation = move)
			plyModel.put()
			game.play(game.toCell(move))
			if (game.over):
				gameModel.over = True
				gameModel.put()
	context = createContextFilling(game_uuid)
	return render_to_response('game/history.html', context)

def createContextFilling(game_uuid,ply=9):
	contextFilling = {}
	gameQuery = GameModel.all()
	gameQuery.filter('uuid = ', game_uuid)
	gameModel = gameQuery.get()
	if (gameModel):
		contextFilling['game_uuid'] = gameModel.uuid
		game, numberOfPlies = replayedGame(gameModel,ply)
		for representation in game.representations:
			cell = representation[0]
			representation = representation[1]
			contextFilling[representation] = symbolFor[cell.piece]
			if (not gameModel.over and cell.playable()):
				contextFilling['play' + representation] = representation
				
		if (gameModel.over):
			ply = min(int(ply),numberOfPlies)
			if (ply > 0):
				contextFilling['prevPly'] = ply-1
			if (ply < numberOfPlies):
				contextFilling['nextPly'] = ply+1
			
	return contextFilling

def replayedGame(gameModel, ply):
	plyQuery = PlyModel.all()
	plyQuery.filter('game_uuid = ', gameModel.uuid)
	plyQuery.order('index')
	plyModels = plyQuery.fetch(9)
	game = ReplayableGame(piecefactory.nought)
	representations = map((lambda x: x.representation), plyModels)[0:int(ply)]
	game.replay(representations)
	return game, len(plyModels)
	
