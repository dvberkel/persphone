base := function(m,n)
	local result;
	result := [];
	while m > 0 do
		Add(result, m mod n);
		m := QuoInt(m,n);
	od;
	return result;
end;

m := 8;
max := m^m;
Print(max, "\n");
for n in [1..max] do
	coefficients := base(n,m);

	sum := 0;
	for index in coefficients do
		sum := sum + index^index;
	od;
	
	if (n = sum) then
		Print(coefficients);
		Print(n, " : ", sum, "\n");
	fi;
od;
