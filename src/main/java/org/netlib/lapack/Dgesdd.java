package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.blas.Dgemm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgesdd
{
    public static void dgesdd(String s, int i, int j, double ad[], int k, int l, double ad1[], int i1, 
            double ad2[], int j1, int k1, double ad3[], int l1, int i2, double ad4[], 
            int j2, int k2, int ai[], int l2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        int i3 = 0;
        int l3 = 0;
        intW intw1 = new intW(0);
        int k7 = 0;
        int l7 = 0;
        boolean flag9 = false;
        int k17 = 0;
        int j18 = 0;
        int k18 = 0;
        int i19 = 0;
        double d = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        int[] ai1 = new int[1];
        double[] ad5 = new double[1];
        intw.val = 0;
        k18 = Math.min(i, j);
        flag1 = Lsame.lsame(s, "A");
        flag5 = Lsame.lsame(s, "S");
        flag2 = flag1 || flag5;
        flag4 = Lsame.lsame(s, "O");
        flag3 = Lsame.lsame(s, "N");
        flag = k2 == -1;
        if(!(((flag1 || flag5) || flag4) || flag3))
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        else
        if(j < 0)
            intw.val = -3;
        else
        if(l < Math.max(1, i))
            intw.val = -5;
        else
        if(((k1 < 1) || (flag2 && (k1 < i))) || ((flag4 && (i < j)) && (k1 < i)))
            intw.val = -8;
        else
        if((((i2 < 1) || (flag1 && (i2 < j))) || (flag5 && (i2 < k18))) || ((flag4 && (i >= j)) && (i2 < j)))
            intw.val = -10;
        if(intw.val == 0)
        {
            int l18 = 1;
            j18 = 1;
            if((i >= j) && (k18 > 0))
            {
                i19 = (int)(((double)k18 * 11.0) / 6.0);
                if(flag3)
                    i3 = 7 * j;
                else
                    i3 = 3 * j * j + 4 * j;
                if(i >= i19)
                {
                    if(flag3)
                    {
                        int l21 = j + j * Ilaenv.ilaenv(1, "DGEQRF", " ", i, j, -1, -1);
                        l21 = Math.max(l21, 3 * j + 2 * j * Ilaenv.ilaenv(1, "DGEBRD", " ", j, j, -1, -1));
                        j18 = Math.max(l21, i3 + j);
                        l18 = i3 + j;
                    } else
                    if(flag4)
                    {
                        int i22 = j + j * Ilaenv.ilaenv(1, "DGEQRF", " ", i, j, -1, -1);
                        i22 = Math.max(i22, j + j * Ilaenv.ilaenv(1, "DORGQR", " ", i, j, j, -1));
                        i22 = Math.max(i22, 3 * j + 2 * j * Ilaenv.ilaenv(1, "DGEBRD", " ", j, j, -1, -1));
                        i22 = Math.max(i22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "QLN", j, j, j, -1));
                        i22 = Math.max(i22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "PRT", j, j, j, -1));
                        i22 = Math.max(i22, i3 + 3 * j);
                        j18 = i22 + 2 * j * j;
                        l18 = i3 + 2 * j * j + 3 * j;
                    } else
                    if(flag5)
                    {
                        int j22 = j + j * Ilaenv.ilaenv(1, "DGEQRF", " ", i, j, -1, -1);
                        j22 = Math.max(j22, j + j * Ilaenv.ilaenv(1, "DORGQR", " ", i, j, j, -1));
                        j22 = Math.max(j22, 3 * j + 2 * j * Ilaenv.ilaenv(1, "DGEBRD", " ", j, j, -1, -1));
                        j22 = Math.max(j22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "QLN", j, j, j, -1));
                        j22 = Math.max(j22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "PRT", j, j, j, -1));
                        j22 = Math.max(j22, i3 + 3 * j);
                        j18 = j22 + j * j;
                        l18 = i3 + j * j + 3 * j;
                    } else
                    if(flag1)
                    {
                        int k22 = j + j * Ilaenv.ilaenv(1, "DGEQRF", " ", i, j, -1, -1);
                        k22 = Math.max(k22, j + i * Ilaenv.ilaenv(1, "DORGQR", " ", i, i, j, -1));
                        k22 = Math.max(k22, 3 * j + 2 * j * Ilaenv.ilaenv(1, "DGEBRD", " ", j, j, -1, -1));
                        k22 = Math.max(k22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "QLN", j, j, j, -1));
                        k22 = Math.max(k22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "PRT", j, j, j, -1));
                        k22 = Math.max(k22, i3 + 3 * j);
                        j18 = k22 + j * j;
                        l18 = i3 + j * j + 3 * j;
                    }
                } else
                {
                    int l22 = 3 * j + (i + j) * Ilaenv.ilaenv(1, "DGEBRD", " ", i, j, -1, -1);
                    if(flag3)
                    {
                        j18 = Math.max(l22, i3 + 3 * j);
                        l18 = 3 * j + Math.max(i, i3);
                    } else
                    if(flag4)
                    {
                        l22 = Math.max(l22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, j, j, -1));
                        l22 = Math.max(l22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "PRT", j, j, j, -1));
                        l22 = Math.max(l22, i3 + 3 * j);
                        j18 = l22 + i * j;
                        l18 = 3 * j + Math.max(i, j * j + i3);
                    } else
                    if(flag5)
                    {
                        l22 = Math.max(l22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, j, j, -1));
                        l22 = Math.max(l22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "PRT", j, j, j, -1));
                        j18 = Math.max(l22, i3 + 3 * j);
                        l18 = 3 * j + Math.max(i, i3);
                    } else
                    if(flag1)
                    {
                        l22 = Math.max(l22, 3 * j + i * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, i, j, -1));
                        l22 = Math.max(l22, 3 * j + j * Ilaenv.ilaenv(1, "DORMBR", "PRT", j, j, j, -1));
                        j18 = Math.max(j18, i3 + 3 * j);
                        l18 = 3 * j + Math.max(i, i3);
                    }
                }
            } else
            if(k18 > 0)
            {
                i19 = (int)(((double)k18 * 11.0) / 6.0);
                if(flag3)
                    i3 = 7 * i;
                else
                    i3 = 3 * i * i + 4 * i;
                if(j >= i19)
                {
                    if(flag3)
                    {
                        int i23 = i + i * Ilaenv.ilaenv(1, "DGELQF", " ", i, j, -1, -1);
                        i23 = Math.max(i23, 3 * i + 2 * i * Ilaenv.ilaenv(1, "DGEBRD", " ", i, i, -1, -1));
                        j18 = Math.max(i23, i3 + i);
                        l18 = i3 + i;
                    } else
                    if(flag4)
                    {
                        int j23 = i + i * Ilaenv.ilaenv(1, "DGELQF", " ", i, j, -1, -1);
                        j23 = Math.max(j23, i + i * Ilaenv.ilaenv(1, "DORGLQ", " ", i, j, i, -1));
                        j23 = Math.max(j23, 3 * i + 2 * i * Ilaenv.ilaenv(1, "DGEBRD", " ", i, i, -1, -1));
                        j23 = Math.max(j23, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, i, i, -1));
                        j23 = Math.max(j23, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "PRT", i, i, i, -1));
                        j23 = Math.max(j23, i3 + 3 * i);
                        j18 = j23 + 2 * i * i;
                        l18 = i3 + 2 * i * i + 3 * i;
                    } else
                    if(flag5)
                    {
                        int k23 = i + i * Ilaenv.ilaenv(1, "DGELQF", " ", i, j, -1, -1);
                        k23 = Math.max(k23, i + i * Ilaenv.ilaenv(1, "DORGLQ", " ", i, j, i, -1));
                        k23 = Math.max(k23, 3 * i + 2 * i * Ilaenv.ilaenv(1, "DGEBRD", " ", i, i, -1, -1));
                        k23 = Math.max(k23, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, i, i, -1));
                        k23 = Math.max(k23, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "PRT", i, i, i, -1));
                        k23 = Math.max(k23, i3 + 3 * i);
                        j18 = k23 + i * i;
                        l18 = i3 + i * i + 3 * i;
                    } else
                    if(flag1)
                    {
                        int l23 = i + i * Ilaenv.ilaenv(1, "DGELQF", " ", i, j, -1, -1);
                        l23 = Math.max(l23, i + j * Ilaenv.ilaenv(1, "DORGLQ", " ", j, j, i, -1));
                        l23 = Math.max(l23, 3 * i + 2 * i * Ilaenv.ilaenv(1, "DGEBRD", " ", i, i, -1, -1));
                        l23 = Math.max(l23, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, i, i, -1));
                        l23 = Math.max(l23, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "PRT", i, i, i, -1));
                        l23 = Math.max(l23, i3 + 3 * i);
                        j18 = l23 + i * i;
                        l18 = i3 + i * i + 3 * i;
                    }
                } else
                {
                    int i24 = 3 * i + (i + j) * Ilaenv.ilaenv(1, "DGEBRD", " ", i, j, -1, -1);
                    if(flag3)
                    {
                        j18 = Math.max(i24, i3 + 3 * i);
                        l18 = 3 * i + Math.max(j, i3);
                    } else
                    if(flag4)
                    {
                        i24 = Math.max(i24, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, i, j, -1));
                        i24 = Math.max(i24, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "PRT", i, j, i, -1));
                        i24 = Math.max(i24, i3 + 3 * i);
                        j18 = i24 + i * j;
                        l18 = 3 * i + Math.max(j, i * i + i3);
                    } else
                    if(flag5)
                    {
                        i24 = Math.max(i24, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, i, j, -1));
                        i24 = Math.max(i24, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "PRT", i, j, i, -1));
                        j18 = Math.max(i24, i3 + 3 * i);
                        l18 = 3 * i + Math.max(j, i3);
                    } else
                    if(flag1)
                    {
                        i24 = Math.max(i24, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "QLN", i, i, j, -1));
                        i24 = Math.max(i24, 3 * i + i * Ilaenv.ilaenv(1, "DORMBR", "PRT", j, j, i, -1));
                        j18 = Math.max(i24, i3 + 3 * i);
                        l18 = 3 * i + Math.max(j, i3);
                    }
                }
            }
            j18 = Math.max(j18, l18);
            ad4[j2] = j18;
            if((k2 < l18) && flag ^ true)
                intw.val = -12;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGESDD", -intw.val);
            return;
        }
        if(flag)
            return;
        if((i == 0) || (j == 0))
            return;
        d2 = Dlamch.dlamch("P");
        d3 = Math.sqrt(Dlamch.dlamch("S")) / d2;
        d1 = 1.0 / d3;
        d = Dlange.dlange("M", i, j, ad, k, l, ad5, 0);
        flag9 = false;
        if((d > 0.0) && (d < d3))
        {
            flag9 = true;
            Dlascl.dlascl("G", 0, 0, d, d3, i, j, ad, k, l, intw1);
        } else
        if(d > d1)
        {
            flag9 = true;
            Dlascl.dlascl("G", 0, 0, d, d1, i, j, ad, k, l, intw1);
        }
        if(i >= j)
        {
            if(i >= i19)
            {
                if(flag3)
                {
                    int i8 = 1;
                    int j19 = i8 + j;
                    Dgeqrf.dgeqrf(i, j, ad, k, l, ad4, (i8 - 1) + j2, ad4, (j19 - 1) + j2, (k2 - j19) + 1, intw1);
                    Dlaset.dlaset("L", j - 1, j - 1, 0.0, 0.0, ad, 1 + k, l);
                    int i5 = 1;
                    int k12 = i5 + j;
                    int i10 = k12 + j;
                    j19 = i10 + j;
                    Dgebrd.dgebrd(j, j, ad, k, l, ad1, i1, ad4, (i5 - 1) + j2, ad4, (k12 - 1) + j2, ad4, (i10 - 1) + j2, ad4, (j19 - 1) + j2, (k2 - j19) + 1, intw1);
                    j19 = i5 + j;
                    Dbdsdc.dbdsdc("U", "N", j, ad1, i1, ad4, (i5 - 1) + j2, ad5, 0, 1, ad5, 0, 1, ad5, 0, ai1, 0, ad4, (j19 - 1) + j2, ai, l2, intw);
                } else
                if(flag4)
                {
                    l7 = 1;
                    if(k2 >= l * j + j * j + 3 * j + i3)
                        k17 = l;
                    else
                        k17 = (k2 - j * j - 3 * j - i3) / j;
                    int j8 = l7 + k17 * j;
                    int k19 = j8 + j;
                    Dgeqrf.dgeqrf(i, j, ad, k, l, ad4, (j8 - 1) + j2, ad4, (k19 - 1) + j2, (k2 - k19) + 1, intw1);
                    Dlacpy.dlacpy("U", j, j, ad, k, l, ad4, (l7 - 1) + j2, k17);
                    Dlaset.dlaset("L", j - 1, j - 1, 0.0, 0.0, ad4, ((l7 + 1) - 1) + j2, k17);
                    Dorgqr.dorgqr(i, j, j, ad, k, l, ad4, (j8 - 1) + j2, ad4, (k19 - 1) + j2, (k2 - k19) + 1, intw1);
                    int j5 = j8;
                    int l12 = j5 + j;
                    int j10 = l12 + j;
                    k19 = j10 + j;
                    Dgebrd.dgebrd(j, j, ad4, (l7 - 1) + j2, k17, ad1, i1, ad4, (j5 - 1) + j2, ad4, (l12 - 1) + j2, ad4, (j10 - 1) + j2, ad4, (k19 - 1) + j2, (k2 - k19) + 1, intw1);
                    int i15 = k19;
                    k19 = i15 + j * j;
                    Dbdsdc.dbdsdc("U", "I", j, ad1, i1, ad4, (j5 - 1) + j2, ad4, (i15 - 1) + j2, j, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (k19 - 1) + j2, ai, l2, intw);
                    Dormbr.dormbr("Q", "L", "N", j, j, j, ad4, (l7 - 1) + j2, k17, ad4, (l12 - 1) + j2, ad4, (i15 - 1) + j2, j, ad4, (k19 - 1) + j2, (k2 - k19) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", j, j, j, ad4, (l7 - 1) + j2, k17, ad4, (j10 - 1) + j2, ad3, l1, i2, ad4, (k19 - 1) + j2, (k2 - k19) + 1, intw1);
                    int i4 = 1;
                    for(int j24 = ((i - 1) + k17) / k17; j24 > 0; j24--)
                    {
                        l3 = Math.min((i - i4) + 1, k17);
                        Dgemm.dgemm("N", "N", l3, j, j, 1.0, ad, (i4 - 1) + k, l, ad4, (i15 - 1) + j2, j, 0.0, ad4, (l7 - 1) + j2, k17);
                        Dlacpy.dlacpy("F", l3, j, ad4, (l7 - 1) + j2, k17, ad, (i4 - 1) + k, l);
                        i4 += k17;
                    }

                } else
                if(flag5)
                {
                    l7 = 1;
                    k17 = j;
                    int k8 = l7 + k17 * j;
                    int l19 = k8 + j;
                    Dgeqrf.dgeqrf(i, j, ad, k, l, ad4, (k8 - 1) + j2, ad4, (l19 - 1) + j2, (k2 - l19) + 1, intw1);
                    Dlacpy.dlacpy("U", j, j, ad, k, l, ad4, (l7 - 1) + j2, k17);
                    Dlaset.dlaset("L", j - 1, j - 1, 0.0, 0.0, ad4, ((l7 + 1) - 1) + j2, k17);
                    Dorgqr.dorgqr(i, j, j, ad, k, l, ad4, (k8 - 1) + j2, ad4, (l19 - 1) + j2, (k2 - l19) + 1, intw1);
                    int k5 = k8;
                    int i13 = k5 + j;
                    int k10 = i13 + j;
                    l19 = k10 + j;
                    Dgebrd.dgebrd(j, j, ad4, (l7 - 1) + j2, k17, ad1, i1, ad4, (k5 - 1) + j2, ad4, (i13 - 1) + j2, ad4, (k10 - 1) + j2, ad4, (l19 - 1) + j2, (k2 - l19) + 1, intw1);
                    Dbdsdc.dbdsdc("U", "I", j, ad1, i1, ad4, (k5 - 1) + j2, ad2, j1, k1, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (l19 - 1) + j2, ai, l2, intw);
                    Dormbr.dormbr("Q", "L", "N", j, j, j, ad4, (l7 - 1) + j2, k17, ad4, (i13 - 1) + j2, ad2, j1, k1, ad4, (l19 - 1) + j2, (k2 - l19) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", j, j, j, ad4, (l7 - 1) + j2, k17, ad4, (k10 - 1) + j2, ad3, l1, i2, ad4, (l19 - 1) + j2, (k2 - l19) + 1, intw1);
                    Dlacpy.dlacpy("F", j, j, ad2, j1, k1, ad4, (l7 - 1) + j2, k17);
                    Dgemm.dgemm("N", "N", i, j, j, 1.0, ad, k, l, ad4, (l7 - 1) + j2, k17, 0.0, ad2, j1, k1);
                } else
                if(flag1)
                {
                    int j15 = 1;
                    int l17 = j;
                    int l8 = j15 + l17 * j;
                    int i20 = l8 + j;
                    Dgeqrf.dgeqrf(i, j, ad, k, l, ad4, (l8 - 1) + j2, ad4, (i20 - 1) + j2, (k2 - i20) + 1, intw1);
                    Dlacpy.dlacpy("L", i, j, ad, k, l, ad2, j1, k1);
                    Dorgqr.dorgqr(i, i, j, ad2, j1, k1, ad4, (l8 - 1) + j2, ad4, (i20 - 1) + j2, (k2 - i20) + 1, intw1);
                    Dlaset.dlaset("L", j - 1, j - 1, 0.0, 0.0, ad, 1 + k, l);
                    int l5 = l8;
                    int j13 = l5 + j;
                    int l10 = j13 + j;
                    i20 = l10 + j;
                    Dgebrd.dgebrd(j, j, ad, k, l, ad1, i1, ad4, (l5 - 1) + j2, ad4, (j13 - 1) + j2, ad4, (l10 - 1) + j2, ad4, (i20 - 1) + j2, (k2 - i20) + 1, intw1);
                    Dbdsdc.dbdsdc("U", "I", j, ad1, i1, ad4, (l5 - 1) + j2, ad4, (j15 - 1) + j2, j, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (i20 - 1) + j2, ai, l2, intw);
                    Dormbr.dormbr("Q", "L", "N", j, j, j, ad, k, l, ad4, (j13 - 1) + j2, ad4, (j15 - 1) + j2, l17, ad4, (i20 - 1) + j2, (k2 - i20) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", j, j, j, ad, k, l, ad4, (l10 - 1) + j2, ad3, l1, i2, ad4, (i20 - 1) + j2, (k2 - i20) + 1, intw1);
                    Dgemm.dgemm("N", "N", i, j, j, 1.0, ad2, j1, k1, ad4, (j15 - 1) + j2, l17, 0.0, ad, k, l);
                    Dlacpy.dlacpy("F", i, j, ad, k, l, ad2, j1, k1);
                }
            } else
            {
                int i6 = 1;
                int k13 = i6 + j;
                int i11 = k13 + j;
                int j20 = i11 + j;
                Dgebrd.dgebrd(i, j, ad, k, l, ad1, i1, ad4, (i6 - 1) + j2, ad4, (k13 - 1) + j2, ad4, (i11 - 1) + j2, ad4, (j20 - 1) + j2, (k2 - j20) + 1, intw1);
                if(flag3)
                    Dbdsdc.dbdsdc("U", "N", j, ad1, i1, ad4, (i6 - 1) + j2, ad5, 0, 1, ad5, 0, 1, ad5, 0, ai1, 0, ad4, (j20 - 1) + j2, ai, l2, intw);
                else
                if(flag4)
                {
                    int k15 = j20;
                    int i18;
                    if(k2 >= i * j + 3 * j + i3)
                    {
                        i18 = i;
                        j20 = k15 + i18 * j;
                        Dlaset.dlaset("F", i, j, 0.0, 0.0, ad4, (k15 - 1) + j2, i18);
                    } else
                    {
                        i18 = j;
                        j20 = k15 + i18 * j;
                        l7 = j20;
                        k17 = (k2 - j * j - 3 * j) / j;
                    }
                    j20 = k15 + i18 * j;
                    Dbdsdc.dbdsdc("U", "I", j, ad1, i1, ad4, (i6 - 1) + j2, ad4, (k15 - 1) + j2, i18, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (j20 - 1) + j2, ai, l2, intw);
                    Dormbr.dormbr("P", "R", "T", j, j, j, ad, k, l, ad4, (i11 - 1) + j2, ad3, l1, i2, ad4, (j20 - 1) + j2, (k2 - j20) + 1, intw1);
                    if(k2 >= i * j + 3 * j + i3)
                    {
                        Dormbr.dormbr("Q", "L", "N", i, j, j, ad, k, l, ad4, (k13 - 1) + j2, ad4, (k15 - 1) + j2, i18, ad4, (j20 - 1) + j2, (k2 - j20) + 1, intw1);
                        Dlacpy.dlacpy("F", i, j, ad4, (k15 - 1) + j2, i18, ad, k, l);
                    } else
                    {
                        Dorgbr.dorgbr("Q", i, j, j, ad, k, l, ad4, (k13 - 1) + j2, ad4, (j20 - 1) + j2, (k2 - j20) + 1, intw1);
                        int j4 = 1;
                        for(int k24 = ((i - 1) + k17) / k17; k24 > 0; k24--)
                        {
                            l3 = Math.min((i - j4) + 1, k17);
                            Dgemm.dgemm("N", "N", l3, j, j, 1.0, ad, (j4 - 1) + k, l, ad4, (k15 - 1) + j2, i18, 0.0, ad4, (l7 - 1) + j2, k17);
                            Dlacpy.dlacpy("F", l3, j, ad4, (l7 - 1) + j2, k17, ad, (j4 - 1) + k, l);
                            j4 += k17;
                        }

                    }
                } else
                if(flag5)
                {
                    Dlaset.dlaset("F", i, j, 0.0, 0.0, ad2, j1, k1);
                    Dbdsdc.dbdsdc("U", "I", j, ad1, i1, ad4, (i6 - 1) + j2, ad2, j1, k1, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (j20 - 1) + j2, ai, l2, intw);
                    Dormbr.dormbr("Q", "L", "N", i, j, j, ad, k, l, ad4, (k13 - 1) + j2, ad2, j1, k1, ad4, (j20 - 1) + j2, (k2 - j20) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", j, j, j, ad, k, l, ad4, (i11 - 1) + j2, ad3, l1, i2, ad4, (j20 - 1) + j2, (k2 - j20) + 1, intw1);
                } else
                if(flag1)
                {
                    Dlaset.dlaset("F", i, i, 0.0, 0.0, ad2, j1, k1);
                    Dbdsdc.dbdsdc("U", "I", j, ad1, i1, ad4, (i6 - 1) + j2, ad2, j1, k1, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (j20 - 1) + j2, ai, l2, intw);
                    if(i > j)
                        Dlaset.dlaset("F", i - j, i - j, 0.0, 1.0, ad2, ((j + 1) - 1) + ((j + 1) - 1) * k1 + j1, k1);
                    Dormbr.dormbr("Q", "L", "N", i, i, j, ad, k, l, ad4, (k13 - 1) + j2, ad2, j1, k1, ad4, (j20 - 1) + j2, (k2 - j20) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", j, j, i, ad, k, l, ad4, (i11 - 1) + j2, ad3, l1, i2, ad4, (j20 - 1) + j2, (k2 - j20) + 1, intw1);
                }
            }
        } else
        if(j >= i19)
        {
            if(flag3)
            {
                int i9 = 1;
                int k20 = i9 + i;
                Dgelqf.dgelqf(i, j, ad, k, l, ad4, (i9 - 1) + j2, ad4, (k20 - 1) + j2, (k2 - k20) + 1, intw1);
                Dlaset.dlaset("U", i - 1, i - 1, 0.0, 0.0, ad, l + k, l);
                int j6 = 1;
                int l13 = j6 + i;
                int j11 = l13 + i;
                k20 = j11 + i;
                Dgebrd.dgebrd(i, i, ad, k, l, ad1, i1, ad4, (j6 - 1) + j2, ad4, (l13 - 1) + j2, ad4, (j11 - 1) + j2, ad4, (k20 - 1) + j2, (k2 - k20) + 1, intw1);
                k20 = j6 + i;
                Dbdsdc.dbdsdc("U", "N", i, ad1, i1, ad4, (j6 - 1) + j2, ad5, 0, 1, ad5, 0, 1, ad5, 0, ai1, 0, ad4, (k20 - 1) + j2, ai, l2, intw);
            } else
            if(flag4)
            {
                int l15 = 1;
                k7 = l15 + i * i;
                int i17;
                if(k2 >= i * j + i * i + 3 * i + i3)
                {
                    i17 = i;
                    l3 = j;
                } else
                {
                    i17 = i;
                    l3 = (k2 - i * i) / i;
                }
                int j9 = k7 + i17 * i;
                int l20 = j9 + i;
                Dgelqf.dgelqf(i, j, ad, k, l, ad4, (j9 - 1) + j2, ad4, (l20 - 1) + j2, (k2 - l20) + 1, intw1);
                Dlacpy.dlacpy("L", i, i, ad, k, l, ad4, (k7 - 1) + j2, i17);
                Dlaset.dlaset("U", i - 1, i - 1, 0.0, 0.0, ad4, ((k7 + i17) - 1) + j2, i17);
                Dorglq.dorglq(i, j, i, ad, k, l, ad4, (j9 - 1) + j2, ad4, (l20 - 1) + j2, (k2 - l20) + 1, intw1);
                int k6 = j9;
                int i14 = k6 + i;
                int k11 = i14 + i;
                l20 = k11 + i;
                Dgebrd.dgebrd(i, i, ad4, (k7 - 1) + j2, i17, ad1, i1, ad4, (k6 - 1) + j2, ad4, (i14 - 1) + j2, ad4, (k11 - 1) + j2, ad4, (l20 - 1) + j2, (k2 - l20) + 1, intw1);
                Dbdsdc.dbdsdc("U", "I", i, ad1, i1, ad4, (k6 - 1) + j2, ad2, j1, k1, ad4, (l15 - 1) + j2, i, ad5, 0, ai1, 0, ad4, (l20 - 1) + j2, ai, l2, intw);
                Dormbr.dormbr("Q", "L", "N", i, i, i, ad4, (k7 - 1) + j2, i17, ad4, (i14 - 1) + j2, ad2, j1, k1, ad4, (l20 - 1) + j2, (k2 - l20) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", i, i, i, ad4, (k7 - 1) + j2, i17, ad4, (k11 - 1) + j2, ad4, (l15 - 1) + j2, i, ad4, (l20 - 1) + j2, (k2 - l20) + 1, intw1);
                int k4 = 1;
                for(int l24 = ((j - 1) + l3) / l3; l24 > 0; l24--)
                {
                    int j3 = Math.min((j - k4) + 1, l3);
                    Dgemm.dgemm("N", "N", i, j3, i, 1.0, ad4, (l15 - 1) + j2, i, ad, (k4 - 1) * l + k, l, 0.0, ad4, (k7 - 1) + j2, i17);
                    Dlacpy.dlacpy("F", i, j3, ad4, (k7 - 1) + j2, i17, ad, (k4 - 1) * l + k, l);
                    k4 += l3;
                }

            } else
            if(flag5)
            {
                k7 = 1;
                int j17 = i;
                int k9 = k7 + j17 * i;
                int i21 = k9 + i;
                Dgelqf.dgelqf(i, j, ad, k, l, ad4, (k9 - 1) + j2, ad4, (i21 - 1) + j2, (k2 - i21) + 1, intw1);
                Dlacpy.dlacpy("L", i, i, ad, k, l, ad4, (k7 - 1) + j2, j17);
                Dlaset.dlaset("U", i - 1, i - 1, 0.0, 0.0, ad4, ((k7 + j17) - 1) + j2, j17);
                Dorglq.dorglq(i, j, i, ad, k, l, ad4, (k9 - 1) + j2, ad4, (i21 - 1) + j2, (k2 - i21) + 1, intw1);
                int l6 = k9;
                int j14 = l6 + i;
                int l11 = j14 + i;
                i21 = l11 + i;
                Dgebrd.dgebrd(i, i, ad4, (k7 - 1) + j2, j17, ad1, i1, ad4, (l6 - 1) + j2, ad4, (j14 - 1) + j2, ad4, (l11 - 1) + j2, ad4, (i21 - 1) + j2, (k2 - i21) + 1, intw1);
                Dbdsdc.dbdsdc("U", "I", i, ad1, i1, ad4, (l6 - 1) + j2, ad2, j1, k1, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (i21 - 1) + j2, ai, l2, intw);
                Dormbr.dormbr("Q", "L", "N", i, i, i, ad4, (k7 - 1) + j2, j17, ad4, (j14 - 1) + j2, ad2, j1, k1, ad4, (i21 - 1) + j2, (k2 - i21) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", i, i, i, ad4, (k7 - 1) + j2, j17, ad4, (l11 - 1) + j2, ad3, l1, i2, ad4, (i21 - 1) + j2, (k2 - i21) + 1, intw1);
                Dlacpy.dlacpy("F", i, i, ad3, l1, i2, ad4, (k7 - 1) + j2, j17);
                Dgemm.dgemm("N", "N", i, j, i, 1.0, ad4, (k7 - 1) + j2, j17, ad, k, l, 0.0, ad3, l1, i2);
            } else
            if(flag1)
            {
                int i16 = 1;
                int k16 = i;
                int l9 = i16 + k16 * i;
                int j21 = l9 + i;
                Dgelqf.dgelqf(i, j, ad, k, l, ad4, (l9 - 1) + j2, ad4, (j21 - 1) + j2, (k2 - j21) + 1, intw1);
                Dlacpy.dlacpy("U", i, j, ad, k, l, ad3, l1, i2);
                Dorglq.dorglq(j, j, i, ad3, l1, i2, ad4, (l9 - 1) + j2, ad4, (j21 - 1) + j2, (k2 - j21) + 1, intw1);
                Dlaset.dlaset("U", i - 1, i - 1, 0.0, 0.0, ad, l + k, l);
                int i7 = l9;
                int k14 = i7 + i;
                int i12 = k14 + i;
                j21 = i12 + i;
                Dgebrd.dgebrd(i, i, ad, k, l, ad1, i1, ad4, (i7 - 1) + j2, ad4, (k14 - 1) + j2, ad4, (i12 - 1) + j2, ad4, (j21 - 1) + j2, (k2 - j21) + 1, intw1);
                Dbdsdc.dbdsdc("U", "I", i, ad1, i1, ad4, (i7 - 1) + j2, ad2, j1, k1, ad4, (i16 - 1) + j2, k16, ad5, 0, ai1, 0, ad4, (j21 - 1) + j2, ai, l2, intw);
                Dormbr.dormbr("Q", "L", "N", i, i, i, ad, k, l, ad4, (k14 - 1) + j2, ad2, j1, k1, ad4, (j21 - 1) + j2, (k2 - j21) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", i, i, i, ad, k, l, ad4, (i12 - 1) + j2, ad4, (i16 - 1) + j2, k16, ad4, (j21 - 1) + j2, (k2 - j21) + 1, intw1);
                Dgemm.dgemm("N", "N", i, j, i, 1.0, ad4, (i16 - 1) + j2, k16, ad3, l1, i2, 0.0, ad, k, l);
                Dlacpy.dlacpy("F", i, j, ad, k, l, ad3, l1, i2);
            }
        } else
        {
            int j7 = 1;
            int l14 = j7 + i;
            int j12 = l14 + i;
            int k21 = j12 + i;
            Dgebrd.dgebrd(i, j, ad, k, l, ad1, i1, ad4, (j7 - 1) + j2, ad4, (l14 - 1) + j2, ad4, (j12 - 1) + j2, ad4, (k21 - 1) + j2, (k2 - k21) + 1, intw1);
            if(flag3)
                Dbdsdc.dbdsdc("L", "N", i, ad1, i1, ad4, (j7 - 1) + j2, ad5, 0, 1, ad5, 0, 1, ad5, 0, ai1, 0, ad4, (k21 - 1) + j2, ai, l2, intw);
            else
            if(flag4)
            {
                int l16 = i;
                int j16 = k21;
                if(k2 >= i * j + 3 * i + i3)
                {
                    Dlaset.dlaset("F", i, j, 0.0, 0.0, ad4, (j16 - 1) + j2, l16);
                    k21 = j16 + l16 * j;
                } else
                {
                    k21 = j16 + l16 * i;
                    k7 = k21;
                    l3 = (k2 - i * i - 3 * i) / i;
                }
                Dbdsdc.dbdsdc("L", "I", i, ad1, i1, ad4, (j7 - 1) + j2, ad2, j1, k1, ad4, (j16 - 1) + j2, l16, ad5, 0, ai1, 0, ad4, (k21 - 1) + j2, ai, l2, intw);
                Dormbr.dormbr("Q", "L", "N", i, i, j, ad, k, l, ad4, (l14 - 1) + j2, ad2, j1, k1, ad4, (k21 - 1) + j2, (k2 - k21) + 1, intw1);
                if(k2 >= i * j + 3 * i + i3)
                {
                    Dormbr.dormbr("P", "R", "T", i, j, i, ad, k, l, ad4, (j12 - 1) + j2, ad4, (j16 - 1) + j2, l16, ad4, (k21 - 1) + j2, (k2 - k21) + 1, intw1);
                    Dlacpy.dlacpy("F", i, j, ad4, (j16 - 1) + j2, l16, ad, k, l);
                } else
                {
                    Dorgbr.dorgbr("P", i, j, i, ad, k, l, ad4, (j12 - 1) + j2, ad4, (k21 - 1) + j2, (k2 - k21) + 1, intw1);
                    int l4 = 1;
                    for(int i25 = ((j - 1) + l3) / l3; i25 > 0; i25--)
                    {
                        int k3 = Math.min((j - l4) + 1, l3);
                        Dgemm.dgemm("N", "N", i, k3, i, 1.0, ad4, (j16 - 1) + j2, l16, ad, (l4 - 1) * l + k, l, 0.0, ad4, (k7 - 1) + j2, i);
                        Dlacpy.dlacpy("F", i, k3, ad4, (k7 - 1) + j2, i, ad, (l4 - 1) * l + k, l);
                        l4 += l3;
                    }

                }
            } else
            if(flag5)
            {
                Dlaset.dlaset("F", i, j, 0.0, 0.0, ad3, l1, i2);
                Dbdsdc.dbdsdc("L", "I", i, ad1, i1, ad4, (j7 - 1) + j2, ad2, j1, k1, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (k21 - 1) + j2, ai, l2, intw);
                Dormbr.dormbr("Q", "L", "N", i, i, j, ad, k, l, ad4, (l14 - 1) + j2, ad2, j1, k1, ad4, (k21 - 1) + j2, (k2 - k21) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", i, j, i, ad, k, l, ad4, (j12 - 1) + j2, ad3, l1, i2, ad4, (k21 - 1) + j2, (k2 - k21) + 1, intw1);
            } else
            if(flag1)
            {
                Dlaset.dlaset("F", j, j, 0.0, 0.0, ad3, l1, i2);
                Dbdsdc.dbdsdc("L", "I", i, ad1, i1, ad4, (j7 - 1) + j2, ad2, j1, k1, ad3, l1, i2, ad5, 0, ai1, 0, ad4, (k21 - 1) + j2, ai, l2, intw);
                if(j > i)
                    Dlaset.dlaset("F", j - i, j - i, 0.0, 1.0, ad3, i + i * i2 + l1, i2);
                Dormbr.dormbr("Q", "L", "N", i, i, j, ad, k, l, ad4, (l14 - 1) + j2, ad2, j1, k1, ad4, (k21 - 1) + j2, (k2 - k21) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", j, j, i, ad, k, l, ad4, (j12 - 1) + j2, ad3, l1, i2, ad4, (k21 - 1) + j2, (k2 - k21) + 1, intw1);
            }
        }
        if(flag9)
        {
            if(d > d1)
                Dlascl.dlascl("G", 0, 0, d1, d, k18, 1, ad1, i1, k18, intw1);
            if(d < d3)
                Dlascl.dlascl("G", 0, 0, d3, d, k18, 1, ad1, i1, k18, intw1);
        }
        ad4[j2] = j18;
    }
}
