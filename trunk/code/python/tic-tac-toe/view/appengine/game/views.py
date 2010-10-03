from django.http import HttpRequest
from django.http import HttpResponse
from django.template import Context, loader
from django.shortcuts import render_to_response

import uuid
from google.appengine.api import users
from google.appengine.ext import db
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

def history(request,game_uuid,ply=10):
	contextFilling = createContextFilling(game_uuid,ply)
	return render_to_response('game/history.html',Context(contextFilling))

def createContextFilling(game_uuid,ply=10):
	contextFilling = {}
	gameQuery = GameModel.all()
	gameQuery.filter('uuid = ', game_uuid)
	gameModel = gameQuery.get()
	if (gameModel):
		contextFilling['game_uuid'] = gameModel.uuid
		game = replayedGame(gameModel,ply)
		for representation in game.representations:
			contextFilling[representation[1]] = symbolFor[representation[0].piece]
			if (not gameModel.over and representation[0])
				
		if (gameModel.over):
			contextFilling['prevPly'] = int(ply)-1
			contextFilling['nextPly'] = int(ply)+1
			
	return contextFilling

def replayedGame(gameModel, ply):
	plyQuery = PlyModel.all()
	plyQuery.filter('game_uuid = ', gameModel.uuid)
	plyQuery.order('index')
	plies = plyQuery.fetch(ply)
	game = ReplayableGame(piecefactory.nought)
	for ply in plies:
		game.replay(ply.representation)
	return game
	
