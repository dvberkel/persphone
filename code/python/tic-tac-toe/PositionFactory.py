#! /usr/bin/env python

from domain.cell.Cell import Cell

class PositionFactory():
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
	factory = PositionFactory()
	assert len(factory.cells()) == 9
