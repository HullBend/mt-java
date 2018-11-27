package org.netlib.lapack;

import org.netlib.util.Util;
import org.netlib.util.booleanW;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlamc2 {
	public static void dlamc2(intW intw, intW intw1, booleanW booleanw,
			doubleW doublew, intW intw2, doubleW doublew1, intW intw3,
			doubleW doublew2) {
		booleanW booleanw1 = new booleanW(false);
		booleanW booleanw2 = new booleanW(false);
		intW intw4 = new intW(0);
		intW intw5 = new intW(0);
		intW intw6 = new intW(0);
		intW intw7 = new intW(0);
		if (first) {
			double d21 = 0;
			double d9 = 1;
			double d19 = 2;
			Dlamc1.dlamc1(lbeta, lt, booleanw2, booleanw1);
			double d3 = lbeta.val;
			double d1 = Math.pow(d3, -lt.val);
			leps = d1;
			d3 = d19 / 3;
			double d7 = d9 / 2;
			double d13 = Dlamc3.dlamc3(d3, -d7);
			double d17 = Dlamc3.dlamc3(d13, d13);
			d3 = Dlamc3.dlamc3(d17, -d7);
			d3 = Dlamc3.dlamc3(d3, d13);
			d3 = Math.abs(d3);
			if (d3 < leps)
				d3 = leps;
			leps = 1;
			while ((leps <= d3) || (d3 <= d21)) {
				leps = d3;
				double d5 = Dlamc3.dlamc3(d7 * leps,
						Math.pow(d19, 5) * Math.pow(leps, 2));
				d5 = Dlamc3.dlamc3(d7, -d5);
				d3 = Dlamc3.dlamc3(d7, d5);
				d5 = Dlamc3.dlamc3(d7, -d3);
				d3 = Dlamc3.dlamc3(d7, d5);
			}
			if (d1 < leps)
				leps = d1;
			double d11 = d9 / lbeta.val;
			double d15 = d9;
			for (int j = (3 - 1) + 1; j > 0; j--) {
				d15 = Dlamc3.dlamc3(d15 * d11, d21);
			}

			d1 = Dlamc3.dlamc3(d9, d15);
			Dlamc4.dlamc4(intw7, d9, lbeta.val);
			Dlamc4.dlamc4(intw6, -d9, lbeta.val);
			Dlamc4.dlamc4(intw5, d1, lbeta.val);
			Dlamc4.dlamc4(intw4, -d1, lbeta.val);
			boolean flag1 = false;
			if ((intw7.val == intw6.val) && (intw5.val == intw4.val)) {
				if (intw7.val == intw5.val)
					lemin = intw7.val;
				else if (intw5.val - intw7.val == 3) {
					lemin = (intw7.val - 1) + lt.val;
					flag1 = true;
				} else {
					lemin = Math.min(intw7.val, intw5.val);
					iwarn = true;
				}
			} else if ((intw7.val == intw5.val) && (intw6.val == intw4.val)) {
				if (Math.abs(intw7.val - intw6.val) == 1) {
					lemin = Math.max(intw7.val, intw6.val);
				} else {
					lemin = Math.min(intw7.val, intw6.val);
					iwarn = true;
				}
			} else if ((Math.abs(intw7.val - intw6.val) == 1)
					&& (intw5.val == intw4.val)) {
				if (intw5.val - Math.min(intw7.val, intw6.val) == 3) {
					lemin = (Math.max(intw7.val, intw6.val) - 1) + lt.val;
				} else {
					lemin = Math.min(intw7.val, intw6.val);
					iwarn = true;
				}
			} else {
				lemin = Math.min(Util.min(intw7.val, intw6.val, intw5.val),
						intw4.val);
				iwarn = true;
			}
			first = false;
			if (iwarn) {
				first = true;
				System.err
						.println("WARNING. The value EMIN may be incorrect:  EMIN = '"
								+ lemin
								+ "'. If, after inspection, the value EMIN looks acceptable please comment out the IF block as marked within the code of routine 'DLAMC2' otherwise supply EMIN explicitly.");
			}
			flag1 = flag1 || booleanw1.val;
			lrmin = 1;
			for (int k = (1 - lemin - 1) + 1; k > 0; k--) {
				lrmin = Dlamc3.dlamc3(lrmin * d11, d21);
			}

			Dlamc5.dlamc5(lbeta.val, lt.val, lemin, flag1, lemax, lrmax);
		}
		intw.val = lbeta.val;
		intw1.val = lt.val;
		booleanw.val = booleanw2.val;
		doublew.val = leps;
		intw2.val = lemin;
		doublew1.val = lrmin;
		intw3.val = lemax.val;
		doublew2.val = lrmax.val;
	}

	public static boolean first = true;
	public static boolean iwarn = false;
	public static intW lbeta = new intW(0);
	public static intW lemax = new intW(0);
	public static int lemin = 0;
	public static intW lt = new intW(0);
	public static double leps = 0.0D;
	public static doubleW lrmax = new doubleW(0.0D);
	public static double lrmin = 0.0D;
}
