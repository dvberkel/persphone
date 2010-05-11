contains([Y|_],X) :- X = Y.
contains([_|Ys],X) :- contains(Ys,X).

subset([],[]).
subset([],[_|_]).
subset([X|Xs],Y) :- contains(Y,X),subset(Xs,Y).
