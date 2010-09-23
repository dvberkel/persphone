#! /usr/bin/env python

class Piece():
	def opponent(self):
		return None
	
class Nought(Piece):
	def opponent(self):
		return cross

class Cross(Piece):
	def opponent(self):
		return nought

class Empty(Piece):
	pass

nought = Nought()
cross = Cross()
empty = Empty()
	
if __name__ == '__main__':
	assert nought == nought
	assert nought != cross
	assert nought != empty
	assert cross == cross
	assert cross != nought
	assert cross != empty
	assert empty == empty
	assert empty != nought
	assert empty != cross
	assert nought.opponent() == cross
	assert cross.opponent() == nought
