package org.netlib.blas;

// DDOT forms the dot product of two vectors.
// Uses unrolled loops for increments equal to one.
public final class Ddot {

    public static double ddot(int n, double[] dx, int _dx_offset, int incx, double[] dy,
            int _dy_offset, int incy) {

        if (n <= 0) {
            return 0.0;
        }

        double ddot;
        label0: {

            int j = 0;
            ddot = 0.0;

            // code for unequal increments or equal increments
            // not equal to 1
            if (incx != 1 || incy != 1) {
                int k = 1;
                int l = 1;
                if (incx < 0) {
                    k = (-n + 1) * incx + 1;
                }
                if (incy < 0) {
                    l = (-n + 1) * incy + 1;
                }
                j = 1;
                for (int q = n; q > 0; q--) {
                    ddot += dx[k - 1 + _dx_offset] * dy[l - 1 + _dy_offset];
                    k += incx;
                    l += incy;
                    j++;
                }

                return ddot;
            }
            // code for both increments equal to 1
            int m = n % 5;
            if (m != 0) {
                j = 1;
                for (int q = m; q > 0; q--) {
                    ddot += dx[j - 1 + _dx_offset] * dy[j - 1 + _dy_offset];
                    j++;
                }

                if (n < 5) {
                    break label0;
                }
            }
            int mp1 = m + 1;
            j = mp1;
            for (int q = (n - mp1 + 5) / 5; q > 0; q--) {
                ddot = ddot
                        + dx[j - 1 + _dx_offset] * dy[j - 1 + _dy_offset]
                        + dx[j     + _dx_offset] * dy[j     + _dy_offset]
                        + dx[j + 1 + _dx_offset] * dy[j + 1 + _dy_offset]
                        + dx[j + 2 + _dx_offset] * dy[j + 2 + _dy_offset]
                        + dx[j + 3 + _dx_offset] * dy[j + 3 + _dy_offset];
                j += 5;
            }

        }
        return ddot;
    }
}
