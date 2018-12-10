package org.netlib.blas;

public final class Daxpy {

    public static void daxpy(int n, double da, double[] dx, int _dx_offset, int incx,
            double[] dy, int _dy_offset, int incy) {

        if (n <= 0 || da == 0.0) {
            return;
        }

        int j1 = 0;

        if ((incx != 1) || (incy != 1)) {
            int k1 = 1;
            int l1 = 1;
            if (incx < 0) {
                k1 = (-n + 1) * incx + 1;
            }
            if (incy < 0) {
                l1 = (-n + 1) * incy + 1;
            }
            j1 = 1;
            for (int k2 = (n - 1) + 1; k2 > 0; k2--) {
                dy[(l1 - 1) + _dy_offset] = dy[(l1 - 1) + _dy_offset] + da * dx[(k1 - 1) + _dx_offset];
                k1 += incx;
                l1 += incy;
                j1++;
            }

            return;
        }
        int i2 = n % 4;
        if (i2 != 0) {
            j1 = 1;
            for (int l2 = (i2 - 1) + 1; l2 > 0; l2--) {
                dy[(j1 - 1) + _dy_offset] = dy[(j1 - 1) + _dy_offset] + da * dx[(j1 - 1) + _dx_offset];
                j1++;
            }

            if (n < 4) {
                return;
            }
        }
        int j2 = i2 + 1;
        j1 = j2;
        for (int i3 = ((n - j2) + 4) / 4; i3 > 0; i3--) {
            dy[j1 - 1 + _dy_offset] = dy[j1 - 1 + _dy_offset] + da * dx[j1 - 1 + _dx_offset];
            dy[j1 + _dy_offset    ] = dy[j1     + _dy_offset] + da * dx[j1     + _dx_offset];
            dy[j1 + 1 + _dy_offset] = dy[j1 + 1 + _dy_offset] + da * dx[j1 + 1 + _dx_offset];
            dy[j1 + 2 + _dy_offset] = dy[j1 + 2 + _dy_offset] + da * dx[j1 + 2 + _dx_offset];
            j1 += 4;
        }
    }
}
