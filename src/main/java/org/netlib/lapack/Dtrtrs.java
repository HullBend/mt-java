package org.netlib.lapack;

import org.netlib.blas.Dtrsm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dtrtrs
{
    public static void dtrtrs(String s, String s1, String s2, int i, int j, double ad[], int k, int l, 
            double ad1[], int i1, int j1, intW intw)
    {
        boolean flag = false;
        intw.val = 0;
        flag = Lsame.lsame(s2, "N");
        if(Lsame.lsame(s, "U") ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -1;
        else
        if((Lsame.lsame(s1, "N") ^ true && Lsame.lsame(s1, "T") ^ true) && Lsame.lsame(s1, "C") ^ true)
            intw.val = -2;
        else
        if(flag ^ true && Lsame.lsame(s2, "U") ^ true)
            intw.val = -3;
        else
        if(i < 0)
            intw.val = -4;
        else
        if(j < 0)
            intw.val = -5;
        else
        if(l < Math.max(1, i))
            intw.val = -7;
        else
        if(j1 < Math.max(1, i))
            intw.val = -9;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DTRTRS", -intw.val);
            return;
        }
        if(i == 0)
            return;
        if(flag)
        {
            intw.val = 1;
            for(int k1 = (i - 1) + 1; k1 > 0; k1--)
            {
                if(ad[(intw.val - 1) + (intw.val - 1) * l + k] == 0.0D)
                    return;
                intw.val = intw.val + 1;
            }

        }
        intw.val = 0;
        Dtrsm.dtrsm("Left", s, s1, s2, i, j, 1.0D, ad, k, l, ad1, i1, j1);
    }
}
