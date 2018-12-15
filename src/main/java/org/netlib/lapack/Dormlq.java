package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dormlq
{
    public static void dormlq(String s, String s1, int i, int j, int k, double ad[], int l, int i1, 
            double ad1[], int j1, double ad2[], int k1, int l1, double ad3[], int i2, 
            int j2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        int l3 = 0;
        intW intw1 = new intW(0);
        int i4 = 0;
        int j4 = 0;
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        int k5 = 0;
        int l5 = 0;
        int i6 = 0;
        int j6 = 0;
        double ad4[] = new double[65 * 64];
        intw.val = 0;
        flag = Lsame.lsame(s, "L");
        flag2 = Lsame.lsame(s1, "N");
        flag1 = j2 == -1;
        if(flag)
        {
            i6 = i;
            j6 = j;
        } else
        {
            i6 = j;
            j6 = i;
        }
        if(flag ^ true && Lsame.lsame(s, "R") ^ true)
            intw.val = -1;
        else
        if(flag2 ^ true && Lsame.lsame(s1, "T") ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if(j < 0)
            intw.val = -4;
        else
        if((k < 0) || (k > i6))
            intw.val = -5;
        else
        if(i1 < Math.max(1, k))
            intw.val = -7;
        else
        if(l1 < Math.max(1, i))
            intw.val = -10;
        else
        if((j2 < Math.max(1, j6)) && flag1 ^ true)
            intw.val = -12;
        if(intw.val == 0)
        {
            j5 = Math.min(64, Ilaenv.ilaenv(1, "DORMLQ", s + s1, i, j, k, -1));
            l4 = Math.max(1, j6) * j5;
            ad3[(1 - 1) + i2] = l4;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORMLQ", -intw.val);
            return;
        }
        if(flag1)
            return;
        if(((i == 0) || (j == 0)) || (k == 0))
        {
            ad3[(1 - 1) + i2] = 1;
            return;
        }
        k5 = 2;
        k4 = j6;
        if((j5 > 1) && (j5 < k))
        {
            i4 = j6 * j5;
            if(j2 < i4)
            {
                j5 = j2 / k4;
                k5 = Math.max(2, Ilaenv.ilaenv(2, "DORMLQ", s + s1, i, j, k, -1));
            }
        } else
        {
            i4 = j6;
        }
        if((j5 < k5) || (j5 >= k))
        {
            Dorml2.dorml2(s, s1, i, j, k, ad, l, i1, ad1, j1, ad2, k1, l1, ad3, i2, intw1);
        } else
        {
            int l2;
            int i3;
            int j3;
            if((flag && flag2) || (flag ^ true && flag2 ^ true))
            {
                l2 = 1;
                i3 = k;
                j3 = j5;
            } else
            {
                l2 = ((k - 1) / j5) * j5 + 1;
                i3 = 1;
                j3 = -j5;
            }
            if(flag)
            {
                l5 = j;
                j4 = 1;
            } else
            {
                i5 = i;
                l3 = 1;
            }
            String s3;
            if(flag2)
                s3 = "T";
            else
                s3 = "N";
            int k2 = l2;
            for(int k6 = ((i3 - l2) + j3) / j3; k6 > 0; k6--)
            {
                int k3 = Math.min(j5, (k - k2) + 1);
                Dlarft.dlarft("Forward", "Rowwise", (i6 - k2) + 1, k3, ad, (k2 - 1) + (k2 - 1) * i1 + l, i1, ad1, (k2 - 1) + j1, ad4, 0, 65);
                if(flag)
                {
                    i5 = (i - k2) + 1;
                    l3 = k2;
                } else
                {
                    l5 = (j - k2) + 1;
                    j4 = k2;
                }
                Dlarfb.dlarfb(s, s3, "Forward", "Rowwise", i5, l5, k3, ad, (k2 - 1) + (k2 - 1) * i1 + l, i1, ad4, 0, 65, ad2, (l3 - 1) + (j4 - 1) * l1 + k1, l1, ad3, i2, k4);
                k2 += j3;
            }

        }
        ad3[(1 - 1) + i2] = l4;
    }
}
