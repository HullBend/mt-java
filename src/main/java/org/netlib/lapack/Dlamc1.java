package org.netlib.lapack;

import org.netlib.util.booleanW;
import org.netlib.util.intW;

public final class Dlamc1 {

    public static void dlamc1(intW beta, intW t, booleanW rnd, booleanW ieee1) {
        beta.val = 2;
        t.val = 53;
        rnd.val = true;
        ieee1.val = true;
    }
}
