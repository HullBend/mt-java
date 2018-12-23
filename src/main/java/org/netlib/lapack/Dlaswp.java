package org.netlib.lapack;

public final class Dlaswp
{
    public static void dlaswp(int i, double[] ad, int j, int k, int l, int i1, int[] ai, int j1, 
            int k1)
    {
        int j2 = 0;
        int k2 = 0;
        int byte0 = 0;
        int l3 = 0;
        int l4 = 0;
        if (k1 > 0)
        {
            l3 = l;
            j2 = l;
            k2 = i1;
            byte0 = 1;
        } else
        if (k1 < 0)
        {
            l3 = 1 + (1 - i1) * k1;
            j2 = i1;
            k2 = l;
            byte0 = -1;
        } else
        {
            return;
        }
        l4 = (i / 32) * 32;
        if (l4 != 0)
        {
            int i4 = 1;
            for (int i5 = ((l4 - 1) + 32) / 32; i5 > 0; i5--)
            {
                int j3 = l3;
                int l1 = j2;
                for (int k5 = ((k2 - j2) + byte0) / byte0; k5 > 0; k5--)
                {
                    int l2 = ai[(j3 - 1) + j1];
                    if (l2 != l1)
                    {
                        int j4 = i4;
                        for (int i6 = ((i4 + 31) - i4) + 1; i6 > 0; i6--)
                        {
                            double d1 = ad[(l1 - 1) + (j4 - 1) * k + j];
                            ad[(l1 - 1) + (j4 - 1) * k + j] = ad[(l2 - 1) + (j4 - 1) * k + j];
                            ad[(l2 - 1) + (j4 - 1) * k + j] = d1;
                            j4++;
                        }

                    }
                    j3 += k1;
                    l1 += byte0;
                }

                i4 += 32;
            }

        }
        if (l4 != i)
        {
            l4++;
            int k3 = l3;
            int i2 = j2;
            for (int j5 = ((k2 - j2) + byte0) / byte0; j5 > 0; j5--)
            {
                int i3 = ai[(k3 - 1) + j1];
                if (i3 != i2)
                {
                    int k4 = l4;
                    for (int l5 = (i - l4) + 1; l5 > 0; l5--)
                    {
                        double d2 = ad[(i2 - 1) + (k4 - 1) * k + j];
                        ad[(i2 - 1) + (k4 - 1) * k + j] = ad[(i3 - 1) + (k4 - 1) * k + j];
                        ad[(i3 - 1) + (k4 - 1) * k + j] = d2;
                        k4++;
                    }

                }
                k3 += k1;
                i2 += byte0;
            }

        }
    }
}
