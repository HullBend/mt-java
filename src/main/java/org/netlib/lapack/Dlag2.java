package org.netlib.lapack;

import org.netlib.util.Util;
import org.netlib.util.doubleW;

public final class Dlag2 {
	public static void dlag2(double ad[], int i, int j, double ad1[], int k,
			int l, double d, doubleW doublew, doubleW doublew1,
			doubleW doublew2, doubleW doublew3, doubleW doublew4) {
		double d1 = 0.0D;
		double d2 = 0.0D;
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		double d6 = 0.0D;
		double d9 = 0.0D;
		double d12 = 0.0D;
		double d13 = 0.0D;
		double d14 = 0.0D;
		double d15 = 0.0D;
		double d16 = 0.0D;
		double d17 = 0.0D;
		double d18 = 0.0D;
		double d19 = 0.0D;
		double d20 = 0.0D;
		double d21 = 0.0D;
		double d22 = 0.0D;
		double d23 = 0.0D;
		double d24 = 0.0D;
		double d25 = 0.0D;
		double d26 = 0.0D;
		double d29 = 0.0D;
		double d30 = 0.0D;
		double d31 = 0.0D;
		double d32 = 0.0D;
		double d33 = 0.0D;
		double d34 = 0.0D;
		double d35 = 0.0D;
		double d36 = 0.0D;
		double d37 = 0.0D;
		double d38 = 0.0D;
		double d39 = 0.0D;
		double d42 = 0.0D;
		double d50 = 0.0D;
		d34 = Math.sqrt(d);
		d33 = 1.0D / d34;
		d37 = 1.0D / d;
		d6 = Util.max(
				Math.abs(ad[(1 - 1) + (1 - 1) * j + i])
						+ Math.abs(ad[(2 - 1) + (1 - 1) * j + i]),
				Math.abs(ad[(1 - 1) + (2 - 1) * j + i])
						+ Math.abs(ad[(2 - 1) + (2 - 1) * j + i]), d);
		d12 = 1.0D / d6;
		d1 = d12 * ad[(1 - 1) + (1 - 1) * j + i];
		d3 = d12 * ad[(2 - 1) + (1 - 1) * j + i];
		d2 = d12 * ad[(1 - 1) + (2 - 1) * j + i];
		d4 = d12 * ad[(2 - 1) + (2 - 1) * j + i];
		d13 = ad1[(1 - 1) + (1 - 1) * l + k];
		d14 = ad1[(1 - 1) + (2 - 1) * l + k];
		d15 = ad1[(2 - 1) + (2 - 1) * l + k];
		d18 = d34
				* Math.max(
						Util.max(Math.abs(d13), Math.abs(d14), Math.abs(d15)),
						d34);
		if (Math.abs(d13) < d18)
			d13 = Util.dsign(d18, d13);
		if (Math.abs(d15) < d18)
			d15 = Util.dsign(d18, d15);
		d19 = Util.max(Math.abs(d13), Math.abs(d14) + Math.abs(d15), d);
		d21 = Math.max(Math.abs(d13), Math.abs(d15));
		d20 = 1.0D / d21;
		d13 *= d20;
		d14 *= d20;
		d15 *= d20;
		d16 = 1.0D / d13;
		d17 = 1.0D / d15;
		d35 = d1 * d16;
		d36 = d4 * d17;
		if (Math.abs(d35) <= Math.abs(d36)) {
			d9 = d2 - d35 * d14;
			double d11 = d4 - d35 * d15;
			d39 = d3 * (d16 * d17);
			d5 = d11 * d17 - d39 * d14;
			d30 = 0.5D * d5;
			d38 = d35;
		} else {
			d9 = d2 - d36 * d14;
			double d8 = d1 - d36 * d13;
			d39 = d3 * (d16 * d17);
			d5 = -(d39 * d14);
			d30 = 0.5D * (d8 * d16 + d5);
			d38 = d36;
		}
		d31 = d39 * d9;
		if (Math.abs(d30 * d34) >= 1.0D) {
			d29 = Math.pow(d34 * d30, 2) + d31 * d;
			d32 = Math.sqrt(Math.abs(d29)) * d33;
		} else if (Math.pow(d30, 2) + Math.abs(d31) <= d) {
			d29 = Math.pow(d33 * d30, 2) + d31 * d37;
			d32 = Math.sqrt(Math.abs(d29)) * d34;
		} else {
			d29 = Math.pow(d30, 2) + d31;
			d32 = Math.sqrt(Math.abs(d29));
		}
		if ((d29 >= 0.0D) || (d32 == 0.0D)) {
			double d41 = d30 + Util.dsign(d32, d30);
			double d28 = d30 - Util.dsign(d32, d30);
			double d44 = d38 + d41;
			double d53 = d38 + d28;
			if (0.5D * Math.abs(d44) > Math.max(Math.abs(d53), d)) {
				double d46 = (d1 * d4 - d2 * d3) * (d16 * d17);
				d53 = d46 / d44;
			}
			if (d30 > d5) {
				doublew2.val = Math.min(d44, d53);
				doublew3.val = Math.max(d44, d53);
			} else {
				doublew2.val = Math.max(d44, d53);
				doublew3.val = Math.min(d44, d53);
			}
			doublew4.val = 0.0D;
		} else {
			doublew2.val = d38 + d30;
			doublew3.val = doublew2.val;
			doublew4.val = d32;
		}
		d22 = d21 * (d * Math.max(1.0D, d12));
		d23 = d * Math.max(1.0D, d19);
		d24 = d21 * d;
		if ((d12 <= 1.0D) && (d21 <= 1.0D))
			d25 = Math.min(1.0D, (d12 / d) * d21);
		else
			d25 = 1.0D;
		if ((d12 <= 1.0D) || (d21 <= 1.0D))
			d26 = Math.min(1.0D, d12 * d21);
		else
			d26 = 1.0D;
		d42 = Math.abs(doublew2.val) + Math.abs(doublew4.val);
		d50 = Math.max(
				Util.max(d, d22, 1.0000100000000001D * (d42 * d23 + d24)),
				Math.min(d25, 0.5D * Math.max(d42, d26)));
		if (d50 != 1.0D) {
			double d48 = 1.0D / d50;
			if (d50 > 1.0D)
				doublew.val = Math.max(d12, d21) * d48 * Math.min(d12, d21);
			else
				doublew.val = Math.min(d12, d21) * d48 * Math.max(d12, d21);
			doublew2.val = doublew2.val * d48;
			if (doublew4.val != 0.0D) {
				doublew4.val = doublew4.val * d48;
				doublew3.val = doublew2.val;
				doublew1.val = doublew.val;
			}
		} else {
			doublew.val = d12 * d21;
			doublew1.val = doublew.val;
		}
		if (doublew4.val == 0.0D) {
			double d51 = Math
					.max(Util
							.max(d,
									d22,
									1.0000100000000001D * (Math
											.abs(doublew3.val) * d23 + d24)),
							Math.min(d25, 0.5D * Math.max(
									Math.abs(doublew3.val), d26)));
			if (d51 != 1.0D) {
				double d49 = 1.0D / d51;
				if (d51 > 1.0D)
					doublew1.val = Math.max(d12, d21) * d49
							* Math.min(d12, d21);
				else
					doublew1.val = Math.min(d12, d21) * d49
							* Math.max(d12, d21);
				doublew3.val = doublew3.val * d49;
			} else {
				doublew1.val = d12 * d21;
			}
		}
	}
}
