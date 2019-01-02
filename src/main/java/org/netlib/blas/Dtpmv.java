package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dtpmv
{
    public static void dtpmv(String s, String s1, String s2, int i, double ad[], int j, double ad1[], int k, 
            int l)
    {
        int byte0 = 0;
        int i9 = 0;
        boolean flag = false;
        if (!Lsame.lsame(s, "U") && !Lsame.lsame(s, "L"))
            byte0 = 1;
        else
        if ((!Lsame.lsame(s1, "N") && !Lsame.lsame(s1, "T")) && !Lsame.lsame(s1, "C"))
            byte0 = 2;
        else
        if (!Lsame.lsame(s2, "U") && !Lsame.lsame(s2, "N"))
            byte0 = 3;
        else
        if (i < 0)
            byte0 = 4;
        else
        if (l == 0)
            byte0 = 7;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DTPMV ", byte0);
            return;
        }
        if (i == 0)
            return;
        flag = Lsame.lsame(s2, "N");
        if (l <= 0)
            i9 = 1 - (i - 1) * l;
        else
        if (l != 1)
            i9 = 1;
        if (Lsame.lsame(s1, "N"))
        {
            if(Lsame.lsame(s, "U"))
            {
                int i8 = 1;
                if(l == 1)
                {
                    int i3 = 1;
                    for(int j9 = i; j9 > 0; j9--)
                    {
                        if(ad1[(i3 - 1) + k] != 0.0)
                        {
                            double d1 = ad1[(i3 - 1) + k];
                            int i6 = i8;
                            int i1 = 1;
                            for(int j11 = i3 - 1; j11 > 0; j11--)
                            {
                                ad1[(i1 - 1) + k] = ad1[(i1 - 1) + k] + d1 * ad[(i6 - 1) + j];
                                i6++;
                                i1++;
                            }

                            if(flag)
                                ad1[(i3 - 1) + k] = ad1[(i3 - 1) + k] * ad[((i8 + i3) - 1 - 1) + j];
                        }
                        i8 += i3;
                        i3++;
                    }

                } else
                {
                    int i5 = i9;
                    int j3 = 1;
                    for(int k9 = i; k9 > 0; k9--)
                    {
                        if(ad1[(i5 - 1) + k] != 0.0)
                        {
                            double d2 = ad1[(i5 - 1) + k];
                            int i2 = i9;
                            int j6 = i8;
                            for(int k11 = ((i8 + j3) - 2 - i8) + 1; k11 > 0; k11--)
                            {
                                ad1[(i2 - 1) + k] = ad1[(i2 - 1) + k] + d2 * ad[(j6 - 1) + j];
                                i2 += l;
                                j6++;
                            }

                            if(flag)
                                ad1[(i5 - 1) + k] = ad1[(i5 - 1) + k] * ad[((i8 + j3) - 1 - 1) + j];
                        }
                        i5 += l;
                        i8 += j3;
                        j3++;
                    }

                }
            } else
            {
                int j8 = (i * (i + 1)) / 2;
                if(l == 1)
                {
                    int k3 = i;
                    for(int l9 = ((1 - i) + -1) / -1; l9 > 0; l9--)
                    {
                        if(ad1[(k3 - 1) + k] != 0.0)
                        {
                            double d3 = ad1[(k3 - 1) + k];
                            int k6 = j8;
                            int j1 = i;
                            for(int l11 = (((k3 + 1) - i) + -1) / -1; l11 > 0; l11--)
                            {
                                ad1[(j1 - 1) + k] = ad1[(j1 - 1) + k] + d3 * ad[(k6 - 1) + j];
                                k6--;
                                j1--;
                            }

                            if(flag)
                                ad1[(k3 - 1) + k] = ad1[(k3 - 1) + k] * ad[(((j8 - i) + k3) - 1) + j];
                        }
                        j8 -= (i - k3) + 1;
                        k3--;
                    }

                } else
                {
                    i9 += (i - 1) * l;
                    int j5 = i9;
                    int l3 = i;
                    for(int i10 = ((1 - i) + -1) / -1; i10 > 0; i10--)
                    {
                        if(ad1[(j5 - 1) + k] != 0.0)
                        {
                            double d4 = ad1[(j5 - 1) + k];
                            int j2 = i9;
                            int l6 = j8;
                            for(int i12 = ((j8 - (i - (l3 + 1)) - j8) + -1) / -1; i12 > 0; i12--)
                            {
                                ad1[(j2 - 1) + k] = ad1[(j2 - 1) + k] + d4 * ad[(l6 - 1) + j];
                                j2 -= l;
                                l6--;
                            }

                            if(flag)
                                ad1[(j5 - 1) + k] = ad1[(j5 - 1) + k] * ad[(((j8 - i) + l3) - 1) + j];
                        }
                        j5 -= l;
                        j8 -= (i - l3) + 1;
                        l3--;
                    }

                }
            }
        } else
        if(Lsame.lsame(s, "U"))
        {
            int k8 = (i * (i + 1)) / 2;
            if(l == 1)
            {
                int i4 = i;
                for(int j10 = ((1 - i) + -1) / -1; j10 > 0; j10--)
                {
                    double d5 = ad1[(i4 - 1) + k];
                    if(flag)
                        d5 *= ad[(k8 - 1) + j];
                    int i7 = k8 - 1;
                    int k1 = i4 - 1;
                    for(int j12 = ((1 - (i4 - 1)) + -1) / -1; j12 > 0; j12--)
                    {
                        d5 += ad[(i7 - 1) + j] * ad1[(k1 - 1) + k];
                        i7--;
                        k1--;
                    }

                    ad1[(i4 - 1) + k] = d5;
                    k8 -= i4;
                    i4--;
                }

            } else
            {
                int k5 = i9 + (i - 1) * l;
                int j4 = i;
                for(int k10 = ((1 - i) + -1) / -1; k10 > 0; k10--)
                {
                    double d6 = ad1[(k5 - 1) + k];
                    int k2 = k5;
                    if(flag)
                        d6 *= ad[(k8 - 1) + j];
                    int j7 = k8 - 1;
                    for(int k12 = ((((k8 - j4) + 1) - (k8 - 1)) + -1) / -1; k12 > 0; k12--)
                    {
                        k2 -= l;
                        d6 += ad[(j7 - 1) + j] * ad1[(k2 - 1) + k];
                        j7--;
                    }

                    ad1[(k5 - 1) + k] = d6;
                    k5 -= l;
                    k8 -= j4;
                    j4--;
                }

            }
        } else
        {
            int l8 = 1;
            if(l == 1)
            {
                int k4 = 1;
                for(int l10 = (i - 1) + 1; l10 > 0; l10--)
                {
                    double d7 = ad1[(k4 - 1) + k];
                    if(flag)
                        d7 *= ad[(l8 - 1) + j];
                    int k7 = l8 + 1;
                    int l1 = k4 + 1;
                    for(int l12 = (i - (k4 + 1)) + 1; l12 > 0; l12--)
                    {
                        d7 += ad[(k7 - 1) + j] * ad1[(l1 - 1) + k];
                        k7++;
                        l1++;
                    }

                    ad1[(k4 - 1) + k] = d7;
                    l8 += (i - k4) + 1;
                    k4++;
                }

            } else
            {
                int l5 = i9;
                int l4 = 1;
                for (int i11 = i; i11 > 0; i11--)
                {
                    double d8 = ad1[(l5 - 1) + k];
                    int l2 = l5;
                    if (flag)
                        d8 *= ad[(l8 - 1) + j];
                    int l7 = l8 + 1;
                    for (int i13 = ((l8 + i) - l4 - (l8 + 1)) + 1; i13 > 0; i13--)
                    {
                        l2 += l;
                        d8 += ad[(l7 - 1) + j] * ad1[(l2 - 1) + k];
                        l7++;
                    }

                    ad1[(l5 - 1) + k] = d8;
                    l5 += l;
                    l8 += (i - l4) + 1;
                    l4++;
                }

            }
        }
    }
}
