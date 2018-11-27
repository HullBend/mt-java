package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.Util;
import org.netlib.util.intW;

public final class Dgegs {
	public static void dgegs(String s, String s1, int i, double ad[], int j,
			int k, double ad1[], int l, int i1, double ad2[], int j1,
			double ad3[], int k1, double ad4[], int l1, double ad5[], int i2,
			int j2, double ad6[], int k2, int l2, double ad7[], int i3, int j3,
			intW intw) {
		int k5;
		label0: {
			boolean flag = false;
			boolean flag1 = false;
			boolean flag2 = false;
			boolean flag3 = false;
			boolean flag4 = false;
			int k3 = 0;
			intW intw1 = new intW(0);
			intW intw2 = new intW(0);
			byte byte0 = 0;
			byte byte1 = 0;
			int l3 = 0;
			intW intw3 = new intW(0);
			int i4 = 0;
			int j4 = 0;
			int k4 = 0;
			int l4 = 0;
			int j5 = 0;
			k5 = 0;
			double d = 0.0D;
			double d1 = 0.0D;
			double d2 = 0.0D;
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			double d6 = 0.0D;
			double d7 = 0.0D;
			if (Lsame.lsame(s, "N")) {
				byte0 = 1;
				flag2 = false;
			} else if (Lsame.lsame(s, "V")) {
				byte0 = 2;
				flag2 = true;
			} else {
				byte0 = -1;
				flag2 = false;
			}
			if (Lsame.lsame(s1, "N")) {
				byte1 = 1;
				flag3 = false;
			} else if (Lsame.lsame(s1, "V")) {
				byte1 = 2;
				flag3 = true;
			} else {
				byte1 = -1;
				flag3 = false;
			}
			j5 = Math.max(4 * i, 1);
			k5 = j5;
			ad7[(1 - 1) + i3] = k5;
			flag4 = j3 == -1;
			intw.val = 0;
			if (byte0 <= 0)
				intw.val = -1;
			else if (byte1 <= 0)
				intw.val = -2;
			else if (i < 0)
				intw.val = -3;
			else if (k < Math.max(1, i))
				intw.val = -5;
			else if (i1 < Math.max(1, i))
				intw.val = -7;
			else if ((j2 < 1) || (flag2 && (j2 < i)))
				intw.val = -12;
			else if ((l2 < 1) || (flag3 && (l2 < i)))
				intw.val = -14;
			else if ((j3 < j5) && flag4 ^ true)
				intw.val = -16;
			if (intw.val == 0) {
				int i6 = Ilaenv.ilaenv(1, "DGEQRF", " ", i, i, -1, -1);
				int j6 = Ilaenv.ilaenv(1, "DORMQR", " ", i, i, i, -1);
				int k6 = Ilaenv.ilaenv(1, "DORGQR", " ", i, i, i, -1);
				int l5 = Util.max(i6, j6, k6);
				int i5 = 2 * i + i * (l5 + 1);
				ad7[(1 - 1) + i3] = i5;
			}
			if (intw.val != 0) {
				Xerbla.xerbla("DGEGS ", -intw.val);
				return;
			}
			if (flag4)
				return;
			if (i == 0)
				return;
			d5 = Dlamch.dlamch("E") * Dlamch.dlamch("B");
			d6 = Dlamch.dlamch("S");
			d7 = (i * d6) / d5;
			d2 = 1.0D / d7;
			d = Dlange.dlange("M", i, i, ad, j, k, ad7, i3);
			flag = false;
			if ((d > 0.0D) && (d < d7)) {
				d1 = d7;
				flag = true;
			} else if (d > d2) {
				d1 = d2;
				flag = true;
			}
			if (flag) {
				Dlascl.dlascl("G", -1, -1, d, d1, i, i, ad, j, k, intw2);
				if (intw2.val != 0) {
					intw.val = i + 9;
					return;
				}
			}
			d3 = Dlange.dlange("M", i, i, ad1, l, i1, ad7, i3);
			flag1 = false;
			if ((d3 > 0.0D) && (d3 < d7)) {
				d4 = d7;
				flag1 = true;
			} else if (d3 > d2) {
				d4 = d2;
				flag1 = true;
			}
			if (flag1) {
				Dlascl.dlascl("G", -1, -1, d3, d4, i, i, ad1, l, i1, intw2);
				if (intw2.val != 0) {
					intw.val = i + 9;
					return;
				}
			}
			l3 = 1;
			i4 = i + 1;
			l4 = i4 + i;
			Dggbal.dggbal("P", i, ad, j, k, ad1, l, i1, intw3, intw1, ad7,
					(l3 - 1) + i3, ad7, (i4 - 1) + i3, ad7, (l4 - 1) + i3,
					intw2);
			if (intw2.val != 0) {
				intw.val = i + 1;
				break label0;
			}
			j4 = (intw1.val + 1) - intw3.val;
			k3 = (i + 1) - intw3.val;
			k4 = l4;
			l4 = k4 + j4;
			Dgeqrf.dgeqrf(j4, k3, ad1, (intw3.val - 1) + (intw3.val - 1) * i1
					+ l, i1, ad7, (k4 - 1) + i3, ad7, (l4 - 1) + i3, (j3 + 1)
					- l4, intw2);
			if (intw2.val >= 0)
				k5 = Math.max(k5, ((int) ad7[(l4 - 1) + i3] + l4) - 1);
			if (intw2.val != 0) {
				intw.val = i + 2;
				break label0;
			}
			Dormqr.dormqr("L", "T", j4, k3, j4, ad1, (intw3.val - 1)
					+ (intw3.val - 1) * i1 + l, i1, ad7, (k4 - 1) + i3, ad,
					(intw3.val - 1) + (intw3.val - 1) * k + j, k, ad7, (l4 - 1)
							+ i3, (j3 + 1) - l4, intw2);
			if (intw2.val >= 0)
				k5 = Math.max(k5, ((int) ad7[(l4 - 1) + i3] + l4) - 1);
			if (intw2.val != 0) {
				intw.val = i + 3;
				break label0;
			}
			if (flag2) {
				Dlaset.dlaset("Full", i, i, 0.0D, 1.0D, ad5, i2, j2);
				Dlacpy.dlacpy("L", j4 - 1, j4 - 1, ad1, ((intw3.val + 1) - 1)
						+ (intw3.val - 1) * i1 + l, i1, ad5,
						((intw3.val + 1) - 1) + (intw3.val - 1) * j2 + i2, j2);
				Dorgqr.dorgqr(j4, j4, j4, ad5, (intw3.val - 1)
						+ (intw3.val - 1) * j2 + i2, j2, ad7, (k4 - 1) + i3,
						ad7, (l4 - 1) + i3, (j3 + 1) - l4, intw2);
				if (intw2.val >= 0)
					k5 = Math.max(k5, ((int) ad7[(l4 - 1) + i3] + l4) - 1);
				if (intw2.val != 0) {
					intw.val = i + 4;
					break label0;
				}
			}
			if (flag3)
				Dlaset.dlaset("Full", i, i, 0.0D, 1.0D, ad6, k2, l2);
			Dgghrd.dgghrd(s, s1, i, intw3.val, intw1.val, ad, j, k, ad1, l, i1,
					ad5, i2, j2, ad6, k2, l2, intw2);
			if (intw2.val != 0) {
				intw.val = i + 5;
				break label0;
			}
			l4 = k4;
			Dhgeqz.dhgeqz("S", s, s1, i, intw3.val, intw1.val, ad, j, k, ad1,
					l, i1, ad2, j1, ad3, k1, ad4, l1, ad5, i2, j2, ad6, k2, l2,
					ad7, (l4 - 1) + i3, (j3 + 1) - l4, intw2);
			if (intw2.val >= 0)
				k5 = Math.max(k5, ((int) ad7[(l4 - 1) + i3] + l4) - 1);
			if (intw2.val != 0) {
				if ((intw2.val > 0) && (intw2.val <= i))
					intw.val = intw2.val;
				else if ((intw2.val > i) && (intw2.val <= 2 * i))
					intw.val = intw2.val - i;
				else
					intw.val = i + 6;
				break label0;
			}
			if (flag2) {
				Dggbak.dggbak("P", "L", i, intw3.val, intw1.val, ad7, (l3 - 1)
						+ i3, ad7, (i4 - 1) + i3, i, ad5, i2, j2, intw2);
				if (intw2.val != 0) {
					intw.val = i + 7;
					break label0;
				}
			}
			if (flag3) {
				Dggbak.dggbak("P", "R", i, intw3.val, intw1.val, ad7, (l3 - 1)
						+ i3, ad7, (i4 - 1) + i3, i, ad6, k2, l2, intw2);
				if (intw2.val != 0) {
					intw.val = i + 8;
					break label0;
				}
			}
			if (flag) {
				Dlascl.dlascl("H", -1, -1, d1, d, i, i, ad, j, k, intw2);
				if (intw2.val != 0) {
					intw.val = i + 9;
					return;
				}
				Dlascl.dlascl("G", -1, -1, d1, d, i, 1, ad2, j1, i, intw2);
				if (intw2.val != 0) {
					intw.val = i + 9;
					return;
				}
				Dlascl.dlascl("G", -1, -1, d1, d, i, 1, ad3, k1, i, intw2);
				if (intw2.val != 0) {
					intw.val = i + 9;
					return;
				}
			}
			if (flag1) {
				Dlascl.dlascl("U", -1, -1, d4, d3, i, i, ad1, l, i1, intw2);
				if (intw2.val != 0) {
					intw.val = i + 9;
					return;
				}
				Dlascl.dlascl("G", -1, -1, d4, d3, i, 1, ad4, l1, i, intw2);
				if (intw2.val != 0) {
					intw.val = i + 9;
					return;
				}
			}
		}
		ad7[(1 - 1) + i3] = k5;
	}
}
