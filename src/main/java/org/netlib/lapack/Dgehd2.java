package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgehd2 {
	public static void dgehd2(int i, int j, int k, double ad[], int l, int i1,
			double ad1[], int j1, double ad2[], int k1, intW intw) {
		int l1 = 0;
		intw.val = 0;
		if (i < 0)
			intw.val = -1;
		else if ((j < 1) || (j > Math.max(1, i)))
			intw.val = -2;
		else if ((k < Math.min(j, i)) || (k > i))
			intw.val = -3;
		else if (i1 < Math.max(1, i))
			intw.val = -5;
		if (intw.val != 0) {
			Xerbla.xerbla("DGEHD2", -intw.val);
			return;
		}
		l1 = j;
		for (int i2 = (k - 1 - j) + 1; i2 > 0; i2--) {
			dlarfg_adapter(k - l1, ad, ((l1 + 1) - 1) + (l1 - 1) * i1 + l, ad,
					(Math.min(l1 + 2, i) - 1) + (l1 - 1) * i1 + l, 1, ad1,
					(l1 - 1) + j1);
			double d1 = ad[((l1 + 1) - 1) + (l1 - 1) * i1 + l];
			ad[((l1 + 1) - 1) + (l1 - 1) * i1 + l] = 1.0D;
			Dlarf.dlarf("Right", k, k - l1, ad, ((l1 + 1) - 1) + (l1 - 1) * i1
					+ l, 1, ad1[(l1 - 1) + j1], ad, (1 - 1) + ((l1 + 1) - 1)
					* i1 + l, i1, ad2, k1);
			Dlarf.dlarf("Left", k - l1, i - l1, ad, ((l1 + 1) - 1) + (l1 - 1)
					* i1 + l, 1, ad1[(l1 - 1) + j1], ad, ((l1 + 1) - 1)
					+ ((l1 + 1) - 1) * i1 + l, i1, ad2, k1);
			ad[((l1 + 1) - 1) + (l1 - 1) * i1 + l] = d1;
			l1++;
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
