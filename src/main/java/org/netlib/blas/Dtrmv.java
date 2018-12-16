package org.netlib.blas;

import org.netlib.err.Xerbla;

// DTRMV  performs one of the matrix-vector operations
// x := A*x,  or  x := A**T*x, where x is an n element
// vector and  A is an n by n unit, or non-unit, upper
// or lower triangular matrix.
public final class Dtrmv {

    public static void dtrmv(String uplo, String trans, String diag, int n, double[] a, int _a_offset, int lda,
            double[] x, int _x_offset, int incx) {

        int info = 0;
        if (!Lsame.lsame(uplo, "U") && !Lsame.lsame(uplo, "L")) {
            info = 1;
        } else if ((!Lsame.lsame(trans, "N") && !Lsame.lsame(trans, "T")) && !Lsame.lsame(trans, "C")) {
            info = 2;
        } else if (!Lsame.lsame(diag, "U") && !Lsame.lsame(diag, "N")) {
            info = 3;
        } else if (n < 0) {
            info = 4;
        } else if (lda < Math.max(1, n)) {
            info = 6;
        } else if (incx == 0) {
            info = 8;
        }
        if (info != 0) {
            Xerbla.xerbla("DTRMV ", info);
            return;
        }
        if (n == 0) {
            return;
        }

        boolean nounit = Lsame.lsame(diag, "N");
        // Set up the start point in X if the increment is not unity. This
        // will be ( N - 1 )*INCX too small for descending loops.
        int kx = 0;
        if (incx <= 0) {
            kx = 1 - (n - 1) * incx;
        } else if (incx != 1) {
            kx = 1;
        }

        if (Lsame.lsame(trans, "N")) {
            // Form x := A*x
            if (Lsame.lsame(uplo, "U")) {
                if (incx == 1) {
                    int j = 1;
                    for (int p = n; p > 0; p--) {
                        if (x[j - 1 + _x_offset] != 0.0) {
                            double temp = x[j - 1 + _x_offset];
                            int i = 1;
                            for (int q = j - 1; q > 0; q--) {
                                x[i - 1 + _x_offset] = x[i - 1 + _x_offset]
                                        + temp * a[i - 1 + (j - 1) * lda + _a_offset];
                                i++;
                            }

                            if (nounit) {
                                x[j - 1 + _x_offset] = x[j - 1 + _x_offset] * a[j - 1 + (j - 1) * lda + _a_offset];
                            }
                        }
                        j++;
                    }
                } else {
                    int jx = kx;
                    int j = 1;
                    for (int p = n; p > 0; p--) {
                        if (x[jx - 1 + _x_offset] != 0.0) {
                            double temp = x[jx - 1 + _x_offset];
                            int ix = kx;
                            int i = 1;
                            for (int q = j - 1; q > 0; q--) {
                                x[ix - 1 + _x_offset] = x[ix - 1 + _x_offset]
                                        + temp * a[i - 1 + (j - 1) * lda + _a_offset];
                                ix += incx;
                                i++;
                            }

                            if (nounit) {
                                x[jx - 1 + _x_offset] = x[jx - 1 + _x_offset] * a[j - 1 + (j - 1) * lda + _a_offset];
                            }
                        }
                        jx += incx;
                        j++;
                    }

                }
            } else if (incx == 1) {
                int j = n;
                for (int p = n; p > 0; p--) {
                    if (x[j - 1 + _x_offset] != 0.0) {
                        double temp = x[j - 1 + _x_offset];
                        int i = n;
                        for (int q = n - j; q > 0; q--) {
                            x[i - 1 + _x_offset] = x[i - 1 + _x_offset] + temp * a[i - 1 + (j - 1) * lda + _a_offset];
                            i--;
                        }

                        if (nounit) {
                            x[j - 1 + _x_offset] = x[j - 1 + _x_offset] * a[j - 1 + (j - 1) * lda + _a_offset];
                        }
                    }
                    j--;
                }
            } else {
                kx += (n - 1) * incx;
                int jx = kx;
                int j = n;
                for (int p = n; p > 0; p--) {
                    if (x[jx - 1 + _x_offset] != 0.0) {
                        double temp = x[jx - 1 + _x_offset];
                        int ix = kx;
                        int i = n;
                        for (int q = n - j; q > 0; q--) {
                            x[ix - 1 + _x_offset] = x[ix - 1 + _x_offset] + temp * a[i - 1 + (j - 1) * lda + _a_offset];
                            ix -= incx;
                            i--;
                        }

                        if (nounit) {
                            x[jx - 1 + _x_offset] = x[jx - 1 + _x_offset] * a[j - 1 + (j - 1) * lda + _a_offset];
                        }
                    }
                    jx -= incx;
                    j--;
                }
            }
        } else if (Lsame.lsame(uplo, "U")) {
            // Form x := A**T*x
            if (incx == 1) {
                int j = n;
                for (int p = n; p > 0; p--) {
                    double temp = x[j - 1 + _x_offset];
                    if (nounit) {
                        temp *= a[j - 1 + (j - 1) * lda + _a_offset];
                    }
                    int i = j - 1;
                    for (int q = j; q > 0; q--) {
                        temp += a[i - 1 + (j - 1) * lda + _a_offset] * x[i - 1 + _x_offset];
                        i--;
                    }

                    x[j - 1 + _x_offset] = temp;
                    j--;
                }
            } else {
                int jx = kx + (n - 1) * incx;
                int j = n;
                for (int p = n; p > 0; p--) {
                    double temp = x[jx - 1 + _x_offset];
                    int ix = jx;
                    if (nounit) {
                        temp *= a[j - 1 + (j - 1) * lda + _a_offset];
                    }
                    int i = j - 1;
                    for (int q = j - 1; q > 0; q--) {
                        ix -= incx;
                        temp += a[i - 1 + (j - 1) * lda + _a_offset] * x[ix - 1 + _x_offset];
                        i--;
                    }

                    x[jx - 1 + _x_offset] = temp;
                    jx -= incx;
                    j--;
                }
            }
        } else if (incx == 1) {
            int j = 1;
            for (int p = n; p > 0; p--) {
                double temp = x[j - 1 + _x_offset];
                if (nounit) {
                    temp *= a[j - 1 + (j - 1) * lda + _a_offset];
                }
                int i = j + 1;
                for (int q = n - j; q > 0; q--) {
                    temp += a[i - 1 + (j - 1) * lda + _a_offset] * x[i - 1 + _x_offset];
                    i++;
                }

                x[j - 1 + _x_offset] = temp;
                j++;
            }
        } else {
            int jx = kx;
            int j = 1;
            for (int p = n; p > 0; p--) {
                double temp = x[jx - 1 + _x_offset];
                int ix = jx;
                if (nounit) {
                    temp *= a[j - 1 + (j - 1) * lda + _a_offset];
                }
                int i = j + 1;
                for (int q = n - j; q > 0; q--) {
                    ix += incx;
                    temp += a[i - 1 + (j - 1) * lda + _a_offset] * x[ix - 1 + _x_offset];
                    i++;
                }

                x[jx - 1 + _x_offset] = temp;
                jx += incx;
                j++;
            }
        }
    }
}
