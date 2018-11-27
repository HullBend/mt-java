package org.netlib.blas;

public final class Ddot {
	public static double ddot(int i, double ad[], int j, int k, double ad1[],
			int l, int i1) {
		double d;
		label0: {
			d = 0.0D;
			int j1 = 0;
			int i2 = 0;
			int j2 = 0;
			double d1 = 0.0D;
			d1 = 0.0D;
			d = 0.0D;
			if (i <= 0)
				return d1;
			if ((k != 1) || (i1 != 1)) {
				int k1 = 1;
				int l1 = 1;
				if (k < 0)
					k1 = (-i + 1) * k + 1;
				if (i1 < 0)
					l1 = (-i + 1) * i1 + 1;
				j1 = 1;
				for (int k2 = (i - 1) + 1; k2 > 0; k2--) {
					d += ad[(k1 - 1) + j] * ad1[(l1 - 1) + l];
					k1 += k;
					l1 += i1;
					j1++;
				}

				double d2 = d;
				return d2;
			}
			i2 = i % 5;
			if (i2 != 0) {
				j1 = 1;
				for (int l2 = (i2 - 1) + 1; l2 > 0; l2--) {
					d += ad[(j1 - 1) + j] * ad1[(j1 - 1) + l];
					j1++;
				}

				if (i < 5)
					break label0;
			}
			j2 = i2 + 1;
			j1 = j2;
			for (int i3 = ((i - j2) + 5) / 5; i3 > 0; i3--) {
				d = d + ad[(j1 - 1) + j] * ad1[(j1 - 1) + l]
						+ ad[((j1 + 1) - 1) + j] * ad1[((j1 + 1) - 1) + l]
						+ ad[((j1 + 2) - 1) + j] * ad1[((j1 + 2) - 1) + l]
						+ ad[((j1 + 3) - 1) + j] * ad1[((j1 + 3) - 1) + l]
						+ ad[((j1 + 4) - 1) + j] * ad1[((j1 + 4) - 1) + l];
				j1 += 5;
			}

		}
		double d3 = d;
		return d3;
	}
}
