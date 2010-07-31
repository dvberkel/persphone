contactless := function(stones,points)
	return Binomial(stones + points - 1,stones);
end;

contactfull := function(stones,points,opponentStones,occupiedPoints)
	return Binomial(points,occupiedPoints) * contactless(opponentStones,occupiedPoints) * contactless(stones,points-occupiedPoints);
end;

points := 6;

endPositions := 0;
for stones in [0..15] do
	number := contactless(stones,points);
	Print(stones,":",number,"\n");
	endPositions := endPositions + number;
od;
Print(endPositions,"\n");


for opponentStones in [1..15] do
	endPositionPerOpponentStones := 0;
	for occupiedPoints in [1..Minimum(opponentStones,points)] do
		endPositionPerOccupiedPoint := 0;
		for stones in [0..15] do
			number := contactfull(stones,points,opponentStones,occupiedPoints);
			Print(opponentStones, ".",occupiedPoints, "|", stones ,":", number ,"\n");
			endPositionPerOccupiedPoint := endPositionPerOccupiedPoint + number;
		od;
		Print(opponentStones, ".", occupiedPoints, "---",endPositionPerOccupiedPoint,"\n");
		endPositionPerOpponentStones := endPositionPerOpponentStones + endPositionPerOccupiedPoint;
	od;
	Print(opponentStones, "===", endPositionPerOpponentStones, "\n");
	endPositions := endPositions + endPositionPerOpponentStones;
od;
Print(endPositions,"\n");
