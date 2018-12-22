package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.blas.Lsame;
import org.netlib.util.*;

public final class Dgels
{

    public static void dgels(String s, int i, int j, int k, double[] ad, int l, int i1, double[] ad1, 
            int j1, int k1, double[] ad2, int l1, int i2, intW intw)
    {

        int j4;
label0:
        {
            int j2 = 0;
            int k3 = 0;
            int i4 = 0;
            j4 = 0;
            double d = 0.0;
            double d1 = 0.0;
            double[] ad3 = new double[1];
            intw.val = 0;
            k3 = Math.min(i, j);
            boolean flag = i2 == -1;
            if (!(Lsame.lsame(s, "N") || Lsame.lsame(s, "T")))
                intw.val = -1;
            else
            if (i < 0)
                intw.val = -2;
            else
            if (j < 0)
                intw.val = -3;
            else
            if (k < 0)
                intw.val = -4;
            else
            if (i1 < Math.max(1, i))
                intw.val = -6;
            else
            if (k1 < Util.max(1, i, j))
                intw.val = -8;
            else if (!flag && i2 < Math.max(1, k3 + Math.max(k3, k))) {
                intw.val = -10;
            }

            boolean flag1 = false;
            if (intw.val == 0 || intw.val == -10)
            {
                flag1 = true;
                if (Lsame.lsame(s, "N")) {
                    flag1 = false;
                }
                int l3;
                if (i >= j)
                {
                    l3 = Ilaenv.ilaenv(1, "DGEQRF", " ", i, j, -1, -1);
                    if (flag1)
                        l3 = Math.max(l3, Ilaenv.ilaenv(1, "DORMQR", "LN", i, k, j, -1));
                    else
                        l3 = Math.max(l3, Ilaenv.ilaenv(1, "DORMQR", "LT", i, k, j, -1));
                } else
                {
                    l3 = Ilaenv.ilaenv(1, "DGELQF", " ", i, j, -1, -1);
                    if (flag1)
                        l3 = Math.max(l3, Ilaenv.ilaenv(1, "DORMLQ", "LT", j, k, i, -1));
                    else
                        l3 = Math.max(l3, Ilaenv.ilaenv(1, "DORMLQ", "LN", j, k, i, -1));
                }
                j4 = Math.max(1, k3 + Math.max(k3, k) * l3);
                ad2[l1] = j4;
            }
            if (intw.val != 0)
            {
                Xerbla.xerbla("DGELS ", -intw.val);
                return;
            }
            if (flag) {
                return;
            }
            if (Util.min(i, j, k) == 0)
            {
                Dlaset.dlaset("Full", Math.max(i, j), k, 0.0, 0.0, ad1, j1, k1);
                return;
            }

            doubleW dw1 = new doubleW(Dlamch.dlamch("S") / Dlamch.dlamch("P"));
            doubleW dw2 = new doubleW(1.0 / dw1.val);
            Dlabad.dlabad(dw1, dw2);
            d = Dlange.dlange("M", i, j, ad, l, i1, ad3, 0);
            int byte0 = 0;
            if (d > 0.0 && d < dw1.val)
            {
                Dlascl.dlascl("G", 0, 0, d, dw1.val, i, j, ad, l, i1, intw);
                byte0 = 1;
            } else
            if (d > dw2.val)
            {
                Dlascl.dlascl("G", 0, 0, d, dw2.val, i, j, ad, l, i1, intw);
                byte0 = 2;
            } else
            if (d == 0.0)
            {
                Dlaset.dlaset("F", Math.max(i, j), k, 0.0, 0.0, ad1, j1, k1);
                break label0;
            }
            j2 = i;
            if (flag1) {
                j2 = j;
            }
            d1 = Dlange.dlange("M", j2, k, ad1, j1, k1, ad3, 0);
            int byte1 = 0;
            if (d1 > 0.0 && d1 < dw1.val)
            {
                Dlascl.dlascl("G", 0, 0, d1, dw1.val, j2, k, ad1, j1, k1, intw);
                byte1 = 1;
            } else
            if (d1 > dw2.val)
            {
                Dlascl.dlascl("G", 0, 0, d1, dw2.val, j2, k, ad1, j1, k1, intw);
                byte1 = 2;
            }
            if (i >= j)
            {
                Dgeqrf.dgeqrf(i, j, ad, l, i1, ad2, l1, ad2, k3 + l1, i2 - k3, intw);
                if (!flag1)
                {
                    Dormqr.dormqr("Left", "Transpose", i, k, j, ad, l, i1, ad2, l1, ad1, j1, k1, ad2, k3 + l1, i2 - k3, intw);
                    Dtrtrs.dtrtrs("Upper", "No transpose", "Non-unit", j, k, ad, l, i1, ad1, j1, k1, intw);
                    if (intw.val > 0) {
                        return;
                    }
                    i4 = j;
                } else
                {
                    Dtrtrs.dtrtrs("Upper", "Transpose", "Non-unit", j, k, ad, l, i1, ad1, j1, k1, intw);
                    if (intw.val > 0) {
                        return;
                    }
                    int i3 = 1;
                    for (int k4 = k; k4 > 0; k4--)
                    {
                        int k2 = j + 1;
                        for (int i5 = (i - (j + 1)) + 1; i5 > 0; i5--)
                        {
                            ad1[(k2 - 1) + (i3 - 1) * k1 + j1] = 0.0;
                            k2++;
                        }

                        i3++;
                    }

                    Dormqr.dormqr("Left", "No transpose", i, k, j, ad, l, i1, ad2, l1, ad1, j1, k1, ad2, k3 + l1, i2 - k3, intw);
                    i4 = i;
                }
            } else
            {
                Dgelqf.dgelqf(i, j, ad, l, i1, ad2, l1, ad2, k3 + l1, i2 - k3, intw);
                if (!flag1)
                {
                    Dtrtrs.dtrtrs("Lower", "No transpose", "Non-unit", i, k, ad, l, i1, ad1, j1, k1, intw);
                    if (intw.val > 0) {
                        return;
                    }
                    int j3 = 1;
                    for (int l4 = k; l4 > 0; l4--)
                    {
                        int l2 = i + 1;
                        for (int j5 = (j - (i + 1)) + 1; j5 > 0; j5--)
                        {
                            ad1[(l2 - 1) + (j3 - 1) * k1 + j1] = 0.0;
                            l2++;
                        }

                        j3++;
                    }

                    Dormlq.dormlq("Left", "Transpose", j, k, i, ad, l, i1, ad2, l1, ad1, j1, k1, ad2, k3 + l1, i2 - k3, intw);
                    i4 = j;
                } else
                {
                    Dormlq.dormlq("Left", "No transpose", j, k, i, ad, l, i1, ad2, l1, ad1, j1, k1, ad2, k3 + l1, i2 - k3, intw);
                    Dtrtrs.dtrtrs("Lower", "Transpose", "Non-unit", i, k, ad, l, i1, ad1, j1, k1, intw);
                    if (intw.val > 0) {
                        return;
                    }
                    i4 = i;
                }
            }
            if (byte0 == 1)
                Dlascl.dlascl("G", 0, 0, d, dw1.val, i4, k, ad1, j1, k1, intw);
            else
            if (byte0 == 2)
                Dlascl.dlascl("G", 0, 0, d, dw2.val, i4, k, ad1, j1, k1, intw);
            if (byte1 == 1)
                Dlascl.dlascl("G", 0, 0, dw1.val, d1, i4, k, ad1, j1, k1, intw);
            else
            if (byte1 == 2)
                Dlascl.dlascl("G", 0, 0, dw2.val, d1, i4, k, ad1, j1, k1, intw);
        }
        ad2[l1] = j4;
    }
}
