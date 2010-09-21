#! /usr/bin/env python

class Piece():
	pass
	
class Nought(Piece):
	pass

class Cross(Piece):
	pass

class Empty(Piece):
	pass

class PieceFactory():
	nought = Nought()
	cross = Cross()
	empty = Empty()
	
if __name__ == '__main__':
	assert PieceFactory.nought == PieceFactory.nought
	assert PieceFactory.nought != PieceFactory.cross
	assert PieceFactory.nought != PieceFactory.empty
	assert PieceFactory.cross == PieceFactory.cross
	assert PieceFactory.cross != PieceFactory.nought
	assert PieceFactory.cross != PieceFactory.empty
	assert PieceFactory.empty == PieceFactory.empty
	assert PieceFactory.empty != PieceFactory.nought
	assert PieceFactory.empty != PieceFactory.cross
