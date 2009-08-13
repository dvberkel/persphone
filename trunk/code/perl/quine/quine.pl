#! /usr/bin/env perl

use strict;
use warnings;

my $program = <<'EOP';
	#! /usr/bin/env perl

	use strict;
	use warnings;

	my $program = <<'EOP';
	EOP

	my $copy = $program;
	$program =~ s/\t//g;
	$program =~ s/(\n)(EOP)/$1$copy$2/;

	print $program;
EOP
 
my $copy = $program;
$program =~ s/\t//g;
$program =~ s/(\n)(EOP)/$1$copy$2/;

print $program;
