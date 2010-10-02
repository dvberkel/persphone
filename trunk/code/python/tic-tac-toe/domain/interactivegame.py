#!/usr/bin/env python

from replayablegame import ReplayableGame
from pattern.notify.observable import Observable
from pattern.factory import piecefactory
from domain.player import RandomPlayer

class InteractiveGame(ReplayableGame,Observable):
	def __init__(self,noughtPlayer,crossPlayer):
		ReplayableGame.__init__(self,piecefactory.nought)
		Observable.__init__(self)
		self._players = {True:noughtPlayer, False:crossPlayer}
		self._currentKey = True
	
	def start(self):
		self.notifyObservers()
		while len(self.playableCells()) > 0:
			player = self._players[self._currentKey]
			cell = player.strategy(self)
			self.play(cell)
			self._currentKey = not self._currentKey
			self.notifyObservers()

if __name__ == '__main__':
	game = InteractiveGame(RandomPlayer(),RandomPlayer())
	game.start()
	assert game.over
