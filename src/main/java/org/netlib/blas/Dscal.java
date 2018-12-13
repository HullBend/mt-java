package org.netlib.blas;

// DSCAL scales a vector by a constant.
// Uses unrolled loops for increment equal to 1.
public final class Dscal {

    public static void dscal(int n, double da, double[] dx, int _dx_offset, int incx) {

        if (n <= 0 || incx <= 0) {
            return;
        }

        int l = 0;
        // code for increment not equal to 1
        if (incx != 1) {
            int nincx = n * incx;
            l = 1;
            for (int i = ((nincx - 1) + incx) / incx; i > 0; i--) {
                dx[l - 1 + _dx_offset] = da * dx[l - 1 + _dx_offset];
                l += incx;
            }

            return;
        }
        // code for increment equal to 1
        int m = n % 5;
        if (m != 0) {
            l = 1;
            for (int i = m; i > 0; i--) {
                dx[l - 1 + _dx_offset] = da * dx[l - 1 + _dx_offset];
                l++;
            }

            if (n < 5) {
                return;
            }
        }
        int mp = m + 1;
        l = mp;
        for (int i = ((n - mp) + 5) / 5; i > 0; i--) {
            dx[l - 1 + _dx_offset] = da * dx[l - 1 + _dx_offset];
            dx[l     + _dx_offset] = da * dx[l     + _dx_offset];
            dx[l + 1 + _dx_offset] = da * dx[l + 1 + _dx_offset];
            dx[l + 2 + _dx_offset] = da * dx[l + 2 + _dx_offset];
            dx[l + 3 + _dx_offset] = da * dx[l + 3 + _dx_offset];
            l += 5;
        }
    }
}
