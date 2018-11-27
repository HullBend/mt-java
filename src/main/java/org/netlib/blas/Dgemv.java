package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dgemv {
	public static void dgemv(String s, int i, int j, double d, double ad[],
			int k, int l, double ad1[], int i1, int j1, double d1,
			double ad2[], int k1, int l1) {
		byte byte0 = 0;
		int j6 = 0;
		int k6 = 0;
		int l6 = 0;
		int i7 = 0;
		byte0 = 0;
		if ((Lsame.lsame(s, "N") ^ true && Lsame.lsame(s, "T") ^ true)
				&& Lsame.lsame(s, "C") ^ true)
			byte0 = 1;
		else if (i < 0)
			byte0 = 2;
		else if (j < 0)
			byte0 = 3;
		else if (l < Math.max(1, i))
			byte0 = 6;
		else if (j1 == 0)
			byte0 = 8;
		else if (l1 == 0)
			byte0 = 11;
		if (byte0 != 0) {
			Xerbla.xerbla("DGEMV ", byte0);
			return;
		}
		if (((i == 0) || (j == 0)) || ((d == 0.0D) && (d1 == 1.0D)))
			return;
		if (Lsame.lsame(s, "N")) {
			l6 = j;
			i7 = i;
		} else {
			l6 = i;
			i7 = j;
		}
		if (j1 > 0)
			j6 = 1;
		else
			j6 = 1 - (l6 - 1) * j1;
		if (l1 > 0)
			k6 = 1;
		else
			k6 = 1 - (i7 - 1) * l1;
		if (d1 != 1.0D)
			if (l1 == 1) {
				if (d1 == 0.0D) {
					int i2 = 1;
					for (int j7 = (i7 - 1) + 1; j7 > 0; j7--) {
						ad2[(i2 - 1) + k1] = 0.0D;
						i2++;
					}

				} else {
					int j2 = 1;
					for (int k7 = (i7 - 1) + 1; k7 > 0; k7--) {
						ad2[(j2 - 1) + k1] = d1 * ad2[(j2 - 1) + k1];
						j2++;
					}

				}
			} else {
				int j4 = k6;
				if (d1 == 0.0D) {
					for (int l7 = (i7 - 1) + 1; l7 > 0; l7--) {
						ad2[(j4 - 1) + k1] = 0.0D;
						j4 += l1;
					}

				} else {
					for (int i8 = (i7 - 1) + 1; i8 > 0; i8--) {
						ad2[(j4 - 1) + k1] = d1 * ad2[(j4 - 1) + k1];
						j4 += l1;
					}

				}
			}
		if (d == 0.0D)
			return;
		if (Lsame.lsame(s, "N")) {
			int l5 = j6;
			if (l1 == 1) {
				int l4 = 1;
				for (int j8 = (j - 1) + 1; j8 > 0; j8--) {
					if (ad1[(l5 - 1) + i1] != 0.0D) {
						double d3 = d * ad1[(l5 - 1) + i1];
						int i3 = 1;
						for (int j9 = (i - 1) + 1; j9 > 0; j9--) {
							ad2[(i3 - 1) + k1] = ad2[(i3 - 1) + k1] + d3
									* ad[(i3 - 1) + (l4 - 1) * l + k];
							i3++;
						}

					}
					l5 += j1;
					l4++;
				}

			} else {
				int i5 = 1;
				for (int k8 = (j - 1) + 1; k8 > 0; k8--) {
					if (ad1[(l5 - 1) + i1] != 0.0D) {
						double d4 = d * ad1[(l5 - 1) + i1];
						int k4 = k6;
						int j3 = 1;
						for (int k9 = (i - 1) + 1; k9 > 0; k9--) {
							ad2[(k4 - 1) + k1] = ad2[(k4 - 1) + k1] + d4
									* ad[(j3 - 1) + (i5 - 1) * l + k];
							k4 += l1;
							j3++;
						}

					}
					l5 += j1;
					i5++;
				}

			}
		} else {
			int i6 = k6;
			if (j1 == 1) {
				int j5 = 1;
				for (int l8 = (j - 1) + 1; l8 > 0; l8--) {
					double d5 = 0.0D;
					int k3 = 1;
					for (int l9 = (i - 1) + 1; l9 > 0; l9--) {
						d5 += ad[(k3 - 1) + (j5 - 1) * l + k]
								* ad1[(k3 - 1) + i1];
						k3++;
					}

					ad2[(i6 - 1) + k1] = ad2[(i6 - 1) + k1] + d * d5;
					i6 += l1;
					j5++;
				}

			} else {
				int k5 = 1;
				for (int i9 = (j - 1) + 1; i9 > 0; i9--) {
					double d6 = 0.0D;
					int i4 = j6;
					int l3 = 1;
					for (int i10 = (i - 1) + 1; i10 > 0; i10--) {
						d6 += ad[(l3 - 1) + (k5 - 1) * l + k]
								* ad1[(i4 - 1) + i1];
						i4 += j1;
						l3++;
					}

					ad2[(i6 - 1) + k1] = ad2[(i6 - 1) + k1] + d * d6;
					i6 += l1;
					k5++;
				}

			}
		}
	}
}
