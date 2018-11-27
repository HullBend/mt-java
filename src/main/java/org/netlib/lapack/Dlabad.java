package org.netlib.lapack;

import org.netlib.util.Util;
import org.netlib.util.doubleW;

public final class Dlabad {
	public static void dlabad(doubleW doublew, doubleW doublew1) {
		if (Util.log10(doublew1.val) > 2000D) {
			doublew.val = Math.sqrt(doublew.val);
			doublew1.val = Math.sqrt(doublew1.val);
		}
	}
}
