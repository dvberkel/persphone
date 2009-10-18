base := function(m,n)
	local result;
	result := [];
	while m > 0 do
		Add(result, m mod n);
		m := QuoInt(m,n);
	od;
	return result;
end;

number := function(result,n)
	local m, i;
	m := 0;
	for i in [1..Length(result)] do
		m := m + result[i] * n^(i-1);
	od;
	return m;
end;

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
