package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.util.doubleW;

public final class Dlange {

    public static double dlange(String s, int i, int j, double ad[], int k,
            int l, double ad1[], int i1) {

        double d = 0.0;

        if (Math.min(i, j) == 0)
            d = 0.0;
        else if (Lsame.lsame(s, "M")) {
            d = 0.0;
            int i2 = 1;
            for (int i3 = j; i3 > 0; i3--) {
                int j1 = 1;
                for (int k4 = i; k4 > 0; k4--) {
                    d = Math.max(d, Math.abs(ad[j1 - 1 + (i2 - 1) * l + k]));
                    j1++;
                }

                i2++;
            }

        } else if (Lsame.lsame(s, "O") || s.regionMatches(0, "1", 0, 1)) {
            d = 0.0;
            int j2 = 1;
            doubleW dw = new doubleW(0.0);
            for (int j3 = j; j3 > 0; j3--) {
                dw.val = 0.0;
                int k1 = 1;
                for (int l4 = i; l4 > 0; l4--) {
                    dw.val = dw.val
                            + Math.abs(ad[k1 - 1 + (j2 - 1) * l + k]);
                    k1++;
                }

                d = Math.max(d, dw.val);
                j2++;
            }

        } else if (Lsame.lsame(s, "I")) {
            int l1 = 1;
            for (int k3 = i; k3 > 0; k3--) {
                ad1[l1 - 1 + i1] = 0.0;
                l1++;
            }

            int k2 = 1;
            for (int l3 = j; l3 > 0; l3--) {
                l1 = 1;
                for (int i5 = i; i5 > 0; i5--) {
                    ad1[l1 - 1 + i1] = ad1[l1 - 1 + i1]
                            + Math.abs(ad[l1 - 1 + (k2 - 1) * l + k]);
                    l1++;
                }

                k2++;
            }

            d = 0.0;
            l1 = 1;
            for (int i4 = i; i4 > 0; i4--) {
                d = Math.max(d, ad1[l1 - 1 + i1]);
                l1++;
            }

        } else if (Lsame.lsame(s, "F") || Lsame.lsame(s, "E")) {
            doubleW dw1 = new doubleW(1.0);
            doubleW dw2 = new doubleW(0.0);
            
            int l2 = 1;
            for (int j4 = j; j4 > 0; j4--) {
                Dlassq.dlassq(i, ad, (l2 - 1) * l + k, 1, dw2,
                        dw1);
                l2++;
            }

            d = dw2.val * Math.sqrt(dw1.val);
        }
        return d;
    }
}
