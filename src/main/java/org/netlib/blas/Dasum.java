package org.netlib.blas;


public final class Dasum
{
    public static double dasum(int i, double ad[], int j, int k)
    {
        double d;
label0:
        {
            d = 0.0D;
            int l = 0;
            int i1 = 0;
            int j1 = 0;
            double d1 = 0.0D;
            d1 = 0.0D;
            d = 0.0D;
            if((i <= 0) || (k <= 0))
                return d1;
            if(k != 1)
            {
                int k1 = i * k;
                l = 1;
                for(int l1 = ((k1 - 1) + k) / k; l1 > 0; l1--)
                {
                    d += Math.abs(ad[(l - 1) + j]);
                    l += k;
                }

                double d2 = d;
                return d2;
            }
            i1 = i % 6;
            if(i1 != 0)
            {
                l = 1;
                for(int i2 = (i1 - 1) + 1; i2 > 0; i2--)
                {
                    d += Math.abs(ad[(l - 1) + j]);
                    l++;
                }

                if(i < 6)
                    break label0;
            }
            j1 = i1 + 1;
            l = j1;
            for(int j2 = ((i - j1) + 6) / 6; j2 > 0; j2--)
            {
                d = d + Math.abs(ad[(l - 1) + j]) + Math.abs(ad[((l + 1) - 1) + j]) + Math.abs(ad[((l + 2) - 1) + j]) + Math.abs(ad[((l + 3) - 1) + j]) + Math.abs(ad[((l + 4) - 1) + j]) + Math.abs(ad[((l + 5) - 1) + j]);
                l += 6;
            }

        }
        double d3 = d;
        return d3;
    }
}