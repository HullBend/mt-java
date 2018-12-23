package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgeqrf {

	public static void dgeqrf(int i, int j, double[] ad, int k, int l,
			double[] ad1, int i1, double[] ad2, int j1, int k1, intW intw) {

		boolean flag = false;
		int l1 = 0;
		intW intw1 = new intW(0);
		int j2 = 0;
		int k2 = 0;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int k3 = 0;
		int l3 = 0;
		intw.val = 0;
		j3 = Ilaenv.ilaenv(1, "DGEQRF", " ", i, j, -1, -1);
		i3 = j * j3;
		ad2[j1] = i3;
		flag = (k1 == -1);
		if (i < 0)
			intw.val = -1;
		else if (j < 0)
			intw.val = -2;
		else if (l < Math.max(1, i))
			intw.val = -4;
		else if (!flag && k1 < Math.max(1, j))
			intw.val = -7;

		if (intw.val != 0) {
			Xerbla.xerbla("DGEQRF", -intw.val);
			return;
		}

		if (flag) {
			return;
        }
		k2 = Math.min(i, j);
		if (k2 == 0) {
			ad2[j1] = 1;
			return;
		}
		k3 = 2;
		l3 = 0;
		j2 = j;
		if (j3 > 1 && j3 < k2) {
			l3 = Math.max(0, Ilaenv.ilaenv(3, "DGEQRF", " ", i, j, -1, -1));
			if (l3 < k2) {
				l2 = j;
				j2 = l2 * j3;
				if (k1 < j2) {
					j3 = k1 / l2;
					k3 = Math.max(2,
							Ilaenv.ilaenv(2, "DGEQRF", " ", i, j, -1, -1));
				}
			}
		}
		if (j3 >= k3 && j3 < k2 && l3 < k2) {
			l1 = 1;
			for (int i4 = (k2 - l3 - 1 + j3) / j3; i4 > 0; i4--) {
				int i2 = Math.min(k2 - l1 + 1, j3);
				Dgeqr2.dgeqr2(i - l1 + 1, i2, ad,
						l1 - 1 + (l1 - 1) * l + k, l, ad1, l1 - 1 + i1,
						ad2, j1, intw1);
				if (l1 + i2 <= j) {
					Dlarft.dlarft("Forward", "Columnwise", (i - l1) + 1, i2,
							ad, l1 - 1 + (l1 - 1) * l + k, l, ad1, l1 - 1
									+ i1, ad2, j1, l2);
					Dlarfb.dlarfb("Left", "Transpose", "Forward", "Columnwise",
							i - l1 + 1, j - l1 - i2 + 1, i2, ad, l1 - 1
									+ (l1 - 1) * l + k, l, ad2, j1, l2, ad,
							l1 - 1 + (l1 + i2 - 1) * l + k, l, ad2,
							i2 + j1, l2);
				}
				l1 += j3;
			}

		} else {
			l1 = 1;
		}
		if (l1 <= k2) {
			Dgeqr2.dgeqr2(i - l1 + 1, j - l1 + 1, ad, l1 - 1 + (l1 - 1)
					* l + k, l, ad1, l1 - 1 + i1, ad2, j1, intw1);
        }
		ad2[j1] = j2;
	}
}
