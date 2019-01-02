package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsbmv
{
    public static void dsbmv(String s, int i, int j, double d, double ad[], int k, int l, 
            double ad1[], int i1, int j1, double d1, double ad2[], int k1, 
            int l1)
    {
        int byte0 = 0;
        int k7 = 0;
        int l7 = 0;
        byte0 = 0;
        if (!Lsame.lsame(s, "U") && !Lsame.lsame(s, "L"))
            byte0 = 1;
        else
        if(i < 0)
            byte0 = 2;
        else
        if(j < 0)
            byte0 = 3;
        else
        if(l < j + 1)
            byte0 = 6;
        else
        if(j1 == 0)
            byte0 = 8;
        else
        if(l1 == 0)
            byte0 = 11;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSBMV ", byte0);
            return;
        }
        if ((i == 0) || ((d == 0.0) && (d1 == 1.0)))
            return;
        if(j1 > 0)
            k7 = 1;
        else
            k7 = 1 - (i - 1) * j1;
        if(l1 > 0)
            l7 = 1;
        else
            l7 = 1 - (i - 1) * l1;
        if(d1 != 1.0)
            if(l1 == 1)
            {
                if(d1 == 0.0)
                {
                    int i2 = 1;
                    for(int i9 = i; i9 > 0; i9--)
                    {
                        ad2[(i2 - 1) + k1] = 0.0;
                        i2++;
                    }

                } else
                {
                    int j2 = 1;
                    for(int j9 = i; j9 > 0; j9--)
                    {
                        ad2[(j2 - 1) + k1] = d1 * ad2[(j2 - 1) + k1];
                        j2++;
                    }

                }
            } else
            {
                int k4 = l7;
                if(d1 == 0.0)
                {
                    for(int k9 = i; k9 > 0; k9--)
                    {
                        ad2[(k4 - 1) + k1] = 0.0;
                        k4 += l1;
                    }

                } else
                {
                    for(int l9 = i; l9 > 0; l9--)
                    {
                        ad2[(k4 - 1) + k1] = d1 * ad2[(k4 - 1) + k1];
                        k4 += l1;
                    }

                }
            }
        if (d == 0.0)
            return;
        if (Lsame.lsame(s, "U"))
        {
            int j7 = j + 1;
            if ((j1 == 1) && (l1 == 1))
            {
                int j5 = 1;
                for(int i10 = i; i10 > 0; i10--)
                {
                    double d3 = d * ad1[(j5 - 1) + i1];
                    double d8 = 0.0;
                    int i8 = j7 - j5;
                    int i3 = Math.max(1, j5 - j);
                    for(int i11 = (j5 - 1 - Math.max(1, j5 - j)) + 1; i11 > 0; i11--)
                    {
                        ad2[(i3 - 1) + k1] = ad2[(i3 - 1) + k1] + d3 * ad[((i8 + i3) - 1) + (j5 - 1) * l + k];
                        d8 += ad[((i8 + i3) - 1) + (j5 - 1) * l + k] * ad1[(i3 - 1) + i1];
                        i3++;
                    }

                    ad2[(j5 - 1) + k1] = ad2[(j5 - 1) + k1] + d3 * ad[(j7 - 1) + (j5 - 1) * l + k] + d * d8;
                    j5++;
                }

            } else
            {
                int j6 = k7;
                int l6 = l7;
                int k5 = 1;
                for(int j10 = i; j10 > 0; j10--)
                {
                    double d4 = d * ad1[(j6 - 1) + i1];
                    double d9 = 0.0;
                    int i4 = k7;
                    int l4 = l7;
                    int j8 = j7 - k5;
                    int j3 = Math.max(1, k5 - j);
                    for(int j11 = (k5 - 1 - Math.max(1, k5 - j)) + 1; j11 > 0; j11--)
                    {
                        ad2[(l4 - 1) + k1] = ad2[(l4 - 1) + k1] + d4 * ad[((j8 + j3) - 1) + (k5 - 1) * l + k];
                        d9 += ad[((j8 + j3) - 1) + (k5 - 1) * l + k] * ad1[(i4 - 1) + i1];
                        i4 += j1;
                        l4 += l1;
                        j3++;
                    }

                    ad2[(l6 - 1) + k1] = ad2[(l6 - 1) + k1] + d4 * ad[(j7 - 1) + (k5 - 1) * l + k] + d * d9;
                    j6 += j1;
                    l6 += l1;
                    if(k5 > j)
                    {
                        k7 += j1;
                        l7 += l1;
                    }
                    k5++;
                }

            }
        } else
        if ((j1 == 1) && (l1 == 1))
        {
            int l5 = 1;
            for(int k10 = i; k10 > 0; k10--)
            {
                double d5 = d * ad1[(l5 - 1) + i1];
                double d10 = 0.0;
                ad2[(l5 - 1) + k1] = ad2[(l5 - 1) + k1] + d5 * ad[(1 - 1) + (l5 - 1) * l + k];
                int k8 = 1 - l5;
                int k3 = l5 + 1;
                for(int k11 = (Math.min(i, l5 + j) - (l5 + 1)) + 1; k11 > 0; k11--)
                {
                    ad2[(k3 - 1) + k1] = ad2[(k3 - 1) + k1] + d5 * ad[((k8 + k3) - 1) + (l5 - 1) * l + k];
                    d10 += ad[((k8 + k3) - 1) + (l5 - 1) * l + k] * ad1[(k3 - 1) + i1];
                    k3++;
                }

                ad2[(l5 - 1) + k1] = ad2[(l5 - 1) + k1] + d * d10;
                l5++;
            }

        } else
        {
            int k6 = k7;
            int i7 = l7;
            int i6 = 1;
            for (int l10 = i; l10 > 0; l10--)
            {
                double d6 = d * ad1[(k6 - 1) + i1];
                double d11 = 0.0;
                ad2[(i7 - 1) + k1] = ad2[(i7 - 1) + k1] + d6 * ad[(1 - 1) + (i6 - 1) * l + k];
                int l8 = 1 - i6;
                int j4 = k6;
                int i5 = i7;
                int l3 = i6 + 1;
                for (int l11 = (Math.min(i, i6 + j) - (i6 + 1)) + 1; l11 > 0; l11--)
                {
                    j4 += j1;
                    i5 += l1;
                    ad2[(i5 - 1) + k1] = ad2[(i5 - 1) + k1] + d6 * ad[((l8 + l3) - 1) + (i6 - 1) * l + k];
                    d11 += ad[((l8 + l3) - 1) + (i6 - 1) * l + k] * ad1[(j4 - 1) + i1];
                    l3++;
                }

                ad2[(i7 - 1) + k1] = ad2[(i7 - 1) + k1] + d * d11;
                k6 += j1;
                i7 += l1;
                i6++;
            }

        }
    }
}
