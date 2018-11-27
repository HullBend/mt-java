package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Dgemm;
import org.netlib.blas.Dtrmm;
import org.netlib.blas.Lsame;

public final class Dlarfb {
	public static void dlarfb(String s, String s1, String s2, String s3, int i,
			int j, int k, double ad[], int l, int i1, double ad1[], int j1,
			int k1, double ad2[], int l1, int i2, double ad3[], int j2, int k2) {
		String s4 = new String(" ");
		if ((i <= 0) || (j <= 0))
			return;
		if (Lsame.lsame(s1, "N"))
			s4 = "T";
		else
			s4 = "N";
		if (Lsame.lsame(s3, "C")) {
			if (Lsame.lsame(s2, "F")) {
				if (Lsame.lsame(s, "L")) {
					int l4 = 1;
					for (int l6 = (k - 1) + 1; l6 > 0; l6--) {
						Dcopy.dcopy(j, ad2, (l4 - 1) + (1 - 1) * i2 + l1, i2,
								ad3, (1 - 1) + (l4 - 1) * k2 + j2, 1);
						l4++;
					}

					Dtrmm.dtrmm("Right", "Lower", "No transpose", "Unit", j, k,
							1.0D, ad, l, i1, ad3, j2, k2);
					if (i > k)
						Dgemm.dgemm("Transpose", "No transpose", j, k, i - k,
								1.0D, ad2, ((k + 1) - 1) + (1 - 1) * i2 + l1,
								i2, ad, ((k + 1) - 1) + (1 - 1) * i1 + l, i1,
								1.0D, ad3, j2, k2);
					Dtrmm.dtrmm("Right", "Upper", s4, "Non-unit", j, k, 1.0D,
							ad1, j1, k1, ad3, j2, k2);
					if (i > k)
						Dgemm.dgemm("No transpose", "Transpose", i - k, j, k,
								-1D, ad, ((k + 1) - 1) + (1 - 1) * i1 + l, i1,
								ad3, j2, k2, 1.0D, ad2, ((k + 1) - 1) + (1 - 1)
										* i2 + l1, i2);
					Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", j, k,
							1.0D, ad, l, i1, ad3, j2, k2);
					l4 = 1;
					for (int i7 = (k - 1) + 1; i7 > 0; i7--) {
						int l2 = 1;
						for (int l10 = (j - 1) + 1; l10 > 0; l10--) {
							ad2[(l4 - 1) + (l2 - 1) * i2 + l1] = ad2[(l4 - 1)
									+ (l2 - 1) * i2 + l1]
									- ad3[(l2 - 1) + (l4 - 1) * k2 + j2];
							l2++;
						}

						l4++;
					}

				} else if (Lsame.lsame(s, "R")) {
					int i5 = 1;
					for (int j7 = (k - 1) + 1; j7 > 0; j7--) {
						Dcopy.dcopy(i, ad2, (1 - 1) + (i5 - 1) * i2 + l1, 1,
								ad3, (1 - 1) + (i5 - 1) * k2 + j2, 1);
						i5++;
					}

					Dtrmm.dtrmm("Right", "Lower", "No transpose", "Unit", i, k,
							1.0D, ad, l, i1, ad3, j2, k2);
					if (j > k)
						Dgemm.dgemm("No transpose", "No transpose", i, k,
								j - k, 1.0D, ad2, (1 - 1) + ((k + 1) - 1) * i2
										+ l1, i2, ad, ((k + 1) - 1) + (1 - 1)
										* i1 + l, i1, 1.0D, ad3, j2, k2);
					Dtrmm.dtrmm("Right", "Upper", s1, "Non-unit", i, k, 1.0D,
							ad1, j1, k1, ad3, j2, k2);
					if (j > k)
						Dgemm.dgemm("No transpose", "Transpose", i, j - k, k,
								-1D, ad3, j2, k2, ad, ((k + 1) - 1) + (1 - 1)
										* i1 + l, i1, 1.0D, ad2, (1 - 1)
										+ ((k + 1) - 1) * i2 + l1, i2);
					Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", i, k,
							1.0D, ad, l, i1, ad3, j2, k2);
					i5 = 1;
					for (int k7 = (k - 1) + 1; k7 > 0; k7--) {
						int i3 = 1;
						for (int i11 = (i - 1) + 1; i11 > 0; i11--) {
							ad2[(i3 - 1) + (i5 - 1) * i2 + l1] = ad2[(i3 - 1)
									+ (i5 - 1) * i2 + l1]
									- ad3[(i3 - 1) + (i5 - 1) * k2 + j2];
							i3++;
						}

						i5++;
					}

				}
			} else if (Lsame.lsame(s, "L")) {
				int j5 = 1;
				for (int l7 = (k - 1) + 1; l7 > 0; l7--) {
					Dcopy.dcopy(j, ad2, (((i - k) + j5) - 1) + (1 - 1) * i2
							+ l1, i2, ad3, (1 - 1) + (j5 - 1) * k2 + j2, 1);
					j5++;
				}

				Dtrmm.dtrmm("Right", "Upper", "No transpose", "Unit", j, k,
						1.0D, ad, (((i - k) + 1) - 1) + (1 - 1) * i1 + l, i1,
						ad3, j2, k2);
				if (i > k)
					Dgemm.dgemm("Transpose", "No transpose", j, k, i - k, 1.0D,
							ad2, l1, i2, ad, l, i1, 1.0D, ad3, j2, k2);
				Dtrmm.dtrmm("Right", "Lower", s4, "Non-unit", j, k, 1.0D, ad1,
						j1, k1, ad3, j2, k2);
				if (i > k)
					Dgemm.dgemm("No transpose", "Transpose", i - k, j, k, -1D,
							ad, l, i1, ad3, j2, k2, 1.0D, ad2, l1, i2);
				Dtrmm.dtrmm("Right", "Upper", "Transpose", "Unit", j, k, 1.0D,
						ad, (((i - k) + 1) - 1) + (1 - 1) * i1 + l, i1, ad3,
						j2, k2);
				j5 = 1;
				for (int i8 = (k - 1) + 1; i8 > 0; i8--) {
					int j3 = 1;
					for (int j11 = (j - 1) + 1; j11 > 0; j11--) {
						ad2[(((i - k) + j5) - 1) + (j3 - 1) * i2 + l1] = ad2[(((i - k) + j5) - 1)
								+ (j3 - 1) * i2 + l1]
								- ad3[(j3 - 1) + (j5 - 1) * k2 + j2];
						j3++;
					}

					j5++;
				}

			} else if (Lsame.lsame(s, "R")) {
				int k5 = 1;
				for (int j8 = (k - 1) + 1; j8 > 0; j8--) {
					Dcopy.dcopy(i, ad2, (1 - 1) + (((j - k) + k5) - 1) * i2
							+ l1, 1, ad3, (1 - 1) + (k5 - 1) * k2 + j2, 1);
					k5++;
				}

				Dtrmm.dtrmm("Right", "Upper", "No transpose", "Unit", i, k,
						1.0D, ad, (((j - k) + 1) - 1) + (1 - 1) * i1 + l, i1,
						ad3, j2, k2);
				if (j > k)
					Dgemm.dgemm("No transpose", "No transpose", i, k, j - k,
							1.0D, ad2, l1, i2, ad, l, i1, 1.0D, ad3, j2, k2);
				Dtrmm.dtrmm("Right", "Lower", s1, "Non-unit", i, k, 1.0D, ad1,
						j1, k1, ad3, j2, k2);
				if (j > k)
					Dgemm.dgemm("No transpose", "Transpose", i, j - k, k, -1D,
							ad3, j2, k2, ad, l, i1, 1.0D, ad2, l1, i2);
				Dtrmm.dtrmm("Right", "Upper", "Transpose", "Unit", i, k, 1.0D,
						ad, (((j - k) + 1) - 1) + (1 - 1) * i1 + l, i1, ad3,
						j2, k2);
				k5 = 1;
				for (int k8 = (k - 1) + 1; k8 > 0; k8--) {
					int k3 = 1;
					for (int k11 = (i - 1) + 1; k11 > 0; k11--) {
						ad2[(k3 - 1) + (((j - k) + k5) - 1) * i2 + l1] = ad2[(k3 - 1)
								+ (((j - k) + k5) - 1) * i2 + l1]
								- ad3[(k3 - 1) + (k5 - 1) * k2 + j2];
						k3++;
					}

					k5++;
				}

			}
		} else if (Lsame.lsame(s3, "R"))
			if (Lsame.lsame(s2, "F")) {
				if (Lsame.lsame(s, "L")) {
					int l5 = 1;
					for (int l8 = (k - 1) + 1; l8 > 0; l8--) {
						Dcopy.dcopy(j, ad2, (l5 - 1) + (1 - 1) * i2 + l1, i2,
								ad3, (1 - 1) + (l5 - 1) * k2 + j2, 1);
						l5++;
					}

					Dtrmm.dtrmm("Right", "Upper", "Transpose", "Unit", j, k,
							1.0D, ad, l, i1, ad3, j2, k2);
					if (i > k)
						Dgemm.dgemm("Transpose", "Transpose", j, k, i - k,
								1.0D, ad2, ((k + 1) - 1) + (1 - 1) * i2 + l1,
								i2, ad, (1 - 1) + ((k + 1) - 1) * i1 + l, i1,
								1.0D, ad3, j2, k2);
					Dtrmm.dtrmm("Right", "Upper", s4, "Non-unit", j, k, 1.0D,
							ad1, j1, k1, ad3, j2, k2);
					if (i > k)
						Dgemm.dgemm("Transpose", "Transpose", i - k, j, k, -1D,
								ad, (1 - 1) + ((k + 1) - 1) * i1 + l, i1, ad3,
								j2, k2, 1.0D, ad2, ((k + 1) - 1) + (1 - 1) * i2
										+ l1, i2);
					Dtrmm.dtrmm("Right", "Upper", "No transpose", "Unit", j, k,
							1.0D, ad, l, i1, ad3, j2, k2);
					l5 = 1;
					for (int i9 = (k - 1) + 1; i9 > 0; i9--) {
						int l3 = 1;
						for (int l11 = (j - 1) + 1; l11 > 0; l11--) {
							ad2[(l5 - 1) + (l3 - 1) * i2 + l1] = ad2[(l5 - 1)
									+ (l3 - 1) * i2 + l1]
									- ad3[(l3 - 1) + (l5 - 1) * k2 + j2];
							l3++;
						}

						l5++;
					}

				} else if (Lsame.lsame(s, "R")) {
					int i6 = 1;
					for (int j9 = (k - 1) + 1; j9 > 0; j9--) {
						Dcopy.dcopy(i, ad2, (1 - 1) + (i6 - 1) * i2 + l1, 1,
								ad3, (1 - 1) + (i6 - 1) * k2 + j2, 1);
						i6++;
					}

					Dtrmm.dtrmm("Right", "Upper", "Transpose", "Unit", i, k,
							1.0D, ad, l, i1, ad3, j2, k2);
					if (j > k)
						Dgemm.dgemm("No transpose", "Transpose", i, k, j - k,
								1.0D, ad2, (1 - 1) + ((k + 1) - 1) * i2 + l1,
								i2, ad, (1 - 1) + ((k + 1) - 1) * i1 + l, i1,
								1.0D, ad3, j2, k2);
					Dtrmm.dtrmm("Right", "Upper", s1, "Non-unit", i, k, 1.0D,
							ad1, j1, k1, ad3, j2, k2);
					if (j > k)
						Dgemm.dgemm("No transpose", "No transpose", i, j - k,
								k, -1D, ad3, j2, k2, ad, (1 - 1)
										+ ((k + 1) - 1) * i1 + l, i1, 1.0D,
								ad2, (1 - 1) + ((k + 1) - 1) * i2 + l1, i2);
					Dtrmm.dtrmm("Right", "Upper", "No transpose", "Unit", i, k,
							1.0D, ad, l, i1, ad3, j2, k2);
					i6 = 1;
					for (int k9 = (k - 1) + 1; k9 > 0; k9--) {
						int i4 = 1;
						for (int i12 = (i - 1) + 1; i12 > 0; i12--) {
							ad2[(i4 - 1) + (i6 - 1) * i2 + l1] = ad2[(i4 - 1)
									+ (i6 - 1) * i2 + l1]
									- ad3[(i4 - 1) + (i6 - 1) * k2 + j2];
							i4++;
						}

						i6++;
					}

				}
			} else if (Lsame.lsame(s, "L")) {
				int j6 = 1;
				for (int l9 = (k - 1) + 1; l9 > 0; l9--) {
					Dcopy.dcopy(j, ad2, (((i - k) + j6) - 1) + (1 - 1) * i2
							+ l1, i2, ad3, (1 - 1) + (j6 - 1) * k2 + j2, 1);
					j6++;
				}

				Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", j, k, 1.0D,
						ad, (1 - 1) + (((i - k) + 1) - 1) * i1 + l, i1, ad3,
						j2, k2);
				if (i > k)
					Dgemm.dgemm("Transpose", "Transpose", j, k, i - k, 1.0D,
							ad2, l1, i2, ad, l, i1, 1.0D, ad3, j2, k2);
				Dtrmm.dtrmm("Right", "Lower", s4, "Non-unit", j, k, 1.0D, ad1,
						j1, k1, ad3, j2, k2);
				if (i > k)
					Dgemm.dgemm("Transpose", "Transpose", i - k, j, k, -1D, ad,
							l, i1, ad3, j2, k2, 1.0D, ad2, l1, i2);
				Dtrmm.dtrmm("Right", "Lower", "No transpose", "Unit", j, k,
						1.0D, ad, (1 - 1) + (((i - k) + 1) - 1) * i1 + l, i1,
						ad3, j2, k2);
				j6 = 1;
				for (int i10 = (k - 1) + 1; i10 > 0; i10--) {
					int j4 = 1;
					for (int j12 = (j - 1) + 1; j12 > 0; j12--) {
						ad2[(((i - k) + j6) - 1) + (j4 - 1) * i2 + l1] = ad2[(((i - k) + j6) - 1)
								+ (j4 - 1) * i2 + l1]
								- ad3[(j4 - 1) + (j6 - 1) * k2 + j2];
						j4++;
					}

					j6++;
				}

			} else if (Lsame.lsame(s, "R")) {
				int k6 = 1;
				for (int j10 = (k - 1) + 1; j10 > 0; j10--) {
					Dcopy.dcopy(i, ad2, (1 - 1) + (((j - k) + k6) - 1) * i2
							+ l1, 1, ad3, (1 - 1) + (k6 - 1) * k2 + j2, 1);
					k6++;
				}

				Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", i, k, 1.0D,
						ad, (1 - 1) + (((j - k) + 1) - 1) * i1 + l, i1, ad3,
						j2, k2);
				if (j > k)
					Dgemm.dgemm("No transpose", "Transpose", i, k, j - k, 1.0D,
							ad2, l1, i2, ad, l, i1, 1.0D, ad3, j2, k2);
				Dtrmm.dtrmm("Right", "Lower", s1, "Non-unit", i, k, 1.0D, ad1,
						j1, k1, ad3, j2, k2);
				if (j > k)
					Dgemm.dgemm("No transpose", "No transpose", i, j - k, k,
							-1D, ad3, j2, k2, ad, l, i1, 1.0D, ad2, l1, i2);
				Dtrmm.dtrmm("Right", "Lower", "No transpose", "Unit", i, k,
						1.0D, ad, (1 - 1) + (((j - k) + 1) - 1) * i1 + l, i1,
						ad3, j2, k2);
				k6 = 1;
				for (int k10 = (k - 1) + 1; k10 > 0; k10--) {
					int k4 = 1;
					for (int k12 = (i - 1) + 1; k12 > 0; k12--) {
						ad2[(k4 - 1) + (((j - k) + k6) - 1) * i2 + l1] = ad2[(k4 - 1)
								+ (((j - k) + k6) - 1) * i2 + l1]
								- ad3[(k4 - 1) + (k6 - 1) * k2 + j2];
						k4++;
					}

					k6++;
				}

			}
	}
}
