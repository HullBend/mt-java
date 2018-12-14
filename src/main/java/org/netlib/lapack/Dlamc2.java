package org.netlib.lapack;

import org.netlib.util.booleanW;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlamc2 {

    public static void dlamc2(intW beta, intW t, booleanW rnd, doubleW eps,
            intW emin, doubleW rmin, intW emax, doubleW rmax) {

        beta.val = 2;
        t.val = 53;
        rnd.val = true;
        eps.val = 1.1102230246251565E-16;
        emin.val = -1021;
        rmin.val = 2.2250738585072014E-308;
        emax.val = 1024;
        rmax.val = 1.7976931348623157E308;
    }
}
