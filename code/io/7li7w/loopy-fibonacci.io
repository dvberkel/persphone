Fibonacci := Object clone

Fibonacci calculate := method(n,
	a := 0
	b := 1
	while(n > 0,
		tmp := a
		a := b
		b := tmp + a
		n := n - 1
	)
	return a
)

Fibonacci calculate(1) println
Fibonacci calculate(4) println
Fibonacci calculate(10) println
