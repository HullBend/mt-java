package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dspr2
{
    public static void dspr2(String s, int i, double d, double ad[], int j, int k, double ad1[], 
            int l, int i1, double ad2[], int j1)
    {
        byte byte0 = 0;
        int i4 = 0;
        int j4 = 0;
        int k5 = 0;
        int l5 = 0;
        int i6 = 0;
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
        if(i1 == 0)
            byte0 = 7;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DSPR2 ", byte0);
            return;
        }
        if((i == 0) || (d == 0.0D))
            return;
        if((k != 1) || (i1 != 1))
        {
            if(k > 0)
                l5 = 1;
            else
                l5 = 1 - (i - 1) * k;
            if(i1 > 0)
                i6 = 1;
            else
                i6 = 1 - (i - 1) * i1;
            i4 = l5;
            j4 = i6;
        }
        k5 = 1;
        if(Lsame.lsame(s, "U"))
        {
            if((k == 1) && (i1 == 1))
            {
                int i3 = 1;
                for(int j6 = (i - 1) + 1; j6 > 0; j6--)
                {
                    if((ad[(i3 - 1) + j] != 0.0D) || (ad1[(i3 - 1) + l] != 0.0D))
                    {
                        double d2 = d * ad1[(i3 - 1) + l];
                        double d7 = d * ad[(i3 - 1) + j];
                        int k4 = k5;
                        int k1 = 1;
                        for(int j7 = (i3 - 1) + 1; j7 > 0; j7--)
                        {
                            ad2[(k4 - 1) + j1] = ad2[(k4 - 1) + j1] + ad[(k1 - 1) + j] * d2 + ad1[(k1 - 1) + l] * d7;
                            k4++;
                            k1++;
                        }

                    }
                    k5 += i3;
                    i3++;
                }

            } else
            {
                int j3 = 1;
                for(int k6 = (i - 1) + 1; k6 > 0; k6--)
                {
                    if((ad[(i4 - 1) + j] != 0.0D) || (ad1[(j4 - 1) + l] != 0.0D))
                    {
                        double d3 = d * ad1[(j4 - 1) + l];
                        double d8 = d * ad[(i4 - 1) + j];
                        int i2 = l5;
                        int k2 = i6;
                        int l4 = k5;
                        for(int k7 = ((k5 + j3) - 1 - k5) + 1; k7 > 0; k7--)
                        {
                            ad2[(l4 - 1) + j1] = ad2[(l4 - 1) + j1] + ad[(i2 - 1) + j] * d3 + ad1[(k2 - 1) + l] * d8;
                            i2 += k;
                            k2 += i1;
                            l4++;
                        }

                    }
                    i4 += k;
                    j4 += i1;
                    k5 += j3;
                    j3++;
                }

            }
        } else
        if((k == 1) && (i1 == 1))
        {
            int k3 = 1;
            for(int l6 = (i - 1) + 1; l6 > 0; l6--)
            {
                if((ad[(k3 - 1) + j] != 0.0D) || (ad1[(k3 - 1) + l] != 0.0D))
                {
                    double d4 = d * ad1[(k3 - 1) + l];
                    double d9 = d * ad[(k3 - 1) + j];
                    int i5 = k5;
                    int l1 = k3;
                    for(int l7 = (i - k3) + 1; l7 > 0; l7--)
                    {
                        ad2[(i5 - 1) + j1] = ad2[(i5 - 1) + j1] + ad[(l1 - 1) + j] * d4 + ad1[(l1 - 1) + l] * d9;
                        i5++;
                        l1++;
                    }

                }
                k5 = ((k5 + i) - k3) + 1;
                k3++;
            }

        } else
        {
            int l3 = 1;
            for (int i7 = (i - 1) + 1; i7 > 0; i7--)
            {
                if ((ad[(i4 - 1) + j] != 0.0D) || (ad1[(j4 - 1) + l] != 0.0D))
                {
                    double d5 = d * ad1[(j4 - 1) + l];
                    double d10 = d * ad[(i4 - 1) + j];
                    int j2 = i4;
                    int l2 = j4;
                    int j5 = k5;
                    for (int i8 = ((k5 + i) - l3 - k5) + 1; i8 > 0; i8--)
                    {
                        ad2[(j5 - 1) + j1] = ad2[(j5 - 1) + j1] + ad[(j2 - 1) + j] * d5 + ad1[(l2 - 1) + l] * d10;
                        j2 += k;
                        l2 += i1;
                        j5++;
                    }

                }
                i4 += k;
                j4 += i1;
                k5 = ((k5 + i) - l3) + 1;
                l3++;
            }

        }
    }
}
