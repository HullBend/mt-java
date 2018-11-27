package org.netlib.lapack;

import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlamc5 {
	public static void dlamc5(int i, int j, int k, boolean flag, intW intw,
			doubleW doublew) {
		int l = 0;
		int i1 = 0;
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		int j2 = 0;
		double d = 0.0D;
		double d1 = 0.0D;
		double d2 = 0.0D;
		double d3 = 0.0D;
		k1 = 1;
		l = 1;
		do {
			i2 = k1 * 2;
			if (i2 > -k)
				break;
			k1 = i2;
			l++;
		} while (true);
		if (k1 == -k) {
			j2 = k1;
		} else {
			j2 = i2;
			l++;
		}
		if (j2 + k > -k1 - k)
			i1 = 2 * k1;
		else
			i1 = 2 * j2;
		intw.val = (i1 + k) - 1;
		l1 = 1 + l + j;
		if ((l1 % 2 == 1) && (i == 2))
			intw.val = intw.val - 1;
		if (flag)
			intw.val = intw.val - 1;
		d1 = 1.0D / i;
		d3 = i - 1.0D;
		d2 = 0.0D;
		for (int k2 = (j - 1) + 1; k2 > 0; k2--) {
			d3 *= d1;
			if (d2 < 1.0D)
				d = d2;
			d2 = Dlamc3.dlamc3(d2, d3);
		}

		if (d2 >= 1.0D)
			d2 = d;
		for (int l2 = (intw.val - 1) + 1; l2 > 0; l2--) {
			d2 = Dlamc3.dlamc3(d2 * i, 0.0D);
		}

		doublew.val = d2;
	}
}
