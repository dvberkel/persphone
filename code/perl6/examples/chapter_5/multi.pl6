#! /usr/bin/env perl6

use v6;

multi testOutput(Bool $d) { say "boolean";}
multi testOutput(Str $d) {say "string";}
multi testOutput() {say "nothing to see";}

testOutput("hello");
testOutput();

enum Symbol <Rock Paper Scissors>;
multi wins(Scissors $, Paper $) {+1}
multi wins(Paper $, Rock $) {+1}
multi wins(Rock $, Scissors $) {+1}
multi wins(::T $, T $) {0}
multi wins($,$) {-1}


sub play($a, $b) {
	given wins($a, $b) {
		when +1 { say 'Player One wins' }
		when 0  { say 'Draw'}
		when -1 { say 'Player Two wins' }
	}
}

play(Scissors, Paper);
play(Paper, Paper);
play(Rock, Paper);

