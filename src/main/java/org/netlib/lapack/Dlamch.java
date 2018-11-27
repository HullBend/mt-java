package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.util.booleanW;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlamch {
	public static double dlamch(String s) {
		booleanW booleanw = new booleanW(false);
		intW intw = new intW(0);
		intW intw1 = new intW(0);
		intW intw2 = new intW(0);
		intW intw3 = new intW(0);
		double d = 0.0D;
		double d3 = 0.0D;
		if (first) {
			Dlamc2.dlamc2(intw, intw3, booleanw, eps, intw2, rmin, intw1, rmax);
			base = intw.val;
			t = intw3.val;
			if (booleanw.val) {
				rnd = 1.0D;
				eps.val = Math.pow(base, 1 - intw3.val) / 2;
			} else {
				rnd = 0.0D;
				eps.val = Math.pow(base, 1 - intw3.val);
			}
			prec = eps.val * base;
			emin = intw2.val;
			emax = intw1.val;
			sfmin = rmin.val;
			double d2 = 1.0D / rmax.val;
			if (d2 >= sfmin)
				sfmin = d2 * (1.0D + eps.val);
		}
		if (Lsame.lsame(s, "E"))
			d = eps.val;
		else if (Lsame.lsame(s, "S"))
			d = sfmin;
		else if (Lsame.lsame(s, "B"))
			d = base;
		else if (Lsame.lsame(s, "P"))
			d = prec;
		else if (Lsame.lsame(s, "N"))
			d = t;
		else if (Lsame.lsame(s, "R"))
			d = rnd;
		else if (Lsame.lsame(s, "M"))
			d = emin;
		else if (Lsame.lsame(s, "U"))
			d = rmin.val;
		else if (Lsame.lsame(s, "L"))
			d = emax;
		else if (Lsame.lsame(s, "O"))
			d = rmax.val;
		d3 = d;
		first = false;
		return d3;
	}

	public static boolean first = true;
	public static double base = 0.0D;
	public static double emax = 0.0D;
	public static double emin = 0.0D;
	public static doubleW eps = new doubleW(0.0D);
	public static double prec = 0.0D;
	public static doubleW rmax = new doubleW(0.0D);
	public static doubleW rmin = new doubleW(0.0D);
	public static double rnd = 0.0D;
	public static double sfmin = 0.0D;
	public static double t = 0.0D;
}
