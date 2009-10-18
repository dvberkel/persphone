Read("base.g");

munchausen := function(coefficients)
	local sum, index;
	sum := 0;
	for index in coefficients do
		sum := sum + index^index;
	od;
	return sum;
end;

for m in [2..8] do
	max := 2*m^m;
	Print(m, " ; ", max, "\n");
	n := 1;	coefficients := base(n,m);
	while n <= max do
		sum := munchausen(coefficients);
	
		if (n = sum) then
			Print(coefficients);
			Print(" ", n, " : ", sum, "\n");
		fi;
		
		n := n + 1; coefficients := next(coefficients, m);
	od;
od;
