/**
 * File: LogisticMap.java
 * Package: ProyectoDiscretas2.chaotic.LogisticMap
 * Creation: 19/05/2014 at 13:48:34
 */

package chaotic;

import util.Serializer;

/**
 * @author camiloasc1
 * 
 */
public class LogisticMap extends ChaoticProcess
{

   
	private double r;
	private double x1;
	private double xn;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see chaotic.ChaoticSource#init()
	 */
	@Override
	public void init()
	{
		r = 4;
		x1 = xn = Math.random();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see chaotic.ChaoticSource#init(byte[])
	 */
	@Override
	public void init(byte[] key)
	{
		r = 4;//Serializer.toDouble(Serializer.subArray(key, 0, 7));
		x1 = xn =Serializer.toDouble(Serializer.subArray(key, 0, 7)); //Serializer.toDouble(Serializer.subArray(key, 8, 15));
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see chaotic.ChaoticSource#close()
	 */
	@Override
	public void close()
	{
		xn = x1;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see chaotic.ChaoticSource#getKey()
	 */
	@Override
	public byte[] getKey()
	{
		return Serializer.concat( Serializer.toArray(x1));
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see chaotic.ChaoticSource#next()
	 */
	@Override
	public double next()
	{
		return xn = (r * xn * (1 - xn));
	}
        
         public double getXn() {
        return xn;
    }
}
