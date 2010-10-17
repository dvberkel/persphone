class Robot():
	def __init__(self):
		self.location = [0,0]
		self.heading = [1,0]
	
	def forward(self):
		self.location[0] += self.heading[0]
		self.location[1] += self.heading[1]
		return self
	
	def left(self):
		self.heading = [-self.heading[1],self.heading[0]]
		return self
	
	def right(self):
		self.heading = [self.heading[1],-self.heading[0]]
		return self
	
	def load(self, program):
		self.program = program
	
	def execute(self):
		tokenizer = Tokenizer(self.program)
		token = tokenizer.next()
		while (token):
			if (token.concept == 'MOVE'):
				if (token.value == 'F'):
					self.forward()
				if (token.value == 'L'):
					self.left()
				if (token.value == 'R'):
					self.right()
			token = tokenizer.next()

class Tokenizer():
	def __init__(self, program):
		self.program = program
		self. index = 0
	
	def next(self):
		if (self.index < len(self.program)):
			if (self.program[self.index] in 'FLR'):
				value = self.program[self.index]
				self.index += 1
				return Token('MOVE',value)
		else:
			return None	

class Token():
	def __init__(self,concept,value):
		self.concept = concept
		self.value = value

def test0():
	robot = Robot()
	
	assert robot.location == [0,0]

def test1():
	robot = Robot()
	
	robot.forward().forward()
	
	assert robot.location == [2,0]

def test2():
	robot = Robot()
	
	robot.left().forward()
	assert robot.location == [0,1]

	robot.right().forward()
	assert robot.location == [1,1]

def test3():
	robot = Robot()
	
	robot.load('FLFRF')
	robot.execute()
	
	assert robot.location == [2,1]

def test4():
	robot = Robot()
	
	robot.load('5FL3F')
	robot.execute()
	
	assert robot.location == [5,3]


if __name__ == '__main__':
	test0()
	test1()
	test2()
	test3()
