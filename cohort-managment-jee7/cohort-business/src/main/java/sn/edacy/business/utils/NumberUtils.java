package sn.edacy.business.utils;

public class NumberUtils {
	
	
	/**
	 * Return long from a string
	 * @param s
	 * @return
	 */
	public static Long parseString(String s) {
		try {
			return Long.parseLong(s);
		} catch(NumberFormatException e) {
			return null;
		}
	}

}
