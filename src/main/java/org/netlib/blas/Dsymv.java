package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsymv
{
    public static void dsymv(String s, int i, double d, double ad[], int j, int k, double ad1[], 
            int l, int i1, double d1, double ad2[], int j1, int k1)
    {
        int byte0 = 0;
        int i7 = 0;
        int j7 = 0;
        byte0 = 0;
        if (!Lsame.lsame(s, "U") && !Lsame.lsame(s, "L"))
            byte0 = 1;
        else
        if(i < 0)
            byte0 = 2;
        else
        if(k < Math.max(1, i))
            byte0 = 5;
        else
        if(i1 == 0)
            byte0 = 7;
        else
        if(k1 == 0)
            byte0 = 10;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DSYMV ", byte0);
            return;
        }
        if((i == 0) || ((d == 0.0) && (d1 == 1.0)))
            return;
        if(i1 > 0)
            i7 = 1;
        else
            i7 = 1 - (i - 1) * i1;
        if(k1 > 0)
            j7 = 1;
        else
            j7 = 1 - (i - 1) * k1;
        if(d1 != 1.0)
            if(k1 == 1)
            {
                if(d1 == 0.0)
                {
                    int l1 = 1;
                    for(int k7 = i; k7 > 0; k7--)
                    {
                        ad2[(l1 - 1) + j1] = 0.0;
                        l1++;
                    }

                } else
                {
                    int i2 = 1;
                    for(int l7 = i; l7 > 0; l7--)
                    {
                        ad2[(i2 - 1) + j1] = d1 * ad2[(i2 - 1) + j1];
                        i2++;
                    }

                }
            } else
            {
                int j4 = j7;
                if(d1 == 0.0)
                {
                    for(int i8 = i; i8 > 0; i8--)
                    {
                        ad2[(j4 - 1) + j1] = 0.0;
                        j4 += k1;
                    }

                } else
                {
                    for(int j8 = i; j8 > 0; j8--)
                    {
                        ad2[(j4 - 1) + j1] = d1 * ad2[(j4 - 1) + j1];
                        j4 += k1;
                    }

                }
            }
        if (d == 0.0)
            return;
        if (Lsame.lsame(s, "U"))
        {
            if((i1 == 1) && (k1 == 1))
            {
                int i5 = 1;
                for(int k8 = i; k8 > 0; k8--)
                {
                    double d3 = d * ad1[(i5 - 1) + l];
                    double d8 = 0.0;
                    int l2 = 1;
                    for(int k9 = i5 - 1; k9 > 0; k9--)
                    {
                        ad2[(l2 - 1) + j1] = ad2[(l2 - 1) + j1] + d3 * ad[(l2 - 1) + (i5 - 1) * k + j];
                        d8 += ad[(l2 - 1) + (i5 - 1) * k + j] * ad1[(l2 - 1) + l];
                        l2++;
                    }

                    ad2[(i5 - 1) + j1] = ad2[(i5 - 1) + j1] + d3 * ad[(i5 - 1) + (i5 - 1) * k + j] + d * d8;
                    i5++;
                }

            } else
            {
                int i6 = i7;
                int k6 = j7;
                int j5 = 1;
                for(int l8 = i; l8 > 0; l8--)
                {
                    double d4 = d * ad1[(i6 - 1) + l];
                    double d9 = 0.0;
                    int l3 = i7;
                    int k4 = j7;
                    int i3 = 1;
                    for(int l9 = j5 - 1; l9 > 0; l9--)
                    {
                        ad2[(k4 - 1) + j1] = ad2[(k4 - 1) + j1] + d4 * ad[(i3 - 1) + (j5 - 1) * k + j];
                        d9 += ad[(i3 - 1) + (j5 - 1) * k + j] * ad1[(l3 - 1) + l];
                        l3 += i1;
                        k4 += k1;
                        i3++;
                    }

                    ad2[(k6 - 1) + j1] = ad2[(k6 - 1) + j1] + d4 * ad[(j5 - 1) + (j5 - 1) * k + j] + d * d9;
                    i6 += i1;
                    k6 += k1;
                    j5++;
                }

            }
        } else
        if ((i1 == 1) && (k1 == 1))
        {
            int k5 = 1;
            for(int i9 = i; i9 > 0; i9--)
            {
                double d5 = d * ad1[(k5 - 1) + l];
                double d10 = 0.0;
                ad2[(k5 - 1) + j1] = ad2[(k5 - 1) + j1] + d5 * ad[(k5 - 1) + (k5 - 1) * k + j];
                int j3 = k5 + 1;
                for(int i10 = (i - (k5 + 1)) + 1; i10 > 0; i10--)
                {
                    ad2[(j3 - 1) + j1] = ad2[(j3 - 1) + j1] + d5 * ad[(j3 - 1) + (k5 - 1) * k + j];
                    d10 += ad[(j3 - 1) + (k5 - 1) * k + j] * ad1[(j3 - 1) + l];
                    j3++;
                }

                ad2[(k5 - 1) + j1] = ad2[(k5 - 1) + j1] + d * d10;
                k5++;
            }

        } else
        {
            int j6 = i7;
            int l6 = j7;
            int l5 = 1;
            for (int j9 = i; j9 > 0; j9--)
            {
                double d6 = d * ad1[(j6 - 1) + l];
                double d11 = 0.0;
                ad2[(l6 - 1) + j1] = ad2[(l6 - 1) + j1] + d6 * ad[(l5 - 1) + (l5 - 1) * k + j];
                int i4 = j6;
                int l4 = l6;
                int k3 = l5 + 1;
                for (int j10 = (i - (l5 + 1)) + 1; j10 > 0; j10--)
                {
                    i4 += i1;
                    l4 += k1;
                    ad2[(l4 - 1) + j1] = ad2[(l4 - 1) + j1] + d6 * ad[(k3 - 1) + (l5 - 1) * k + j];
                    d11 += ad[(k3 - 1) + (l5 - 1) * k + j] * ad1[(i4 - 1) + l];
                    k3++;
                }

                ad2[(l6 - 1) + j1] = ad2[(l6 - 1) + j1] + d * d11;
                j6 += i1;
                l6 += k1;
                l5++;
            }

        }
    }
}
