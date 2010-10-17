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
		for command in self.program:
			if (command == 'F'):
				self.forward()
			if (command == 'L'):
				self.left()
			if (command == 'R'):
				self.right();

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


if __name__ == '__main__':
	test0()
	test1()
	test2()
	test3()
