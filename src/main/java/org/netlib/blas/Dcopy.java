package org.netlib.blas;

// DCOPY copies a vector, x, to a vector, y.
// Uses unrolled loops for increments equal to 1.
public final class Dcopy {

    public static void dcopy(int n, double[] dx, int _dx_offset, int incx, double[] dy, int _dy_offset, int incy) {

        if (n <= 0) {
            return;
        }

        int k = 0;

        // code for unequal increments or equal increments
        // not equal to 1
        if (incx != 1 || incy != 1) {
            int ix = 1;
            int iy = 1;
            if (incx < 0) {
                ix = (-n + 1) * incx + 1;
            }
            if (incy < 0) {
                iy = (-n + 1) * incy + 1;
            }
            k = 1;
            for (int i = n; i > 0; i--) {
                dy[iy - 1 + _dy_offset] = dx[ix - 1 + _dx_offset];
                ix += incx;
                iy += incy;
                k++;
            }

            return;
        }
        // code for both increments equal to 1
        int m = n % 7;
        if (m != 0) {
            k = 1;
            for (int i = m; i > 0; i--) {
                dy[k - 1 + _dy_offset] = dx[k - 1 + _dx_offset];
                k++;
            }

            if (n < 7) {
                return;
            }
        }
        int mp = m + 1;
        k = mp;
        for (int i = ((n - mp) + 7) / 7; i > 0; i--) {
            dy[k - 1 + _dy_offset] = dx[k - 1 + _dx_offset];
            dy[k     + _dy_offset] = dx[k     + _dx_offset];
            dy[k + 1 + _dy_offset] = dx[k + 1 + _dx_offset];
            dy[k + 2 + _dy_offset] = dx[k + 2 + _dx_offset];
            dy[k + 3 + _dy_offset] = dx[k + 3 + _dx_offset];
            dy[k + 4 + _dy_offset] = dx[k + 4 + _dx_offset];
            dy[k + 5 + _dy_offset] = dx[k + 5 + _dx_offset];
            k += 7;
        }
    }
}
