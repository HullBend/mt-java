package org.netlib.blas;

public final class Dswap {
	public static void dswap(int i, double ad[], int j, int k, double ad1[],
			int l, int i1) {
		int j1 = 0;
		int i2 = 0;
		int j2 = 0;
		if (i <= 0)
			return;
		if ((k != 1) || (i1 != 1)) {
			int k1 = 1;
			int l1 = 1;
			if (k < 0)
				k1 = (-i + 1) * k + 1;
			if (i1 < 0)
				l1 = (-i + 1) * i1 + 1;
			j1 = 1;
			for (int k2 = (i - 1) + 1; k2 > 0; k2--) {
				double d1 = ad[(k1 - 1) + j];
				ad[(k1 - 1) + j] = ad1[(l1 - 1) + l];
				ad1[(l1 - 1) + l] = d1;
				k1 += k;
				l1 += i1;
				j1++;
			}

			return;
		}
		i2 = i % 3;
		if (i2 != 0) {
			j1 = 1;
			for (int l2 = (i2 - 1) + 1; l2 > 0; l2--) {
				double d2 = ad[(j1 - 1) + j];
				ad[(j1 - 1) + j] = ad1[(j1 - 1) + l];
				ad1[(j1 - 1) + l] = d2;
				j1++;
			}

			if (i < 3)
				return;
		}
		j2 = i2 + 1;
		j1 = j2;
		for (int i3 = ((i - j2) + 3) / 3; i3 > 0; i3--) {
			double d3 = ad[(j1 - 1) + j];
			ad[(j1 - 1) + j] = ad1[(j1 - 1) + l];
			ad1[(j1 - 1) + l] = d3;
			d3 = ad[((j1 + 1) - 1) + j];
			ad[((j1 + 1) - 1) + j] = ad1[((j1 + 1) - 1) + l];
			ad1[((j1 + 1) - 1) + l] = d3;
			d3 = ad[((j1 + 2) - 1) + j];
			ad[((j1 + 2) - 1) + j] = ad1[((j1 + 2) - 1) + l];
			ad1[((j1 + 2) - 1) + l] = d3;
			j1 += 3;
		}
	}
}
