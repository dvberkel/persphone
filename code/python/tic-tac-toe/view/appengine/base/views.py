from django.shortcuts import render_to_response
from google.appengine.api import users

def login(request):
	return render_to_response('base.html', {'signout' : users.create_logout_url(request.path)})
