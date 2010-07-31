#! /usr/bin/env perl6

use v6;

sub panic() {
	say "Oh no! Something has gone most terribly wrong!";
}

panic();

{
	our sub eat() {
		say "om nom nom";
	}
	sub drink() {
		say "glug glug";
	}
}
eat();   # om nom nom
# drink(); # fails, can’t drink outside of the block

