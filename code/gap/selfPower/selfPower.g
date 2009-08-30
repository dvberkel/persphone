base := function(m,n)
	local result;
	result := [];
	while m > 0 do
		Add(result, m mod n);
		m := QuoInt(m,n);
	od;
	return result;
end;

for n in [1..10^10] do
	coefficients := base(n,10);

	sum := 0;
	for index in coefficients do
		sum := sum + index^index;
	od;
	
	if (n = sum) then
		Print(n, " : ", sum, "\n");
	fi;
od;
