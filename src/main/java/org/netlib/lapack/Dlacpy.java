package org.netlib.lapack;

import org.netlib.blas.Lsame;

public final class Dlacpy {
	public static void dlacpy(String s, int i, int j, double ad[], int k,
			int l, double ad1[], int i1, int j1) {
		if (Lsame.lsame(s, "U")) {
			int j2 = 1;
			for (int i3 = (j - 1) + 1; i3 > 0; i3--) {
				int k1 = 1;
				for (int l3 = (Math.min(j2, i) - 1) + 1; l3 > 0; l3--) {
					ad1[(k1 - 1) + (j2 - 1) * j1 + i1] = ad[(k1 - 1) + (j2 - 1)
							* l + k];
					k1++;
				}

				j2++;
			}

		} else if (Lsame.lsame(s, "L")) {
			int k2 = 1;
			for (int j3 = (j - 1) + 1; j3 > 0; j3--) {
				int l1 = k2;
				for (int i4 = (i - k2) + 1; i4 > 0; i4--) {
					ad1[(l1 - 1) + (k2 - 1) * j1 + i1] = ad[(l1 - 1) + (k2 - 1)
							* l + k];
					l1++;
				}

				k2++;
			}

		} else {
			int l2 = 1;
			for (int k3 = (j - 1) + 1; k3 > 0; k3--) {
				int i2 = 1;
				for (int j4 = (i - 1) + 1; j4 > 0; j4--) {
					ad1[(i2 - 1) + (l2 - 1) * j1 + i1] = ad[(i2 - 1) + (l2 - 1)
							* l + k];
					i2++;
				}

				l2++;
			}

		}
	}
}
