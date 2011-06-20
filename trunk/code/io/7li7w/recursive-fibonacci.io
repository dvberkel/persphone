Fibonacci := Object clone

Fibonacci calculate := method(n,
	if(n == 0, return 0)
	if(n == 1, return 1)
	return self calculate(n-1) + self calculate(n-2)
)

Fibonacci calculate(1) println
Fibonacci calculate(4) println
Fibonacci calculate(10) println
