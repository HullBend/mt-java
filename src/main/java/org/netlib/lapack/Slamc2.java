package org.netlib.lapack;

import org.netlib.util.*;

public final class Slamc2 {

    public static void slamc2(intW intw, intW intw1, booleanW booleanw, floatW floatw, intW intw2, floatW floatw1,
            intW intw3, floatW floatw2) {
        booleanW booleanw1 = new booleanW(false);
        booleanW booleanw2 = new booleanW(false);
        intW intw4 = new intW(0);
        intW intw5 = new intW(0);
        intW intw6 = new intW(0);
        intW intw7 = new intW(0);
        if (first) {
            float f21 = 0;
            float f9 = 1;
            float f19 = 2;
            Slamc1.slamc1(lbeta, lt, booleanw2, booleanw1);
            float f3 = lbeta.val;
            float f1 = (float) Math.pow(f3, -lt.val);
            leps = f1;
            f3 = f19 / (float) 3;
            float f7 = f9 / (float) 2;
            float f13 = Slamc3.slamc3(f3, -f7);
            float f17 = Slamc3.slamc3(f13, f13);
            f3 = Slamc3.slamc3(f17, -f7);
            f3 = Slamc3.slamc3(f3, f13);
            f3 = Math.abs(f3);
            if (f3 < leps)
                f3 = leps;
            leps = 1;
            while ((leps <= f3) || (f3 <= f21)) {
                leps = f3;
                float f5 = Slamc3.slamc3(f7 * leps, (float) Math.pow(f19, 5) * (float) Math.pow(leps, 2));
                f5 = Slamc3.slamc3(f7, -f5);
                f3 = Slamc3.slamc3(f7, f5);
                f5 = Slamc3.slamc3(f7, -f3);
                f3 = Slamc3.slamc3(f7, f5);
            }
            if (f1 < leps)
                leps = f1;
            float f11 = f9 / (float) lbeta.val;
            float f15 = f9;
            for (int j = (3 - 1) + 1; j > 0; j--) {
                f15 = Slamc3.slamc3(f15 * f11, f21);
            }

            f1 = Slamc3.slamc3(f9, f15);
            Slamc4.slamc4(intw7, f9, lbeta.val);
            Slamc4.slamc4(intw6, -f9, lbeta.val);
            Slamc4.slamc4(intw5, f1, lbeta.val);
            Slamc4.slamc4(intw4, -f1, lbeta.val);
            boolean flag1 = false;
            if ((intw7.val == intw6.val) && (intw5.val == intw4.val)) {
                if (intw7.val == intw5.val)
                    lemin = intw7.val;
                else if (intw5.val - intw7.val == 3) {
                    lemin = (intw7.val - 1) + lt.val;
                    flag1 = true;
                } else {
                    lemin = Math.min(intw7.val, intw5.val);
                    iwarn = true;
                }
            } else if ((intw7.val == intw5.val) && (intw6.val == intw4.val)) {
                if (Math.abs(intw7.val - intw6.val) == 1) {
                    lemin = Math.max(intw7.val, intw6.val);
                } else {
                    lemin = Math.min(intw7.val, intw6.val);
                    iwarn = true;
                }
            } else if ((Math.abs(intw7.val - intw6.val) == 1) && (intw5.val == intw4.val)) {
                if (intw5.val - Math.min(intw7.val, intw6.val) == 3) {
                    lemin = (Math.max(intw7.val, intw6.val) - 1) + lt.val;
                } else {
                    lemin = Math.min(intw7.val, intw6.val);
                    iwarn = true;
                }
            } else {
                lemin = Math.min(Util.min(intw7.val, intw6.val, intw5.val), intw4.val);
                iwarn = true;
            }
            first = false;
            if (iwarn) {
                first = true;
                System.err.println("WARNING. The value EMIN may be incorrect:  EMIN = '" + lemin
                        + "'. If, after inspection, the value EMIN looks acceptable please comment out the IF block as marked within the code of routine 'SLAMC2' otherwise supply EMIN explicitly.");
            }
            flag1 = flag1 || booleanw1.val;
            lrmin = 1;
            for (int k = (1 - lemin - 1) + 1; k > 0; k--) {
                lrmin = Slamc3.slamc3(lrmin * f11, f21);
            }

            Slamc5.slamc5(lbeta.val, lt.val, lemin, flag1, lemax, lrmax);
        }
        intw.val = lbeta.val;
        intw1.val = lt.val;
        booleanw.val = booleanw2.val;
        floatw.val = leps;
        intw2.val = lemin;
        floatw1.val = lrmin;
        intw3.val = lemax.val;
        floatw2.val = lrmax.val;
    }

    public static boolean first = true;
    public static boolean iwarn = false;
    public static intW lbeta = new intW(0);
    public static intW lemax = new intW(0);
    public static int lemin = 0;
    public static intW lt = new intW(0);
    public static float leps = 0.0F;
    public static floatW lrmax = new floatW(0.0F);
    public static float lrmin = 0.0F;
}
