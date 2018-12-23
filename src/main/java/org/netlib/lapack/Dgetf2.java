package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgetf2
{
    public static void dgetf2(int i, int j, double[] ad, int k, int l, int[] ai, int i1, intW intw)
    {

        intw.val = 0;
		if (i < 0) {
			intw.val = -1;
		} else if (j < 0) {
			intw.val = -2;
		} else if (l < Math.max(1, i)) {
			intw.val = -4;
		}

        if (intw.val != 0)
        {
            Xerbla.xerbla("DGETF2", -intw.val);
            return;
        }
        if (i == 0 || j == 0) {
            return;
        }

        int k1 = 1;
        for (int p = Math.min(i, j); p > 0; p--)
        {
            int l1 = k1 - 1 + Idamax.idamax(i - k1 + 1, ad, k1 - 1 + (k1 - 1) * l + k, 1);
            ai[k1 - 1 + i1] = l1;
            if (ad[l1 - 1 + (k1 - 1) * l + k] != 0.0)
            {
                if (l1 != k1) {
                    Dswap.dswap(j, ad, k1 - 1 + k, l, ad, l1 - 1 + k, l);
                }
                if (k1 < i) {
                    if (Math.abs(ad[k1 - 1 + (k1 - 1) * l + k]) >= 2.2250738585072014E-308)
                    {
                        Dscal.dscal(i - k1, 1.0 / ad[k1 - 1 + (k1 - 1) * l + k], ad, k1 + (k1 - 1) * l + k, 1);
                    } else
                    {
                        int j1 = 1;
                        for (int q = i - k1; q > 0; q--)
                        {
                            ad[k1 + j1 - 1 + (k1 - 1) * l + k] = ad[k1 + j1 - 1 + (k1 - 1) * l + k] / ad[k1 - 1 + (k1 - 1) * l + k];
                            j1++;
                        }

                    }
                }
            } else
            if (intw.val == 0) {
                intw.val = k1;
            }
            if (k1 < Math.min(i, j)) {
                Dger.dger(i - k1, j - k1, -1.0, ad, k1 + (k1 - 1) * l + k, 1, ad, k1 - 1 + k1 * l + k, l, ad, k1 + k1 * l + k, l);
            }
            k1++;
        }
    }
}
