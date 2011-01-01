class Robot():
	def __init__(self):
		self.location = [0,0]
		self.heading = [1,0]
		self.marks = []
	
	def forward(self,number=1):
		for turn in range(number):
			self.location[0] += self.heading[0]
			self.location[1] += self.heading[1]
		return self
		
	def left(self,number=1):
		for turn in range(number):
			self.heading = [-self.heading[1],self.heading[0]]
		return self
	
	def right(self,number=1):
		for turn in range(number):
			self.heading = [self.heading[1],-self.heading[0]]
		return self
	
	def load(self, program):
		self.program = program
		return self
	
	def execute(self):
		tokenizer = Tokenizer(self.program)
		token = tokenizer.next()
		while (token):
			self.executeToken(tokenizer,token)
			token = tokenizer.next()
		return self
	
	def executeToken(self,tokenizer,token):
		if (token.concept == 'MOVE'):
			if (token.value == 'F'):
				self.forward()
			if (token.value == 'L'):
				self.left()
			if (token.value == 'R'):
				self.right()
		if (token.concept == 'INT'):
			nextToken = tokenizer.next()
			for number in range(token.value):
				self.executeToken(tokenizer,nextToken)
		if (token.concept == 'MARK'):
			if (token.value == 'M'):
				self.pushMark()
			if (token.value == 'P'):
				self.popMark().execute()
	
	def plan(self,location):
		program = ''
		if self.heading == [-1,0]:
			program += '2R'
		elif self.heading == [0,1]:
			program += 'R'
		elif self.heading == [0,-1]:
			program += 'L'
		
		delta = [location[0] - self.location[0], location[1] - self.location[1]]
		if delta[0] < 0:
			program += '2R%dF2R' % abs(delta[0])
		elif delta[0] > 0:
			program += '%dF' % abs(delta[0])
		
		if delta[1] < 0:
			program += 'R%dFL' % abs(delta[1])
		elif delta[1] > 0:
			program += 'L%dFR' % abs(delta[1])
		
		return self.load(program)		
	
	def pushMark(self):
		self.marks.append(self.location[:])
		return self
	
	def popMark(self):
		self.plan(self.marks.pop())
		return self
	
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
			if (self.program[self.index] in '0123456789'):
				start = self.index
				while (self.program[self.index] in '0123456789'):
					self.index += 1
				return Token('INT',int(self.program[start:self.index]))
			if (self.program[self.index] in 'MP'):
				value = self.program[self.index]
				self.index += 1
				return Token('MARK',value)
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
	robot.forward(3)
	assert robot.location == [3,0]

	robot.left(3).forward().right(2).forward(2)
	assert robot.location == [3,1]
	
def test4():
	robot = Robot()
	robot.load('FLFRF')
	robot.execute()
	assert robot.location == [2,1]

def test5():
	robot = Robot()
	robot.load('5FL3F').execute()
	assert robot.location == [5,3]

def test6():
	robot = Robot()
	robot.plan([8,5])
	assert robot.location == [0,0] # Robots can not teleport!
	robot.execute()
	assert robot.location == [8,5]
	
	robot.forward()
	assert robot.location == [9,5]
	
	robot.plan([2,1]).execute()
	assert robot.location == [2,1]

def test7():
	robot = Robot()
	robot.pushMark()
	robot.forward(8).left().forward(5)
	robot.pushMark().forward(3).left().forward(5)
	assert robot.location == [3,8]
	
	robot.popMark().execute()
	assert robot.location == [8,5]

def test8():
	robot = Robot()
	robot.load('5FM8FL3F').execute()
	assert robot.location == [13,3]
	
	robot.popMark().execute()
	assert robot.location == [5,0]

def test9():
	robot = Robot()
	robot.load('M21FR34FPFLF').execute()
	assert robot.location == [1,1]

if __name__ == '__main__':
	test0()
	test1()
	test2()
	test3()
	test4()
	test5()
	test6()
	test7()
	test8()
	test9()
