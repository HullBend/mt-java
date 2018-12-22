package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.blas.Lsame;
import org.netlib.util.*;

public final class Dgels
{

	public static void dgels(String trans, int m, int n, int nrhs, double[] a, int _a_offset, int lda, double[] b,
			int _b_offset, int ldb, double[] work, int _work_offset, int lwork, intW info) {

        info.val = 0;
        int k3 = Math.min(m, n);
        boolean flag = lwork == -1;
		if (!(Lsame.lsame(trans, "N") || Lsame.lsame(trans, "T"))) {
			info.val = -1;
		} else if (m < 0) {
			info.val = -2;
		} else if (n < 0) {
			info.val = -3;
		} else if (nrhs < 0) {
			info.val = -4;
		} else if (lda < Math.max(1, m)) {
			info.val = -6;
		} else if (ldb < Util.max(1, m, n)) {
			info.val = -8;
		} else if (!flag && lwork < Math.max(1, k3 + Math.max(k3, nrhs))) {
			info.val = -10;
		}

		int j4 = 0;
        boolean flag1 = false;
        if (info.val == 0 || info.val == -10)
        {
            flag1 = true;
            if (Lsame.lsame(trans, "N")) {
                flag1 = false;
            }
            int l3;
            if (m >= n)
            {
                l3 = Ilaenv.ilaenv(1, "DGEQRF", " ", m, n, -1, -1);
                if (flag1) {
                    l3 = Math.max(l3, Ilaenv.ilaenv(1, "DORMQR", "LN", m, nrhs, n, -1));
                } else {
                    l3 = Math.max(l3, Ilaenv.ilaenv(1, "DORMQR", "LT", m, nrhs, n, -1));
                }
            } else
            {
                l3 = Ilaenv.ilaenv(1, "DGELQF", " ", m, n, -1, -1);
                if (flag1) {
                    l3 = Math.max(l3, Ilaenv.ilaenv(1, "DORMLQ", "LT", n, nrhs, m, -1));
                } else {
                    l3 = Math.max(l3, Ilaenv.ilaenv(1, "DORMLQ", "LN", n, nrhs, m, -1));
                }
            }
            j4 = Math.max(1, k3 + Math.max(k3, nrhs) * l3);
            work[_work_offset] = j4;
        }
        if (info.val != 0)
        {
            Xerbla.xerbla("DGELS ", -info.val);
            return;
        }
        if (flag) {
            return;
        }
        if (Util.min(m, n, nrhs) == 0)
        {
            Dlaset.dlaset("Full", Math.max(m, n), nrhs, 0.0, 0.0, b, _b_offset, ldb);
            return;
        }

        doubleW dw1 = new doubleW(1.0020841800044864E-292);
        doubleW dw2 = new doubleW(9.979201547673599E291);
        Dlabad.dlabad(dw1, dw2);
        double[] ad3 = new double[1];
        double d = Dlange.dlange("M", m, n, a, _a_offset, lda, ad3, 0);
        int byte0 = 0;
        if (d > 0.0 && d < dw1.val)
        {
            Dlascl.dlascl("G", 0, 0, d, dw1.val, m, n, a, _a_offset, lda, info);
            byte0 = 1;
        } else
        if (d > dw2.val)
        {
            Dlascl.dlascl("G", 0, 0, d, dw2.val, m, n, a, _a_offset, lda, info);
            byte0 = 2;
        } else
        if (d == 0.0)
        {
            Dlaset.dlaset("F", Math.max(m, n), nrhs, 0.0, 0.0, b, _b_offset, ldb);
            work[_work_offset] = j4;
            return;
        }
        int j2 = m;
        if (flag1) {
            j2 = n;
        }
        double d1 = Dlange.dlange("M", j2, nrhs, b, _b_offset, ldb, ad3, 0);
        int byte1 = 0;
        if (d1 > 0.0 && d1 < dw1.val)
        {
            Dlascl.dlascl("G", 0, 0, d1, dw1.val, j2, nrhs, b, _b_offset, ldb, info);
            byte1 = 1;
        } else
        if (d1 > dw2.val)
        {
            Dlascl.dlascl("G", 0, 0, d1, dw2.val, j2, nrhs, b, _b_offset, ldb, info);
            byte1 = 2;
        }
        int i4 = 0;
        if (m >= n)
        {
            Dgeqrf.dgeqrf(m, n, a, _a_offset, lda, work, _work_offset, work, k3 + _work_offset, lwork - k3, info);
            if (!flag1)
            {
                Dormqr.dormqr("Left", "Transpose", m, nrhs, n, a, _a_offset, lda, work, _work_offset, b, _b_offset, ldb, work, k3 + _work_offset, lwork - k3, info);
                Dtrtrs.dtrtrs("Upper", "No transpose", "Non-unit", n, nrhs, a, _a_offset, lda, b, _b_offset, ldb, info);
                if (info.val > 0) {
                    return;
                }
                i4 = n;
            } else
            {
                Dtrtrs.dtrtrs("Upper", "Transpose", "Non-unit", n, nrhs, a, _a_offset, lda, b, _b_offset, ldb, info);
                if (info.val > 0) {
                    return;
                }
                int i3 = 1;
                for (int k4 = nrhs; k4 > 0; k4--)
                {
                    int k2 = n + 1;
                    for (int i5 = m - n; i5 > 0; i5--)
                    {
                        b[(k2 - 1) + (i3 - 1) * ldb + _b_offset] = 0.0;
                        k2++;
                    }

                    i3++;
                }

                Dormqr.dormqr("Left", "No transpose", m, nrhs, n, a, _a_offset, lda, work, _work_offset, b, _b_offset, ldb, work, k3 + _work_offset, lwork - k3, info);
                i4 = m;
            }
        } else
        {
            Dgelqf.dgelqf(m, n, a, _a_offset, lda, work, _work_offset, work, k3 + _work_offset, lwork - k3, info);
            if (!flag1)
            {
                Dtrtrs.dtrtrs("Lower", "No transpose", "Non-unit", m, nrhs, a, _a_offset, lda, b, _b_offset, ldb, info);
                if (info.val > 0) {
                    return;
                }
                int j3 = 1;
                for (int l4 = nrhs; l4 > 0; l4--)
                {
                    int l2 = m + 1;
                    for (int j5 = n - m; j5 > 0; j5--)
                    {
                        b[(l2 - 1) + (j3 - 1) * ldb + _b_offset] = 0.0;
                        l2++;
                    }

                    j3++;
                }

                Dormlq.dormlq("Left", "Transpose", n, nrhs, m, a, _a_offset, lda, work, _work_offset, b, _b_offset, ldb, work, k3 + _work_offset, lwork - k3, info);
                i4 = n;
            } else
            {
                Dormlq.dormlq("Left", "No transpose", n, nrhs, m, a, _a_offset, lda, work, _work_offset, b, _b_offset, ldb, work, k3 + _work_offset, lwork - k3, info);
                Dtrtrs.dtrtrs("Lower", "Transpose", "Non-unit", m, nrhs, a, _a_offset, lda, b, _b_offset, ldb, info);
                if (info.val > 0) {
                    return;
                }
                i4 = m;
            }
        }
		if (byte0 == 1) {
			Dlascl.dlascl("G", 0, 0, d, dw1.val, i4, nrhs, b, _b_offset, ldb, info);
		} else if (byte0 == 2) {
			Dlascl.dlascl("G", 0, 0, d, dw2.val, i4, nrhs, b, _b_offset, ldb, info);
		}
		if (byte1 == 1) {
			Dlascl.dlascl("G", 0, 0, dw1.val, d1, i4, nrhs, b, _b_offset, ldb, info);
		} else if (byte1 == 2) {
			Dlascl.dlascl("G", 0, 0, dw2.val, d1, i4, nrhs, b, _b_offset, ldb, info);
		}

        work[_work_offset] = j4;
    }
}
