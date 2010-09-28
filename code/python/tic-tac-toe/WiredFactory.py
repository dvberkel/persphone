#!/usr/bin/env python

from domain.cell.CellFactory import CellFactory
from LineFactory import LineFactory
from pattern.observer.Observer import Observer

class WiredFactory(CellFactory,LineFactory,Observer):
	def __init__(self):
		CellFactory.__init__(self)
		LineFactory.__init__(self)
		self.wire()
	
	def wire(self):
		self.wireCells()
		self.wireLines()
	
	def wireCells(self):
		self.wireCellsTo([self.upperLeft, self.upperCenter, self.upperRight], self.upper)
		self.wireCellsTo([self.middleLeft, self.middleCenter, self.middleRight], self.middle)
		self.wireCellsTo([self.lowerLeft, self.lowerCenter, self.lowerRight], self.lower)
		self.wireCellsTo([self.upperLeft, self.middleLeft, self.lowerLeft], self.left)
		self.wireCellsTo([self.upperCenter, self.middleCenter, self.lowerCenter], self.center)
		self.wireCellsTo([self.upperRight, self.middleRight, self.lowerRight], self.right)
		self.wireCellsTo([self.upperLeft, self.middleCenter, self.lowerRight], self.slash)
		self.wireCellsTo([self.lowerLeft, self.middleCenter, self.upperRight], self.backslash)		
	
	def wireCellsTo(self, cells, line):
		for cell in cells:
			cell.subscribe(line)
	
	def wireLines(self):
		for line in self.lines():
			line.subscribe(self)

if __name__ == '__main__':
	assert WiredFactory()


