package org.netlib.lapack;

import org.netlib.blas.Dgemm;
import org.netlib.blas.Dtrsm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgetrf
{
    public static void dgetrf(int i, int j, double[] ad, int k, int l, int[] ai, int i1, intW intw)
    {
        intW intw1 = new intW(0);
        int i2 = 0;
        intw.val = 0;
        if(i < 0)
            intw.val = -1;
        else
        if(j < 0)
            intw.val = -2;
        else
        if(l < Math.max(1, i))
            intw.val = -4;

        if(intw.val != 0)
        {
            Xerbla.xerbla("DGETRF", -intw.val);
            return;
        }
        if (i == 0 || j == 0) {
            return;
        }
        i2 = Ilaenv.ilaenv(1, "DGETRF", " ", i, j, -1, -1);
        if (i2 <= 1 || i2 >= Math.min(i, j))
        {
            Dgetf2.dgetf2(i, j, ad, k, l, ai, i1, intw);
        } else
        {
            int k1 = 1;
            for (int j2 = ((Math.min(i, j) - 1) + i2) / i2; j2 > 0; j2--)
            {
                int l1 = Math.min((Math.min(i, j) - k1) + 1, i2);
                Dgetf2.dgetf2(i - k1 + 1, l1, ad, k1 - 1 + (k1 - 1) * l + k, l, ai, k1 - 1 + i1, intw1);
                if (intw.val == 0 && intw1.val > 0)
                    intw.val = (intw1.val + k1) - 1;
                int j1 = k1;
                for (int k2 = (Math.min(i, (k1 + l1) - 1) - k1) + 1; k2 > 0; k2--)
                {
                    ai[j1 - 1 + i1] = k1 - 1 + ai[j1 - 1 + i1];
                    j1++;
                }

                Dlaswp.dlaswp(k1 - 1, ad, k, l, k1, k1 + l1 - 1, ai, i1, 1);
                if (k1 + l1 <= j)
                {
                    Dlaswp.dlaswp(j - k1 - l1 + 1, ad, (k1 + l1 - 1) * l + k, l, k1, k1 + l1 - 1, ai, i1, 1);
                    Dtrsm.dtrsm("Left", "Lower", "No transpose", "Unit", l1, j - k1 - l1 + 1, 1.0, ad, k1 - 1 + (k1 - 1) * l + k, l, ad, k1 - 1 + (k1 + l1 - 1) * l + k, l);
                    if(k1 + l1 <= i)
                        Dgemm.dgemm("No transpose", "No transpose", i - k1 - l1 + 1, j - k1 - l1 + 1, l1, -1.0, ad, k1 + l1 - 1 + (k1 - 1) * l + k, l, ad, k1 - 1 + (k1 + l1 - 1) * l + k, l, 1.0, ad, k1 + l1 - 1 + (k1 + l1 - 1) * l + k, l);
                }
                k1 += i2;
            }

        }
    }
}
