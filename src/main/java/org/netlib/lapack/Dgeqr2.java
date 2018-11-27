package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgeqr2 {
	public static void dgeqr2(int i, int j, double ad[], int k, int l,
			double ad1[], int i1, double ad2[], int j1, intW intw) {
		int k1 = 0;
		int l1 = 0;
		intw.val = 0;
		if (i < 0)
			intw.val = -1;
		else if (j < 0)
			intw.val = -2;
		else if (l < Math.max(1, i))
			intw.val = -4;
		if (intw.val != 0) {
			Xerbla.xerbla("DGEQR2", -intw.val);
			return;
		}
		l1 = Math.min(i, j);
		k1 = 1;
		for (int i2 = (l1 - 1) + 1; i2 > 0; i2--) {
			dlarfg_adapter((i - k1) + 1, ad, (k1 - 1) + (k1 - 1) * l + k, ad,
					(Math.min(k1 + 1, i) - 1) + (k1 - 1) * l + k, 1, ad1,
					(k1 - 1) + i1);
			if (k1 < j) {
				double d1 = ad[(k1 - 1) + (k1 - 1) * l + k];
				ad[(k1 - 1) + (k1 - 1) * l + k] = 1.0D;
				Dlarf.dlarf("Left", (i - k1) + 1, j - k1, ad, (k1 - 1)
						+ (k1 - 1) * l + k, 1, ad1[(k1 - 1) + i1], ad, (k1 - 1)
						+ ((k1 + 1) - 1) * l + k, l, ad2, j1);
				ad[(k1 - 1) + (k1 - 1) * l + k] = d1;
			}
			k1++;
		}

	}

	private static void dlarfg_adapter(int i, double ad[], int j, double ad1[],
			int k, int l, double ad2[], int i1) {
		doubleW doublew = new doubleW(ad[j]);
		doubleW doublew1 = new doubleW(ad2[i1]);
		Dlarfg.dlarfg(i, doublew, ad1, k, l, doublew1);
		ad[j] = doublew.val;
		ad2[i1] = doublew1.val;
	}
}
