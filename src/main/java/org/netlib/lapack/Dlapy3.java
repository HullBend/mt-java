package org.netlib.lapack;

import org.netlib.util.Util;

public final class Dlapy3 {
	public static double dlapy3(double d, double d1, double d2) {
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		double d6 = 0.0D;
		double d7 = 0.0D;
		d4 = Math.abs(d);
		d5 = Math.abs(d1);
		d6 = Math.abs(d2);
		d3 = Util.max(d4, d5, d6);
		if (d3 == 0.0D)
			d7 = d4 + d5 + d6;
		else
			d7 = d3
					* Math.sqrt(Math.pow(d4 / d3, 2) + Math.pow(d5 / d3, 2)
							+ Math.pow(d6 / d3, 2));
		return d7;
	}
}
