/**
 * File: ChaoticSource.java
 * Package: ProyectoDiscretas2.chaotic.ChaoticSource
 * Creation: 19/05/2014 at 13:30:52
 */

package chaotic;

/**
 * @author camiloasc1
 * 
 */
public interface ChaoticSource
{
	/**
	 * Init with a random key
	 */
	abstract public void init();
	
	/**
	 * Init with specified key
	 * 
	 * @param key
	 *            key to use
	 */
	abstract public void init(byte[] key);
	
	/**
	 * Close the chaotic source
	 */
	abstract public void close();
	
	/**
	 * @return the key
	 */
	abstract public byte[] getKey();
	
	/**
	 * @return chaotic result
	 */
	abstract public double next();
	
	/**
	 * @param skip
	 *            number of results to skip
	 * @return chaotic result
	 */
	abstract public double next(int skip);
}
