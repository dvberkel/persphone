#! /usr/bin/env python

def gcd(a,b):
	if a == 0:
		return b
	elif b == 0:
		return a
	else:
		return gcd(b, a % b)

def sign(a):
	if a >= 0:
		return 1
	else:
		return -1

def grid(size):
	result = set()
	
	for x in range(size):
		for y in range(size):
			result.add(Pair(x,y))
	
	return result

class Pair:
	x = 0
	y = 0
	
	def __init__(self, x, y):
		self.x = x
		self.y = y
	
	def translate(self, dx, dy):
		return Pair(self.x + dx, self.y + dy)
	
	def pairsInBetween(self, target):
		dx = target.x - self.x
		dy = target.y - self.y
		
		d = gcd(abs(dx),abs(dy));
		
		dx = sign(dx) * (abs(dx) / d)
		dy = sign(dy) * (abs(dy) / d)
			
		inBetween = set()
		pair = self.translate(dx, dy)
		while not pair == target:
			inBetween.add(pair)
			pair = pair.translate(dx,dy)
		
		return inBetween

	def __eq__(self, other):
		if (other == None):
			return False
		
		return self.x == other.x and self.y == other.y
	
	def __hash__(self):
		prime = 37
		
		result = 1
		result = prime * result + self.x
		result = prime * result + self.y
		
		return result		
	
	def __str__(self):
		return "(" + str(self.x) + "," + str(self.y) + ")"

class PatternTree:
	parent = None
	patternElement = None
	possible = set()
	children = set()
	
	def __init__(self, parent, patternElement, possible):
		self.parent = parent
		self.patternElement = patternElement
		self.possible = possible
		self.children = set()
	
	def generate(self):
		for patternElement in self.possible:
			nextPossible = self.possible.copy()
			nextPossible.remove(patternElement)
			
			if (self.reachable(patternElement)):
				child = PatternTree(self,patternElement,nextPossible)
				self.children.add(child)
				child.generate()
				 
	
	def reachable(self, target):
		if self.patternElement == None:
			return True
		else:
			obstructions = self.patternElement.pairsInBetween(target)
			
			return len(self.possible.intersection(obstructions)) == 0
		
	def depth(self):
		if self.parent != None:
			return 1 + self.parent.depth()
		else:
			return 0
	
	def receiveVisitor(self, visitor):
		if hasattr(visitor,"performAction"):
			visitor.performAction(self)
		
		for child in self.children:
			child.receiveVisitor(visitor);


class Visitor:
	count = 0
	nodesAtDepth = {}
	
	def __init__(self):
		self.count = 0;
		self.nodesAtDepth = {}

	def performAction(self, patternTree):
		self.count = self.count + 1;
		
		depth = patternTree.depth()
		if self.nodesAtDepth.has_key(depth):
			self.nodesAtDepth[depth] = self.nodesAtDepth[depth] + 1
		else:
			self.nodesAtDepth[depth] = 1

if __name__ == "__main__":
	
	possible = grid(3)
	
	unlockPatterns = PatternTree(None, None, possible)
	unlockPatterns.generate()
	
	visitor = Visitor()	
	unlockPatterns.receiveVisitor(visitor)
	
	print "number of nodes " + str(visitor.count)
	for key in visitor.nodesAtDepth.keys():
		print str(key) + " -> " + str(visitor.nodesAtDepth[key])
