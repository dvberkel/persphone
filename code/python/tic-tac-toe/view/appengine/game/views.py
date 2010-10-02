from django.http import HttpRequest
from django.http import HttpResponse
from django.template import Context, loader
from django.shortcuts import render_to_response

def overview(request):
	return render_to_response('game/overview.html', {})


def history(request,gameId):
	template = loader.get_template('game/history.html')
	context = Context({
		'gameId': gameId,
	})
	return HttpResponse(template.render(context))

