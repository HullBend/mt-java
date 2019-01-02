package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsyr2
{
    public static void dsyr2(String s, int i, double d, double ad[], int j, int k, double ad1[], 
            int l, int i1, double ad2[], int j1, int k1)
    {
        int byte0 = 0;
        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        int k5 = 0;
        byte0 = 0;
        if (!Lsame.lsame(s, "U") && !Lsame.lsame(s, "L"))
            byte0 = 1;
        else
        if(i < 0)
            byte0 = 2;
        else
        if(k == 0)
            byte0 = 5;
        else
        if(i1 == 0)
            byte0 = 7;
        else
        if(k1 < Math.max(1, i))
            byte0 = 9;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DSYR2 ", byte0);
            return;
        }
        if((i == 0) || (d == 0.0))
            return;
        if((k != 1) || (i1 != 1))
        {
            if(k > 0)
                j5 = 1;
            else
                j5 = 1 - (i - 1) * k;
            if(i1 > 0)
                k5 = 1;
            else
                k5 = 1 - (i - 1) * i1;
            l4 = j5;
            i5 = k5;
        }
        if(Lsame.lsame(s, "U"))
        {
            if((k == 1) && (i1 == 1))
            {
                int l3 = 1;
                for(int l5 = i; l5 > 0; l5--)
                {
                    if((ad[(l3 - 1) + j] != 0.0) || (ad1[(l3 - 1) + l] != 0.0))
                    {
                        double d2 = d * ad1[(l3 - 1) + l];
                        double d7 = d * ad[(l3 - 1) + j];
                        int l1 = 1;
                        for(int l6 = l3; l6 > 0; l6--)
                        {
                            ad2[(l1 - 1) + (l3 - 1) * k1 + j1] = ad2[(l1 - 1) + (l3 - 1) * k1 + j1] + ad[(l1 - 1) + j] * d2 + ad1[(l1 - 1) + l] * d7;
                            l1++;
                        }

                    }
                    l3++;
                }

            } else
            {
                int i4 = 1;
                for(int i6 = i; i6 > 0; i6--)
                {
                    if((ad[(l4 - 1) + j] != 0.0) || (ad1[(i5 - 1) + l] != 0.0))
                    {
                        double d3 = d * ad1[(i5 - 1) + l];
                        double d8 = d * ad[(l4 - 1) + j];
                        int l2 = j5;
                        int j3 = k5;
                        int i2 = 1;
                        for(int i7 = i4; i7 > 0; i7--)
                        {
                            ad2[(i2 - 1) + (i4 - 1) * k1 + j1] = ad2[(i2 - 1) + (i4 - 1) * k1 + j1] + ad[(l2 - 1) + j] * d3 + ad1[(j3 - 1) + l] * d8;
                            l2 += k;
                            j3 += i1;
                            i2++;
                        }

                    }
                    l4 += k;
                    i5 += i1;
                    i4++;
                }

            }
        } else
        if((k == 1) && (i1 == 1))
        {
            int j4 = 1;
            for(int j6 = i; j6 > 0; j6--)
            {
                if((ad[(j4 - 1) + j] != 0.0) || (ad1[(j4 - 1) + l] != 0.0))
                {
                    double d4 = d * ad1[(j4 - 1) + l];
                    double d9 = d * ad[(j4 - 1) + j];
                    int j2 = j4;
                    for(int j7 = (i - j4) + 1; j7 > 0; j7--)
                    {
                        ad2[(j2 - 1) + (j4 - 1) * k1 + j1] = ad2[(j2 - 1) + (j4 - 1) * k1 + j1] + ad[(j2 - 1) + j] * d4 + ad1[(j2 - 1) + l] * d9;
                        j2++;
                    }

                }
                j4++;
            }

        } else
        {
            int k4 = 1;
            for (int k6 = i; k6 > 0; k6--)
            {
                if ((ad[(l4 - 1) + j] != 0.0) || (ad1[(i5 - 1) + l] != 0.0))
                {
                    double d5 = d * ad1[(i5 - 1) + l];
                    double d10 = d * ad[(l4 - 1) + j];
                    int i3 = l4;
                    int k3 = i5;
                    int k2 = k4;
                    for (int k7 = (i - k4) + 1; k7 > 0; k7--)
                    {
                        ad2[(k2 - 1) + (k4 - 1) * k1 + j1] = ad2[(k2 - 1) + (k4 - 1) * k1 + j1] + ad[(i3 - 1) + j] * d5 + ad1[(k3 - 1) + l] * d10;
                        i3 += k;
                        k3 += i1;
                        k2++;
                    }

                }
                l4 += k;
                i5 += i1;
                k4++;
            }

        }
    }
}
