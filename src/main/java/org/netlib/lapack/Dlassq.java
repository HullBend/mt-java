package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlassq {
	public static void dlassq(int i, double ad[], int j, int k,
			doubleW doublew, doubleW doublew1) {
		if (i > 0) {
			int l = 1;
			for (int i1 = (((1 + (i - 1) * k) - 1) + k) / k; i1 > 0; i1--) {
				if (ad[(l - 1) + j] != 0.0D) {
					double d1 = Math.abs(ad[(l - 1) + j]);
					if (doublew.val < d1) {
						doublew1.val = 1 + doublew1.val
								* Math.pow(doublew.val / d1, 2);
						doublew.val = d1;
					} else {
						doublew1.val = doublew1.val
								+ Math.pow(d1 / doublew.val, 2);
					}
				}
				l += k;
			}
		}
	}
}
