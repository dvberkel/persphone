%%
% This module provides a means to perform calculations with polynomials.
%
% Author: Daan van Berkel
%%
-module(polynomial).
-export([construct/1, leadingTerm/1, add/2, multiply/2]).

%%
% This function constructs a polynomial with the coefficients specified.
% The term {{x, N}, Head} will be added to the polynomial.
%
%%
construct([], _) ->
	[];
construct([Head | Tail], N) ->
	[{{x,N}, Head}] ++ construct(Tail, N+1).

%%
% The publicly exported function which produces a polynomial with said 
% coefficients.
%
%%
construct(Coefficients) ->
	construct(Coefficients, 0).

%%
% Returns the leading term of a polynomial.
%
%%
leadingTerm([{{x, M}, A}|R], unspecified) ->
	leadingTerm(R,{{x, M}, A});
leadingTerm([], {{x, N}, B}) ->
	{{x, N}, B};
leadingTerm([{{x, M}, A}|R], {{x, N}, _}) when M > N ->
	leadingTerm(R,{{x, M}, A});
leadingTerm([{{x, _}, _}|R], {{x, N}, B}) ->
	leadingTerm(R,{{x, N}, B}).

%%
% The publicly exported function which returns the leading term of a polynomial.
%
%%
leadingTerm(F) ->
	leadingTerm(F, unspecified).

%%
% Adds a monomial to a polynomial.
%
%%
addMonomial([], {{x, N}, B}) ->
	[{{x, N}, B}];
addMonomial([{{x, N}, A} | R], {{x,N},B}) ->
	[{{x, N}, A + B} | R];
addMonomial([Head | Tail], Monomial) ->
	[Head] ++ addMonomial(Tail, Monomial).

%%
% Adds two polynomials.
%
%%
add(F,[]) ->
	F;
add(F, [{{x, N}, B} | R]) ->
	add(addMonomial(F, {{x,N}, B}), R).

%%
% Multiplies a polynomial with a monomial.
%
%%
multiplyMonomial([],{{x, _}, _}) ->
	[];
multiplyMonomial([{{x, M}, A} | R], {{x, N}, B}) ->
	[{{x, M+N}, A*B}] ++ multiplyMonomial(R,{{x, N}, B}).

%%
% The publicily exported function which returns the product of two polynomials.
%
%%
multiply(_,[]) ->
	[];
multiply(F,[{{x, N}, B} | R]) ->
	add(multiplyMonomial(F,{{x, N}, B}), multiply(F,R)).
