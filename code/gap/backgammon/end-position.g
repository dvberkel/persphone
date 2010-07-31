contactless := function(stones,points)
	return Binomial(stones + points - 1,stones);
end;

contactfull := function(stones,points,opponentStones,occupiedPoints)
	return Binomial(points,occupiedPoints) * contactless(opponentStones,occupiedPoints) * contactless(stones,points-occupiedPoints);
end;


endPositions := 0;
for stones in [0..15] do
	number := contactless(stones,6);
	Print(stones,":",number,"\n");
	endPositions := endPositions + number;
od;
Print(endPositions,"\n");


for opponentStones in [1..15] do
	endPositionPerOpponentStones := 0;
	for occupiedPoints in [1..Minimum(opponentStones,6)] do
		endPositionPerOccupiedPoint := 0;
		for stones in [0..15] do
			number := contactfull(stones,6,opponentStones,occupiedPoints);
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
