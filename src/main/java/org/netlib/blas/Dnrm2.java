package org.netlib.blas;

public final class Dnrm2 {
	public static double dnrm2(int i, double ad[], int j, int k) {
		double d2 = 0.0D;
		double d7 = 0.0D;
		if ((i < 1) || (k < 1))
			d2 = 0.0D;
		else if (i == 1) {
			d2 = Math.abs(ad[(1 - 1) + j]);
		} else {
			double d4 = 0.0D;
			double d6 = 1.0D;
			int l = 1;
			for (int i1 = (((1 + (i - 1) * k) - 1) + k) / k; i1 > 0; i1--) {
				if (ad[(l - 1) + j] != 0.0D) {
					double d1 = Math.abs(ad[(l - 1) + j]);
					if (d4 < d1) {
						d6 = 1.0D + d6 * Math.pow(d4 / d1, 2);
						d4 = d1;
					} else {
						d6 += Math.pow(d1 / d4, 2);
					}
				}
				l += k;
			}

			d2 = d4 * Math.sqrt(d6);
		}
		d7 = d2;
		return d7;
	}
}
