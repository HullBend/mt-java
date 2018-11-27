package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.util.doubleW;

public final class Dlange {
	public static double dlange(String s, int i, int j, double ad[], int k,
			int l, double ad1[], int i1) {
		doubleW doublew = new doubleW(0.0D);
		doubleW doublew1 = new doubleW(0.0D);
		double d = 0.0D;
		double d1 = 0.0D;
		if (Math.min(i, j) == 0)
			d = 0.0D;
		else if (Lsame.lsame(s, "M")) {
			d = 0.0D;
			int i2 = 1;
			for (int i3 = (j - 1) + 1; i3 > 0; i3--) {
				int j1 = 1;
				for (int k4 = (i - 1) + 1; k4 > 0; k4--) {
					d = Math.max(d, Math.abs(ad[(j1 - 1) + (i2 - 1) * l + k]));
					j1++;
				}

				i2++;
			}

		} else if (Lsame.lsame(s, "O") || s.regionMatches(0, "1", 0, 1)) {
			d = 0.0D;
			int j2 = 1;
			for (int j3 = (j - 1) + 1; j3 > 0; j3--) {
				doublew1.val = 0.0D;
				int k1 = 1;
				for (int l4 = (i - 1) + 1; l4 > 0; l4--) {
					doublew1.val = doublew1.val
							+ Math.abs(ad[(k1 - 1) + (j2 - 1) * l + k]);
					k1++;
				}

				d = Math.max(d, doublew1.val);
				j2++;
			}

		} else if (Lsame.lsame(s, "I")) {
			int l1 = 1;
			for (int k3 = (i - 1) + 1; k3 > 0; k3--) {
				ad1[(l1 - 1) + i1] = 0.0D;
				l1++;
			}

			int k2 = 1;
			for (int l3 = (j - 1) + 1; l3 > 0; l3--) {
				l1 = 1;
				for (int i5 = (i - 1) + 1; i5 > 0; i5--) {
					ad1[(l1 - 1) + i1] = ad1[(l1 - 1) + i1]
							+ Math.abs(ad[(l1 - 1) + (k2 - 1) * l + k]);
					l1++;
				}

				k2++;
			}

			d = 0.0D;
			l1 = 1;
			for (int i4 = (i - 1) + 1; i4 > 0; i4--) {
				d = Math.max(d, ad1[(l1 - 1) + i1]);
				l1++;
			}

		} else if (Lsame.lsame(s, "F") || Lsame.lsame(s, "E")) {
			doublew.val = 0.0D;
			doublew1.val = 1.0D;
			int l2 = 1;
			for (int j4 = (j - 1) + 1; j4 > 0; j4--) {
				Dlassq.dlassq(i, ad, (1 - 1) + (l2 - 1) * l + k, 1, doublew,
						doublew1);
				l2++;
			}

			d = doublew.val * Math.sqrt(doublew1.val);
		}
		d1 = d;
		return d1;
	}
}
