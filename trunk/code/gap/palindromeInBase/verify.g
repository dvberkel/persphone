p := 950041;
#p := 960961;
#p := 1062601;
#p := 1108801;
#p := 1259701;

count := countPalindromeInBase(p);

for n in count[2] do
	if not n = 1 then
		Print(n, " ", base(p,n), "\n");
	fi;
od;
