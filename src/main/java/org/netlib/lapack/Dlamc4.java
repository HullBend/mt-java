package org.netlib.lapack;

import org.netlib.util.intW;

public final class Dlamc4 {
	public static void dlamc4(intW intw, double d, int i) {
		double d1 = 0.0D;
		double d2 = 0.0D;
		double d5 = 0.0D;
		double d6 = 0.0D;
		double d7 = 0.0D;
		double d8 = 0.0D;
		double d9 = 0.0D;
		double d10 = 0.0D;
		double d11 = 0.0D;
		d1 = d;
		d9 = 1;
		d10 = d9 / i;
		d11 = 0;
		intw.val = 1;
		d2 = Dlamc3.dlamc3(d1 * d10, d11);
		d5 = d1;
		d6 = d1;
		d7 = d1;
		d8 = d1;
		while ((((d5 != d1) || (d6 != d1)) || (d7 != d1)) || (d8 != d1)) {
			intw.val = intw.val - 1;
			d1 = d2;
			d2 = Dlamc3.dlamc3(d1 / i, d11);
			d5 = Dlamc3.dlamc3(d2 * i, d11);
			d7 = d11;
			for (int k = (i - 1) + 1; k > 0; k--) {
				d7 += d2;
			}

			double d4 = Dlamc3.dlamc3(d1 * d10, d11);
			d6 = Dlamc3.dlamc3(d4 / d10, d11);
			d8 = d11;
			for (int l = (i - 1) + 1; l > 0; l--) {
				d8 += d4;
			}
		}
	}
}
