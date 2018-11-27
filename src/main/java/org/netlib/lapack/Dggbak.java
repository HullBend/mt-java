package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.blas.Dswap;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dggbak {
	public static void dggbak(String s, String s1, int i, int j, int k,
			double ad[], int l, double ad1[], int i1, int j1, double ad2[],
			int k1, int l1, intW intw) {
		boolean flag = false;
		boolean flag1 = false;
		flag1 = Lsame.lsame(s1, "R");
		flag = Lsame.lsame(s1, "L");
		intw.val = 0;
		if (((Lsame.lsame(s, "N") ^ true && Lsame.lsame(s, "P") ^ true) && Lsame
				.lsame(s, "S") ^ true) && Lsame.lsame(s, "B") ^ true)
			intw.val = -1;
		else if (flag1 ^ true && flag ^ true)
			intw.val = -2;
		else if (i < 0)
			intw.val = -3;
		else if (j < 1)
			intw.val = -4;
		else if (((i == 0) && (k == 0)) && (j != 1))
			intw.val = -4;
		else if ((i > 0) && ((k < j) || (k > Math.max(1, i))))
			intw.val = -5;
		else if (((i == 0) && (j == 1)) && (k != 0))
			intw.val = -5;
		else if (j1 < 0)
			intw.val = -8;
		else if (l1 < Math.max(1, i))
			intw.val = -10;
		if (intw.val != 0) {
			Xerbla.xerbla("DGGBAK", -intw.val);
			return;
		}
		if (i == 0)
			return;
		if (j1 == 0)
			return;
		if (Lsame.lsame(s, "N"))
			return;
		if ((j != k) && (Lsame.lsame(s, "S") || Lsame.lsame(s, "B"))) {
			if (flag1) {
				int i2 = j;
				for (int k4 = (k - j) + 1; k4 > 0; k4--) {
					Dscal.dscal(j1, ad1[(i2 - 1) + i1], ad2, (i2 - 1) + (1 - 1)
							* l1 + k1, l1);
					i2++;
				}

			}
			if (flag) {
				int j2 = j;
				for (int l4 = (k - j) + 1; l4 > 0; l4--) {
					Dscal.dscal(j1, ad[(j2 - 1) + l], ad2, (j2 - 1) + (1 - 1)
							* l1 + k1, l1);
					j2++;
				}

			}
		}
		if (Lsame.lsame(s, "P") || Lsame.lsame(s, "B")) {
			if (flag1) {
				if (j != 1) {
					int k2 = j - 1;
					for (int i5 = ((1 - (j - 1)) + -1) / -1; i5 > 0; i5--) {
						int k3 = (int) ad1[(k2 - 1) + i1];
						if (k3 != k2)
							Dswap.dswap(j1, ad2, (k2 - 1) + (1 - 1) * l1 + k1,
									l1, ad2, (k3 - 1) + (1 - 1) * l1 + k1, l1);
						k2--;
					}

				}
				if (k != i) {
					int l2 = k + 1;
					for (int j5 = (i - (k + 1)) + 1; j5 > 0; j5--) {
						int l3 = (int) ad1[(l2 - 1) + i1];
						if (l3 != l2)
							Dswap.dswap(j1, ad2, (l2 - 1) + (1 - 1) * l1 + k1,
									l1, ad2, (l3 - 1) + (1 - 1) * l1 + k1, l1);
						l2++;
					}

				}
			}
			if (flag) {
				if (j != 1) {
					int i3 = j - 1;
					for (int k5 = ((1 - (j - 1)) + -1) / -1; k5 > 0; k5--) {
						int i4 = (int) ad[(i3 - 1) + l];
						if (i4 != i3)
							Dswap.dswap(j1, ad2, (i3 - 1) + (1 - 1) * l1 + k1,
									l1, ad2, (i4 - 1) + (1 - 1) * l1 + k1, l1);
						i3--;
					}

				}
				if (k != i) {
					int j3 = k + 1;
					for (int l5 = (i - (k + 1)) + 1; l5 > 0; l5--) {
						int j4 = (int) ad[(j3 - 1) + l];
						if (j4 != j3)
							Dswap.dswap(j1, ad2, (j3 - 1) + (1 - 1) * l1 + k1,
									l1, ad2, (j4 - 1) + (1 - 1) * l1 + k1, l1);
						j3++;
					}

				}
			}
		}
	}
}
