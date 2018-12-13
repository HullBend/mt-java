package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dgbmv
{
    public static void dgbmv(String s, int i, int j, int k, int l, double d, double ad[], 
            int i1, int j1, double ad1[], int k1, int l1, double d1, 
            double ad2[], int i2, int j2)
    {
        byte byte0 = 0;
        int l7 = 0;
        int i8 = 0;
        int j8 = 0;
        int k8 = 0;
        int l8 = 0;
        byte0 = 0;
        if((Lsame.lsame(s, "N") ^ true && Lsame.lsame(s, "T") ^ true) && Lsame.lsame(s, "C") ^ true)
            byte0 = 1;
        else
        if(i < 0)
            byte0 = 2;
        else
        if(j < 0)
            byte0 = 3;
        else
        if(k < 0)
            byte0 = 4;
        else
        if(l < 0)
            byte0 = 5;
        else
        if(j1 < k + l + 1)
            byte0 = 8;
        else
        if(l1 == 0)
            byte0 = 10;
        else
        if(j2 == 0)
            byte0 = 13;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DGBMV ", byte0);
            return;
        }
        if(((i == 0) || (j == 0)) || ((d == 0.0D) && (d1 == 1.0D)))
            return;
        if(Lsame.lsame(s, "N"))
        {
            k8 = j;
            l8 = i;
        } else
        {
            k8 = i;
            l8 = j;
        }
        if(l1 > 0)
            i8 = 1;
        else
            i8 = 1 - (k8 - 1) * l1;
        if(j2 > 0)
            j8 = 1;
        else
            j8 = 1 - (l8 - 1) * j2;
        if(d1 != 1.0D)
            if(j2 == 1)
            {
                if(d1 == 0.0D)
                {
                    int k2 = 1;
                    for(int i9 = (l8 - 1) + 1; i9 > 0; i9--)
                    {
                        ad2[(k2 - 1) + i2] = 0.0D;
                        k2++;
                    }

                } else
                {
                    int l2 = 1;
                    for(int j9 = (l8 - 1) + 1; j9 > 0; j9--)
                    {
                        ad2[(l2 - 1) + i2] = d1 * ad2[(l2 - 1) + i2];
                        l2++;
                    }

                }
            } else
            {
                int l4 = j8;
                if(d1 == 0.0D)
                {
                    for(int k9 = (l8 - 1) + 1; k9 > 0; k9--)
                    {
                        ad2[(l4 - 1) + i2] = 0.0D;
                        l4 += j2;
                    }

                } else
                {
                    for(int l9 = (l8 - 1) + 1; l9 > 0; l9--)
                    {
                        ad2[(l4 - 1) + i2] = d1 * ad2[(l4 - 1) + i2];
                        l4 += j2;
                    }

                }
            }
        if(d == 0.0D)
            return;
        l7 = l + 1;
        if(Lsame.lsame(s, "N"))
        {
            int j6 = i8;
            if(j2 == 1)
            {
                int j5 = 1;
                for(int i10 = (j - 1) + 1; i10 > 0; i10--)
                {
                    if(ad1[(j6 - 1) + k1] != 0.0D)
                    {
                        double d3 = d * ad1[(j6 - 1) + k1];
                        int l6 = l7 - j5;
                        int k3 = Math.max(1, j5 - l);
                        for(int i11 = (Math.min(i, j5 + k) - Math.max(1, j5 - l)) + 1; i11 > 0; i11--)
                        {
                            ad2[(k3 - 1) + i2] = ad2[(k3 - 1) + i2] + d3 * ad[((l6 + k3) - 1) + (j5 - 1) * j1 + i1];
                            k3++;
                        }

                    }
                    j6 += l1;
                    j5++;
                }

            } else
            {
                int k5 = 1;
                for(int j10 = (j - 1) + 1; j10 > 0; j10--)
                {
                    if(ad1[(j6 - 1) + k1] != 0.0D)
                    {
                        double d4 = d * ad1[(j6 - 1) + k1];
                        int i5 = j8;
                        int i7 = l7 - k5;
                        int l3 = Math.max(1, k5 - l);
                        for(int j11 = (Math.min(i, k5 + k) - Math.max(1, k5 - l)) + 1; j11 > 0; j11--)
                        {
                            ad2[(i5 - 1) + i2] = ad2[(i5 - 1) + i2] + d4 * ad[((i7 + l3) - 1) + (k5 - 1) * j1 + i1];
                            i5 += j2;
                            l3++;
                        }

                    }
                    j6 += l1;
                    if(k5 > l)
                        j8 += j2;
                    k5++;
                }

            }
        } else
        {
            int k6 = j8;
            if(l1 == 1)
            {
                int l5 = 1;
                for(int k10 = (j - 1) + 1; k10 > 0; k10--)
                {
                    double d5 = 0.0D;
                    int j7 = l7 - l5;
                    int i4 = Math.max(1, l5 - l);
                    for(int k11 = (Math.min(i, l5 + k) - Math.max(1, l5 - l)) + 1; k11 > 0; k11--)
                    {
                        d5 += ad[((j7 + i4) - 1) + (l5 - 1) * j1 + i1] * ad1[(i4 - 1) + k1];
                        i4++;
                    }

                    ad2[(k6 - 1) + i2] = ad2[(k6 - 1) + i2] + d * d5;
                    k6 += j2;
                    l5++;
                }

            } else
            {
                int i6 = 1;
                for(int l10 = (j - 1) + 1; l10 > 0; l10--)
                {
                    double d6 = 0.0D;
                    int k4 = i8;
                    int k7 = l7 - i6;
                    int j4 = Math.max(1, i6 - l);
                    for(int l11 = (Math.min(i, i6 + k) - Math.max(1, i6 - l)) + 1; l11 > 0; l11--)
                    {
                        d6 += ad[((k7 + j4) - 1) + (i6 - 1) * j1 + i1] * ad1[(k4 - 1) + k1];
                        k4 += l1;
                        j4++;
                    }

                    ad2[(k6 - 1) + i2] = ad2[(k6 - 1) + i2] + d * d6;
                    k6 += j2;
                    if(i6 > l)
                        i8 += l1;
                    i6++;
                }

            }
        }
    }
}