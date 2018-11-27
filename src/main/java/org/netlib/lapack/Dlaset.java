package org.netlib.lapack;

import org.netlib.blas.Lsame;

public final class Dlaset {
	public static void dlaset(String s, int i, int j, double d, double d1,
			double ad[], int k, int l) {
		int i1 = 0;
		if (Lsame.lsame(s, "U")) {
			int j1 = 2;
			for (int i2 = (j - 2) + 1; i2 > 0; i2--) {
				i1 = 1;
				for (int i3 = (Math.min(j1 - 1, i) - 1) + 1; i3 > 0; i3--) {
					ad[(i1 - 1) + (j1 - 1) * l + k] = d;
					i1++;
				}

				j1++;
			}

		} else if (Lsame.lsame(s, "L")) {
			int k1 = 1;
			for (int j2 = (Math.min(i, j) - 1) + 1; j2 > 0; j2--) {
				i1 = k1 + 1;
				for (int j3 = (i - (k1 + 1)) + 1; j3 > 0; j3--) {
					ad[(i1 - 1) + (k1 - 1) * l + k] = d;
					i1++;
				}

				k1++;
			}

		} else {
			int l1 = 1;
			for (int k2 = (j - 1) + 1; k2 > 0; k2--) {
				i1 = 1;
				for (int k3 = (i - 1) + 1; k3 > 0; k3--) {
					ad[(i1 - 1) + (l1 - 1) * l + k] = d;
					i1++;
				}

				l1++;
			}

		}
		i1 = 1;
		for (int l2 = (Math.min(i, j) - 1) + 1; l2 > 0; l2--) {
			ad[(i1 - 1) + (i1 - 1) * l + k] = d1;
			i1++;
		}
	}
}
