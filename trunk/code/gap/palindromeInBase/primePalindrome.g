base := function(m,n)
	local result;
	result := [];
	while m > 0 do
		Add(result, m mod n);
		m := QuoInt(m,n);
	od;
	return result;
end;

isPalindrome := function(result)
	local length, i;
	length := Length(result);
	for i in [1..length] do
		if (not result[i] = result[length + 1 - i]) then
			return false;
		fi;
	od;
	return true;
end;

countPalindromeInBase := function(n)
	local result, count, i;
	count := 1; result := [1];
	for i in [2..n-1] do
		if isPalindrome(base(n,i)) then
			count := count + 1;
			Add(result,i);
		fi;
	od;
	return [count, result];
end;

# 86676
p := 2; max := countPalindromeInBase(p);
Print(max);
while true do
	p := NextPrimeInt(p);
	count := countPalindromeInBase(p);
	if count[1] >= max[1] then
		max := count;
		Print(max);
	fi;
od;
