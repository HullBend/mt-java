package org.netlib.blas;

public final class Drot {
	public static void drot(int i, double ad[], int j, int k, double ad1[],
			int l, int i1, double d, double d1) {
		int j1 = 0;
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
			for (int i2 = (i - 1) + 1; i2 > 0; i2--) {
				double d3 = d * ad[(k1 - 1) + j] + d1 * ad1[(l1 - 1) + l];
				ad1[(l1 - 1) + l] = d * ad1[(l1 - 1) + l] - d1
						* ad[(k1 - 1) + j];
				ad[(k1 - 1) + j] = d3;
				k1 += k;
				l1 += i1;
				j1++;
			}

			return;
		}
		j1 = 1;
		for (int j2 = (i - 1) + 1; j2 > 0; j2--) {
			double d4 = d * ad[(j1 - 1) + j] + d1 * ad1[(j1 - 1) + l];
			ad1[(j1 - 1) + l] = d * ad1[(j1 - 1) + l] - d1 * ad[(j1 - 1) + j];
			ad[(j1 - 1) + j] = d4;
			j1++;
		}

	}
}
