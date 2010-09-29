#! /usr/bin/env python

class Observer():
	def notify(self, observable):
		pass
		
class TestObserver(Observer):
	def __init__(self):
		self.count = 0;
	
	def notify(self,observable):
		self.count += 1

if __name__ == '__main__':
	observer = TestObserver()
	assert observer.count == 0
	observer.notify(None)
	assert observer.count == 1
	
