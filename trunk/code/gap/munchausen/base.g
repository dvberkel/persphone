base := function(m,b)
	local coefficients;
	coefficients := [];
	while m > 0 do
		Add(coefficients, m mod b);
		m := QuoInt(m,b);
	od;
	return coefficients;
end;

number := function(coefficients,b)
	local m, i;
	m := 0;
	for i in [1..Length(coefficients)] do
		m := m + coefficients[i] * b^(i-1);
	od;
	return m;
end;

next := function(coefficients, n)
	local i;
	coefficients[1] := coefficients[1] + 1;
	i := 1;
	while coefficients[i] = n do
		coefficients[i] := 0;
		i := i + 1;
		if (i <= Length(coefficients)) then
			coefficients[i] := coefficients[i] + 1;
		else
			Add(coefficients, 1);
		fi;
	od;
	return coefficients;
end;
