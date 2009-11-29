Read("base.g");

munchausen := function(coefficients)
	local sum, index, coefficient;
	sum := 0;
	for coefficient in coefficients do
		sum := sum + coefficient^coefficient;
	od;
	return sum;
end;

bound := function(b)
	return 2*b^b;
end;

collectMunchausen := function(b)
	local numbers, max, n, coefficients, sum;
	numbers := [];
	max := bound(b);
	n := 1;	coefficients := base(n,b);
	while n <= max do
		sum := munchausen(coefficients);

		if (n = sum) then
			Add(numbers,n);
		fi;
	
		n := n + 1; coefficients := next(coefficients, b);
	od;
	return numbers;
end;

showMunchausen := function(upToBase)
	local b, max, numbers, coefficients;
	for b in [2..upToBase] do
		max := bound(b);
		Print(b, " ; ", max, "\n");
		numbers := collectMunchausen(b);
		for number in numbers do
			Print(number, " ");
		od;
		Print("\n");
	od;
end;

countMunchausen := function(upToBase)
	local b, max, numbers, coefficients;
	for b in [2..upToBase] do
		numbers := collectMunchausen(b);
		Print(Length(numbers), "\n");
	od;
end;

showMunchausen(4);
#countMunchausen(10);
