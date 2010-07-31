contactless := function(stones,points)
	return Binomial(stones + points - 1,stones);
end;

contactfull := function(stones,points,opponentStones,occupiedPoints)
	return Binomial(points,occupiedPoints) * contactless(opponentStones,occupiedPoints) * contactless(stones,points-occupiedPoints);
end;

endPositions := 0;
for stones in [0..15] do
	Print(stones,":",contactless(stones,6),"\n");
	endPositions := endPositions + contactless(stones,6);
od;
