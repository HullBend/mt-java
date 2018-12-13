package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dspmv
{
    public static void dspmv(String s, int i, double d, double ad[], int j, double ad1[], int k, 
            int l, double d1, double ad2[], int i1, int j1)
    {
        byte byte0 = 0;
        int j7 = 0;
        int k7 = 0;
        int l7 = 0;
        byte0 = 0;
        if(Lsame.lsame(s, "U") ^ true && Lsame.lsame(s, "L") ^ true)
            byte0 = 1;
        else
        if(i < 0)
            byte0 = 2;
        else
        if(l == 0)
            byte0 = 6;
        else
        if(j1 == 0)
            byte0 = 9;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DSPMV ", byte0);
            return;
        }
        if((i == 0) || ((d == 0.0D) && (d1 == 1.0D)))
            return;
        if(l > 0)
            k7 = 1;
        else
            k7 = 1 - (i - 1) * l;
        if(j1 > 0)
            l7 = 1;
        else
            l7 = 1 - (i - 1) * j1;
        if(d1 != 1.0D)
            if(j1 == 1)
            {
                if(d1 == 0.0D)
                {
                    int k1 = 1;
                    for(int i8 = (i - 1) + 1; i8 > 0; i8--)
                    {
                        ad2[(k1 - 1) + i1] = 0.0D;
                        k1++;
                    }

                } else
                {
                    int l1 = 1;
                    for(int j8 = (i - 1) + 1; j8 > 0; j8--)
                    {
                        ad2[(l1 - 1) + i1] = d1 * ad2[(l1 - 1) + i1];
                        l1++;
                    }

                }
            } else
            {
                int k3 = l7;
                if(d1 == 0.0D)
                {
                    for(int k8 = (i - 1) + 1; k8 > 0; k8--)
                    {
                        ad2[(k3 - 1) + i1] = 0.0D;
                        k3 += j1;
                    }

                } else
                {
                    for(int l8 = (i - 1) + 1; l8 > 0; l8--)
                    {
                        ad2[(k3 - 1) + i1] = d1 * ad2[(k3 - 1) + i1];
                        k3 += j1;
                    }

                }
            }
        if(d == 0.0D)
            return;
        j7 = 1;
        if(Lsame.lsame(s, "U"))
        {
            if((l == 1) && (j1 == 1))
            {
                int j4 = 1;
                for(int i9 = (i - 1) + 1; i9 > 0; i9--)
                {
                    double d3 = d * ad1[(j4 - 1) + k];
                    double d8 = 0.0D;
                    int j6 = j7;
                    int k2 = 1;
                    for(int i10 = (j4 - 1 - 1) + 1; i10 > 0; i10--)
                    {
                        ad2[(k2 - 1) + i1] = ad2[(k2 - 1) + i1] + d3 * ad[(j6 - 1) + j];
                        d8 += ad[(j6 - 1) + j] * ad1[(k2 - 1) + k];
                        j6++;
                        k2++;
                    }

                    ad2[(j4 - 1) + i1] = ad2[(j4 - 1) + i1] + d3 * ad[((j7 + j4) - 1 - 1) + j] + d * d8;
                    j7 += j4;
                    j4++;
                }

            } else
            {
                int j5 = k7;
                int l5 = l7;
                int k4 = 1;
                for(int j9 = (i - 1) + 1; j9 > 0; j9--)
                {
                    double d4 = d * ad1[(j5 - 1) + k];
                    double d9 = 0.0D;
                    int i3 = k7;
                    int l3 = l7;
                    int k6 = j7;
                    for(int j10 = ((j7 + k4) - 2 - j7) + 1; j10 > 0; j10--)
                    {
                        ad2[(l3 - 1) + i1] = ad2[(l3 - 1) + i1] + d4 * ad[(k6 - 1) + j];
                        d9 += ad[(k6 - 1) + j] * ad1[(i3 - 1) + k];
                        i3 += l;
                        l3 += j1;
                        k6++;
                    }

                    ad2[(l5 - 1) + i1] = ad2[(l5 - 1) + i1] + d4 * ad[((j7 + k4) - 1 - 1) + j] + d * d9;
                    j5 += l;
                    l5 += j1;
                    j7 += k4;
                    k4++;
                }

            }
        } else
        if((l == 1) && (j1 == 1))
        {
            int l4 = 1;
            for(int k9 = (i - 1) + 1; k9 > 0; k9--)
            {
                double d5 = d * ad1[(l4 - 1) + k];
                double d10 = 0.0D;
                ad2[(l4 - 1) + i1] = ad2[(l4 - 1) + i1] + d5 * ad[(j7 - 1) + j];
                int l6 = j7 + 1;
                int l2 = l4 + 1;
                for(int k10 = (i - (l4 + 1)) + 1; k10 > 0; k10--)
                {
                    ad2[(l2 - 1) + i1] = ad2[(l2 - 1) + i1] + d5 * ad[(l6 - 1) + j];
                    d10 += ad[(l6 - 1) + j] * ad1[(l2 - 1) + k];
                    l6++;
                    l2++;
                }

                ad2[(l4 - 1) + i1] = ad2[(l4 - 1) + i1] + d * d10;
                j7 += (i - l4) + 1;
                l4++;
            }

        } else
        {
            int k5 = k7;
            int i6 = l7;
            int i5 = 1;
            for (int l9 = (i - 1) + 1; l9 > 0; l9--)
            {
                double d6 = d * ad1[(k5 - 1) + k];
                double d11 = 0.0D;
                ad2[(i6 - 1) + i1] = ad2[(i6 - 1) + i1] + d6 * ad[(j7 - 1) + j];
                int j3 = k5;
                int i4 = i6;
                int i7 = j7 + 1;
                for (int l10 = ((j7 + i) - i5 - (j7 + 1)) + 1; l10 > 0; l10--)
                {
                    j3 += l;
                    i4 += j1;
                    ad2[(i4 - 1) + i1] = ad2[(i4 - 1) + i1] + d6 * ad[(i7 - 1) + j];
                    d11 += ad[(i7 - 1) + j] * ad1[(j3 - 1) + k];
                    i7++;
                }

                ad2[(i6 - 1) + i1] = ad2[(i6 - 1) + i1] + d * d11;
                k5 += l;
                i6 += j1;
                j7 += (i - i5) + 1;
                i5++;
            }

        }
    }
}
