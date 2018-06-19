package com.narad.util;

import com.google.common.base.CaseFormat;

/**
 * Util class for Adaptor
 * 
 * @author Devendra
 *
 */
public class AdapterUtil {
	/**
	 * Convert hyphen to lower camel 
	 * @param name
	 * @return
	 */
	public static  String convertPropertyName (String name) {
		return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, name);
	}

}
