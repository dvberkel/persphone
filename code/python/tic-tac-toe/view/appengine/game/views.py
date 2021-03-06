from django.template import Context
from django.shortcuts import render_to_response

import uuid
from google.appengine.api import users
from view.appengine.game.models import GameModel
from view.appengine.game.models import PlyModel
from view.appengine.game.models import GameSequenceModel
from domain.replayablegame import ReplayableGame
from pattern.factory import piecefactory

symbolFor = {piecefactory.nought: 'O', piecefactory.cross: 'X', piecefactory.empty: '_'}

def new(request):
	gameSequenceModel = getGameSequenceModel()
	gameSequenceModel.sequenceId = gameSequenceModel.sequenceId + 1
	gameSequenceModel.put()
	gameModel = GameModel(owner=gameSequenceModel.owner,uuid=str(uuid.uuid4()),over=False,index=gameSequenceModel.sequenceId)
	gameModel.put()
	context = createContextFilling(request,gameModel.uuid)
	return render_to_response('game/history.html', context)

def getGameSequenceModel():
	gameSequenceQuery = GameSequenceModel.all();
	gameSequenceQuery.filter('owner = ', users.get_current_user())
	gameSequenceModel = gameSequenceQuery.get()
	if not gameSequenceModel:
		gameSequenceModel = GameSequenceModel(owner=users.get_current_user(),sequenceId=0)
		gameSequenceModel.put()
	return gameSequenceModel;

def overview(request):
	activeQuery = gameModelQuery(False)
	activeGames = activeQuery.fetch(100) # TODO pagination
	finishedQuery = gameModelQuery(True)
	finishedGames = finishedQuery.fetch(100) # TODO pagination
	context = Context({
		'signout': users.create_logout_url(request.path),
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
	contextFilling = createContextFilling(request,game_uuid,ply)
	return render_to_response('game/history.html',Context(contextFilling))

def play(request,game_uuid,move):
	gameQuery = GameModel.all()
	gameQuery.filter('uuid = ', game_uuid)
	gameModel = gameQuery.get()
	if (gameModel):
		game, numberOfPlies = replayedGame(gameModel,9)
		if (move and game.toCell(move).playable()):
			plyModel = PlyModel(game_uuid = gameModel.uuid,index = numberOfPlies + 1, representation = move)
			plyModel.put()
			game.play(game.toCell(move))
			if (game.over or len(game.playableCells()) == 0):
				gameModel.over = True
				gameModel.put()
	context = createContextFilling(request, game_uuid)
	return render_to_response('game/history.html', context)

def createContextFilling(request,game_uuid,ply=9):
	contextFilling = {'signout': users.create_logout_url(request.path)}
	gameQuery = GameModel.all()
	gameQuery.filter('uuid = ', game_uuid)
	gameModel = gameQuery.get()
	if (gameModel):
		contextFilling['game_uuid'] = gameModel.uuid
		contextFilling['game_index'] = gameModel.index
		game, numberOfPlies = replayedGame(gameModel,ply)
		for representation in game.representations:
			cell = representation.cell
			representation = representation.name
			contextFilling[representation] = symbolFor[cell.piece]
			if (not gameModel.over and cell.playable()):
				contextFilling['play' + representation] = representation
				
		if (gameModel.over):
			ply = min(int(ply),numberOfPlies)
			if (ply > 1):
				contextFilling['prevPly'] = ply-1
			elif (ply == 1):
				contextFilling['prevPly'] = '00'
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
	
