package org.netlib.lapack;

import org.netlib.util.booleanW;
import org.netlib.util.intW;

public final class Dlamc1 {
	public static void dlamc1(intW intw, intW intw1, booleanW booleanw,
			booleanW booleanw1) {
		if (first) {
			double d9 = 1;
			double d1 = 1;
			double d5 = 1;
			while (d5 != d9) {
				d1 = 2 * d1;
				d5 = Dlamc3.dlamc3(d1, d9);
				d5 = Dlamc3.dlamc3(d5, -d1);
			}
			double d3 = 1;
			d5 = Dlamc3.dlamc3(d1, d3);
			while (d5 != d1) {
				d3 = 2 * d3;
				d5 = Dlamc3.dlamc3(d1, d3);
			}
			double d11 = d9 / 4;
			double d13 = d5;
			d5 = Dlamc3.dlamc3(d5, -d1);
			lbeta = (int) (d5 + d11);
			d3 = lbeta;
			double d7 = Dlamc3.dlamc3(d3 / 2, -(d3 / 100));
			d5 = Dlamc3.dlamc3(d7, d1);
			if (d5 == d1)
				lrnd = true;
			else
				lrnd = false;
			d7 = Dlamc3.dlamc3(d3 / 2, d3 / 100);
			d5 = Dlamc3.dlamc3(d7, d1);
			if (lrnd && (d5 == d1))
				lrnd = false;
			double d15 = Dlamc3.dlamc3(d3 / 2, d1);
			double d17 = Dlamc3.dlamc3(d3 / 2, d13);
			lieee1 = ((d15 == d1) && (d17 > d13)) && lrnd;
			lt = 0;
			d1 = 1;
			d5 = 1;
			while (d5 != d9) {
				lt++;
				d1 *= lbeta;
				d5 = Dlamc3.dlamc3(d1, d9);
				d5 = Dlamc3.dlamc3(d5, -d1);
			}
		}
		intw.val = lbeta;
		intw1.val = lt;
		booleanw.val = lrnd;
		booleanw1.val = lieee1;
		first = false;
	}

	public static boolean first = true;
	public static boolean lieee1 = false;
	public static boolean lrnd = false;
	public static int lbeta = 0;
	public static int lt = 0;
}
