#! /usr/bin/env python

class Piece():
	pass
	
class Nought(Piece):
	pass

class Cross(Piece):
	pass

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
