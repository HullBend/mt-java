package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsyr2k
{
    public static void dsyr2k(String s, String s1, int i, int j, double d, double ad[], int k, 
            int l, double ad1[], int i1, int j1, double d1, double ad2[], 
            int k1, int l1)
    {
        int byte0 = 0;
        int i8 = 0;
        boolean flag3 = false;
        if (Lsame.lsame(s1, "N"))
            i8 = i;
        else
            i8 = j;
        flag3 = Lsame.lsame(s, "U");
        byte0 = 0;
        if (!flag3 && !Lsame.lsame(s, "L"))
            byte0 = 1;
        else
        if ((!Lsame.lsame(s1, "N") && !Lsame.lsame(s1, "T")) && !Lsame.lsame(s1, "C"))
            byte0 = 2;
        else
        if (i < 0)
            byte0 = 3;
        else
        if (j < 0)
            byte0 = 4;
        else
        if (l < Math.max(1, i8))
            byte0 = 7;
        else
        if (j1 < Math.max(1, i8))
            byte0 = 9;
        else
        if (l1 < Math.max(1, i))
            byte0 = 12;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSYR2K", byte0);
            return;
        }
        if ((i == 0) || (((d == 0.0) || (j == 0)) && (d1 == 1.0)))
            return;
        if(d == 0.0)
        {
            if(flag3)
            {
                if(d1 == 0.0)
                {
                    int i5 = 1;
                    for(int j8 = i; j8 > 0; j8--)
                    {
                        int i2 = 1;
                        for(int j10 = i5; j10 > 0; j10--)
                        {
                            ad2[(i2 - 1) + (i5 - 1) * l1 + k1] = 0.0;
                            i2++;
                        }

                        i5++;
                    }

                } else
                {
                    int j5 = 1;
                    for(int k8 = i; k8 > 0; k8--)
                    {
                        int j2 = 1;
                        for(int k10 = j5; k10 > 0; k10--)
                        {
                            ad2[(j2 - 1) + (j5 - 1) * l1 + k1] = d1 * ad2[(j2 - 1) + (j5 - 1) * l1 + k1];
                            j2++;
                        }

                        j5++;
                    }

                }
            } else
            if(d1 == 0.0)
            {
                int k5 = 1;
                for(int l8 = i; l8 > 0; l8--)
                {
                    int k2 = k5;
                    for(int l10 = (i - k5) + 1; l10 > 0; l10--)
                    {
                        ad2[(k2 - 1) + (k5 - 1) * l1 + k1] = 0.0;
                        k2++;
                    }

                    k5++;
                }

            } else
            {
                int l5 = 1;
                for(int i9 = i; i9 > 0; i9--)
                {
                    int l2 = l5;
                    for(int i11 = (i - l5) + 1; i11 > 0; i11--)
                    {
                        ad2[(l2 - 1) + (l5 - 1) * l1 + k1] = d1 * ad2[(l2 - 1) + (l5 - 1) * l1 + k1];
                        l2++;
                    }

                    l5++;
                }

            }
            return;
        }
        if (Lsame.lsame(s1, "N"))
        {
            if(flag3)
            {
                int i6 = 1;
                for(int j9 = i; j9 > 0; j9--)
                {
                    if(d1 == 0.0)
                    {
                        int i3 = 1;
                        for(int j11 = i6; j11 > 0; j11--)
                        {
                            ad2[(i3 - 1) + (i6 - 1) * l1 + k1] = 0.0;
                            i3++;
                        }

                    } else
                    if(d1 != 1.0)
                    {
                        int j3 = 1;
                        for(int k11 = i6; k11 > 0; k11--)
                        {
                            ad2[(j3 - 1) + (i6 - 1) * l1 + k1] = d1 * ad2[(j3 - 1) + (i6 - 1) * l1 + k1];
                            j3++;
                        }

                    }
                    int i7 = 1;
                    for(int l11 = j; l11 > 0; l11--)
                    {
                        if((ad[(i6 - 1) + (i7 - 1) * l + k] != 0.0) || (ad1[(i6 - 1) + (i7 - 1) * j1 + i1] != 0.0))
                        {
                            double d3 = d * ad1[(i6 - 1) + (i7 - 1) * j1 + i1];
                            double d8 = d * ad[(i6 - 1) + (i7 - 1) * l + k];
                            int k3 = 1;
                            for(int j13 = i6; j13 > 0; j13--)
                            {
                                ad2[(k3 - 1) + (i6 - 1) * l1 + k1] = ad2[(k3 - 1) + (i6 - 1) * l1 + k1] + ad[(k3 - 1) + (i7 - 1) * l + k] * d3 + ad1[(k3 - 1) + (i7 - 1) * j1 + i1] * d8;
                                k3++;
                            }

                        }
                        i7++;
                    }

                    i6++;
                }

            } else
            {
                int j6 = 1;
                for(int k9 = i; k9 > 0; k9--)
                {
                    if(d1 == 0.0)
                    {
                        int l3 = j6;
                        for(int i12 = (i - j6) + 1; i12 > 0; i12--)
                        {
                            ad2[(l3 - 1) + (j6 - 1) * l1 + k1] = 0.0;
                            l3++;
                        }

                    } else
                    if(d1 != 1.0)
                    {
                        int i4 = j6;
                        for(int j12 = (i - j6) + 1; j12 > 0; j12--)
                        {
                            ad2[(i4 - 1) + (j6 - 1) * l1 + k1] = d1 * ad2[(i4 - 1) + (j6 - 1) * l1 + k1];
                            i4++;
                        }

                    }
                    int j7 = 1;
                    for(int k12 = j; k12 > 0; k12--)
                    {
                        if((ad[(j6 - 1) + (j7 - 1) * l + k] != 0.0) || (ad1[(j6 - 1) + (j7 - 1) * j1 + i1] != 0.0))
                        {
                            double d4 = d * ad1[(j6 - 1) + (j7 - 1) * j1 + i1];
                            double d9 = d * ad[(j6 - 1) + (j7 - 1) * l + k];
                            int j4 = j6;
                            for(int k13 = (i - j6) + 1; k13 > 0; k13--)
                            {
                                ad2[(j4 - 1) + (j6 - 1) * l1 + k1] = ad2[(j4 - 1) + (j6 - 1) * l1 + k1] + ad[(j4 - 1) + (j7 - 1) * l + k] * d4 + ad1[(j4 - 1) + (j7 - 1) * j1 + i1] * d9;
                                j4++;
                            }

                        }
                        j7++;
                    }

                    j6++;
                }

            }
        } else
        if(flag3)
        {
            int k6 = 1;
            for(int l9 = i; l9 > 0; l9--)
            {
                int k4 = 1;
                for(int l12 = (k6 - 1) + 1; l12 > 0; l12--)
                {
                    double d5 = 0.0;
                    double d10 = 0.0;
                    int k7 = 1;
                    for(int l13 = j; l13 > 0; l13--)
                    {
                        d5 += ad[(k7 - 1) + (k4 - 1) * l + k] * ad1[(k7 - 1) + (k6 - 1) * j1 + i1];
                        d10 += ad1[(k7 - 1) + (k4 - 1) * j1 + i1] * ad[(k7 - 1) + (k6 - 1) * l + k];
                        k7++;
                    }

                    if(d1 == 0.0)
                        ad2[(k4 - 1) + (k6 - 1) * l1 + k1] = d * d5 + d * d10;
                    else
                        ad2[(k4 - 1) + (k6 - 1) * l1 + k1] = d1 * ad2[(k4 - 1) + (k6 - 1) * l1 + k1] + d * d5 + d * d10;
                    k4++;
                }

                k6++;
            }

        } else
        {
            int l6 = 1;
            for (int i10 = i; i10 > 0; i10--)
            {
                int l4 = l6;
                for (int i13 = (i - l6) + 1; i13 > 0; i13--)
                {
                    double d6 = 0.0;
                    double d11 = 0.0;
                    int l7 = 1;
                    for (int i14 = j; i14 > 0; i14--)
                    {
                        d6 += ad[(l7 - 1) + (l4 - 1) * l + k] * ad1[(l7 - 1) + (l6 - 1) * j1 + i1];
                        d11 += ad1[(l7 - 1) + (l4 - 1) * j1 + i1] * ad[(l7 - 1) + (l6 - 1) * l + k];
                        l7++;
                    }

                    if (d1 == 0.0)
                        ad2[(l4 - 1) + (l6 - 1) * l1 + k1] = d * d6 + d * d11;
                    else
                        ad2[(l4 - 1) + (l6 - 1) * l1 + k1] = d1 * ad2[(l4 - 1) + (l6 - 1) * l1 + k1] + d * d6 + d * d11;
                    l4++;
                }

                l6++;
            }

        }
    }
}
