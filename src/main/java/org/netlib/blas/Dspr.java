package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dspr
{
    public static void dspr(String s, int i, double d, double ad[], int j, int k, double ad1[], 
            int l)
    {
        byte byte0 = 0;
        int k4 = 0;
        int l4 = 0;
        byte0 = 0;
        if(Lsame.lsame(s, "U") ^ true && Lsame.lsame(s, "L") ^ true)
            byte0 = 1;
        else
        if(i < 0)
            byte0 = 2;
        else
        if(k == 0)
            byte0 = 5;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DSPR  ", byte0);
            return;
        }
        if((i == 0) || (d == 0.0D))
            return;
        if(k <= 0)
            l4 = 1 - (i - 1) * k;
        else
        if(k != 1)
            l4 = 1;
        k4 = 1;
        if(Lsame.lsame(s, "U"))
        {
            if(k == 1)
            {
                int i2 = 1;
                for(int i5 = (i - 1) + 1; i5 > 0; i5--)
                {
                    if(ad[(i2 - 1) + j] != 0.0D)
                    {
                        double d2 = d * ad[(i2 - 1) + j];
                        int k3 = k4;
                        int i1 = 1;
                        for(int i6 = (i2 - 1) + 1; i6 > 0; i6--)
                        {
                            ad1[(k3 - 1) + l] = ad1[(k3 - 1) + l] + ad[(i1 - 1) + j] * d2;
                            k3++;
                            i1++;
                        }

                    }
                    k4 += i2;
                    i2++;
                }

            } else
            {
                int i3 = l4;
                int j2 = 1;
                for(int j5 = (i - 1) + 1; j5 > 0; j5--)
                {
                    if(ad[(i3 - 1) + j] != 0.0D)
                    {
                        double d3 = d * ad[(i3 - 1) + j];
                        int k1 = l4;
                        int l3 = k4;
                        for(int j6 = ((k4 + j2) - 1 - k4) + 1; j6 > 0; j6--)
                        {
                            ad1[(l3 - 1) + l] = ad1[(l3 - 1) + l] + ad[(k1 - 1) + j] * d3;
                            k1 += k;
                            l3++;
                        }

                    }
                    i3 += k;
                    k4 += j2;
                    j2++;
                }

            }
        } else
        if(k == 1)
        {
            int k2 = 1;
            for(int k5 = (i - 1) + 1; k5 > 0; k5--)
            {
                if(ad[(k2 - 1) + j] != 0.0D)
                {
                    double d4 = d * ad[(k2 - 1) + j];
                    int i4 = k4;
                    int j1 = k2;
                    for(int k6 = (i - k2) + 1; k6 > 0; k6--)
                    {
                        ad1[(i4 - 1) + l] = ad1[(i4 - 1) + l] + ad[(j1 - 1) + j] * d4;
                        i4++;
                        j1++;
                    }

                }
                k4 = ((k4 + i) - k2) + 1;
                k2++;
            }

        } else
        {
            int j3 = l4;
            int l2 = 1;
            for(int l5 = (i - 1) + 1; l5 > 0; l5--)
            {
                if(ad[(j3 - 1) + j] != 0.0D)
                {
                    double d5 = d * ad[(j3 - 1) + j];
                    int l1 = j3;
                    int j4 = k4;
                    for(int l6 = ((k4 + i) - l2 - k4) + 1; l6 > 0; l6--)
                    {
                        ad1[(j4 - 1) + l] = ad1[(j4 - 1) + l] + ad[(l1 - 1) + j] * d5;
                        l1 += k;
                        j4++;
                    }

                }
                j3 += k;
                k4 = ((k4 + i) - l2) + 1;
                l2++;
            }

        }
    }
}