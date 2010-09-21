#! /usr/bin/env python

class Position():
	def __init__(self):
		pass	

	def __str__(self):
		return self.horizontal() + ' ' + self.vertical()

class Left(Position):
	def vertical(self):
		return 'left'

class Center(Position):
	def vertical(self):
		return 'center'

class Right(Position):
	def vertical(self):
		return 'right'

class Upper(Position):
	def horizontal(self):
		return 'upper'

class Middle(Position):
	def horizontal(self):
		return 'middle'

class Lower(Position):
	def horizontal(self):
		return 'lower'
		
class UL(Upper,Left):
	def __init__(self):
		pass

class UC(Upper,Center):
	def __init__(self):
		pass

class UR(Upper,Right):
	def __init__(self):
		pass

class ML(Middle,Left):
	def __init__(self):
		pass

class MC(Middle,Left):
	def __init__(self):
		pass

class MR(Middle,Right):
	def __init__(self):
		pass

class LL(Lower,Left):
	def __init__(self):
		pass

class LC(Lower,Center):
	def __init__(self):
		pass

class LR(Lower,Right):
	def __init__(self):
		pass

if __name__ == '__main__':
	assert str(UL()) == 'upper left'
