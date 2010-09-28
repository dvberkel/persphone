#! /usr/bin/env python

import observer

class Observable:
	def __init__(self):
		self._observers = []
	
	def subscribe(self,observer):
		self._observers.append(observer) # only if it is an observer
	
	def notifyObservers(self):
		for observer in self._observers:
			observer.notify(self)
	
if __name__ == '__main__':
	observer = observer.TestObserver()
	
	observable = Observable()
	observable.subscribe(observer)
	
	observable.notifyObservers()
	
	assert observer.count == 1
