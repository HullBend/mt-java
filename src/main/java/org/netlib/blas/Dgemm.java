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

        // trace offset values != 0 (temporary measure)
        if (_a_offset != 0 || _b_offset != 0 || _c_offset != 0) {
            System.err.println("_a_offset: " + _a_offset + ", _b_offset: " + _b_offset + ", _c_offset: " + _c_offset);
            new RuntimeException().printStackTrace();
        }

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
        if (((m == 0) || (n == 0)) || (((alpha == 0.0D) || (k == 0)) && (beta == 1.0D))) {
            return;
        }

        // And also if alpha == 0
        if (alpha == 0.0D) {
            if (beta == 0.0D) {
                int l4 = 1;
                for (int j8 = (n - 1) + 1; j8 > 0; j8--) {
                    int j2 = 1;
                    for (int l9 = (m - 1) + 1; l9 > 0; l9--) {
                        c[(j2 - 1) + (l4 - 1) * ldc + _c_offset] = 0.0D;
                        j2++;
                    }

                    l4++;
                }

            } else {
                int i5 = 1;
                for (int k8 = (n - 1) + 1; k8 > 0; k8--) {
                    int k2 = 1;
                    for (int i10 = (m - 1) + 1; i10 > 0; i10--) {
                        c[(k2 - 1) + (i5 - 1) * ldc + _c_offset] = beta * c[(k2 - 1) + (i5 - 1) * ldc + _c_offset];
                        k2++;
                    }

                    i5++;
                }

            }
            return;
        }

        // Start the operations

        if (notb) {
            if (nota) {
                // Form C := alpha*A*B + beta*C
                int j5 = 1;
                for (int l8 = (n - 1) + 1; l8 > 0; l8--) {
                    if (beta == 0.0D) {
                        int l2 = 1;
                        for (int j10 = (m - 1) + 1; j10 > 0; j10--) {
                            c[(l2 - 1) + (j5 - 1) * ldc + _c_offset] = 0.0D;
                            l2++;
                        }

                    } else if (beta != 1.0D) {
                        int i3 = 1;
                        for (int k10 = (m - 1) + 1; k10 > 0; k10--) {
                            c[(i3 - 1) + (j5 - 1) * ldc + _c_offset] = beta * c[(i3 - 1) + (j5 - 1) * ldc + _c_offset];
                            i3++;
                        }

                    }
                    int j6 = 1;
                    for (int l10 = (k - 1) + 1; l10 > 0; l10--) {
                        if (b[(j6 - 1) + (j5 - 1) * ldb + _b_offset] != 0.0D) {
                            double d3 = alpha * b[(j6 - 1) + (j5 - 1) * ldb + _b_offset];
                            int j3 = 1;
                            for (int j12 = (m - 1) + 1; j12 > 0; j12--) {
                                c[(j3 - 1) + (j5 - 1) * ldc + _c_offset] = c[(j3 - 1) + (j5 - 1) * ldc + _c_offset]
                                        + d3 * a[(j3 - 1) + (j6 - 1) * lda + _a_offset];
                                j3++;
                            }

                        }
                        j6++;
                    }

                    j5++;
                }

            } else {
                // Form C := alpha*A**T*B + beta*C
                int k5 = 1;
                for (int i9 = (n - 1) + 1; i9 > 0; i9--) {
                    int k3 = 1;
                    for (int i11 = (m - 1) + 1; i11 > 0; i11--) {
                        double d4 = 0.0D;
                        int k6 = 1;
                        for (int k12 = (k - 1) + 1; k12 > 0; k12--) {
                            d4 += a[(k6 - 1) + (k3 - 1) * lda + _a_offset] * b[(k6 - 1) + (k5 - 1) * ldb + _b_offset];
                            k6++;
                        }

                        if (beta == 0.0D)
                            c[(k3 - 1) + (k5 - 1) * ldc + _c_offset] = alpha * d4;
                        else
                            c[(k3 - 1) + (k5 - 1) * ldc + _c_offset] = alpha * d4
                                    + beta * c[(k3 - 1) + (k5 - 1) * ldc + _c_offset];
                        k3++;
                    }

                    k5++;
                }

            }
        } else if (nota) {
            // Form C := alpha*A*B**T + beta*C
            int l5 = 1;
            for (int j9 = (n - 1) + 1; j9 > 0; j9--) {
                if (beta == 0.0D) {
                    int l3 = 1;
                    for (int j11 = (m - 1) + 1; j11 > 0; j11--) {
                        c[(l3 - 1) + (l5 - 1) * ldc + _c_offset] = 0.0D;
                        l3++;
                    }

                } else if (beta != 1.0D) {
                    int i4 = 1;
                    for (int k11 = (m - 1) + 1; k11 > 0; k11--) {
                        c[(i4 - 1) + (l5 - 1) * ldc + _c_offset] = beta * c[(i4 - 1) + (l5 - 1) * ldc + _c_offset];
                        i4++;
                    }

                }
                int l6 = 1;
                for (int l11 = (k - 1) + 1; l11 > 0; l11--) {
                    if (b[(l5 - 1) + (l6 - 1) * ldb + _b_offset] != 0.0D) {
                        double d5 = alpha * b[(l5 - 1) + (l6 - 1) * ldb + _b_offset];
                        int j4 = 1;
                        for (int l12 = (m - 1) + 1; l12 > 0; l12--) {
                            c[(j4 - 1) + (l5 - 1) * ldc + _c_offset] = c[(j4 - 1) + (l5 - 1) * ldc + _c_offset]
                                    + d5 * a[(j4 - 1) + (l6 - 1) * lda + _a_offset];
                            j4++;
                        }

                    }
                    l6++;
                }

                l5++;
            }

        } else {
            // Form C := alpha*A**T*B**T + beta*C
            int i6 = 1;
            for (int k9 = (n - 1) + 1; k9 > 0; k9--) {
                int k4 = 1;
                for (int i12 = (m - 1) + 1; i12 > 0; i12--) {
                    double d6 = 0.0D;
                    int i7 = 1;
                    for (int i13 = (k - 1) + 1; i13 > 0; i13--) {
                        d6 += a[(i7 - 1) + (k4 - 1) * lda + _a_offset] * b[(i6 - 1) + (i7 - 1) * ldb + _b_offset];
                        i7++;
                    }

                    if (beta == 0.0D)
                        c[(k4 - 1) + (i6 - 1) * ldc + _c_offset] = alpha * d6;
                    else
                        c[(k4 - 1) + (i6 - 1) * ldc + _c_offset] = alpha * d6
                                + beta * c[(k4 - 1) + (i6 - 1) * ldc + _c_offset];
                    k4++;
                }

                i6++;
            }

        }
    }
}
