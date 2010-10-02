#!/usr/bin/env python

from game import Game
from pattern.factory import piecefactory

class ReplayableGame(Game):
	def __init__(self,startPiece):
		Game.__init__(self,startPiece)

	def replay(self,representations):
		for representation in representations:
			cell = self.toCell(representation)
			self.play(cell)

if __name__ == '__main__':
	game = ReplayableGame(piecefactory.nought)
	game.replay(['ll','ml','mc','uc','ur'])
	assert game.over
