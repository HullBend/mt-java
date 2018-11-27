package org.netlib.blas;

public final class Dscal {
	public static void dscal(int i, double d, double ad[], int j, int k) {
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		if ((i <= 0) || (k <= 0))
			return;
		if (k != 1) {
			int k1 = i * k;
			l = 1;
			for (int l1 = ((k1 - 1) + k) / k; l1 > 0; l1--) {
				ad[(l - 1) + j] = d * ad[(l - 1) + j];
				l += k;
			}

			return;
		}
		i1 = i % 5;
		if (i1 != 0) {
			l = 1;
			for (int i2 = (i1 - 1) + 1; i2 > 0; i2--) {
				ad[(l - 1) + j] = d * ad[(l - 1) + j];
				l++;
			}

			if (i < 5)
				return;
		}
		j1 = i1 + 1;
		l = j1;
		for (int j2 = ((i - j1) + 5) / 5; j2 > 0; j2--) {
			ad[(l - 1) + j] = d * ad[(l - 1) + j];
			ad[((l + 1) - 1) + j] = d * ad[((l + 1) - 1) + j];
			ad[((l + 2) - 1) + j] = d * ad[((l + 2) - 1) + j];
			ad[((l + 3) - 1) + j] = d * ad[((l + 3) - 1) + j];
			ad[((l + 4) - 1) + j] = d * ad[((l + 4) - 1) + j];
			l += 5;
		}
	}
}
