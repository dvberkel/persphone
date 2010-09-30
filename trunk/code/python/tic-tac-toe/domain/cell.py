#! /usr/bin/env python

from pattern.factory import piecefactory
from pattern.notify.observable import Observable
from pattern.notify.observer import TestObserver

class Cell(Observable):
	def __init__(self):
		Observable.__init__(self)
		self.piece = piecefactory.empty
	
	def playable(self):
		return self.piece == piecefactory.empty

	def place(self,piece):
		assert self.playable()
		self.piece = piece
		self.notifyObservers()
		
if __name__ == '__main__':
	assert Cell()
	
	cell = Cell()
	assert cell.playable()
	cell.place(piecefactory.cross)
	assert cell.piece == piecefactory.cross
	assert not cell.playable()
	
	observer = TestObserver()
	cell = Cell()
	cell.subscribe(observer)
	cell.place(piecefactory.cross)
	assert observer.count == 1
