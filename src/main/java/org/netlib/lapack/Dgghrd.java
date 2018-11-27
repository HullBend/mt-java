package org.netlib.lapack;

import org.netlib.blas.Drot;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgghrd {
	public static void dgghrd(String s, String s1, int i, int j, int k,
			double ad[], int l, int i1, double ad1[], int j1, int k1,
			double ad2[], int l1, int i2, double ad3[], int j2, int k2,
			intW intw) {
		boolean flag = false;
		boolean flag1 = false;
		byte byte0 = 0;
		byte byte1 = 0;
		int l2 = 0;
		doubleW doublew = new doubleW(0.0D);
		doubleW doublew1 = new doubleW(0.0D);
		if (Lsame.lsame(s, "N")) {
			flag = false;
			byte0 = 1;
		} else if (Lsame.lsame(s, "V")) {
			flag = true;
			byte0 = 2;
		} else if (Lsame.lsame(s, "I")) {
			flag = true;
			byte0 = 3;
		} else {
			byte0 = 0;
		}
		if (Lsame.lsame(s1, "N")) {
			flag1 = false;
			byte1 = 1;
		} else if (Lsame.lsame(s1, "V")) {
			flag1 = true;
			byte1 = 2;
		} else if (Lsame.lsame(s1, "I")) {
			flag1 = true;
			byte1 = 3;
		} else {
			byte1 = 0;
		}
		intw.val = 0;
		if (byte0 <= 0)
			intw.val = -1;
		else if (byte1 <= 0)
			intw.val = -2;
		else if (i < 0)
			intw.val = -3;
		else if (j < 1)
			intw.val = -4;
		else if ((k > i) || (k < j - 1))
			intw.val = -5;
		else if (i1 < Math.max(1, i))
			intw.val = -7;
		else if (k1 < Math.max(1, i))
			intw.val = -9;
		else if ((flag && (i2 < i)) || (i2 < 1))
			intw.val = -11;
		else if ((flag1 && (k2 < i)) || (k2 < 1))
			intw.val = -13;
		if (intw.val != 0) {
			Xerbla.xerbla("DGGHRD", -intw.val);
			return;
		}
		if (byte0 == 3)
			Dlaset.dlaset("Full", i, i, 0.0D, 1.0D, ad2, l1, i2);
		if (byte1 == 3)
			Dlaset.dlaset("Full", i, i, 0.0D, 1.0D, ad3, j2, k2);
		if (i <= 1)
			return;
		l2 = 1;
		for (int k3 = (i - 1 - 1) + 1; k3 > 0; k3--) {
			int i3 = l2 + 1;
			for (int i4 = (i - (l2 + 1)) + 1; i4 > 0; i4--) {
				ad1[(i3 - 1) + (l2 - 1) * k1 + j1] = 0.0D;
				i3++;
			}

			l2++;
		}

		l2 = j;
		for (int l3 = (k - 2 - j) + 1; l3 > 0; l3--) {
			int j3 = k;
			for (int j4 = (((l2 + 2) - k) + -1) / -1; j4 > 0; j4--) {
				double d1 = ad[(j3 - 1 - 1) + (l2 - 1) * i1 + l];
				dlartg_adapter(d1, ad[(j3 - 1) + (l2 - 1) * i1 + l], doublew,
						doublew1, ad, (j3 - 1 - 1) + (l2 - 1) * i1 + l);
				ad[(j3 - 1) + (l2 - 1) * i1 + l] = 0.0D;
				Drot.drot(i - l2, ad, (j3 - 1 - 1) + ((l2 + 1) - 1) * i1 + l,
						i1, ad, (j3 - 1) + ((l2 + 1) - 1) * i1 + l, i1,
						doublew.val, doublew1.val);
				Drot.drot((i + 2) - j3, ad1, (j3 - 1 - 1) + (j3 - 1 - 1) * k1
						+ j1, k1, ad1, (j3 - 1) + (j3 - 1 - 1) * k1 + j1, k1,
						doublew.val, doublew1.val);
				if (flag)
					Drot.drot(i, ad2, (1 - 1) + (j3 - 1 - 1) * i2 + l1, 1, ad2,
							(1 - 1) + (j3 - 1) * i2 + l1, 1, doublew.val,
							doublew1.val);
				d1 = ad1[(j3 - 1) + (j3 - 1) * k1 + j1];
				dlartg_adapter(d1, ad1[(j3 - 1) + (j3 - 1 - 1) * k1 + j1],
						doublew, doublew1, ad1, (j3 - 1) + (j3 - 1) * k1 + j1);
				ad1[(j3 - 1) + (j3 - 1 - 1) * k1 + j1] = 0.0D;
				Drot.drot(k, ad, (1 - 1) + (j3 - 1) * i1 + l, 1, ad, (1 - 1)
						+ (j3 - 1 - 1) * i1 + l, 1, doublew.val, doublew1.val);
				Drot.drot(j3 - 1, ad1, (1 - 1) + (j3 - 1) * k1 + j1, 1, ad1,
						(1 - 1) + (j3 - 1 - 1) * k1 + j1, 1, doublew.val,
						doublew1.val);
				if (flag1)
					Drot.drot(i, ad3, (1 - 1) + (j3 - 1) * k2 + j2, 1, ad3,
							(1 - 1) + (j3 - 1 - 1) * k2 + j2, 1, doublew.val,
							doublew1.val);
				j3--;
			}

			l2++;
		}

	}

	private static void dlartg_adapter(double d, double d1, doubleW doublew,
			doubleW doublew1, double ad[], int i) {
		doubleW doublew2 = new doubleW(ad[i]);
		Dlartg.dlartg(d, d1, doublew, doublew1, doublew2);
		ad[i] = doublew2.val;
	}
}
