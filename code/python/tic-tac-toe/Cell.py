#! /usr/bin/env python

from domain.piece import PieceFactory
from Observable import Observable
import Observer

class Cell(Observable):
	def __init__(self):
		Observable.__init__(self)
		self.piece = PieceFactory.empty
	
	def playable(self):
		return self.piece == PieceFactory.empty

	def place(self,piece):
		assert self.playable()
		self.piece = piece
		self.notifyObservers()
		
if __name__ == '__main__':
	assert Cell()
	
	cell = Cell()
	assert cell.playable()
	cell.place(PieceFactory.cross)
	assert cell.piece == PieceFactory.cross
	assert not cell.playable()
	
	observer = Observer.TestObserver()
	cell = Cell()
	cell.subscribe(observer)
	cell.place(PieceFactory.cross)
	assert observer.count == 1
