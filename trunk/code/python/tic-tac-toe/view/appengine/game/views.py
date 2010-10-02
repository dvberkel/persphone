from django.http import HttpRequest
from django.http import HttpResponse
from django.template import Context, loader
from django.shortcuts import render_to_response

import uuid
from google.appengine.api import users
from view.appengine.game.models import GameModel

def new(request):
	gameModel = GameModel(owner=users.get_current_user(),uuid=str(uuid.uuid4()),over=False)
	gameModel.put()
	context = Context({
		'game_uuid': gameModel.uuid
	})
	return render_to_response('game/history.html', context)

def overview(request):
	return render_to_response('game/overview.html', {})

def history(request,game_uuid,ply=10):
	template = loader.get_template('game/history.html')
	context = Context({
		'game_uuid': game_uuid,
		'prevPly': int(ply)-1,
		'nextPly': int(ply)+1
	})
	return HttpResponse(template.render(context))

