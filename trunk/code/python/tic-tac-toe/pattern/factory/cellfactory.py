#! /usr/bin/env python

from domain.cell import Cell

class CellFactory():
	def __init__(self):
		self.upperLeft = Cell()
		self.upperCenter = Cell()
		self.upperRight = Cell()
		self.middleLeft = Cell()
		self.middleCenter = Cell()
		self.middleRight = Cell()
		self.lowerLeft = Cell()
		self.lowerCenter = Cell()
		self.lowerRight = Cell()
	
	def cells(self):
		return [self.upperLeft,self.upperCenter,self.upperRight,self.middleLeft,self.middleCenter,self.middleRight,self.lowerLeft,self.lowerCenter,self.lowerRight]

if __name__ == '__main__':
	factory = CellFactory()
	assert len(factory.cells()) == 9
