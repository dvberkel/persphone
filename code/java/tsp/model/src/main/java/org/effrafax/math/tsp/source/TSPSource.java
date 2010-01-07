/**
 * 
 */
package org.effrafax.math.tsp.source;

import org.effrafax.math.tsp.instance.TSPInstance;

/**
 * This interface provides a means to provide a {@link TSPInstance}.
 * 
 * @author dvberkel
 * 
 */
public interface TSPSource<N extends Number>
{
	public TSPInstance<N> getTSPInstance();
}
