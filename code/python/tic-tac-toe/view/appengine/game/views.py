from django.http import HttpRequest
from django.http import HttpResponse
from django.template import Context, loader
from django.shortcuts import render_to_response

def overview(request):
	return render_to_response('game/overview.html', {})


def history(request,gameId,ply=10):
	template = loader.get_template('game/history.html')
	context = Context({
		'gameId': gameId,
		'prevPly': int(ply)-1,
		'nextPly': int(ply)+1
	})
	return HttpResponse(template.render(context))

