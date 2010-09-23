#!/usr/bin/env python

from Observer import Observer
from Observable import Observable
import PieceFactory
import Cell

class Line(Observer,Observable):
	def __init__(self):
		Observable.__init__(self)
		self.numberOf = {PieceFactory.nought:0, PieceFactory.cross:0}
		
	def notify(self, observable):
		self.numberOf[observable.piece] += 1
		if 3 in self.numberOf.values():
			self.notifyObservers()
	
	def leader(self):
		if len(self.numberOf.values()) != 1:
			leader = self.numberOf.items()
			leader.sort(cmp=(lambda x, y: y[1] - x[1]))
			return map((lambda t: t[0]), leader)[0]
		else:
			return None	
	
if __name__ == '__main__':
	line = Line()
	assert line.numberOf[PieceFactory.nought] == 0
	print line.numberOf.values()
	assert line.leader() == None
	
	cell = Cell.Cell()
	cell.subscribe(line)
	cell.place(PieceFactory.nought)
	assert line.numberOf[PieceFactory.nought] == 1
	assert line.leader() == PieceFactory.nought
