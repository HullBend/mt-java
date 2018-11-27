package org.netlib.lapack;

import org.netlib.blas.Dgemv;
import org.netlib.blas.Dtrmv;
import org.netlib.blas.Lsame;

public final class Dlarft {
	public static void dlarft(String s, String s1, int i, int j, double ad[],
			int k, int l, double ad1[], int i1, double ad2[], int j1, int k1) {
		if (i == 0)
			return;
		if (Lsame.lsame(s, "F")) {
			int l1 = 1;
			for (int l2 = (j - 1) + 1; l2 > 0; l2--) {
				if (ad1[(l1 - 1) + i1] == 0.0D) {
					int j2 = 1;
					for (int j3 = (l1 - 1) + 1; j3 > 0; j3--) {
						ad2[(j2 - 1) + (l1 - 1) * k1 + j1] = 0.0D;
						j2++;
					}

				} else {
					double d1 = ad[(l1 - 1) + (l1 - 1) * l + k];
					ad[(l1 - 1) + (l1 - 1) * l + k] = 1.0D;
					if (Lsame.lsame(s1, "C"))
						Dgemv.dgemv("Transpose", (i - l1) + 1, l1 - 1,
								-ad1[(l1 - 1) + i1], ad, (l1 - 1) + (1 - 1) * l
										+ k, l, ad,
								(l1 - 1) + (l1 - 1) * l + k, 1, 0.0D, ad2,
								(1 - 1) + (l1 - 1) * k1 + j1, 1);
					else
						Dgemv.dgemv("No transpose", l1 - 1, (i - l1) + 1,
								-ad1[(l1 - 1) + i1], ad, (1 - 1) + (l1 - 1) * l
										+ k, l, ad,
								(l1 - 1) + (l1 - 1) * l + k, l, 0.0D, ad2,
								(1 - 1) + (l1 - 1) * k1 + j1, 1);
					ad[(l1 - 1) + (l1 - 1) * l + k] = d1;
					Dtrmv.dtrmv("Upper", "No transpose", "Non-unit", l1 - 1,
							ad2, j1, k1, ad2, (1 - 1) + (l1 - 1) * k1 + j1, 1);
					ad2[(l1 - 1) + (l1 - 1) * k1 + j1] = ad1[(l1 - 1) + i1];
				}
				l1++;
			}

		} else {
			int i2 = j;
			for (int i3 = ((1 - j) + -1) / -1; i3 > 0; i3--) {
				if (ad1[(i2 - 1) + i1] == 0.0D) {
					int k2 = i2;
					for (int k3 = (j - i2) + 1; k3 > 0; k3--) {
						ad2[(k2 - 1) + (i2 - 1) * k1 + j1] = 0.0D;
						k2++;
					}

				} else {
					if (i2 < j) {
						if (Lsame.lsame(s1, "C")) {
							double d2 = ad[(((i - j) + i2) - 1) + (i2 - 1) * l
									+ k];
							ad[(((i - j) + i2) - 1) + (i2 - 1) * l + k] = 1.0D;
							Dgemv.dgemv("Transpose", (i - j) + i2, j - i2,
									-ad1[(i2 - 1) + i1], ad, (1 - 1)
											+ ((i2 + 1) - 1) * l + k, l, ad,
									(1 - 1) + (i2 - 1) * l + k, 1, 0.0D, ad2,
									((i2 + 1) - 1) + (i2 - 1) * k1 + j1, 1);
							ad[(((i - j) + i2) - 1) + (i2 - 1) * l + k] = d2;
						} else {
							double d3 = ad[(i2 - 1) + (((i - j) + i2) - 1) * l
									+ k];
							ad[(i2 - 1) + (((i - j) + i2) - 1) * l + k] = 1.0D;
							Dgemv.dgemv("No transpose", j - i2, (i - j) + i2,
									-ad1[(i2 - 1) + i1], ad, ((i2 + 1) - 1)
											+ (1 - 1) * l + k, l, ad, (i2 - 1)
											+ (1 - 1) * l + k, l, 0.0D, ad2,
									((i2 + 1) - 1) + (i2 - 1) * k1 + j1, 1);
							ad[(i2 - 1) + (((i - j) + i2) - 1) * l + k] = d3;
						}
						Dtrmv.dtrmv("Lower", "No transpose", "Non-unit",
								j - i2, ad2, ((i2 + 1) - 1) + ((i2 + 1) - 1)
										* k1 + j1, k1, ad2, ((i2 + 1) - 1)
										+ (i2 - 1) * k1 + j1, 1);
					}
					ad2[(i2 - 1) + (i2 - 1) * k1 + j1] = ad1[(i2 - 1) + i1];
				}
				i2--;
			}

		}
	}
}
