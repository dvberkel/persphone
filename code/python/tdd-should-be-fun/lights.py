class Button():
	def __init__(self):
		self._state = False
		self._neighbours = []
	
	def isOn(self):
		return self._state
	
	def press(self):
		self._switch()
		for other in self.neighbours():
			other._switch()
	
	def _switch(self):
		self._state = not self._state
	
	def connect(self, other):
		self._neighbours.append(other)
		other._neighbours.append(self)
	
	def neighbours(self):
		return self._neighbours[:]

def test1():
	button = Button()
	assert not button.isOn()

def test2():
	button = Button()
	button.press()
	assert button.isOn()

def test3():
	this = Button()
	that = Button()
	
	this.connect(that)
	assert this in that.neighbours()
	assert that in this.neighbours()

def test4():
	this = Button()
	that = Button()
	
	this.connect(that)
	this.press()
	assert that.isOn()
	
if __name__ == '__main__':
	test1()
	test2()
	test3()
	test4()
