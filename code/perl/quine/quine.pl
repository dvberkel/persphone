#! /usr/bin/env perl

use strict;
use warnings;

my $program = <<'EOP';
#! /usr/bin/env perl

use strict;
use warnings;

my $program = <<'EOP';
"EOP

my $copy = $program;
$program =~ s/\x{22}/$copy/g;
print $program;
EOP
 
my $copy = $program;
$program =~ s/\x{22}/$copy/g;
print $program;
