#!/usr/bin/env python

from domain.line.Line import Line

class LineFactory():
	def __init__(self):
		self.upper = Line()
		self.middle = Line()
		self.lower = Line()
		self.left = Line()
		self.center = Line()
		self.right = Line()
		self.slash = Line()
		self.backslash = Line()
	
	def lines(self):
		return [self.upper,self.middle,self.lower,self.left,self.center,self.right,self.slash,self.backslash]


if __name__ == '__main__':
	assert LineFactory()
	assert len(LineFactory().lines()) == 8

