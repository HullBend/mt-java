package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgesv
{
    public static void dgesv(int i, int j, double[] ad, int k, int l, int[] ai, int i1, double[] ad1, 
            int j1, int k1, intW intw)
    {
        intw.val = 0;
        if (i < 0)
            intw.val = -1;
        else
        if (j < 0)
            intw.val = -2;
        else
        if (l < Math.max(1, i))
            intw.val = -4;
        else
        if (k1 < Math.max(1, i))
            intw.val = -7;

        if (intw.val != 0)
        {
            Xerbla.xerbla("DGESV ", -intw.val);
            return;
        }
        Dgetrf.dgetrf(i, i, ad, k, l, ai, i1, intw);
        if (intw.val == 0) {
            Dgetrs.dgetrs("No transpose", i, j, ad, k, l, ai, i1, ad1, j1, k1, intw);
        }
    }
}
