#! /usr/bin/env python

class Pair:
	x = 0
	y = 0
	
	def __init__(self, x, y):
		self.x = x
		self.y = y	
	
	def translate(self, dx, dy):
		return Pair(self.x + dx, self.y + dy)
	
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
		return True
		
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
	
	possible = set()
	possible.add(Pair(0,0))
	possible.add(Pair(1,0))
	possible.add(Pair(1,1))
	possible.add(Pair(0,1))
	
	unlockPatterns = PatternTree(None, None, possible)
	unlockPatterns.generate()
	
	visitor = Visitor()
	
	unlockPatterns.receiveVisitor(visitor)
	
	print "number of nodes " + str(visitor.count)
	for key in visitor.nodesAtDepth.keys():
		print str(key) + " -> " + str(visitor.nodesAtDepth[key])
