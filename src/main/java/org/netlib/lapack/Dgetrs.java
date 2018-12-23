package org.netlib.lapack;

import org.netlib.blas.Dtrsm;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgetrs
{
    public static void dgetrs(String s, int i, int j, double[] ad, int k, int l, int[] ai, int i1, 
            double[] ad1, int j1, int k1, intW intw)
    {
        boolean flag = false;
        intw.val = 0;
        flag = Lsame.lsame(s, "N");
        if (!flag && !Lsame.lsame(s, "T") && !Lsame.lsame(s, "C"))
            intw.val = -1;
        else
        if (i < 0)
            intw.val = -2;
        else
        if (j < 0)
            intw.val = -3;
        else
        if (l < Math.max(1, i))
            intw.val = -5;
        else
        if (k1 < Math.max(1, i))
            intw.val = -8;

        if (intw.val != 0)
        {
            Xerbla.xerbla("DGETRS", -intw.val);
            return;
        }
        if (i == 0 || j == 0) {
            return;
        }

        if (flag)
        {
            Dlaswp.dlaswp(j, ad1, j1, k1, 1, i, ai, i1, 1);
            Dtrsm.dtrsm("Left", "Lower", "No transpose", "Unit", i, j, 1.0, ad, k, l, ad1, j1, k1);
            Dtrsm.dtrsm("Left", "Upper", "No transpose", "Non-unit", i, j, 1.0, ad, k, l, ad1, j1, k1);
        } else
        {
            Dtrsm.dtrsm("Left", "Upper", "Transpose", "Non-unit", i, j, 1.0, ad, k, l, ad1, j1, k1);
            Dtrsm.dtrsm("Left", "Lower", "Transpose", "Unit", i, j, 1.0, ad, k, l, ad1, j1, k1);
            Dlaswp.dlaswp(j, ad1, j1, k1, 1, i, ai, i1, -1);
        }
    }
}
