package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dtrmm {

    public static void dtrmm(String side, String uplo, String transa, String diag, int m, int n, double alpha,
            double[] a, int _a_offset, int lda, double[] b, int _b_offset, int ldb) {

        boolean lside = Lsame.lsame(side, "L");
        boolean nounit = Lsame.lsame(diag, "N");
        boolean upper = Lsame.lsame(uplo, "U");
        boolean notrans = Lsame.lsame(transa, "N");
        int info = 0;
        if (!lside && !Lsame.lsame(side, "R")) {
            info = 1;
        } else if (!upper && !Lsame.lsame(uplo, "L")) {
            info = 2;
        } else if (!notrans && !Lsame.lsame(transa, "T") && !Lsame.lsame(transa, "C")) {
            info = 3;
        } else if (!nounit && !Lsame.lsame(diag, "U")) {
            info = 4;
        } else if (m < 0) {
            info = 5;
        } else if (n < 0) {
            info = 6;
        } else if (lda < Math.max(1, (lside) ? m : n)) {
            info = 9;
        } else if (ldb < Math.max(1, m)) {
            info = 11;
        }
        if (info != 0) {
            Xerbla.xerbla("DTRMM ", info);
            return;
        }
        // Quick return if possible
        if (n == 0) {
            return;
        }
        // Quick return when == alpha zero
        if (alpha == 0.0) {
            int j = 1;
            for (int p = n; p > 0; p--) {
                int i = 1;
                for (int q = m; q > 0; q--) {
                    b[i - 1 + (j - 1) * ldb + _b_offset] = 0.0;
                    i++;
                }

                j++;
            }

            return;
        }
        // Start the operations
        if (lside) {
            if (notrans) {
                if (upper) {
                    // lside, notrans, upper
                    int j = 1;
                    for (int p = n; p > 0; p--) {
                        int k = 1;
                        for (int q = m; q > 0; q--) {
                            if (b[k - 1 + (j - 1) * ldb + _b_offset] != 0.0) {
                                double temp = alpha * b[k - 1 + (j - 1) * ldb + _b_offset];
                                int i = 1;
                                for (int r = k - 1; r > 0; r--) {
                                    b[i - 1 + (j - 1) * ldb + _b_offset] = b[i - 1 + (j - 1) * ldb + _b_offset]
                                            + temp * a[i - 1 + (k - 1) * lda + _a_offset];
                                    i++;
                                }

                                if (nounit) {
                                    temp *= a[k - 1 + (k - 1) * lda + _a_offset];
                                }
                                b[k - 1 + (j - 1) * ldb + _b_offset] = temp;
                            }
                            k++;
                        }

                        j++;
                    }

                } else {
                    // lside, notrans, !upper
                    int j = 1;
                    for (int p = n; p > 0; p--) {
                        int k = m;
                        for (int q = m; q > 0; q--) {
                            if (b[k - 1 + (j - 1) * ldb + _b_offset] != 0.0) {
                                double temp = alpha * b[k - 1 + (j - 1) * ldb + _b_offset];
                                b[k - 1 + (j - 1) * ldb + _b_offset] = temp;
                                if (nounit) {
                                    b[k - 1 + (j - 1) * ldb + _b_offset] = b[k - 1 + (j - 1) * ldb + _b_offset]
                                            * a[k - 1 + (k - 1) * lda + _a_offset];
                                }
                                int i = k + 1;
                                for (int r = m - k; r > 0; r--) {
                                    b[i - 1 + (j - 1) * ldb + _b_offset] = b[i - 1 + (j - 1) * ldb + _b_offset]
                                            + temp * a[i - 1 + (k - 1) * lda + _a_offset];
                                    i++;
                                }

                            }
                            k--;
                        }

                        j++;
                    }

                }
            } else if (upper) {
                // Form B := alpha*A**T*B
                // lside, !notrans, upper
                int j = 1;
                for (int p = n; p > 0; p--) {
                    int i = m;
                    for (int q = m; q > 0; q--) {
                        double temp = b[i - 1 + (j - 1) * ldb + _b_offset];
                        if (nounit) {
                            temp *= a[i - 1 + (i - 1) * lda + _a_offset];
                        }
                        int k = 1;
                        for (int r = i - 1; r > 0; r--) {
                            temp += a[k - 1 + (i - 1) * lda + _a_offset] * b[k - 1 + (j - 1) * ldb + _b_offset];
                            k++;
                        }

                        b[i - 1 + (j - 1) * ldb + _b_offset] = alpha * temp;
                        i--;
                    }

                    j++;
                }

            } else {
                // lside, !notrans, !upper
                int j = 1;
                for (int p = n; p > 0; p--) {
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        double temp = b[i - 1 + (j - 1) * ldb + _b_offset];
                        if (nounit) {
                            temp *= a[i - 1 + (i - 1) * lda + _a_offset];
                        }
                        int k = i + 1;
                        for (int r = m - i; r > 0; r--) {
                            temp += a[k - 1 + (i - 1) * lda + _a_offset] * b[k - 1 + (j - 1) * ldb + _b_offset];
                            k++;
                        }

                        b[i - 1 + (j - 1) * ldb + _b_offset] = alpha * temp;
                        i++;
                    }

                    j++;
                }

            }
        } else if (notrans) {
            // Form B := alpha*B*A
            // !lside, notrans
            if (upper) {
                // !lside, notrans, upper
                int j = n;
                for (int p = n; p > 0; p--) {
                    double temp = alpha;
                    if (nounit) {
                        temp *= a[j - 1 + (j - 1) * lda + _a_offset];
                    }
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        b[i - 1 + (j - 1) * ldb + _b_offset] = temp * b[i - 1 + (j - 1) * ldb + _b_offset];
                        i++;
                    }

                    int k = 1;
                    for (int r = j - 1; r > 0; r--) {
                        if (a[k - 1 + (j - 1) * lda + _a_offset] != 0.0) {
                            temp = alpha * a[k - 1 + (j - 1) * lda + _a_offset];
                            int ii = 1;
                            for (int s = m; s > 0; s--) {
                                b[ii - 1 + (j - 1) * ldb + _b_offset] = b[(ii - 1) + (j - 1) * ldb + _b_offset]
                                        + temp * b[ii - 1 + (k - 1) * ldb + _b_offset];
                                ii++;
                            }

                        }
                        k++;
                    }

                    j--;
                }

            } else {
                // !lside, notrans, !upper
                int j = 1;
                for (int p = n; p > 0; p--) {
                    double temp = alpha;
                    if (nounit) {
                        temp *= a[j - 1 + (j - 1) * lda + _a_offset];
                    }
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        b[i - 1 + (j - 1) * ldb + _b_offset] = temp * b[i - 1 + (j - 1) * ldb + _b_offset];
                        i++;
                    }

                    int k = j + 1;
                    for (int r = n - j; r > 0; r--) {
                        if (a[k - 1 + (j - 1) * lda + _a_offset] != 0.0) {
                            temp = alpha * a[k - 1 + (j - 1) * lda + _a_offset];
                            int ii = 1;
                            for (int s = m; s > 0; s--) {
                                b[ii - 1 + (j - 1) * ldb + _b_offset] = b[ii - 1 + (j - 1) * ldb + _b_offset]
                                        + temp * b[ii - 1 + (k - 1) * ldb + _b_offset];
                                ii++;
                            }

                        }
                        k++;
                    }

                    j++;
                }

            }
        } else if (upper) {
            // Form B := alpha*B*A**T
            // !lside, !notrans, upper
            int k = 1;
            for (int p = n; p > 0; p--) {
                int j = 1;
                for (int q = k - 1; q > 0; q--) {
                    if (a[j - 1 + (k - 1) * lda + _a_offset] != 0.0) {
                        double temp = alpha * a[j - 1 + (k - 1) * lda + _a_offset];
                        int i = 1;
                        for (int r = m; r > 0; r--) {
                            b[i - 1 + (j - 1) * ldb + _b_offset] = b[i - 1 + (j - 1) * ldb + _b_offset]
                                    + temp * b[i - 1 + (k - 1) * ldb + _b_offset];
                            i++;
                        }

                    }
                    j++;
                }

                double temp = alpha;
                if (nounit) {
                    temp *= a[k - 1 + (k - 1) * lda + _a_offset];
                }
                if (temp != 1.0) {
                    int i = 1;
                    for (int s = m; s > 0; s--) {
                        b[i - 1 + (k - 1) * ldb + _b_offset] = temp * b[i - 1 + (k - 1) * ldb + _b_offset];
                        i++;
                    }

                }
                k++;
            }

        } else {
            // !lside, !notrans, !upper
            int k = n;
            for (int p = n; p > 0; p--) {
                int j = k + 1;
                for (int q = n - k; q > 0; q--) {
                    if (a[j - 1 + (k - 1) * lda + _a_offset] != 0.0) {
                        double temp = alpha * a[j - 1 + (k - 1) * lda + _a_offset];
                        int i = 1;
                        for (int r = m; r > 0; r--) {
                            b[i - 1 + (j - 1) * ldb + _b_offset] = b[i - 1 + (j - 1) * ldb + _b_offset]
                                    + temp * b[i - 1 + (k - 1) * ldb + _b_offset];
                            i++;
                        }

                    }
                    j++;
                }

                double temp = alpha;
                if (nounit) {
                    temp *= a[k - 1 + (k - 1) * lda + _a_offset];
                }
                if (temp != 1.0) {
                    int i = 1;
                    for (int s = m; s > 0; s--) {
                        b[i - 1 + (k - 1) * ldb + _b_offset] = temp * b[i - 1 + (k - 1) * ldb + _b_offset];
                        i++;
                    }

                }
                k--;
            }

        }
    }
}
