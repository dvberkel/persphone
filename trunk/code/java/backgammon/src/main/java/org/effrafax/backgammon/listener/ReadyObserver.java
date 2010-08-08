package org.effrafax.backgammon.listener;

/**
 * @author dvberkel
 * 
 */
public interface ReadyObserver<O extends ReadyObservable>
{
	public void readyEvent(O observable);
}
