package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dgemm {
    /**
    *  Purpose
    *  =======
    *
    *  DGEMM  performs one of the matrix-matrix operations
    *
    *     C := alpha*op( A )*op( B ) + beta*C,
    *
    *  where  op( X ) is one of
    *
    *     op( X ) = X   or   op( X ) = X',
    *
    *  alpha and beta are scalars, and A, B and C are matrices, with op( A )
    *  an m by k matrix,  op( B )  a  k by n matrix and  C an m by n matrix.
    *
    *  Arguments
    *  ==========
    *
    *  TRANSA - CHARACTER*1.
    *           On entry, TRANSA specifies the form of op( A ) to be used in
    *           the matrix multiplication as follows:
    *
    *              TRANSA = 'N' or 'n',  op( A ) = A.
    *
    *              TRANSA = 'T' or 't',  op( A ) = A'.
    *
    *              TRANSA = 'C' or 'c',  op( A ) = A'.
    *
    *           Unchanged on exit.
    *
    *  TRANSB - CHARACTER*1.
    *           On entry, TRANSB specifies the form of op( B ) to be used in
    *           the matrix multiplication as follows:
    *
    *              TRANSB = 'N' or 'n',  op( B ) = B.
    *
    *              TRANSB = 'T' or 't',  op( B ) = B'.
    *
    *              TRANSB = 'C' or 'c',  op( B ) = B'.
    *
    *           Unchanged on exit.
    *
    *  M      - INTEGER.
    *           On entry,  M  specifies  the number  of rows  of the  matrix
    *           op( A )  and of the  matrix  C.  M  must  be at least  zero.
    *           Unchanged on exit.
    *
    *  N      - INTEGER.
    *           On entry,  N  specifies the number  of columns of the matrix
    *           op( B ) and the number of columns of the matrix C. N must be
    *           at least zero.
    *           Unchanged on exit.
    *
    *  K      - INTEGER.
    *           On entry,  K  specifies  the number of columns of the matrix
    *           op( A ) and the number of rows of the matrix op( B ). K must
    *           be at least  zero.
    *           Unchanged on exit.
    *
    *  ALPHA  - DOUBLE PRECISION.
    *           On entry, ALPHA specifies the scalar alpha.
    *           Unchanged on exit.
    *
    *  A      - DOUBLE PRECISION array of DIMENSION ( LDA, ka ), where ka is
    *           k  when  TRANSA = 'N' or 'n',  and is  m  otherwise.
    *           Before entry with  TRANSA = 'N' or 'n',  the leading  m by k
    *           part of the array  A  must contain the matrix  A,  otherwise
    *           the leading  k by m  part of the array  A  must contain  the
    *           matrix A.
    *           Unchanged on exit.
    *
    *  LDA    - INTEGER.
    *           On entry, LDA specifies the first dimension of A as declared
    *           in the calling (sub) program. When  TRANSA = 'N' or 'n' then
    *           LDA must be at least  max( 1, m ), otherwise  LDA must be at
    *           least  max( 1, k ).
    *           Unchanged on exit.
    *
    *  B      - DOUBLE PRECISION array of DIMENSION ( LDB, kb ), where kb is
    *           n  when  TRANSB = 'N' or 'n',  and is  k  otherwise.
    *           Before entry with  TRANSB = 'N' or 'n',  the leading  k by n
    *           part of the array  B  must contain the matrix  B,  otherwise
    *           the leading  n by k  part of the array  B  must contain  the
    *           matrix B.
    *           Unchanged on exit.
    *
    *  LDB    - INTEGER.
    *           On entry, LDB specifies the first dimension of B as declared
    *           in the calling (sub) program. When  TRANSB = 'N' or 'n' then
    *           LDB must be at least  max( 1, k ), otherwise  LDB must be at
    *           least  max( 1, n ).
    *           Unchanged on exit.
    *
    *  BETA   - DOUBLE PRECISION.
    *           On entry,  BETA  specifies the scalar  beta.  When  BETA  is
    *           supplied as zero then C need not be set on input.
    *           Unchanged on exit.
    *
    *  C      - DOUBLE PRECISION array of DIMENSION ( LDC, n ).
    *           Before entry, the leading  m by n  part of the array  C must
    *           contain the matrix  C,  except when  beta  is zero, in which
    *           case C need not be set on entry.
    *           On exit, the array  C  is overwritten by the  m by n  matrix
    *           ( alpha*op( A )*op( B ) + beta*C ).
    *
    *  LDC    - INTEGER.
    *           On entry, LDC specifies the first dimension of C as declared
    *           in  the  calling  (sub)  program.   LDC  must  be  at  least
    *           max( 1, m ).
    *           Unchanged on exit.
    *
    *
    *  Level 3 Blas routine.
    *
    *  -- Written on 8-February-1989.
    *     Jack Dongarra, Argonne National Laboratory.
    *     Iain Duff, AERE Harwell.
    *     Jeremy Du Croz, Numerical Algorithms Group Ltd.
    *     Sven Hammarling, Numerical Algorithms Group Ltd.
    *
    *
    *     .. External Functions ..
    * </code></pre>
    *
    * @param transa
    * @param transb
    * @param m
    * @param n
    * @param k
    * @param alpha
    * @param a
    * @param _a_offset
    * @param lda
    * @param b
    * @param _b_offset
    * @param ldb
    * @param beta
    * @param c
    * @param _c_offset
    * @param ldc
    */
    public static void dgemm(String transa, String transb, int m, int n, int k, double alpha, double a[], int _a_offset,
            int lda, double b[], int _b_offset, int ldb, double beta, double c[], int _c_offset, int ldc) {

        byte info = 0;
        int nrowa = 0;
        int nrowb = 0;
        boolean nota = Lsame.lsame(transa, "N");
        boolean notb = Lsame.lsame(transb, "N");
        if (nota) {
            nrowa = m;
        } else {
            nrowa = k;
        }
        if (notb) {
            nrowb = k;
        } else {
            nrowb = n;
        }
        info = 0;
        if ((!nota && !Lsame.lsame(transa, "C")) && !Lsame.lsame(transa, "T"))
            info = 1;
        else if ((!notb && !Lsame.lsame(transb, "C")) && !Lsame.lsame(transb, "T"))
            info = 2;
        else if (m < 0)
            info = 3;
        else if (n < 0)
            info = 4;
        else if (k < 0)
            info = 5;
        else if (lda < Math.max(1, nrowa))
            info = 8;
        else if (ldb < Math.max(1, nrowb))
            info = 10;
        else if (ldc < Math.max(1, m))
            info = 13;
        if (info != 0) {
            Xerbla.xerbla("DGEMM ", info);
            return;
        }
        // Quick return if possible
        if (((m == 0) || (n == 0)) || (((alpha == 0.0) || (k == 0)) && (beta == 1.0))) {
            return;
        }

        // And also if alpha == 0
        if (alpha == 0.0) {
            if (beta == 0.0) {
                int v = 1;
                for (int o = n; o > 0; o--) {
                    int i = 1;
                    for (int p = m; p > 0; p--) {
                        c[(i - 1) + (v - 1) * ldc + _c_offset] = 0.0;
                        i++;
                    }

                    v++;
                }

            } else {
                int v = 1;
                for (int o = n; o > 0; o--) {
                    int i = 1;
                    for (int p = m; p > 0; p--) {
                        c[(i - 1) + (v - 1) * ldc + _c_offset] = beta * c[(i - 1) + (v - 1) * ldc + _c_offset];
                        i++;
                    }

                    v++;
                }

            }
            return;
        }

        // Start the operations

        if (notb) {
            if (nota) {
                // Form C := alpha*A*B + beta*C
                int u = 1;
                for (int o = n; o > 0; o--) {
                    if (beta == 0.0) {
                        int i = 1;
                        for (int p = m; p > 0; p--) {
                            c[(i - 1) + (u - 1) * ldc + _c_offset] = 0.0;
                            i++;
                        }

                    } else if (beta != 1.0) {
                        int i = 1;
                        for (int p = m; p > 0; p--) {
                            c[(i - 1) + (u - 1) * ldc + _c_offset] = beta * c[(i - 1) + (u - 1) * ldc + _c_offset];
                            i++;
                        }

                    }
                    int w = 1;
                    for (int p = k; p > 0; p--) {
                        if (b[(w - 1) + (u - 1) * ldb + _b_offset] != 0.0) {
                            double tmp = alpha * b[(w - 1) + (u - 1) * ldb + _b_offset];
                            int i = 1;
                            for (int q = m; q > 0; q--) {
                                c[(i - 1) + (u - 1) * ldc + _c_offset] = c[(i - 1) + (u - 1) * ldc + _c_offset]
                                        + tmp * a[(i - 1) + (w - 1) * lda + _a_offset];
                                i++;
                            }

                        }
                        w++;
                    }

                    u++;
                }

            } else {
                // Form C := alpha*A**T*B + beta*C
                int u = 1;
                for (int o = n; o > 0; o--) {
                    int w = 1;
                    for (int p = m; p > 0; p--) {
                        double tmp = 0.0;
                        int i = 1;
                        for (int q = k; q > 0; q--) {
                            tmp += a[(i - 1) + (w - 1) * lda + _a_offset] * b[(i - 1) + (u - 1) * ldb + _b_offset];
                            i++;
                        }

                        if (beta == 0.0) {
                            c[(w - 1) + (u - 1) * ldc + _c_offset] = alpha * tmp;
                        } else {
                            c[(w - 1) + (u - 1) * ldc + _c_offset] = alpha * tmp
                                    + beta * c[(w - 1) + (u - 1) * ldc + _c_offset];
                        }
                        w++;
                    }

                    u++;
                }

            }
        } else if (nota) {
            // Form C := alpha*A*B**T + beta*C
            int u = 1;
            for (int o = n; o > 0; o--) {
                if (beta == 0.0) {
                    int i = 1;
                    for (int p = m; p > 0; p--) {
                        c[(i - 1) + (u - 1) * ldc + _c_offset] = 0.0;
                        i++;
                    }

                } else if (beta != 1.0) {
                    int i = 1;
                    for (int p = m; p > 0; p--) {
                        c[(i - 1) + (u - 1) * ldc + _c_offset] = beta * c[(i - 1) + (u - 1) * ldc + _c_offset];
                        i++;
                    }

                }
                int w = 1;
                for (int p = k; p > 0; p--) {
                    if (b[(u - 1) + (w - 1) * ldb + _b_offset] != 0.0) {
                        double tmp = alpha * b[(u - 1) + (w - 1) * ldb + _b_offset];
                        int i = 1;
                        for (int q = m; q > 0; q--) {
                            c[(i - 1) + (u - 1) * ldc + _c_offset] = c[(i - 1) + (u - 1) * ldc + _c_offset]
                                    + tmp * a[(i - 1) + (w - 1) * lda + _a_offset];
                            i++;
                        }

                    }
                    w++;
                }

                u++;
            }

        } else {
            // Form C := alpha*A**T*B**T + beta*C
            int u = 1;
            for (int o = n; o > 0; o--) {
                int w = 1;
                for (int p = m; p > 0; p--) {
                    double tmp = 0.0;
                    int i = 1;
                    for (int q = k; q > 0; q--) {
                        tmp += a[(i - 1) + (w - 1) * lda + _a_offset] * b[(u - 1) + (i - 1) * ldb + _b_offset];
                        i++;
                    }

                    if (beta == 0.0) {
                        c[(w - 1) + (u - 1) * ldc + _c_offset] = alpha * tmp;
                    } else {
                        c[(w - 1) + (u - 1) * ldc + _c_offset] = alpha * tmp
                                + beta * c[(w - 1) + (u - 1) * ldc + _c_offset];
                    }
                    w++;
                }

                u++;
            }
        }
    }
}
