#!/usr/bin/env python

from pattern.observer.observer import Observer
from pattern.observer.observable import Observable
from domain.piece import piecefactory
from domain.cell.cell import Cell

class Line(Observer,Observable):
	def __init__(self):
		Observable.__init__(self)
		self.numberOf = {piecefactory.nought:0, piecefactory.cross:0}
		
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
	assert line.numberOf[piecefactory.nought] == 0
	assert line.leader() == None
	
	cell = Cell()
	cell.subscribe(line)
	cell.place(piecefactory.nought)
	assert line.numberOf[piecefactory.nought] == 1
	assert line.leader() == piecefactory.nought
