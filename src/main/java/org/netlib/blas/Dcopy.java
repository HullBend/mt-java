package org.netlib.blas;

public final class Dcopy {
	public static void dcopy(int i, double ad[], int j, int k, double ad1[],
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
				ad1[(l1 - 1) + l] = ad[(k1 - 1) + j];
				k1 += k;
				l1 += i1;
				j1++;
			}

			return;
		}
		i2 = i % 7;
		if (i2 != 0) {
			j1 = 1;
			for (int l2 = (i2 - 1) + 1; l2 > 0; l2--) {
				ad1[(j1 - 1) + l] = ad[(j1 - 1) + j];
				j1++;
			}

			if (i < 7)
				return;
		}
		j2 = i2 + 1;
		j1 = j2;
		for (int i3 = ((i - j2) + 7) / 7; i3 > 0; i3--) {
			ad1[(j1 - 1) + l] = ad[(j1 - 1) + j];
			ad1[((j1 + 1) - 1) + l] = ad[((j1 + 1) - 1) + j];
			ad1[((j1 + 2) - 1) + l] = ad[((j1 + 2) - 1) + j];
			ad1[((j1 + 3) - 1) + l] = ad[((j1 + 3) - 1) + j];
			ad1[((j1 + 4) - 1) + l] = ad[((j1 + 4) - 1) + j];
			ad1[((j1 + 5) - 1) + l] = ad[((j1 + 5) - 1) + j];
			ad1[((j1 + 6) - 1) + l] = ad[((j1 + 6) - 1) + j];
			j1 += 7;
		}
	}
}
