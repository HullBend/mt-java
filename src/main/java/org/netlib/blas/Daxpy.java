package org.netlib.blas;

// constant times a vector plus a vector.
// uses unrolled loops for increments equal to one.
public final class Daxpy {

    public static void daxpy(int n, double da, double[] dx, int _dx_offset, int incx,
            double[] dy, int _dy_offset, int incy) {

        if (n <= 0 || da == 0.0) {
            return;
        }

        int i = 0;

        if (incx != 1 || incy != 1) {
            // code for unequal increments or equal increments
            // not equal to 1
            int ix = 1;
            int iy = 1;
            if (incx < 0) {
                ix = (-n + 1) * incx + 1;
            }
            if (incy < 0) {
                iy = (-n + 1) * incy + 1;
            }
            i = 1;
            for (int k = n; k > 0; k--) {
                dy[(iy - 1) + _dy_offset] = dy[(iy - 1) + _dy_offset] + da * dx[(ix - 1) + _dx_offset];
                ix += incx;
                iy += incy;
                i++;
            }

            return;
        }
        // code for both increments equal to 1
        int m = n % 4; // label 20
        if (m != 0) {
            i = 1;
            for (int k = m; k > 0; k--) {
                dy[(i - 1) + _dy_offset] = dy[(i - 1) + _dy_offset] + da * dx[(i - 1) + _dx_offset];
                i++;
            }

            if (n < 4) {
                return;
            }
        }
        int mp1 = m + 1; // label 40
        i = mp1;
        for (int k = ((n - mp1) + 4) / 4; k > 0; k--) {
            dy[i - 1 + _dy_offset] = dy[i - 1 + _dy_offset] + da * dx[i - 1 + _dx_offset];
            dy[i +     _dy_offset] = dy[i     + _dy_offset] + da * dx[i     + _dx_offset];
            dy[i + 1 + _dy_offset] = dy[i + 1 + _dy_offset] + da * dx[i + 1 + _dx_offset];
            dy[i + 2 + _dy_offset] = dy[i + 2 + _dy_offset] + da * dx[i + 2 + _dx_offset];
            i += 4;
        }
    }
}
