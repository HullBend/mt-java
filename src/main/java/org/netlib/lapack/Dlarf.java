package org.netlib.lapack;

import org.netlib.blas.Dgemv;
import org.netlib.blas.Dger;
import org.netlib.blas.Lsame;

public final class Dlarf {
	public static void dlarf(String s, int i, int j, double ad[], int k, int l,
			double d, double ad1[], int i1, int j1, double ad2[], int k1) {
		if (Lsame.lsame(s, "L")) {
			if (d != 0.0D) {
				Dgemv.dgemv("Transpose", i, j, 1.0D, ad1, i1, j1, ad, k, l,
						0.0D, ad2, k1, 1);
				Dger.dger(i, j, -d, ad, k, l, ad2, k1, 1, ad1, i1, j1);
			}
		} else if (d != 0.0D) {
			Dgemv.dgemv("No transpose", i, j, 1.0D, ad1, i1, j1, ad, k, l,
					0.0D, ad2, k1, 1);
			Dger.dger(i, j, -d, ad2, k1, 1, ad, k, l, ad1, i1, j1);
		}
	}
}
