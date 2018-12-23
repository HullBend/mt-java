package org.netlib.lapack;

import org.netlib.blas.Dnrm2;
import org.netlib.blas.Dscal;
import org.netlib.util.Util;
import org.netlib.util.doubleW;

public final class Dlarfg {

	public static void dlarfg(int i, doubleW doublew, double[] ad, int j,
			int k, doubleW doublew1) {

		double d6 = 0.0;
		if (i <= 1) {
			doublew1.val = 0.0;
			return;
		}
		d6 = Dnrm2.dnrm2(i - 1, ad, j, k);
		if (d6 == 0.0) {
			doublew1.val = 0.0;
		} else {
			double d1 = -Util.dsign(Dlapy2.dlapy2(doublew.val, d6), doublew.val);
			final double d5 = Dlamch.dlamch("S") / Dlamch.dlamch("E"); // XXX
			if (Math.abs(d1) < d5) {
				double d3 = 1.0 / d5;
				int i1 = 0;
				do {
					i1++;
					Dscal.dscal(i - 1, d3, ad, j, k);
					d1 *= d3;
					doublew.val = doublew.val * d3;
				} while (Math.abs(d1) < d5);
				double d7 = Dnrm2.dnrm2(i - 1, ad, j, k);
				d1 = -Util.dsign(Dlapy2.dlapy2(doublew.val, d7), doublew.val);
				doublew1.val = (d1 - doublew.val) / d1;
				Dscal.dscal(i - 1, 1.0 / (doublew.val - d1), ad, j, k);
				doublew.val = d1;
				for (int j1 = i1; j1 > 0; j1--) {
					doublew.val = doublew.val * d5;
				}
			} else {
				doublew1.val = (d1 - doublew.val) / d1;
				Dscal.dscal(i - 1, 1.0 / (doublew.val - d1), ad, j, k);
				doublew.val = d1;
			}
		}
	}
}
