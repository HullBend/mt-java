package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dlascl {
	public static void dlascl(String s, int i, int j, double d, double d1,
			int k, int l, double ad[], int i1, int j1, intW intw) {
		boolean flag = false;
		byte byte0 = 0;
		double d2 = 0.0D;
		double d5 = 0.0D;
		double d8 = 0.0D;
		double d11 = 0.0D;
		intw.val = 0;
		if (Lsame.lsame(s, "G"))
			byte0 = 0;
		else if (Lsame.lsame(s, "L"))
			byte0 = 1;
		else if (Lsame.lsame(s, "U"))
			byte0 = 2;
		else if (Lsame.lsame(s, "H"))
			byte0 = 3;
		else if (Lsame.lsame(s, "B"))
			byte0 = 4;
		else if (Lsame.lsame(s, "Q"))
			byte0 = 5;
		else if (Lsame.lsame(s, "Z"))
			byte0 = 6;
		else
			byte0 = -1;
		if (byte0 == -1)
			intw.val = -1;
		else if (d == 0.0D)
			intw.val = -4;
		else if (k < 0)
			intw.val = -6;
		else if (((l < 0) || ((byte0 == 4) && (l != k)))
				|| ((byte0 == 5) && (l != k)))
			intw.val = -7;
		else if ((byte0 <= 3) && (j1 < Math.max(1, k)))
			intw.val = -9;
		else if (byte0 >= 4)
			if ((i < 0) || (i > Math.max(k - 1, 0)))
				intw.val = -2;
			else if (((j < 0) || (j > Math.max(l - 1, 0)))
					|| (((byte0 == 4) || (byte0 == 5)) && (i != j)))
				intw.val = -3;
			else if ((((byte0 == 4) && (j1 < i + 1)) || ((byte0 == 5) && (j1 < j + 1)))
					|| ((byte0 == 6) && (j1 < 2 * i + j + 1)))
				intw.val = -9;
		if (intw.val != 0) {
			Xerbla.xerbla("DLASCL", -intw.val);
			return;
		}
		if ((l == 0) || (k == 0))
			return;
		d11 = Dlamch.dlamch("S");
		d2 = 1.0D / d11;
		d5 = d;
		d8 = d1;
		do {
			double d4 = d5 * d11;
			double d7 = d8 / d2;
			double d10;
			if ((Math.abs(d4) > Math.abs(d8)) && (d8 != 0.0D)) {
				d10 = d11;
				flag = false;
				d5 = d4;
			} else if (Math.abs(d7) > Math.abs(d5)) {
				d10 = d2;
				flag = false;
				d8 = d7;
			} else {
				d10 = d8 / d5;
				flag = true;
			}
			if (byte0 == 0) {
				int j3 = 1;
				for (int i7 = (l - 1) + 1; i7 > 0; i7--) {
					int k1 = 1;
					for (int l8 = (k - 1) + 1; l8 > 0; l8--) {
						ad[(k1 - 1) + (j3 - 1) * j1 + i1] = ad[(k1 - 1)
								+ (j3 - 1) * j1 + i1]
								* d10;
						k1++;
					}

					j3++;
				}

			} else if (byte0 == 1) {
				int k3 = 1;
				for (int j7 = (l - 1) + 1; j7 > 0; j7--) {
					int l1 = k3;
					for (int i9 = (k - k3) + 1; i9 > 0; i9--) {
						ad[(l1 - 1) + (k3 - 1) * j1 + i1] = ad[(l1 - 1)
								+ (k3 - 1) * j1 + i1]
								* d10;
						l1++;
					}

					k3++;
				}

			} else if (byte0 == 2) {
				int l3 = 1;
				for (int k7 = (l - 1) + 1; k7 > 0; k7--) {
					int i2 = 1;
					for (int j9 = (Math.min(l3, k) - 1) + 1; j9 > 0; j9--) {
						ad[(i2 - 1) + (l3 - 1) * j1 + i1] = ad[(i2 - 1)
								+ (l3 - 1) * j1 + i1]
								* d10;
						i2++;
					}

					l3++;
				}

			} else if (byte0 == 3) {
				int i4 = 1;
				for (int l7 = (l - 1) + 1; l7 > 0; l7--) {
					int j2 = 1;
					for (int k9 = (Math.min(i4 + 1, k) - 1) + 1; k9 > 0; k9--) {
						ad[(j2 - 1) + (i4 - 1) * j1 + i1] = ad[(j2 - 1)
								+ (i4 - 1) * j1 + i1]
								* d10;
						j2++;
					}

					i4++;
				}

			} else if (byte0 == 4) {
				int l5 = i + 1;
				int k6 = l + 1;
				int j4 = 1;
				for (int i8 = (l - 1) + 1; i8 > 0; i8--) {
					int k2 = 1;
					for (int l9 = (Math.min(l5, k6 - j4) - 1) + 1; l9 > 0; l9--) {
						ad[(k2 - 1) + (j4 - 1) * j1 + i1] = ad[(k2 - 1)
								+ (j4 - 1) * j1 + i1]
								* d10;
						k2++;
					}

					j4++;
				}

			} else if (byte0 == 5) {
				int i5 = j + 2;
				int i6 = j + 1;
				int k4 = 1;
				for (int j8 = (l - 1) + 1; j8 > 0; j8--) {
					int l2 = Math.max(i5 - k4, 1);
					for (int i10 = (i6 - Math.max(i5 - k4, 1)) + 1; i10 > 0; i10--) {
						ad[(l2 - 1) + (k4 - 1) * j1 + i1] = ad[(l2 - 1)
								+ (k4 - 1) * j1 + i1]
								* d10;
						l2++;
					}

					k4++;
				}

			} else if (byte0 == 6) {
				int j5 = i + j + 2;
				int k5 = i + 1;
				int j6 = 2 * i + j + 1;
				int l6 = i + j + 1 + k;
				int l4 = 1;
				for (int k8 = (l - 1) + 1; k8 > 0; k8--) {
					int i3 = Math.max(j5 - l4, k5);
					for (int j10 = (Math.min(j6, l6 - l4) - Math.max(j5 - l4,
							k5)) + 1; j10 > 0; j10--) {
						ad[(i3 - 1) + (l4 - 1) * j1 + i1] = ad[(i3 - 1)
								+ (l4 - 1) * j1 + i1]
								* d10;
						i3++;
					}

					l4++;
				}

			}
		} while (flag ^ true);
	}
}
