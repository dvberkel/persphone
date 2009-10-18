next := function(result, n)
	local i;
	result[1] := result[1] + 1;
	i := 1;
	while result[i] = n do
		result[i] := 0;
		i := i + 1;
		if (i <= Length(result)) then
			result[i] := result[i] + 1;
		else
			Add(result, 1);
		fi;
	od;
	return result;
end;

munchausen := function(coefficients)
	local sum, index;
	sum := 0;
	for index in coefficients do
		sum := sum + index^index;
	od;
	return sum;
end;

for m in [2..10] do
	max := 2*m^m;
	n := 1;	coefficients := [1];
	while n <= max do
		sum := munchausen(coefficients);
	
		if (n = sum) then
			Print(n, " ");
		fi;
		
		n := n + 1; coefficients := next(coefficients, m);
	od;
od;
