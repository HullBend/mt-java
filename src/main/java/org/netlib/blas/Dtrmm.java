package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dtrmm {
	public static void dtrmm(String s, String s1, String s2, String s3, int i,
			int j, double d, double ad[], int k, int l, double ad1[], int i1,
			int j1) {
		byte byte0 = 0;
		int i9 = 0;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		flag3 = Lsame.lsame(s, "L");
		if (flag3)
			i9 = i;
		else
			i9 = j;
		flag4 = Lsame.lsame(s3, "N");
		flag5 = Lsame.lsame(s1, "U");
		byte0 = 0;
		if (flag3 ^ true && Lsame.lsame(s, "R") ^ true)
			byte0 = 1;
		else if (flag5 ^ true && Lsame.lsame(s1, "L") ^ true)
			byte0 = 2;
		else if ((Lsame.lsame(s2, "N") ^ true && Lsame.lsame(s2, "T") ^ true)
				&& Lsame.lsame(s2, "C") ^ true)
			byte0 = 3;
		else if (Lsame.lsame(s3, "U") ^ true && Lsame.lsame(s3, "N") ^ true)
			byte0 = 4;
		else if (i < 0)
			byte0 = 5;
		else if (j < 0)
			byte0 = 6;
		else if (l < Math.max(1, i9))
			byte0 = 9;
		else if (j1 < Math.max(1, i))
			byte0 = 11;
		if (byte0 != 0) {
			Xerbla.xerbla("DTRMM ", byte0);
			return;
		}
		if (j == 0)
			return;
		if (d == 0.0D) {
			int l4 = 1;
			for (int j9 = (j - 1) + 1; j9 > 0; j9--) {
				int k1 = 1;
				for (int k11 = (i - 1) + 1; k11 > 0; k11--) {
					ad1[(k1 - 1) + (l4 - 1) * j1 + i1] = 0.0D;
					k1++;
				}

				l4++;
			}

			return;
		}
		if (flag3) {
			if (Lsame.lsame(s2, "N")) {
				if (flag5) {
					int i5 = 1;
					for (int k9 = (j - 1) + 1; k9 > 0; k9--) {
						int i7 = 1;
						for (int l11 = (i - 1) + 1; l11 > 0; l11--) {
							if (ad1[(i7 - 1) + (i5 - 1) * j1 + i1] != 0.0D) {
								double d2 = d
										* ad1[(i7 - 1) + (i5 - 1) * j1 + i1];
								int l1 = 1;
								for (int l14 = (i7 - 1 - 1) + 1; l14 > 0; l14--) {
									ad1[(l1 - 1) + (i5 - 1) * j1 + i1] = ad1[(l1 - 1)
											+ (i5 - 1) * j1 + i1]
											+ d2
											* ad[(l1 - 1) + (i7 - 1) * l + k];
									l1++;
								}

								if (flag4)
									d2 *= ad[(i7 - 1) + (i7 - 1) * l + k];
								ad1[(i7 - 1) + (i5 - 1) * j1 + i1] = d2;
							}
							i7++;
						}

						i5++;
					}

				} else {
					int j5 = 1;
					for (int l9 = (j - 1) + 1; l9 > 0; l9--) {
						int j7 = i;
						for (int i12 = ((1 - i) + -1) / -1; i12 > 0; i12--) {
							if (ad1[(j7 - 1) + (j5 - 1) * j1 + i1] != 0.0D) {
								double d3 = d
										* ad1[(j7 - 1) + (j5 - 1) * j1 + i1];
								ad1[(j7 - 1) + (j5 - 1) * j1 + i1] = d3;
								if (flag4)
									ad1[(j7 - 1) + (j5 - 1) * j1 + i1] = ad1[(j7 - 1)
											+ (j5 - 1) * j1 + i1]
											* ad[(j7 - 1) + (j7 - 1) * l + k];
								int i2 = j7 + 1;
								for (int i15 = (i - (j7 + 1)) + 1; i15 > 0; i15--) {
									ad1[(i2 - 1) + (j5 - 1) * j1 + i1] = ad1[(i2 - 1)
											+ (j5 - 1) * j1 + i1]
											+ d3
											* ad[(i2 - 1) + (j7 - 1) * l + k];
									i2++;
								}

							}
							j7--;
						}

						j5++;
					}

				}
			} else if (flag5) {
				int k5 = 1;
				for (int i10 = (j - 1) + 1; i10 > 0; i10--) {
					int j2 = i;
					for (int j12 = ((1 - i) + -1) / -1; j12 > 0; j12--) {
						double d4 = ad1[(j2 - 1) + (k5 - 1) * j1 + i1];
						if (flag4)
							d4 *= ad[(j2 - 1) + (j2 - 1) * l + k];
						int k7 = 1;
						for (int j15 = (j2 - 1 - 1) + 1; j15 > 0; j15--) {
							d4 += ad[(k7 - 1) + (j2 - 1) * l + k]
									* ad1[(k7 - 1) + (k5 - 1) * j1 + i1];
							k7++;
						}

						ad1[(j2 - 1) + (k5 - 1) * j1 + i1] = d * d4;
						j2--;
					}

					k5++;
				}

			} else {
				int l5 = 1;
				for (int j10 = (j - 1) + 1; j10 > 0; j10--) {
					int k2 = 1;
					for (int k12 = (i - 1) + 1; k12 > 0; k12--) {
						double d5 = ad1[(k2 - 1) + (l5 - 1) * j1 + i1];
						if (flag4)
							d5 *= ad[(k2 - 1) + (k2 - 1) * l + k];
						int l7 = k2 + 1;
						for (int k15 = (i - (k2 + 1)) + 1; k15 > 0; k15--) {
							d5 += ad[(l7 - 1) + (k2 - 1) * l + k]
									* ad1[(l7 - 1) + (l5 - 1) * j1 + i1];
							l7++;
						}

						ad1[(k2 - 1) + (l5 - 1) * j1 + i1] = d * d5;
						k2++;
					}

					l5++;
				}

			}
		} else if (Lsame.lsame(s2, "N")) {
			if (flag5) {
				int i6 = j;
				for (int k10 = ((1 - j) + -1) / -1; k10 > 0; k10--) {
					double d6 = d;
					if (flag4)
						d6 *= ad[(i6 - 1) + (i6 - 1) * l + k];
					int l2 = 1;
					for (int l12 = (i - 1) + 1; l12 > 0; l12--) {
						ad1[(l2 - 1) + (i6 - 1) * j1 + i1] = d6
								* ad1[(l2 - 1) + (i6 - 1) * j1 + i1];
						l2++;
					}

					int i8 = 1;
					for (int i13 = (i6 - 1 - 1) + 1; i13 > 0; i13--) {
						if (ad[(i8 - 1) + (i6 - 1) * l + k] != 0.0D) {
							double d7 = d * ad[(i8 - 1) + (i6 - 1) * l + k];
							int i3 = 1;
							for (int l15 = (i - 1) + 1; l15 > 0; l15--) {
								ad1[(i3 - 1) + (i6 - 1) * j1 + i1] = ad1[(i3 - 1)
										+ (i6 - 1) * j1 + i1]
										+ d7
										* ad1[(i3 - 1) + (i8 - 1) * j1 + i1];
								i3++;
							}

						}
						i8++;
					}

					i6--;
				}

			} else {
				int j6 = 1;
				for (int l10 = (j - 1) + 1; l10 > 0; l10--) {
					double d8 = d;
					if (flag4)
						d8 *= ad[(j6 - 1) + (j6 - 1) * l + k];
					int j3 = 1;
					for (int j13 = (i - 1) + 1; j13 > 0; j13--) {
						ad1[(j3 - 1) + (j6 - 1) * j1 + i1] = d8
								* ad1[(j3 - 1) + (j6 - 1) * j1 + i1];
						j3++;
					}

					int j8 = j6 + 1;
					for (int k13 = (j - (j6 + 1)) + 1; k13 > 0; k13--) {
						if (ad[(j8 - 1) + (j6 - 1) * l + k] != 0.0D) {
							double d9 = d * ad[(j8 - 1) + (j6 - 1) * l + k];
							int k3 = 1;
							for (int i16 = (i - 1) + 1; i16 > 0; i16--) {
								ad1[(k3 - 1) + (j6 - 1) * j1 + i1] = ad1[(k3 - 1)
										+ (j6 - 1) * j1 + i1]
										+ d9
										* ad1[(k3 - 1) + (j8 - 1) * j1 + i1];
								k3++;
							}

						}
						j8++;
					}

					j6++;
				}

			}
		} else if (flag5) {
			int k8 = 1;
			for (int i11 = (j - 1) + 1; i11 > 0; i11--) {
				int k6 = 1;
				for (int l13 = (k8 - 1 - 1) + 1; l13 > 0; l13--) {
					if (ad[(k6 - 1) + (k8 - 1) * l + k] != 0.0D) {
						double d10 = d * ad[(k6 - 1) + (k8 - 1) * l + k];
						int l3 = 1;
						for (int j16 = (i - 1) + 1; j16 > 0; j16--) {
							ad1[(l3 - 1) + (k6 - 1) * j1 + i1] = ad1[(l3 - 1)
									+ (k6 - 1) * j1 + i1]
									+ d10 * ad1[(l3 - 1) + (k8 - 1) * j1 + i1];
							l3++;
						}

					}
					k6++;
				}

				double d11 = d;
				if (flag4)
					d11 *= ad[(k8 - 1) + (k8 - 1) * l + k];
				if (d11 != 1.0D) {
					int i4 = 1;
					for (int i14 = (i - 1) + 1; i14 > 0; i14--) {
						ad1[(i4 - 1) + (k8 - 1) * j1 + i1] = d11
								* ad1[(i4 - 1) + (k8 - 1) * j1 + i1];
						i4++;
					}

				}
				k8++;
			}

		} else {
			int l8 = j;
			for (int j11 = ((1 - j) + -1) / -1; j11 > 0; j11--) {
				int l6 = l8 + 1;
				for (int j14 = (j - (l8 + 1)) + 1; j14 > 0; j14--) {
					if (ad[(l6 - 1) + (l8 - 1) * l + k] != 0.0D) {
						double d12 = d * ad[(l6 - 1) + (l8 - 1) * l + k];
						int j4 = 1;
						for (int k16 = (i - 1) + 1; k16 > 0; k16--) {
							ad1[(j4 - 1) + (l6 - 1) * j1 + i1] = ad1[(j4 - 1)
									+ (l6 - 1) * j1 + i1]
									+ d12 * ad1[(j4 - 1) + (l8 - 1) * j1 + i1];
							j4++;
						}

					}
					l6++;
				}

				double d13 = d;
				if (flag4)
					d13 *= ad[(l8 - 1) + (l8 - 1) * l + k];
				if (d13 != 1.0D) {
					int k4 = 1;
					for (int k14 = (i - 1) + 1; k14 > 0; k14--) {
						ad1[(k4 - 1) + (l8 - 1) * j1 + i1] = d13
								* ad1[(k4 - 1) + (l8 - 1) * j1 + i1];
						k4++;
					}

				}
				l8--;
			}

		}
	}
}