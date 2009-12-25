#! /usr/bin/env python

# Program for calculation of Munchausen numbers

import time

MinBase = 2
MaxBase = 19

P = [1]  # value to be used of zero to the zero power.

for i in range(1, MaxBase):
    P = P + [i**i] # Pre compute power list

def BuildNum(N, DigitsLeft, minDigit, CurSum):
    for i in range(minDigit, Base):
        PD = P[i]
        if (CurSum + PD) > MaxNum: break
        if DigitsLeft > 1:
            BuildNum(N + [i], DigitsLeft - 1, i, CurSum + PD)
        else:
            Sum = CurSum + PD
            if Sum < MinNum: continue
            C = []
            for j in range(0, len(N)+1):
                r = Sum % Base
                Sum /= Base
                C = C + [r]
            if (r > 0) and (sorted(C) == (N + [i])):
                C.reverse()
                Cstr = str(C).replace('L','')
                print '%11.3f\tbase %2d\t%s\t(%d)' % (time.clock(), Base, Cstr, CurSum + PD)


for Base in range(MinBase, MaxBase + 1):
    Digits = 0
    while Digits < Base + 1:
        Digits += 1
        MinNum = Base**(Digits - 1)
        MaxNum = Base**Digits - 1
        N = []
        BuildNum(N, Digits, 0, 0)
print '%11.3f  DONE' % (time.clock())
