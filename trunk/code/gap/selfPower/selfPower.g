base := function(m,n)
	local result;
	result := [];
	while m > 0 do
		Add(result, m mod n);
		m := QuoInt(m,n);
	od;
	return result;
end;

for m in [1..10] do
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
