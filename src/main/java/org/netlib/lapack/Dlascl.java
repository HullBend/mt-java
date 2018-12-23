package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dlascl {

	public static void dlascl(String s, int i, int j, double d, double d1,
			int k, int l, double ad[], int i1, int j1, intW info) {

		info.val = 0;
		int byte0 = 0;
		if (Lsame.lsame(s, "G")) {
			byte0 = 0;
		} else if (Lsame.lsame(s, "L")) {
			byte0 = 1;
		} else if (Lsame.lsame(s, "U")) { 
			byte0 = 2;
		} else if (Lsame.lsame(s, "H")) {
			byte0 = 3;
		} else if (Lsame.lsame(s, "B")) {
			byte0 = 4;
		} else if (Lsame.lsame(s, "Q")) {
			byte0 = 5;
		} else if (Lsame.lsame(s, "Z")) {
			byte0 = 6;
		} else {
			byte0 = -1;
		}

		if (byte0 == -1) {
			info.val = -1;
		} else if (d == 0.0) {
			info.val = -4;
		} else if (k < 0) {
			info.val = -6;
		} else if ((l < 0 || (byte0 == 4 && l != k)) || (byte0 == 5 && l != k)) {
			info.val = -7;
		} else if (byte0 <= 3 && j1 < Math.max(1, k)) {
			info.val = -9;
		} else if (byte0 >= 4) {
			if (i < 0 || i > Math.max(k - 1, 0)) {
				info.val = -2;
			} else if ((j < 0 || j > Math.max(l - 1, 0)) || ((byte0 == 4 || byte0 == 5) && (i != j))) {
				info.val = -3;
			} else if (((byte0 == 4 && j1 < i + 1) || (byte0 == 5 && j1 < j + 1))
					|| (byte0 == 6 && j1 < 2 * i + j + 1)) {
				info.val = -9;
			}
		}

		if (info.val != 0) {
			Xerbla.xerbla("DLASCL", -info.val);
			return;
		}
		if (l == 0 || k == 0) {
			return;
		}

		boolean flag = false;
		final double d11 = 2.2250738585072014E-308;
		double d2 = 1.0 / d11;
		double d5 = d;
		double d8 = d1;
		do {
			double d4 = d5 * d11;
			double d7 = d8 / d2;
			double d10;
			if (Math.abs(d4) > Math.abs(d8) && d8 != 0.0) {
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
				for (int p = l; p > 0; p--) {
					int k1 = 1;
					for (int q = k; q > 0; q--) {
						ad[k1 - 1 + (j3 - 1) * j1 + i1] = ad[k1 - 1
								+ (j3 - 1) * j1 + i1]
								* d10;
						k1++;
					}

					j3++;
				}

			} else if (byte0 == 1) {
				int k3 = 1;
				for (int p = l; p > 0; p--) {
					int l1 = k3;
					for (int q = k - k3 + 1; q > 0; q--) {
						ad[l1 - 1 + (k3 - 1) * j1 + i1] = ad[l1 - 1
								+ (k3 - 1) * j1 + i1]
								* d10;
						l1++;
					}

					k3++;
				}

			} else if (byte0 == 2) {
				int l3 = 1;
				for (int p = l; p > 0; p--) {
					int i2 = 1;
					for (int q = Math.min(l3, k); q > 0; q--) {
						ad[i2 - 1 + (l3 - 1) * j1 + i1] = ad[i2 - 1
								+ (l3 - 1) * j1 + i1]
								* d10;
						i2++;
					}

					l3++;
				}

			} else if (byte0 == 3) {
				int i4 = 1;
				for (int p = l; p > 0; p--) {
					int j2 = 1;
					for (int q = Math.min(i4 + 1, k); q > 0; q--) {
						ad[j2 - 1 + (i4 - 1) * j1 + i1] = ad[j2 - 1
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
				for (int p = l; p > 0; p--) {
					int k2 = 1;
					for (int q = Math.min(l5, k6 - j4); q > 0; q--) {
						ad[k2 - 1 + (j4 - 1) * j1 + i1] = ad[k2 - 1
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
				for (int p = l; p > 0; p--) {
					int l2 = Math.max(i5 - k4, 1);
					for (int q = i6 - Math.max(i5 - k4, 1) + 1; q > 0; q--) {
						ad[l2 - 1 + (k4 - 1) * j1 + i1] = ad[l2 - 1
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
				for (int p = l; p > 0; p--) {
					int i3 = Math.max(j5 - l4, k5);
					for (int q = (Math.min(j6, l6 - l4) - Math.max(j5 - l4,
							k5)) + 1; q > 0; q--) {
						ad[i3 - 1 + (l4 - 1) * j1 + i1] = ad[i3 - 1
								+ (l4 - 1) * j1 + i1]
								* d10;
						i3++;
					}

					l4++;
				}

			}
		} while (!flag);
	}
}
