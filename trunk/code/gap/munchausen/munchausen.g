Read("base.g");

munchausen := function(coefficients)
	local sum, index;
	sum := 0;
	for coefficient in coefficients do
		sum := sum + coefficient^coefficient;
	od;
	return sum;
end;

for b in [2..8] do
	max := 2*b^b;
	Print(b, " ; ", max, "\n");
	n := 1;	coefficients := base(n,b);
	while n <= max do
		sum := munchausen(coefficients);
	
		if (n = sum) then
			Print(coefficients);
			Print(" ", n, " : ", sum, "\n");
		fi;
		
		n := n + 1; coefficients := next(coefficients, b);
	od;
od;
