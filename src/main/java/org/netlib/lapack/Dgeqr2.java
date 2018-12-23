package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgeqr2 {

    public static void dgeqr2(int i, int j, double[] ad, int k, int l,
            double[] ad1, int i1, double[] ad2, int j1, intW intw) {

        int k1 = 0;
        int l1 = 0;
        intw.val = 0;
        if (i < 0)
            intw.val = -1;
        else if (j < 0)
            intw.val = -2;
        else if (l < Math.max(1, i))
            intw.val = -4;
        if (intw.val != 0) {
            Xerbla.xerbla("DGEQR2", -intw.val);
            return;
        }

        l1 = Math.min(i, j);
        k1 = 1;
        doubleW dw1 = new doubleW(0.0);
        doubleW dw2 = new doubleW(0.0);
        for (int i2 = l1; i2 > 0; i2--) {
            dlarfg_adapter(i - k1 + 1, ad, k1 - 1 + (k1 - 1) * l + k, ad,
                    Math.min(k1 + 1, i) - 1 + (k1 - 1) * l + k, 1, ad1,
                    k1 - 1 + i1, dw1, dw2);
            if (k1 < j) {
                double d1 = ad[k1 - 1 + (k1 - 1) * l + k];
                ad[k1 - 1 + (k1 - 1) * l + k] = 1.0;
                Dlarf.dlarf("Left", i - k1 + 1, j - k1, ad, k1 - 1
                        + (k1 - 1) * l + k, 1, ad1[k1 - 1 + i1], ad, k1 - 1
                        + k1 * l + k, l, ad2, j1);
                ad[k1 - 1 + (k1 - 1) * l + k] = d1;
            }
            k1++;
        }

    }

    private static void dlarfg_adapter(int i, double ad[], int j, double ad1[],
            int k, int l, double ad2[], int i1, doubleW dw1, doubleW dw2) {
        dw1.val = ad[j];
        dw2.val = ad2[i1];
        Dlarfg.dlarfg(i, dw1, ad1, k, l, dw2);
        ad[j] = dw1.val;
        ad2[i1] = dw2.val;
    }
}
