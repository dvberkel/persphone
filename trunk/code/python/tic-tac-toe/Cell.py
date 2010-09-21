#! /usr/bin/env python

from PieceFactory import PieceFactory

class Cell():
	def __init__(self,*piece):
		if (len(piece) > 0):
			self.piece = piece[0]
		else:
			self.piece = PieceFactory.empty
	
	def playable(self):
		return self.piece == PieceFactory.empty

	def place(self,piece):
		assert self.playable()
		self.piece = piece
		
if __name__ == '__main__':
	assert Cell()
	assert Cell(PieceFactory.cross)
	
	cell = Cell()
	assert cell.playable()
	cell.place(PieceFactory.cross)
	assert cell.piece == PieceFactory.cross
	
	cell = Cell(PieceFactory.cross)
	assert not cell.playable
