package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorml2
{
    public static void dorml2(String s, String s1, int i, int j, int k, double ad[], int l, int i1, 
            double ad1[], int j1, double ad2[], int k1, int l1, double ad3[], int i2, 
            intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        int j2 = 0;
        int k2 = 0;
        int l2 = 0;
        byte byte0 = 0;
        int i3 = 0;
        int j3 = 0;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        intw.val = 0;
        flag = Lsame.lsame(s, "L");
        flag1 = Lsame.lsame(s1, "N");
        if(flag)
            i4 = i;
        else
            i4 = j;
        if(flag ^ true && Lsame.lsame(s, "R") ^ true)
            intw.val = -1;
        else
        if(flag1 ^ true && Lsame.lsame(s1, "T") ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if(j < 0)
            intw.val = -4;
        else
        if((k < 0) || (k > i4))
            intw.val = -5;
        else
        if(i1 < Math.max(1, k))
            intw.val = -7;
        else
        if(l1 < Math.max(1, i))
            intw.val = -10;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORML2", -intw.val);
            return;
        }
        if(((i == 0) || (j == 0)) || (k == 0))
            return;
        if((flag && flag1) || (flag ^ true && flag1 ^ true))
        {
            k2 = 1;
            l2 = k;
            byte0 = 1;
        } else
        {
            k2 = k;
            l2 = 1;
            byte0 = -1;
        }
        if(flag)
        {
            l3 = j;
            j3 = 1;
        } else
        {
            k3 = i;
            i3 = 1;
        }
        j2 = k2;
        for(int j4 = ((l2 - k2) + byte0) / byte0; j4 > 0; j4--)
        {
            if(flag)
            {
                k3 = (i - j2) + 1;
                i3 = j2;
            } else
            {
                l3 = (j - j2) + 1;
                j3 = j2;
            }
            double d1 = ad[(j2 - 1) + (j2 - 1) * i1 + l];
            ad[(j2 - 1) + (j2 - 1) * i1 + l] = 1.0D;
            Dlarf.dlarf(s, k3, l3, ad, (j2 - 1) + (j2 - 1) * i1 + l, i1, ad1[(j2 - 1) + j1], ad2, (i3 - 1) + (j3 - 1) * l1 + k1, l1, ad3, i2);
            ad[(j2 - 1) + (j2 - 1) * i1 + l] = d1;
            j2 += byte0;
        }

    }
}
