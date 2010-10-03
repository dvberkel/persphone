from django.http import HttpRequest
from django.http import HttpResponse
from django.template import Context, loader
from django.shortcuts import render_to_response

import uuid
from google.appengine.api import users
from google.appengine.ext import db
from view.appengine.game.models import GameModel

def new(request):
	gameModel = GameModel(owner=users.get_current_user(),uuid=str(uuid.uuid4()),over=False)
	gameModel.put()
	context = Context({
		'game_uuid': gameModel.uuid
	})
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
	template = loader.get_template('game/history.html')
	context = Context({
		'game_uuid': game_uuid,
		'prevPly': int(ply)-1,
		'nextPly': int(ply)+1
	})
	return HttpResponse(template.render(context))

