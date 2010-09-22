#! /usr/bin/env python

from PositionFactory import PositionFactory
from Observer import Observer

class Board(PositionFactory,Observer):
	def __init__(self):
		PositionFactory.__init__(self)

if __name__ == '__main__':
	assert Board().upperLeft
