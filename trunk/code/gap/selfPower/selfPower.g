Read("base.g");

for m in [2..5] do
	max := 2*m^m;
	Print(m, " ; ", max, "\n");
	for n in [1..max] do
		coefficients := base(n,m);

		sum := 0;
		for index in coefficients do
			sum := sum + index^index;
		od;
	
		if (n = sum) then
			Print(coefficients);
			Print(" ", n, " : ", sum, "\n");
		fi;
	od;
od;
