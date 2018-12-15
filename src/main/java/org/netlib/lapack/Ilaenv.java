package org.netlib.lapack;

import org.netlib.util.Util;

public final class Ilaenv {

	public static int ilaenv(int i, String s, String s1, int j, int k, int l, int i1) {
		int i2 = i;
		int j1;
		char c;
		char c1;
		byte byte0;
		byte byte1;
		char c2;
		boolean flag7;
		boolean flag9;
		String s3;
		String s5;
		String s7;
		String s9;
		String s11;
		int k1;

		label0: {
			label1: {
				label2: {
					if (i2 != 1 && i2 != 2 && i2 != 3) {

						if (i2 != 4) {
							if (i2 != 5) {
								if (i2 != 6) {
									if (i2 != 7) {
										if (i2 != 8) {
											if (i2 != 9) {
												if (i2 != 10) {
													if (i2 != 11)
														if (i2 != 12 && i2 != 13 && i2 != 14 && i2 != 15 && i2 != 16) {
															byte byte2 = -1;
															return byte2;
														} else {
															int l1 = Iparmq.iparmq(i, s, s1, j, k, l, i1);
															return l1;
														}
												} else {
													return 1;
												}
											} else {
												k1 = 25;
												return k1;
											}
										} else {
											k1 = 50;
											return k1;
										}
									} else {
										k1 = 1;
										return k1;
									}
								} else {
									k1 = (int) ((float) Math.min(j, k) * 1.6F);
									return k1;
								}
							} else {
								k1 = 2;
								return k1;
							}
						} else {
							k1 = 6;
							return k1;
						}
						break label0;
					}
					k1 = 1;
					s11 = s;
					c = s11.substring(1 + -1, 1).charAt(0);
					c1 = 'Z';
					if ((c1 == 'Z') || (c1 == 'z')) {
						if ((c >= 'a') && (c <= 'z')) {
							s11 = Util.stringInsert(s11, Character.valueOf((char) (c - 32)).toString(), 1, 1);
							j1 = 2;
							for (i2 = (6 - 2) + 1; i2 > 0; i2--) {
								c = s11.substring(j1 + -1, j1).charAt(0);
								if ((c >= 'a') && (c <= 'z'))
									s11 = Util.stringInsert(s11, Character.valueOf((char) (c - 32)).toString(), j1, j1);
								j1++;
							}

						}
					} else if ((c1 == '\351') || (c1 == '\251')) {
						if ((((c >= '\201') && (c <= '\211')) || ((c >= '\221') && (c <= '\231')))
								|| ((c >= '\242') && (c <= '\251'))) {
							s11 = Util.stringInsert(s11, Character.valueOf((char) (c + 64)).toString(), 1, 1);
							j1 = 2;
							for (i2 = (6 - 2) + 1; i2 > 0; i2--) {
								c = s11.substring(j1 + -1, j1).charAt(0);
								if ((((c >= '\201') && (c <= '\211')) || ((c >= '\221') && (c <= '\231')))
										|| ((c >= '\242') && (c <= '\251')))
									s11 = Util.stringInsert(s11, Character.valueOf((char) (c + 64)).toString(), j1, j1);
								j1++;
							}

						}
					} else if (((c1 == '\332') || (c1 == '\372')) && ((c >= '\341') && (c <= '\372'))) {
						s11 = Util.stringInsert(s11, Character.valueOf((char) (c - 32)).toString(), 1, 1);
						j1 = 2;
						for (i2 = (6 - 2) + 1; i2 > 0; i2--) {
							c = s11.substring(j1 + -1, j1).charAt(0);
							if ((c >= '\341') && (c <= '\372'))
								s11 = Util.stringInsert(s11, Character.valueOf((char) (c - 32)).toString(), j1, j1);
							j1++;
						}

					}
					s3 = s11.substring(1 + -1, 1);
					flag9 = s3.regionMatches(0, "S", 0, 1) || s3.regionMatches(0, "D", 0, 1);
					flag7 = s3.regionMatches(0, "C", 0, 1) || s3.regionMatches(0, "Z", 0, 1);
					if ((flag7 || flag9) ^ true)
						return k1;
					s5 = s11.substring(2 + -1, 3);
					s9 = s11.substring(4 + -1, 6);
					s7 = s9.substring(2 + -1, 3);
					i2 = i;
					if (i2 != 1) {
						if (i2 == 2)
							break label2;
						if (i2 == 3)
							break label1;
					}
					byte0 = 1;
					if (s5.regionMatches(0, "GE", 0, 2)) {
						if (s9.regionMatches(0, "TRF", 0, 3)) {
							if (flag9)
								byte0 = 64;
							else
								byte0 = 64;
						} else if (((s9.regionMatches(0, "QRF", 0, 3) || s9.regionMatches(0, "RQF", 0, 3))
								|| s9.regionMatches(0, "LQF", 0, 3)) || s9.regionMatches(0, "QLF", 0, 3)) {
							if (flag9)
								byte0 = 32;
							else
								byte0 = 32;
						} else if (s9.regionMatches(0, "HRD", 0, 3)) {
							if (flag9)
								byte0 = 32;
							else
								byte0 = 32;
						} else if (s9.regionMatches(0, "BRD", 0, 3)) {
							if (flag9)
								byte0 = 32;
							else
								byte0 = 32;
						} else if (s9.regionMatches(0, "TRI", 0, 3))
							if (flag9)
								byte0 = 64;
							else
								byte0 = 64;
					} else if (s5.regionMatches(0, "PO", 0, 2)) {
						if (s9.regionMatches(0, "TRF", 0, 3))
							if (flag9)
								byte0 = 64;
							else
								byte0 = 64;
					} else if (s5.regionMatches(0, "SY", 0, 2)) {
						if (s9.regionMatches(0, "TRF", 0, 3)) {
							if (flag9)
								byte0 = 64;
							else
								byte0 = 64;
						} else if (flag9 && s9.regionMatches(0, "TRD", 0, 3))
							byte0 = 32;
						else if (flag9 && s9.regionMatches(0, "GST", 0, 3))
							byte0 = 64;
					} else if (flag7 && s5.regionMatches(0, "HE", 0, 2)) {
						if (s9.regionMatches(0, "TRF", 0, 3))
							byte0 = 64;
						else if (s9.regionMatches(0, "TRD", 0, 3))
							byte0 = 32;
						else if (s9.regionMatches(0, "GST", 0, 3))
							byte0 = 64;
					} else if (flag9 && s5.regionMatches(0, "OR", 0, 2)) {
						if (s9.substring(1 + -1, 1).regionMatches(0, "G", 0, 1)) {
							if ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
									|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
									|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
									|| s7.regionMatches(0, "BR", 0, 2))
								byte0 = 32;
						} else if (s9.substring(1 + -1, 1).regionMatches(0, "M", 0, 1)
								&& ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
										|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
										|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
										|| s7.regionMatches(0, "BR", 0, 2)))
							byte0 = 32;
					} else if (flag7 && s5.regionMatches(0, "UN", 0, 2)) {
						if (s9.substring(1 + -1, 1).regionMatches(0, "G", 0, 1)) {
							if ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
									|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
									|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
									|| s7.regionMatches(0, "BR", 0, 2))
								byte0 = 32;
						} else if (s9.substring(1 + -1, 1).regionMatches(0, "M", 0, 1)
								&& ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
										|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
										|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
										|| s7.regionMatches(0, "BR", 0, 2)))
							byte0 = 32;
					} else if (s5.regionMatches(0, "GB", 0, 2)) {
						if (s9.regionMatches(0, "TRF", 0, 3))
							if (flag9) {
								if (i1 <= 64)
									byte0 = 1;
								else
									byte0 = 32;
							} else if (i1 <= 64)
								byte0 = 1;
							else
								byte0 = 32;
					} else if (s5.regionMatches(0, "PB", 0, 2)) {
						if (s9.regionMatches(0, "TRF", 0, 3))
							if (flag9) {
								if (k <= 64)
									byte0 = 1;
								else
									byte0 = 32;
							} else if (k <= 64)
								byte0 = 1;
							else
								byte0 = 32;
					} else if (s5.regionMatches(0, "TR", 0, 2)) {
						if (s9.regionMatches(0, "TRI", 0, 3))
							if (flag9)
								byte0 = 64;
							else
								byte0 = 64;
					} else if (s5.regionMatches(0, "LA", 0, 2)) {
						if (s9.regionMatches(0, "UUM", 0, 3))
							if (flag9)
								byte0 = 64;
							else
								byte0 = 64;
					} else if ((flag9 && s5.regionMatches(0, "ST", 0, 2)) && s9.regionMatches(0, "EBZ", 0, 3))
						byte0 = 1;
					k1 = byte0;
					return k1;
				}
				byte1 = 2;
				if (s5.regionMatches(0, "GE", 0, 2)) {
					if (((s9.regionMatches(0, "QRF", 0, 3) || s9.regionMatches(0, "RQF", 0, 3))
							|| s9.regionMatches(0, "LQF", 0, 3)) || s9.regionMatches(0, "QLF", 0, 3)) {
						if (flag9)
							byte1 = 2;
						else
							byte1 = 2;
					} else if (s9.regionMatches(0, "HRD", 0, 3)) {
						if (flag9)
							byte1 = 2;
						else
							byte1 = 2;
					} else if (s9.regionMatches(0, "BRD", 0, 3)) {
						if (flag9)
							byte1 = 2;
						else
							byte1 = 2;
					} else if (s9.regionMatches(0, "TRI", 0, 3))
						if (flag9)
							byte1 = 2;
						else
							byte1 = 2;
				} else if (s5.regionMatches(0, "SY", 0, 2)) {
					if (s9.regionMatches(0, "TRF", 0, 3)) {
						if (flag9)
							byte1 = 8;
						else
							byte1 = 8;
					} else if (flag9 && s9.regionMatches(0, "TRD", 0, 3))
						byte1 = 2;
				} else if (flag7 && s5.regionMatches(0, "HE", 0, 2)) {
					if (s9.regionMatches(0, "TRD", 0, 3))
						byte1 = 2;
				} else if (flag9 && s5.regionMatches(0, "OR", 0, 2)) {
					if (s9.substring(1 + -1, 1).regionMatches(0, "G", 0, 1)) {
						if ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
								|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
								|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
								|| s7.regionMatches(0, "BR", 0, 2))
							byte1 = 2;
					} else if (s9.substring(1 + -1, 1).regionMatches(0, "M", 0, 1)
							&& ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
									|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
									|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
									|| s7.regionMatches(0, "BR", 0, 2)))
						byte1 = 2;
				} else if (flag7 && s5.regionMatches(0, "UN", 0, 2))
					if (s9.substring(1 + -1, 1).regionMatches(0, "G", 0, 1)) {
						if ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
								|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
								|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
								|| s7.regionMatches(0, "BR", 0, 2))
							byte1 = 2;
					} else if (s9.substring(1 + -1, 1).regionMatches(0, "M", 0, 1)
							&& ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
									|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
									|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
									|| s7.regionMatches(0, "BR", 0, 2)))
						byte1 = 2;
				k1 = byte1;
				return k1;
			}
			c2 = '\0';
			if (s5.regionMatches(0, "GE", 0, 2)) {
				if (((s9.regionMatches(0, "QRF", 0, 3) || s9.regionMatches(0, "RQF", 0, 3))
						|| s9.regionMatches(0, "LQF", 0, 3)) || s9.regionMatches(0, "QLF", 0, 3)) {
					if (flag9)
						c2 = '\200';
					else
						c2 = '\200';
				} else if (s9.regionMatches(0, "HRD", 0, 3)) {
					if (flag9)
						c2 = '\200';
					else
						c2 = '\200';
				} else if (s9.regionMatches(0, "BRD", 0, 3))
					if (flag9)
						c2 = '\200';
					else
						c2 = '\200';
			} else if (s5.regionMatches(0, "SY", 0, 2)) {
				if (flag9 && s9.regionMatches(0, "TRD", 0, 3))
					c2 = ' ';
			} else if (flag7 && s5.regionMatches(0, "HE", 0, 2)) {
				if (s9.regionMatches(0, "TRD", 0, 3))
					c2 = ' ';
			} else if (flag9 && s5.regionMatches(0, "OR", 0, 2)) {
				if (s9.substring(1 + -1, 1).regionMatches(0, "G", 0, 1)
						&& ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
								|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
								|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
								|| s7.regionMatches(0, "BR", 0, 2)))
					c2 = '\200';
			} else if ((flag7 && s5.regionMatches(0, "UN", 0, 2)) && s9.substring(1 + -1, 1).regionMatches(0, "G", 0, 1)
					&& ((((((s7.regionMatches(0, "QR", 0, 2) || s7.regionMatches(0, "RQ", 0, 2))
							|| s7.regionMatches(0, "LQ", 0, 2)) || s7.regionMatches(0, "QL", 0, 2))
							|| s7.regionMatches(0, "HR", 0, 2)) || s7.regionMatches(0, "TR", 0, 2))
							|| s7.regionMatches(0, "BR", 0, 2)))
				c2 = '\200';
			k1 = c2;
			return k1;
		}
		return 1;
	}
}