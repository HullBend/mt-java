package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgetf2
{
    public static void dgetf2(int i, int j, double ad[], int k, int l, int ai[], int i1, intW intw)
    {
        double d = 0.0D;
        int k1 = 0;
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
            Xerbla.xerbla("DGETF2", -intw.val);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        d = Dlamch.dlamch("S");
        k1 = 1;
        for(int i2 = (Math.min(i, j) - 1) + 1; i2 > 0; i2--)
        {
            int l1 = (k1 - 1) + Idamax.idamax((i - k1) + 1, ad, (k1 - 1) + (k1 - 1) * l + k, 1);
            ai[(k1 - 1) + i1] = l1;
            if(ad[(l1 - 1) + (k1 - 1) * l + k] != 0.0D)
            {
                if(l1 != k1)
                    Dswap.dswap(j, ad, (k1 - 1) + (1 - 1) * l + k, l, ad, (l1 - 1) + (1 - 1) * l + k, l);
                if(k1 < i)
                    if(Math.abs(ad[(k1 - 1) + (k1 - 1) * l + k]) >= d)
                    {
                        Dscal.dscal(i - k1, 1.0D / ad[(k1 - 1) + (k1 - 1) * l + k], ad, ((k1 + 1) - 1) + (k1 - 1) * l + k, 1);
                    } else
                    {
                        int j1 = 1;
                        for(int j2 = (i - k1 - 1) + 1; j2 > 0; j2--)
                        {
                            ad[((k1 + j1) - 1) + (k1 - 1) * l + k] = ad[((k1 + j1) - 1) + (k1 - 1) * l + k] / ad[(k1 - 1) + (k1 - 1) * l + k];
                            j1++;
                        }

                    }
            } else
            if(intw.val == 0)
                intw.val = k1;
            if(k1 < Math.min(i, j))
                Dger.dger(i - k1, j - k1, -1D, ad, ((k1 + 1) - 1) + (k1 - 1) * l + k, 1, ad, (k1 - 1) + ((k1 + 1) - 1) * l + k, l, ad, ((k1 + 1) - 1) + ((k1 + 1) - 1) * l + k, l);
            k1++;
        }

    }
}
