import logging

from google.appengine.api import users
from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app

class MainPage(webapp.RequestHandler):
	def get(self):
		user = users.get_current_user()

		if user:
			logging.info('user %s logged in' % user.nickname())
			self.response.headers['Content-Type'] = 'text/plain'
			self.response.out.write('Welcome to the tic tac toe client!')
		else:
			self.redirect(users.create_login_url(self.request.uri))		

application = webapp.WSGIApplication(
	[('/', MainPage)],
	debug=True)

def main():
	logging.getLogger().setLevel(logging.DEBUG)
	run_wsgi_app(application)

if __name__ == "__main__":
	main()
