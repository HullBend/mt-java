package org.netlib.blas;

public final class Idamax {
	public static int idamax(int i, double ad[], int j, int k) {
		double d = 0.0D;
		int l = 0;
		int j1 = 0;
		j1 = 0;
		if ((i < 1) || (k <= 0))
			return j1;
		j1 = 1;
		if (i == 1)
			return j1;
		if (k != 1) {
			int i1 = 1;
			d = Math.abs(ad[(1 - 1) + j]);
			i1 += k;
			l = 2;
			for (int k1 = (i - 2) + 1; k1 > 0; k1--) {
				if (Math.abs(ad[(i1 - 1) + j]) > d) {
					j1 = l;
					d = Math.abs(ad[(i1 - 1) + j]);
				}
				i1 += k;
				l++;
			}

			return j1;
		}
		d = Math.abs(ad[(1 - 1) + j]);
		l = 2;
		for (int l1 = (i - 2) + 1; l1 > 0; l1--) {
			if (Math.abs(ad[(l - 1) + j]) > d) {
				j1 = l;
				d = Math.abs(ad[(l - 1) + j]);
			}
			l++;
		}

		return j1;
	}
}
