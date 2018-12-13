package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsyr
{
    public static void dsyr(String s, int i, double d, double ad[], int j, int k, double ad1[], 
            int l, int i1)
    {
        byte byte0 = 0;
        int j4 = 0;
        byte0 = 0;
        if(Lsame.lsame(s, "U") ^ true && Lsame.lsame(s, "L") ^ true)
            byte0 = 1;
        else
        if(i < 0)
            byte0 = 2;
        else
        if(k == 0)
            byte0 = 5;
        else
        if(i1 < Math.max(1, i))
            byte0 = 7;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DSYR  ", byte0);
            return;
        }
        if((i == 0) || (d == 0.0D))
            return;
        if(k <= 0)
            j4 = 1 - (i - 1) * k;
        else
        if(k != 1)
            j4 = 1;
        if(Lsame.lsame(s, "U"))
        {
            if(k == 1)
            {
                int l2 = 1;
                for(int k4 = (i - 1) + 1; k4 > 0; k4--)
                {
                    if(ad[(l2 - 1) + j] != 0.0D)
                    {
                        double d2 = d * ad[(l2 - 1) + j];
                        int j1 = 1;
                        for(int k5 = (l2 - 1) + 1; k5 > 0; k5--)
                        {
                            ad1[(j1 - 1) + (l2 - 1) * i1 + l] = ad1[(j1 - 1) + (l2 - 1) * i1 + l] + ad[(j1 - 1) + j] * d2;
                            j1++;
                        }

                    }
                    l2++;
                }

            } else
            {
                int l3 = j4;
                int i3 = 1;
                for(int l4 = (i - 1) + 1; l4 > 0; l4--)
                {
                    if(ad[(l3 - 1) + j] != 0.0D)
                    {
                        double d3 = d * ad[(l3 - 1) + j];
                        int j2 = j4;
                        int k1 = 1;
                        for(int l5 = (i3 - 1) + 1; l5 > 0; l5--)
                        {
                            ad1[(k1 - 1) + (i3 - 1) * i1 + l] = ad1[(k1 - 1) + (i3 - 1) * i1 + l] + ad[(j2 - 1) + j] * d3;
                            j2 += k;
                            k1++;
                        }

                    }
                    l3 += k;
                    i3++;
                }

            }
        } else
        if(k == 1)
        {
            int j3 = 1;
            for(int i5 = (i - 1) + 1; i5 > 0; i5--)
            {
                if(ad[(j3 - 1) + j] != 0.0D)
                {
                    double d4 = d * ad[(j3 - 1) + j];
                    int l1 = j3;
                    for(int i6 = (i - j3) + 1; i6 > 0; i6--)
                    {
                        ad1[(l1 - 1) + (j3 - 1) * i1 + l] = ad1[(l1 - 1) + (j3 - 1) * i1 + l] + ad[(l1 - 1) + j] * d4;
                        l1++;
                    }

                }
                j3++;
            }

        } else
        {
            int i4 = j4;
            int k3 = 1;
            for(int j5 = (i - 1) + 1; j5 > 0; j5--)
            {
                if(ad[(i4 - 1) + j] != 0.0D)
                {
                    double d5 = d * ad[(i4 - 1) + j];
                    int k2 = i4;
                    int i2 = k3;
                    for(int j6 = (i - k3) + 1; j6 > 0; j6--)
                    {
                        ad1[(i2 - 1) + (k3 - 1) * i1 + l] = ad1[(i2 - 1) + (k3 - 1) * i1 + l] + ad[(k2 - 1) + j] * d5;
                        k2 += k;
                        i2++;
                    }

                }
                i4 += k;
                k3++;
            }

        }
    }
}