package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsymm
{
    public static void dsymm(String s, String s1, int i, int j, double d, double ad[], int k, 
            int l, double ad1[], int i1, int j1, double d1, double ad2[], 
            int k1, int l1)
    {
        byte byte0 = 0;
        int i6 = 0;
        boolean flag3 = false;
        if(Lsame.lsame(s, "L"))
            i6 = i;
        else
            i6 = j;
        flag3 = Lsame.lsame(s1, "U");
        byte0 = 0;
        if(Lsame.lsame(s, "L") ^ true && Lsame.lsame(s, "R") ^ true)
            byte0 = 1;
        else
        if(flag3 ^ true && Lsame.lsame(s1, "L") ^ true)
            byte0 = 2;
        else
        if(i < 0)
            byte0 = 3;
        else
        if(j < 0)
            byte0 = 4;
        else
        if(l < Math.max(1, i6))
            byte0 = 7;
        else
        if(j1 < Math.max(1, i))
            byte0 = 9;
        else
        if(l1 < Math.max(1, i))
            byte0 = 12;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DSYMM ", byte0);
            return;
        }
        if(((i == 0) || (j == 0)) || ((d == 0.0D) && (d1 == 1.0D)))
            return;
        if(d == 0.0D)
        {
            if(d1 == 0.0D)
            {
                int i4 = 1;
                for(int j6 = (j - 1) + 1; j6 > 0; j6--)
                {
                    int i2 = 1;
                    for(int k7 = (i - 1) + 1; k7 > 0; k7--)
                    {
                        ad2[(i2 - 1) + (i4 - 1) * l1 + k1] = 0.0D;
                        i2++;
                    }

                    i4++;
                }

            } else
            {
                int j4 = 1;
                for(int k6 = (j - 1) + 1; k6 > 0; k6--)
                {
                    int j2 = 1;
                    for(int l7 = (i - 1) + 1; l7 > 0; l7--)
                    {
                        ad2[(j2 - 1) + (j4 - 1) * l1 + k1] = d1 * ad2[(j2 - 1) + (j4 - 1) * l1 + k1];
                        j2++;
                    }

                    j4++;
                }

            }
            return;
        }
        if(Lsame.lsame(s, "L"))
        {
            if(flag3)
            {
                int k4 = 1;
                for(int l6 = (j - 1) + 1; l6 > 0; l6--)
                {
                    int k2 = 1;
                    for(int i8 = (i - 1) + 1; i8 > 0; i8--)
                    {
                        double d3 = d * ad1[(k2 - 1) + (k4 - 1) * j1 + i1];
                        double d9 = 0.0D;
                        int j5 = 1;
                        for(int k9 = (k2 - 1 - 1) + 1; k9 > 0; k9--)
                        {
                            ad2[(j5 - 1) + (k4 - 1) * l1 + k1] = ad2[(j5 - 1) + (k4 - 1) * l1 + k1] + d3 * ad[(j5 - 1) + (k2 - 1) * l + k];
                            d9 += ad1[(j5 - 1) + (k4 - 1) * j1 + i1] * ad[(j5 - 1) + (k2 - 1) * l + k];
                            j5++;
                        }

                        if(d1 == 0.0D)
                            ad2[(k2 - 1) + (k4 - 1) * l1 + k1] = d3 * ad[(k2 - 1) + (k2 - 1) * l + k] + d * d9;
                        else
                            ad2[(k2 - 1) + (k4 - 1) * l1 + k1] = d1 * ad2[(k2 - 1) + (k4 - 1) * l1 + k1] + d3 * ad[(k2 - 1) + (k2 - 1) * l + k] + d * d9;
                        k2++;
                    }

                    k4++;
                }

            } else
            {
                int l4 = 1;
                for(int i7 = (j - 1) + 1; i7 > 0; i7--)
                {
                    int l2 = i;
                    for(int j8 = ((1 - i) + -1) / -1; j8 > 0; j8--)
                    {
                        double d4 = d * ad1[(l2 - 1) + (l4 - 1) * j1 + i1];
                        double d10 = 0.0D;
                        int k5 = l2 + 1;
                        for(int l9 = (i - (l2 + 1)) + 1; l9 > 0; l9--)
                        {
                            ad2[(k5 - 1) + (l4 - 1) * l1 + k1] = ad2[(k5 - 1) + (l4 - 1) * l1 + k1] + d4 * ad[(k5 - 1) + (l2 - 1) * l + k];
                            d10 += ad1[(k5 - 1) + (l4 - 1) * j1 + i1] * ad[(k5 - 1) + (l2 - 1) * l + k];
                            k5++;
                        }

                        if(d1 == 0.0D)
                            ad2[(l2 - 1) + (l4 - 1) * l1 + k1] = d4 * ad[(l2 - 1) + (l2 - 1) * l + k] + d * d10;
                        else
                            ad2[(l2 - 1) + (l4 - 1) * l1 + k1] = d1 * ad2[(l2 - 1) + (l4 - 1) * l1 + k1] + d4 * ad[(l2 - 1) + (l2 - 1) * l + k] + d * d10;
                        l2--;
                    }

                    l4++;
                }

            }
        } else
        {
            int i5 = 1;
            for(int j7 = (j - 1) + 1; j7 > 0; j7--)
            {
                double d5 = d * ad[(i5 - 1) + (i5 - 1) * l + k];
                if(d1 == 0.0D)
                {
                    int i3 = 1;
                    for(int k8 = (i - 1) + 1; k8 > 0; k8--)
                    {
                        ad2[(i3 - 1) + (i5 - 1) * l1 + k1] = d5 * ad1[(i3 - 1) + (i5 - 1) * j1 + i1];
                        i3++;
                    }

                } else
                {
                    int j3 = 1;
                    for(int l8 = (i - 1) + 1; l8 > 0; l8--)
                    {
                        ad2[(j3 - 1) + (i5 - 1) * l1 + k1] = d1 * ad2[(j3 - 1) + (i5 - 1) * l1 + k1] + d5 * ad1[(j3 - 1) + (i5 - 1) * j1 + i1];
                        j3++;
                    }

                }
                int l5 = 1;
                for(int i9 = (i5 - 1 - 1) + 1; i9 > 0; i9--)
                {
                    double d6;
                    if(flag3)
                        d6 = d * ad[(l5 - 1) + (i5 - 1) * l + k];
                    else
                        d6 = d * ad[(i5 - 1) + (l5 - 1) * l + k];
                    int k3 = 1;
                    for(int i10 = (i - 1) + 1; i10 > 0; i10--)
                    {
                        ad2[(k3 - 1) + (i5 - 1) * l1 + k1] = ad2[(k3 - 1) + (i5 - 1) * l1 + k1] + d6 * ad1[(k3 - 1) + (l5 - 1) * j1 + i1];
                        k3++;
                    }

                    l5++;
                }

                l5 = i5 + 1;
                for(int j9 = (j - (i5 + 1)) + 1; j9 > 0; j9--)
                {
                    double d7;
                    if(flag3)
                        d7 = d * ad[(i5 - 1) + (l5 - 1) * l + k];
                    else
                        d7 = d * ad[(l5 - 1) + (i5 - 1) * l + k];
                    int l3 = 1;
                    for(int j10 = (i - 1) + 1; j10 > 0; j10--)
                    {
                        ad2[(l3 - 1) + (i5 - 1) * l1 + k1] = ad2[(l3 - 1) + (i5 - 1) * l1 + k1] + d7 * ad1[(l3 - 1) + (l5 - 1) * j1 + i1];
                        l3++;
                    }

                    l5++;
                }

                i5++;
            }

        }
    }
}