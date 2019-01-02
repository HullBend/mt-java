package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsyrk
{
    public static void dsyrk(String s, String s1, int i, int j, double d, double ad[], int k, 
            int l, double d1, double ad1[], int i1, int j1)
    {
        int byte0 = 0;
        int k7 = 0;
        boolean flag3 = false;
        if (Lsame.lsame(s1, "N"))
            k7 = i;
        else
            k7 = j;
        flag3 = Lsame.lsame(s, "U");
        byte0 = 0;
        if (!flag3 && !Lsame.lsame(s, "L"))
            byte0 = 1;
        else
        if ((!Lsame.lsame(s1, "N") && !Lsame.lsame(s1, "T")) && !Lsame.lsame(s1, "C"))
            byte0 = 2;
        else
        if(i < 0)
            byte0 = 3;
        else
        if(j < 0)
            byte0 = 4;
        else
        if(l < Math.max(1, k7))
            byte0 = 7;
        else
        if(j1 < Math.max(1, i))
            byte0 = 10;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSYRK ", byte0);
            return;
        }
        if ((i == 0) || (((d == 0.0) || (j == 0)) && (d1 == 1.0)))
            return;
        if (d == 0.0)
        {
            if(flag3)
            {
                if(d1 == 0.0)
                {
                    int k4 = 1;
                    for(int l7 = i; l7 > 0; l7--)
                    {
                        int k1 = 1;
                        for(int l9 = k4; l9 > 0; l9--)
                        {
                            ad1[(k1 - 1) + (k4 - 1) * j1 + i1] = 0.0;
                            k1++;
                        }

                        k4++;
                    }

                } else
                {
                    int l4 = 1;
                    for(int i8 = i; i8 > 0; i8--)
                    {
                        int l1 = 1;
                        for(int i10 = l4; i10 > 0; i10--)
                        {
                            ad1[(l1 - 1) + (l4 - 1) * j1 + i1] = d1 * ad1[(l1 - 1) + (l4 - 1) * j1 + i1];
                            l1++;
                        }

                        l4++;
                    }

                }
            } else
            if(d1 == 0.0)
            {
                int i5 = 1;
                for(int j8 = i; j8 > 0; j8--)
                {
                    int i2 = i5;
                    for(int j10 = (i - i5) + 1; j10 > 0; j10--)
                    {
                        ad1[(i2 - 1) + (i5 - 1) * j1 + i1] = 0.0;
                        i2++;
                    }

                    i5++;
                }

            } else
            {
                int j5 = 1;
                for(int k8 = i; k8 > 0; k8--)
                {
                    int j2 = j5;
                    for(int k10 = (i - j5) + 1; k10 > 0; k10--)
                    {
                        ad1[(j2 - 1) + (j5 - 1) * j1 + i1] = d1 * ad1[(j2 - 1) + (j5 - 1) * j1 + i1];
                        j2++;
                    }

                    j5++;
                }

            }
            return;
        }
        if (Lsame.lsame(s1, "N"))
        {
            if(flag3)
            {
                int k5 = 1;
                for(int l8 = i; l8 > 0; l8--)
                {
                    if(d1 == 0.0)
                    {
                        int k2 = 1;
                        for (int l10 = k5; l10 > 0; l10--)
                        {
                            ad1[(k2 - 1) + (k5 - 1) * j1 + i1] = 0.0;
                            k2++;
                        }

                    } else
                    if (d1 != 1.0)
                    {
                        int l2 = 1;
                        for(int i11 = k5; i11 > 0; i11--)
                        {
                            ad1[(l2 - 1) + (k5 - 1) * j1 + i1] = d1 * ad1[(l2 - 1) + (k5 - 1) * j1 + i1];
                            l2++;
                        }

                    }
                    int k6 = 1;
                    for (int j11 = j; j11 > 0; j11--)
                    {
                        if(ad[(k5 - 1) + (k6 - 1) * l + k] != 0.0)
                        {
                            double d3 = d * ad[(k5 - 1) + (k6 - 1) * l + k];
                            int i3 = 1;
                            for (int l12 = k5; l12 > 0; l12--)
                            {
                                ad1[(i3 - 1) + (k5 - 1) * j1 + i1] = ad1[(i3 - 1) + (k5 - 1) * j1 + i1] + d3 * ad[(i3 - 1) + (k6 - 1) * l + k];
                                i3++;
                            }

                        }
                        k6++;
                    }

                    k5++;
                }

            } else
            {
                int l5 = 1;
                for (int i9 = i; i9 > 0; i9--)
                {
                    if(d1 == 0.0)
                    {
                        int j3 = l5;
                        for (int k11 = (i - l5) + 1; k11 > 0; k11--)
                        {
                            ad1[(j3 - 1) + (l5 - 1) * j1 + i1] = 0.0;
                            j3++;
                        }

                    } else
                    if (d1 != 1.0)
                    {
                        int k3 = l5;
                        for (int l11 = (i - l5) + 1; l11 > 0; l11--)
                        {
                            ad1[(k3 - 1) + (l5 - 1) * j1 + i1] = d1 * ad1[(k3 - 1) + (l5 - 1) * j1 + i1];
                            k3++;
                        }

                    }
                    int l6 = 1;
                    for (int i12 = j; i12 > 0; i12--)
                    {
                        if(ad[(l5 - 1) + (l6 - 1) * l + k] != 0.0)
                        {
                            double d4 = d * ad[(l5 - 1) + (l6 - 1) * l + k];
                            int l3 = l5;
                            for (int i13 = (i - l5) + 1; i13 > 0; i13--)
                            {
                                ad1[(l3 - 1) + (l5 - 1) * j1 + i1] = ad1[(l3 - 1) + (l5 - 1) * j1 + i1] + d4 * ad[(l3 - 1) + (l6 - 1) * l + k];
                                l3++;
                            }

                        }
                        l6++;
                    }

                    l5++;
                }

            }
        } else
        if (flag3)
        {
            int i6 = 1;
            for (int j9 = i; j9 > 0; j9--)
            {
                int i4 = 1;
                for (int j12 = i6; j12 > 0; j12--)
                {
                    double d5 = 0.0;
                    int i7 = 1;
                    for (int j13 = j; j13 > 0; j13--)
                    {
                        d5 += ad[(i7 - 1) + (i4 - 1) * l + k] * ad[(i7 - 1) + (i6 - 1) * l + k];
                        i7++;
                    }

                    if(d1 == 0.0)
                        ad1[(i4 - 1) + (i6 - 1) * j1 + i1] = d * d5;
                    else
                        ad1[(i4 - 1) + (i6 - 1) * j1 + i1] = d * d5 + d1 * ad1[(i4 - 1) + (i6 - 1) * j1 + i1];
                    i4++;
                }

                i6++;
            }

        } else
        {
            int j6 = 1;
            for (int k9 = i; k9 > 0; k9--)
            {
                int j4 = j6;
                for (int k12 = (i - j6) + 1; k12 > 0; k12--)
                {
                    double d6 = 0.0;
                    int j7 = 1;
                    for (int k13 = j; k13 > 0; k13--)
                    {
                        d6 += ad[(j7 - 1) + (j4 - 1) * l + k] * ad[(j7 - 1) + (j6 - 1) * l + k];
                        j7++;
                    }

                    if (d1 == 0.0)
                        ad1[(j4 - 1) + (j6 - 1) * j1 + i1] = d * d6;
                    else
                        ad1[(j4 - 1) + (j6 - 1) * j1 + i1] = d * d6 + d1 * ad1[(j4 - 1) + (j6 - 1) * j1 + i1];
                    j4++;
                }

                j6++;
            }

        }
    }
}
