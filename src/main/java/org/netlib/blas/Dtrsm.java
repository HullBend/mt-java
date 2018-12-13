package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dtrsm
{
    public static void dtrsm(String s, String s1, String s2, String s3, int i, int j, double d, 
            double ad[], int k, int l, double ad1[], int i1, int j1)
    {
        byte byte0 = 0;
        int k10 = 0;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        flag3 = Lsame.lsame(s, "L");
        if(flag3)
            k10 = i;
        else
            k10 = j;
        flag4 = Lsame.lsame(s3, "N");
        flag5 = Lsame.lsame(s1, "U");
        byte0 = 0;
        if(flag3 ^ true && Lsame.lsame(s, "R") ^ true)
            byte0 = 1;
        else
        if(flag5 ^ true && Lsame.lsame(s1, "L") ^ true)
            byte0 = 2;
        else
        if((Lsame.lsame(s2, "N") ^ true && Lsame.lsame(s2, "T") ^ true) && Lsame.lsame(s2, "C") ^ true)
            byte0 = 3;
        else
        if(Lsame.lsame(s3, "U") ^ true && Lsame.lsame(s3, "N") ^ true)
            byte0 = 4;
        else
        if(i < 0)
            byte0 = 5;
        else
        if(j < 0)
            byte0 = 6;
        else
        if(l < Math.max(1, k10))
            byte0 = 9;
        else
        if(j1 < Math.max(1, i))
            byte0 = 11;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DTRSM ", byte0);
            return;
        }
        if(j == 0)
            return;
        if(d == 0.0D)
        {
            int j6 = 1;
            for(int l10 = (j - 1) + 1; l10 > 0; l10--)
            {
                int k1 = 1;
                for(int i13 = (i - 1) + 1; i13 > 0; i13--)
                {
                    ad1[(k1 - 1) + (j6 - 1) * j1 + i1] = 0.0D;
                    k1++;
                }

                j6++;
            }

            return;
        }
        if(flag3)
        {
            if(Lsame.lsame(s2, "N"))
            {
                if(flag5)
                {
                    int k6 = 1;
                    for(int i11 = (j - 1) + 1; i11 > 0; i11--)
                    {
                        if(d != 1.0D)
                        {
                            int l1 = 1;
                            for(int j13 = (i - 1) + 1; j13 > 0; j13--)
                            {
                                ad1[(l1 - 1) + (k6 - 1) * j1 + i1] = d * ad1[(l1 - 1) + (k6 - 1) * j1 + i1];
                                l1++;
                            }

                        }
                        int k8 = i;
                        for(int k13 = ((1 - i) + -1) / -1; k13 > 0; k13--)
                        {
                            if(ad1[(k8 - 1) + (k6 - 1) * j1 + i1] != 0.0D)
                            {
                                if(flag4)
                                    ad1[(k8 - 1) + (k6 - 1) * j1 + i1] = ad1[(k8 - 1) + (k6 - 1) * j1 + i1] / ad[(k8 - 1) + (k8 - 1) * l + k];
                                int i2 = 1;
                                for(int l17 = (k8 - 1 - 1) + 1; l17 > 0; l17--)
                                {
                                    ad1[(i2 - 1) + (k6 - 1) * j1 + i1] = ad1[(i2 - 1) + (k6 - 1) * j1 + i1] - ad1[(k8 - 1) + (k6 - 1) * j1 + i1] * ad[(i2 - 1) + (k8 - 1) * l + k];
                                    i2++;
                                }

                            }
                            k8--;
                        }

                        k6++;
                    }

                } else
                {
                    int l6 = 1;
                    for(int j11 = (j - 1) + 1; j11 > 0; j11--)
                    {
                        if(d != 1.0D)
                        {
                            int j2 = 1;
                            for(int l13 = (i - 1) + 1; l13 > 0; l13--)
                            {
                                ad1[(j2 - 1) + (l6 - 1) * j1 + i1] = d * ad1[(j2 - 1) + (l6 - 1) * j1 + i1];
                                j2++;
                            }

                        }
                        int l8 = 1;
                        for(int i14 = (i - 1) + 1; i14 > 0; i14--)
                        {
                            if(ad1[(l8 - 1) + (l6 - 1) * j1 + i1] != 0.0D)
                            {
                                if(flag4)
                                    ad1[(l8 - 1) + (l6 - 1) * j1 + i1] = ad1[(l8 - 1) + (l6 - 1) * j1 + i1] / ad[(l8 - 1) + (l8 - 1) * l + k];
                                int k2 = l8 + 1;
                                for(int i18 = (i - (l8 + 1)) + 1; i18 > 0; i18--)
                                {
                                    ad1[(k2 - 1) + (l6 - 1) * j1 + i1] = ad1[(k2 - 1) + (l6 - 1) * j1 + i1] - ad1[(l8 - 1) + (l6 - 1) * j1 + i1] * ad[(k2 - 1) + (l8 - 1) * l + k];
                                    k2++;
                                }

                            }
                            l8++;
                        }

                        l6++;
                    }

                }
            } else
            if(flag5)
            {
                int i7 = 1;
                for(int k11 = (j - 1) + 1; k11 > 0; k11--)
                {
                    int l2 = 1;
                    for(int j14 = (i - 1) + 1; j14 > 0; j14--)
                    {
                        double d2 = d * ad1[(l2 - 1) + (i7 - 1) * j1 + i1];
                        int i9 = 1;
                        for(int j18 = (l2 - 1 - 1) + 1; j18 > 0; j18--)
                        {
                            d2 -= ad[(i9 - 1) + (l2 - 1) * l + k] * ad1[(i9 - 1) + (i7 - 1) * j1 + i1];
                            i9++;
                        }

                        if(flag4)
                            d2 /= ad[(l2 - 1) + (l2 - 1) * l + k];
                        ad1[(l2 - 1) + (i7 - 1) * j1 + i1] = d2;
                        l2++;
                    }

                    i7++;
                }

            } else
            {
                int j7 = 1;
                for(int l11 = (j - 1) + 1; l11 > 0; l11--)
                {
                    int i3 = i;
                    for(int k14 = ((1 - i) + -1) / -1; k14 > 0; k14--)
                    {
                        double d3 = d * ad1[(i3 - 1) + (j7 - 1) * j1 + i1];
                        int j9 = i3 + 1;
                        for(int k18 = (i - (i3 + 1)) + 1; k18 > 0; k18--)
                        {
                            d3 -= ad[(j9 - 1) + (i3 - 1) * l + k] * ad1[(j9 - 1) + (j7 - 1) * j1 + i1];
                            j9++;
                        }

                        if(flag4)
                            d3 /= ad[(i3 - 1) + (i3 - 1) * l + k];
                        ad1[(i3 - 1) + (j7 - 1) * j1 + i1] = d3;
                        i3--;
                    }

                    j7++;
                }

            }
        } else
        if(Lsame.lsame(s2, "N"))
        {
            if(flag5)
            {
                int k7 = 1;
                for(int i12 = (j - 1) + 1; i12 > 0; i12--)
                {
                    if(d != 1.0D)
                    {
                        int j3 = 1;
                        for(int l14 = (i - 1) + 1; l14 > 0; l14--)
                        {
                            ad1[(j3 - 1) + (k7 - 1) * j1 + i1] = d * ad1[(j3 - 1) + (k7 - 1) * j1 + i1];
                            j3++;
                        }

                    }
                    int k9 = 1;
                    for(int i15 = (k7 - 1 - 1) + 1; i15 > 0; i15--)
                    {
                        if(ad[(k9 - 1) + (k7 - 1) * l + k] != 0.0D)
                        {
                            int k3 = 1;
                            for(int l18 = (i - 1) + 1; l18 > 0; l18--)
                            {
                                ad1[(k3 - 1) + (k7 - 1) * j1 + i1] = ad1[(k3 - 1) + (k7 - 1) * j1 + i1] - ad[(k9 - 1) + (k7 - 1) * l + k] * ad1[(k3 - 1) + (k9 - 1) * j1 + i1];
                                k3++;
                            }

                        }
                        k9++;
                    }

                    if(flag4)
                    {
                        double d4 = 1.0D / ad[(k7 - 1) + (k7 - 1) * l + k];
                        int l3 = 1;
                        for(int j15 = (i - 1) + 1; j15 > 0; j15--)
                        {
                            ad1[(l3 - 1) + (k7 - 1) * j1 + i1] = d4 * ad1[(l3 - 1) + (k7 - 1) * j1 + i1];
                            l3++;
                        }

                    }
                    k7++;
                }

            } else
            {
                int l7 = j;
                for(int j12 = ((1 - j) + -1) / -1; j12 > 0; j12--)
                {
                    if(d != 1.0D)
                    {
                        int i4 = 1;
                        for(int k15 = (i - 1) + 1; k15 > 0; k15--)
                        {
                            ad1[(i4 - 1) + (l7 - 1) * j1 + i1] = d * ad1[(i4 - 1) + (l7 - 1) * j1 + i1];
                            i4++;
                        }

                    }
                    int l9 = l7 + 1;
                    for(int l15 = (j - (l7 + 1)) + 1; l15 > 0; l15--)
                    {
                        if(ad[(l9 - 1) + (l7 - 1) * l + k] != 0.0D)
                        {
                            int j4 = 1;
                            for(int i19 = (i - 1) + 1; i19 > 0; i19--)
                            {
                                ad1[(j4 - 1) + (l7 - 1) * j1 + i1] = ad1[(j4 - 1) + (l7 - 1) * j1 + i1] - ad[(l9 - 1) + (l7 - 1) * l + k] * ad1[(j4 - 1) + (l9 - 1) * j1 + i1];
                                j4++;
                            }

                        }
                        l9++;
                    }

                    if(flag4)
                    {
                        double d5 = 1.0D / ad[(l7 - 1) + (l7 - 1) * l + k];
                        int k4 = 1;
                        for(int i16 = (i - 1) + 1; i16 > 0; i16--)
                        {
                            ad1[(k4 - 1) + (l7 - 1) * j1 + i1] = d5 * ad1[(k4 - 1) + (l7 - 1) * j1 + i1];
                            k4++;
                        }

                    }
                    l7--;
                }

            }
        } else
        if(flag5)
        {
            int i10 = j;
            for(int k12 = ((1 - j) + -1) / -1; k12 > 0; k12--)
            {
                if(flag4)
                {
                    double d6 = 1.0D / ad[(i10 - 1) + (i10 - 1) * l + k];
                    int l4 = 1;
                    for(int j16 = (i - 1) + 1; j16 > 0; j16--)
                    {
                        ad1[(l4 - 1) + (i10 - 1) * j1 + i1] = d6 * ad1[(l4 - 1) + (i10 - 1) * j1 + i1];
                        l4++;
                    }

                }
                int i8 = 1;
                for(int k16 = (i10 - 1 - 1) + 1; k16 > 0; k16--)
                {
                    if(ad[(i8 - 1) + (i10 - 1) * l + k] != 0.0D)
                    {
                        double d7 = ad[(i8 - 1) + (i10 - 1) * l + k];
                        int i5 = 1;
                        for(int j19 = (i - 1) + 1; j19 > 0; j19--)
                        {
                            ad1[(i5 - 1) + (i8 - 1) * j1 + i1] = ad1[(i5 - 1) + (i8 - 1) * j1 + i1] - d7 * ad1[(i5 - 1) + (i10 - 1) * j1 + i1];
                            i5++;
                        }

                    }
                    i8++;
                }

                if(d != 1.0D)
                {
                    int j5 = 1;
                    for(int l16 = (i - 1) + 1; l16 > 0; l16--)
                    {
                        ad1[(j5 - 1) + (i10 - 1) * j1 + i1] = d * ad1[(j5 - 1) + (i10 - 1) * j1 + i1];
                        j5++;
                    }

                }
                i10--;
            }

        } else
        {
            int j10 = 1;
            for(int l12 = (j - 1) + 1; l12 > 0; l12--)
            {
                if(flag4)
                {
                    double d8 = 1.0D / ad[(j10 - 1) + (j10 - 1) * l + k];
                    int k5 = 1;
                    for(int i17 = (i - 1) + 1; i17 > 0; i17--)
                    {
                        ad1[(k5 - 1) + (j10 - 1) * j1 + i1] = d8 * ad1[(k5 - 1) + (j10 - 1) * j1 + i1];
                        k5++;
                    }

                }
                int j8 = j10 + 1;
                for(int j17 = (j - (j10 + 1)) + 1; j17 > 0; j17--)
                {
                    if(ad[(j8 - 1) + (j10 - 1) * l + k] != 0.0D)
                    {
                        double d9 = ad[(j8 - 1) + (j10 - 1) * l + k];
                        int l5 = 1;
                        for(int k19 = (i - 1) + 1; k19 > 0; k19--)
                        {
                            ad1[(l5 - 1) + (j8 - 1) * j1 + i1] = ad1[(l5 - 1) + (j8 - 1) * j1 + i1] - d9 * ad1[(l5 - 1) + (j10 - 1) * j1 + i1];
                            l5++;
                        }

                    }
                    j8++;
                }

                if(d != 1.0D)
                {
                    int i6 = 1;
                    for(int k17 = (i - 1) + 1; k17 > 0; k17--)
                    {
                        ad1[(i6 - 1) + (j10 - 1) * j1 + i1] = d * ad1[(i6 - 1) + (j10 - 1) * j1 + i1];
                        i6++;
                    }

                }
                j10++;
            }

        }
    }
}