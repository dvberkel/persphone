#! /usr/bin/env python

import domain.piece.PieceFactory
from Observable import Observable
import Observer

class Cell(Observable):
	def __init__(self):
		Observable.__init__(self)
		self.piece = domain.piece.PieceFactory.empty
	
	def playable(self):
		return self.piece == domain.piece.PieceFactory.empty

	def place(self,piece):
		assert self.playable()
		self.piece = piece
		self.notifyObservers()
		
if __name__ == '__main__':
	assert Cell()
	
	cell = Cell()
	assert cell.playable()
	cell.place(domain.piece.PieceFactory.cross)
	assert cell.piece == domain.piece.PieceFactory.cross
	assert not cell.playable()
	
	observer = Observer.TestObserver()
	cell = Cell()
	cell.subscribe(observer)
	cell.place(domain.piece.PieceFactory.cross)
	assert observer.count == 1
