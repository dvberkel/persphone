#!/usr/bin/env python

import random

class Player():
	def __init__(self):
		pass	
	
	def strategy(self, game):
		return None

class RandomPlayer(Player):
	def __init__(self):
		Player.__init__(self)
		
	def strategy(self, game):
		options = game.playableCells()
		random.shuffle(options)
		return options[0]
		
if __name__ == '__main__':
	pass
