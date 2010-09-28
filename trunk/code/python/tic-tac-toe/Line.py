#!/usr/bin/env python

from Observer import Observer
from Observable import Observable
from domain.piece import PieceFactory
from domain.cell import Cell

class Line(Observer,Observable):
	def __init__(self):
		Observable.__init__(self)
		self.numberOf = {PieceFactory.nought:0, PieceFactory.cross:0}
		
	def notify(self, observable):
		self.numberOf[observable.piece] += 1
		if 3 in self.numberOf.values():
			self.notifyObservers()
	
	def leader(self):
		values = self.numberOf.values()
		if min(values) != max(values):
			leader = self.numberOf.items()
			leader.sort(cmp=(lambda x, y: y[1] - x[1]))
			return map((lambda t: t[0]), leader)[0]
		else:
			return None	
	
if __name__ == '__main__':
	line = Line()
	assert line.numberOf[PieceFactory.nought] == 0
	assert line.leader() == None
	
	cell = Cell.Cell()
	cell.subscribe(line)
	cell.place(PieceFactory.nought)
	assert line.numberOf[PieceFactory.nought] == 1
	assert line.leader() == PieceFactory.nought
