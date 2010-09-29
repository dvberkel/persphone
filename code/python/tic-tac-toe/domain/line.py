#!/usr/bin/env python

from pattern.observer import Observer
from pattern.observable import Observable
from domain.piece import piecefactory
from domain.cell import Cell

class Line(Observer,Observable):
	def __init__(self):
		Observable.__init__(self)
		self._numberOf = {piecefactory.nought:0, piecefactory.cross:0}
		
	def notify(self, observable):
		self._numberOf[observable.piece] += 1
		if 3 in self._numberOf.values():
			self.notifyObservers()
	
	def leader(self):
		values = self._numberOf.values()
		if min(values) != max(values):
			candidates = self._numberOf.items()
			candidates.sort(cmp=(lambda x, y: y[1] - x[1]))
			return map((lambda t: t[0]), candidates)[0]
		else:
			return None	
	
if __name__ == '__main__':
	line = Line()
	assert line.leader() == None
	
	cell = Cell()
	cell.subscribe(line)
	cell.place(piecefactory.nought)
	assert line.leader() == piecefactory.nought
