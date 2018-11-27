package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dger {
	public static void dger(int i, int j, double d, double ad[], int k, int l,
			double ad1[], int i1, int j1, double ad2[], int k1, int l1) {
		byte byte0 = 0;
		int j3 = 0;
		byte0 = 0;
		if (i < 0)
			byte0 = 1;
		else if (j < 0)
			byte0 = 2;
		else if (l == 0)
			byte0 = 5;
		else if (j1 == 0)
			byte0 = 7;
		else if (l1 < Math.max(1, i))
			byte0 = 9;
		if (byte0 != 0) {
			Xerbla.xerbla("DGER  ", byte0);
			return;
		}
		if (((i == 0) || (j == 0)) || (d == 0.0D))
			return;
		if (j1 > 0)
			j3 = 1;
		else
			j3 = 1 - (j - 1) * j1;
		if (l == 1) {
			int l2 = 1;
			for (int l3 = (j - 1) + 1; l3 > 0; l3--) {
				if (ad1[(j3 - 1) + i1] != 0.0D) {
					double d2 = d * ad1[(j3 - 1) + i1];
					int i2 = 1;
					for (int j4 = (i - 1) + 1; j4 > 0; j4--) {
						ad2[(i2 - 1) + (l2 - 1) * l1 + k1] = ad2[(i2 - 1)
								+ (l2 - 1) * l1 + k1]
								+ ad[(i2 - 1) + k] * d2;
						i2++;
					}

				}
				j3 += j1;
				l2++;
			}

		} else {
			int k3;
			if (l > 0)
				k3 = 1;
			else
				k3 = 1 - (i - 1) * l;
			int i3 = 1;
			for (int i4 = (j - 1) + 1; i4 > 0; i4--) {
				if (ad1[(j3 - 1) + i1] != 0.0D) {
					double d3 = d * ad1[(j3 - 1) + i1];
					int k2 = k3;
					int j2 = 1;
					for (int k4 = (i - 1) + 1; k4 > 0; k4--) {
						ad2[(j2 - 1) + (i3 - 1) * l1 + k1] = ad2[(j2 - 1)
								+ (i3 - 1) * l1 + k1]
								+ ad[(k2 - 1) + k] * d3;
						k2 += l;
						j2++;
					}

				}
				j3 += j1;
				i3++;
			}

		}
	}
}
