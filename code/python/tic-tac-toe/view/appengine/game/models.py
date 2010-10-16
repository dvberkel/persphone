from google.appengine.ext import db

class GameModel(db.Model):
	owner = db.UserProperty(required=True)
	uuid = db.StringProperty(required=True)
	over = db.BooleanProperty(required=True)
	index = db.IntegerProperty(required=True)
	created = db.DateTimeProperty(auto_now_add=True)

class PlyModel(db.Model):
	game_uuid = db.StringProperty(required=True)
	index = db.IntegerProperty(required=True)
	representation = db.StringProperty(required=True, choices=set(['ul','uc','ur','ml','mc','mr','ll','lc','lr']))

class GameSequenceModel(db.Model):
	owner = db.UserProperty(required=True)
	sequenceId = db.IntegerProperty(required=True)