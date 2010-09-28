#!/usr/bin/env python

from Game import Game
from Observable import Observable
from domain.piece import PieceFactory
import Player

class InteractiveGame(Game,Observable):
	def __init__(self,noughtPlayer,crossPlayer):
		Game.__init__(self,PieceFactory.nought)
		Observable.__init__(self)
		self.players = {True:noughtPlayer, False:crossPlayer}
		self.currentKey = True
	
	def start(self):
		self.notifyObservers()
		while len(self.playableCells()) > 0:
			player = self.players[self.currentKey]
			cell = player.strategy(self)
			self.play(cell)
			self.currentKey = not self.currentKey
			self.notifyObservers()

if __name__ == '__main__':
	game = InteractiveGame(Player.RandomPlayer(),Player.RandomPlayer())
	game.start()
	assert game.over
