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
	local length;
	length := Length(result);
	for i in [1..length] do
		if (not result[i] = result[length + 1 - i]) then
			return false;
		fi;
	od;
	return true;
end;

countPalindromeInBase := function(n)
	local result, count;
	count := 1; result := [1];
	for i in [2..n-1] do
		if isPalindrome(base(n,i)) then
			count := count + 1;
			Add(result,i);
		fi;
	od;
	return [count, result];
end;
