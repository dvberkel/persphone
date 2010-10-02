from django.http import HttpRequest
from django.http import HttpResponse
from django.template import Context, loader
from django.shortcuts import render_to_response

def login(request):
	return render_to_response('base.html', {})
