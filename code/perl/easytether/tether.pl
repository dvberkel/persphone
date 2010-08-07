#! /usr/bin/env perl

use strict;
use warnings;

use POSIX qw/mkfifo/;

my $waitTime = shift @ARGV;
$waitTime = 2 unless $waitTime;

my $pid = fork();
if ($pid == 0) {
	parent();
} else {
	child();
}

sub parent {
	print "configurating easytether\n";
	system('easytether enumerate');
	print "connecting easytether\n";
	system('easytether connect');
}

sub child {
	sleep($waitTime);
	print "setting up dhclient\n";
	exec("dhclient easytether0");	
}
