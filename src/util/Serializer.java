/**
 * File: Serializer.java
 * Package: ProyectoDiscretas2.util.Serializer
 * Creation: 19/05/2014 at 14:16:28
 */

package util;

import java.nio.ByteBuffer;

/**
 * @author camiloasc1
 * 
 */
public class Serializer
{
	public static byte[] toArray(double value)
	{
		byte[] bytes = new byte[8];
		ByteBuffer.wrap(bytes).putDouble(value);
		return bytes;
	}
	
	public static double toDouble(byte[] bytes)
	{
		return ByteBuffer.wrap(bytes).getDouble();
	}
	
	public static byte[] concat(byte[] a)
	{
		int aLen = a.length;
		
		byte[] c = new byte[aLen];
		System.arraycopy(a, 0, c, 0, aLen);
		return c;
	}
	
	public static byte[] subArray(byte[] array, int start, int end)
	{
		if ((start < 0) || (end <= start))
			throw new IllegalArgumentException();
		if (array == null)
			throw new IllegalArgumentException();
		if (array.length < end)
			throw new IllegalArgumentException();
		
		byte[] subArray = new byte[(end - start) + 1];
		System.arraycopy(array, start, subArray, 0, (end - start) + 1);
		return subArray;
	}
}
