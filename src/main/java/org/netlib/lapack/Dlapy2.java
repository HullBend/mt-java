package org.netlib.lapack;

public final class Dlapy2 {
	public static double dlapy2(double d, double d1) {
		double d2 = 0.0D;
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		double d6 = 0.0D;
		d3 = Math.abs(d);
		d4 = Math.abs(d1);
		d2 = Math.max(d3, d4);
		d5 = Math.min(d3, d4);
		if (d5 == 0.0D)
			d6 = d2;
		else
			d6 = d2 * Math.sqrt(1.0D + Math.pow(d5 / d2, 2));
		return d6;
	}
}
