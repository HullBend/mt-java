package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dgemm {
	public static void dgemm(String s, String s1, int i, int j, int k,
			double d, double ad[], int l, int i1, double ad1[], int j1, int k1,
			double d1, double ad2[], int l1, int i2) {
		byte byte0 = 0;
		int l7 = 0;
		int i8 = 0;
		boolean flag4 = false;
		boolean flag5 = false;
		flag4 = Lsame.lsame(s, "N");
		flag5 = Lsame.lsame(s1, "N");
		if (flag4) {
			l7 = i;
		} else {
			l7 = k;
		}
		if (flag5)
			i8 = k;
		else
			i8 = j;
		byte0 = 0;
		if ((flag4 ^ true && Lsame.lsame(s, "C") ^ true) && Lsame.lsame(s, "T")
				^ true)
			byte0 = 1;
		else if ((flag5 ^ true && Lsame.lsame(s1, "C") ^ true)
				&& Lsame.lsame(s1, "T") ^ true)
			byte0 = 2;
		else if (i < 0)
			byte0 = 3;
		else if (j < 0)
			byte0 = 4;
		else if (k < 0)
			byte0 = 5;
		else if (i1 < Math.max(1, l7))
			byte0 = 8;
		else if (k1 < Math.max(1, i8))
			byte0 = 10;
		else if (i2 < Math.max(1, i))
			byte0 = 13;
		if (byte0 != 0) {
			Xerbla.xerbla("DGEMM ", byte0);
			return;
		}
		if (((i == 0) || (j == 0))
				|| (((d == 0.0D) || (k == 0)) && (d1 == 1.0D)))
			return;
		if (d == 0.0D) {
			if (d1 == 0.0D) {
				int l4 = 1;
				for (int j8 = (j - 1) + 1; j8 > 0; j8--) {
					int j2 = 1;
					for (int l9 = (i - 1) + 1; l9 > 0; l9--) {
						ad2[(j2 - 1) + (l4 - 1) * i2 + l1] = 0.0D;
						j2++;
					}

					l4++;
				}

			} else {
				int i5 = 1;
				for (int k8 = (j - 1) + 1; k8 > 0; k8--) {
					int k2 = 1;
					for (int i10 = (i - 1) + 1; i10 > 0; i10--) {
						ad2[(k2 - 1) + (i5 - 1) * i2 + l1] = d1
								* ad2[(k2 - 1) + (i5 - 1) * i2 + l1];
						k2++;
					}

					i5++;
				}

			}
			return;
		}
		if (flag5) {
			if (flag4) {
				int j5 = 1;
				for (int l8 = (j - 1) + 1; l8 > 0; l8--) {
					if (d1 == 0.0D) {
						int l2 = 1;
						for (int j10 = (i - 1) + 1; j10 > 0; j10--) {
							ad2[(l2 - 1) + (j5 - 1) * i2 + l1] = 0.0D;
							l2++;
						}

					} else if (d1 != 1.0D) {
						int i3 = 1;
						for (int k10 = (i - 1) + 1; k10 > 0; k10--) {
							ad2[(i3 - 1) + (j5 - 1) * i2 + l1] = d1
									* ad2[(i3 - 1) + (j5 - 1) * i2 + l1];
							i3++;
						}

					}
					int j6 = 1;
					for (int l10 = (k - 1) + 1; l10 > 0; l10--) {
						if (ad1[(j6 - 1) + (j5 - 1) * k1 + j1] != 0.0D) {
							double d3 = d * ad1[(j6 - 1) + (j5 - 1) * k1 + j1];
							int j3 = 1;
							for (int j12 = (i - 1) + 1; j12 > 0; j12--) {
								ad2[(j3 - 1) + (j5 - 1) * i2 + l1] = ad2[(j3 - 1)
										+ (j5 - 1) * i2 + l1]
										+ d3 * ad[(j3 - 1) + (j6 - 1) * i1 + l];
								j3++;
							}

						}
						j6++;
					}

					j5++;
				}

			} else {
				int k5 = 1;
				for (int i9 = (j - 1) + 1; i9 > 0; i9--) {
					int k3 = 1;
					for (int i11 = (i - 1) + 1; i11 > 0; i11--) {
						double d4 = 0.0D;
						int k6 = 1;
						for (int k12 = (k - 1) + 1; k12 > 0; k12--) {
							d4 += ad[(k6 - 1) + (k3 - 1) * i1 + l]
									* ad1[(k6 - 1) + (k5 - 1) * k1 + j1];
							k6++;
						}

						if (d1 == 0.0D)
							ad2[(k3 - 1) + (k5 - 1) * i2 + l1] = d * d4;
						else
							ad2[(k3 - 1) + (k5 - 1) * i2 + l1] = d * d4 + d1
									* ad2[(k3 - 1) + (k5 - 1) * i2 + l1];
						k3++;
					}

					k5++;
				}

			}
		} else if (flag4) {
			int l5 = 1;
			for (int j9 = (j - 1) + 1; j9 > 0; j9--) {
				if (d1 == 0.0D) {
					int l3 = 1;
					for (int j11 = (i - 1) + 1; j11 > 0; j11--) {
						ad2[(l3 - 1) + (l5 - 1) * i2 + l1] = 0.0D;
						l3++;
					}

				} else if (d1 != 1.0D) {
					int i4 = 1;
					for (int k11 = (i - 1) + 1; k11 > 0; k11--) {
						ad2[(i4 - 1) + (l5 - 1) * i2 + l1] = d1
								* ad2[(i4 - 1) + (l5 - 1) * i2 + l1];
						i4++;
					}

				}
				int l6 = 1;
				for (int l11 = (k - 1) + 1; l11 > 0; l11--) {
					if (ad1[(l5 - 1) + (l6 - 1) * k1 + j1] != 0.0D) {
						double d5 = d * ad1[(l5 - 1) + (l6 - 1) * k1 + j1];
						int j4 = 1;
						for (int l12 = (i - 1) + 1; l12 > 0; l12--) {
							ad2[(j4 - 1) + (l5 - 1) * i2 + l1] = ad2[(j4 - 1)
									+ (l5 - 1) * i2 + l1]
									+ d5 * ad[(j4 - 1) + (l6 - 1) * i1 + l];
							j4++;
						}

					}
					l6++;
				}

				l5++;
			}

		} else {
			int i6 = 1;
			for (int k9 = (j - 1) + 1; k9 > 0; k9--) {
				int k4 = 1;
				for (int i12 = (i - 1) + 1; i12 > 0; i12--) {
					double d6 = 0.0D;
					int i7 = 1;
					for (int i13 = (k - 1) + 1; i13 > 0; i13--) {
						d6 += ad[(i7 - 1) + (k4 - 1) * i1 + l]
								* ad1[(i6 - 1) + (i7 - 1) * k1 + j1];
						i7++;
					}

					if (d1 == 0.0D)
						ad2[(k4 - 1) + (i6 - 1) * i2 + l1] = d * d6;
					else
						ad2[(k4 - 1) + (i6 - 1) * i2 + l1] = d * d6 + d1
								* ad2[(k4 - 1) + (i6 - 1) * i2 + l1];
					k4++;
				}

				i6++;
			}

		}
	}
}
