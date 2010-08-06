/**
 * 
 */
package org.effrafax.backgammon;

import java.util.Arrays;
import java.util.List;

/**
 * @author dvberkel
 * 
 */
public enum Dice
{
	DOUBLE_ONE(1), TWO_ONE(2, 1), THREE_ONE(3, 1), FOUR_ONE(4, 1), FIVE_ONE(5, 1), SIX_ONE(6, 1), //
	DOUBLE_TWO(2), THREE_TWO(3, 2), FOUR_TWO(4, 2), FIVE_TWO(5, 2), SIX_TWO(6, 2), //
	DOUBLE_THREE(3), FOUR_THREE(4, 3), FIVE_THREE(5, 3), SIX_THREE(6, 3), //
	DOUBLE_FOUR(4), FIVE_FOUR(5, 4), SIX_FOUR(6, 4), //
	DOUBLE_FIVE(5), SIX_FIVE(6, 5), //
	DOUBLE_SIX(6);

	private int[] pips;

	Dice(int... pips)
	{
		this.pips = pips;
	}

	public List<int[]> pipSequences()
	{
		if (pips.length == 1)
		{
			return Arrays.asList(new int[] { pips[0], pips[0], pips[0], pips[0] });
		}
		else
		{
			return Arrays.asList(new int[] { pips[0], pips[1] }, new int[] { pips[1], pips[0] });
		}
	}
}
