AverageList := List clone

AverageList average := method(
	return ((self sum) / (self size))
)

AverageList with(1,2,3,4) average println
