/**
 * File: ChaoticProcess.java
 * Package: ProyectoDiscretas2.chaotic.ChaoticProcess
 * Creation: 19/05/2014 at 13:45:08
 */

package chaotic;

/**
 * @author camiloasc1
 * 
 */
public abstract class ChaoticProcess implements ChaoticSource
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see chaotic.ChaoticSource#next(int)
	 */
	@Override
	public double next(int skip)
	{
		for (int i = 0; i < (skip - 1); i++)
		{
			next();
		}
		return next();
	}
        
        
}
