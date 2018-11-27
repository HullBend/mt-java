package org.netlib.lapack;

import org.netlib.blas.Drot;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.Util;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dhgeqz {
	public static void dhgeqz(String s, String s1, String s2, int i, int j,
			int k, double ad[], int l, int i1, double ad1[], int j1, int k1,
			double ad2[], int l1, double ad3[], int i2, double ad4[], int j2,
			double ad5[], int k2, int l2, double ad6[], int i3, int j3,
			double ad7[], int k3, int l3, intW intw) {
		label0: {
			boolean flag7;
			boolean flag8;
			label1: {
				boolean flag6 = false;
				flag7 = false;
				flag8 = false;
				boolean flag9 = false;
				byte byte0 = 0;
				byte byte1 = 0;
				int j4 = 0;
				int k4 = 0;
				int l4 = 0;
				int i5 = 0;
				int j5 = 0;
				byte byte2 = 0;
				int i6 = 0;
				int j13 = 0;
				double d36 = 0.0D;
				double d37 = 0.0D;
				double d38 = 0.0D;
				doubleW doublew = new doubleW(0.0D);
				doubleW doublew1 = new doubleW(0.0D);
				double d53 = 0.0D;
				double d54 = 0.0D;
				double d55 = 0.0D;
				doubleW doublew2 = new doubleW(0.0D);
				doubleW doublew3 = new doubleW(0.0D);
				doubleW doublew4 = new doubleW(0.0D);
				double d72 = 0.0D;
				doubleW doublew5 = new doubleW(0.0D);
				doubleW doublew6 = new doubleW(0.0D);
				doubleW doublew7 = new doubleW(0.0D);
				double d75 = 0.0D;
				double d76 = 0.0D;
				doubleW doublew8 = new doubleW(0.0D);
				doubleW doublew9 = new doubleW(0.0D);
				doubleW doublew10 = new doubleW(0.0D);
				doubleW doublew11 = new doubleW(0.0D);
				doubleW doublew12 = new doubleW(0.0D);
				doubleW doublew13 = new doubleW(0.0D);
				double d105 = 0.0D;
				doubleW doublew14 = new doubleW(0.0D);
				doubleW doublew15 = new doubleW(0.0D);
				doubleW doublew16 = new doubleW(0.0D);
				double ad8[] = new double[3];
				if (Lsame.lsame(s, "E")) {
					flag7 = false;
					byte2 = 1;
				} else if (Lsame.lsame(s, "S")) {
					flag7 = true;
					byte2 = 2;
				} else {
					byte2 = 0;
				}
				if (Lsame.lsame(s1, "N")) {
					flag6 = false;
					byte0 = 1;
				} else if (Lsame.lsame(s1, "V")) {
					flag6 = true;
					byte0 = 2;
				} else if (Lsame.lsame(s1, "I")) {
					flag6 = true;
					byte0 = 3;
				} else {
					byte0 = 0;
				}
				if (Lsame.lsame(s2, "N")) {
					flag8 = false;
					byte1 = 1;
				} else if (Lsame.lsame(s2, "V")) {
					flag8 = true;
					byte1 = 2;
				} else if (Lsame.lsame(s2, "I")) {
					flag8 = true;
					byte1 = 3;
				} else {
					byte1 = 0;
				}
				intw.val = 0;
				ad7[(1 - 1) + k3] = Math.max(1, i);
				flag9 = l3 == -1;
				if (byte2 == 0)
					intw.val = -1;
				else if (byte0 == 0)
					intw.val = -2;
				else if (byte1 == 0)
					intw.val = -3;
				else if (i < 0)
					intw.val = -4;
				else if (j < 1)
					intw.val = -5;
				else if ((k > i) || (k < j - 1))
					intw.val = -6;
				else if (i1 < i)
					intw.val = -8;
				else if (k1 < i)
					intw.val = -10;
				else if ((l2 < 1) || (flag6 && (l2 < i)))
					intw.val = -15;
				else if ((j3 < 1) || (flag8 && (j3 < i)))
					intw.val = -17;
				else if ((l3 < Math.max(1, i)) && flag9 ^ true)
					intw.val = -19;
				if (intw.val != 0) {
					Xerbla.xerbla("DHGEQZ", -intw.val);
					return;
				}
				if (flag9)
					return;
				if (i <= 0) {
					ad7[(1 - 1) + k3] = 1;
					return;
				}
				if (byte0 == 3)
					Dlaset.dlaset("Full", i, i, 0.0D, 1.0D, ad5, k2, l2);
				if (byte1 == 3)
					Dlaset.dlaset("Full", i, i, 0.0D, 1.0D, ad6, i3, j3);
				j5 = (k + 1) - j;
				d76 = Dlamch.dlamch("S");
				d75 = 1.0D / d76;
				d105 = Dlamch.dlamch("E") * Dlamch.dlamch("B");
				d36 = Dlanhs.dlanhs("F", j5, ad, (j - 1) + (j - 1) * i1 + l,
						i1, ad7, k3);
				d53 = Dlanhs.dlanhs("F", j5, ad1, (j - 1) + (j - 1) * k1 + j1,
						k1, ad7, k3);
				d38 = Math.max(d76, d105 * d36);
				d55 = Math.max(d76, d105 * d53);
				d37 = 1.0D / Math.max(d76, d36);
				d54 = 1.0D / Math.max(d76, d53);
				i6 = k + 1;
				for (int k13 = (i - (k + 1)) + 1; k13 > 0; k13--) {
					if (ad1[(i6 - 1) + (i6 - 1) * k1 + j1] < 0.0D) {
						if (flag7) {
							int i10 = 1;
							for (int j14 = (i6 - 1) + 1; j14 > 0; j14--) {
								ad[(i10 - 1) + (i6 - 1) * i1 + l] = -ad[(i10 - 1)
										+ (i6 - 1) * i1 + l];
								ad1[(i10 - 1) + (i6 - 1) * k1 + j1] = -ad1[(i10 - 1)
										+ (i6 - 1) * k1 + j1];
								i10++;
							}

						} else {
							ad[(i6 - 1) + (i6 - 1) * i1 + l] = -ad[(i6 - 1)
									+ (i6 - 1) * i1 + l];
							ad1[(i6 - 1) + (i6 - 1) * k1 + j1] = -ad1[(i6 - 1)
									+ (i6 - 1) * k1 + j1];
						}
						if (flag8) {
							int j10 = 1;
							for (int k14 = (i - 1) + 1; k14 > 0; k14--) {
								ad6[(j10 - 1) + (i6 - 1) * j3 + i3] = -ad6[(j10 - 1)
										+ (i6 - 1) * j3 + i3];
								j10++;
							}

						}
					}
					ad2[(i6 - 1) + l1] = ad[(i6 - 1) + (i6 - 1) * i1 + l];
					ad3[(i6 - 1) + i2] = 0.0D;
					ad4[(i6 - 1) + j2] = ad1[(i6 - 1) + (i6 - 1) * k1 + j1];
					i6++;
				}

				if (k < j)
					break label1;
				l4 = k;
				if (flag7) {
					j4 = 1;
					i5 = i;
				} else {
					j4 = j;
					i5 = k;
				}
				k4 = 0;
				d72 = 0.0D;
				j13 = 30 * ((k - j) + 1);
				for (int l13 = (j13 - 1) + 1; l13 > 0; l13--) {
					label2: {
						int i4;
						label3: {
							label4: {
								label5: {
									if (l4 == j)
										break label4;
									if (Math.abs(ad[(l4 - 1) + (l4 - 1 - 1)
											* i1 + l]) <= d38) {
										ad[(l4 - 1) + (l4 - 1 - 1) * i1 + l] = 0.0D;
										break label4;
									}
									if (Math.abs(ad1[(l4 - 1) + (l4 - 1) * k1
											+ j1]) <= d55) {
										ad1[(l4 - 1) + (l4 - 1) * k1 + j1] = 0.0D;
										break label5;
									}
									int j6 = l4 - 1;
									for (int l14 = ((j - (l4 - 1)) + -1) / -1; l14 > 0; l14--) {
										boolean flag3;
										if (j6 == j)
											flag3 = true;
										else if (Math.abs(ad[(j6 - 1)
												+ (j6 - 1 - 1) * i1 + l]) <= d38) {
											ad[(j6 - 1) + (j6 - 1 - 1) * i1 + l] = 0.0D;
											flag3 = true;
										} else {
											flag3 = false;
										}
										if (Math.abs(ad1[(j6 - 1) + (j6 - 1)
												* k1 + j1]) < d55) {
											ad1[(j6 - 1) + (j6 - 1) * k1 + j1] = 0.0D;
											boolean flag1 = false;
											if (flag3 ^ true) {
												doublew11.val = Math
														.abs(ad[(j6 - 1)
																+ (j6 - 1 - 1)
																* i1 + l]);
												doublew12.val = Math
														.abs(ad[(j6 - 1)
																+ (j6 - 1) * i1
																+ l]);
												doublew13.val = Math.max(
														doublew11.val,
														doublew12.val);
												if ((doublew13.val < 1.0D)
														&& (doublew13.val != 0.0D)) {
													doublew11.val = doublew11.val
															/ doublew13.val;
													doublew12.val = doublew12.val
															/ doublew13.val;
												}
												if (doublew11.val
														* (d37 * Math
																.abs(ad[((j6 + 1) - 1)
																		+ (j6 - 1)
																		* i1
																		+ l])) <= doublew12.val
														* (d37 * d38))
													flag1 = true;
											}
											if (flag3 || flag1) {
												int j9 = j6;
												for (int k18 = (l4 - 1 - j6) + 1; k18 > 0; k18--) {
													doublew11.val = ad[(j9 - 1)
															+ (j9 - 1) * i1 + l];
													dlartg_adapter(
															doublew11.val,
															ad[((j9 + 1) - 1)
																	+ (j9 - 1)
																	* i1 + l],
															doublew2, doublew5,
															ad, (j9 - 1)
																	+ (j9 - 1)
																	* i1 + l);
													ad[((j9 + 1) - 1)
															+ (j9 - 1) * i1 + l] = 0.0D;
													Drot.drot(
															i5 - j9,
															ad,
															(j9 - 1)
																	+ ((j9 + 1) - 1)
																	* i1 + l,
															i1,
															ad,
															((j9 + 1) - 1)
																	+ ((j9 + 1) - 1)
																	* i1 + l,
															i1, doublew2.val,
															doublew5.val);
													Drot.drot(
															i5 - j9,
															ad1,
															(j9 - 1)
																	+ ((j9 + 1) - 1)
																	* k1 + j1,
															k1,
															ad1,
															((j9 + 1) - 1)
																	+ ((j9 + 1) - 1)
																	* k1 + j1,
															k1, doublew2.val,
															doublew5.val);
													if (flag6)
														Drot.drot(
																i,
																ad5,
																(1 - 1)
																		+ (j9 - 1)
																		* l2
																		+ k2,
																1,
																ad5,
																(1 - 1)
																		+ ((j9 + 1) - 1)
																		* l2
																		+ k2,
																1,
																doublew2.val,
																doublew5.val);
													if (flag1)
														ad[(j9 - 1)
																+ (j9 - 1 - 1)
																* i1 + l] = ad[(j9 - 1)
																+ (j9 - 1 - 1)
																* i1 + l]
																* doublew2.val;
													flag1 = false;
													if (Math.abs(ad1[((j9 + 1) - 1)
															+ ((j9 + 1) - 1)
															* k1 + j1]) >= d55) {
														if (j9 + 1 < l4) {
															i4 = j9 + 1;
															break label3;
														}
														break label4;
													}
													ad1[((j9 + 1) - 1)
															+ ((j9 + 1) - 1)
															* k1 + j1] = 0.0D;
													j9++;
												}

											} else {
												int k9 = j6;
												for (int l18 = (l4 - 1 - j6) + 1; l18 > 0; l18--) {
													doublew11.val = ad1[(k9 - 1)
															+ ((k9 + 1) - 1)
															* k1 + j1];
													dlartg_adapter(
															doublew11.val,
															ad1[((k9 + 1) - 1)
																	+ ((k9 + 1) - 1)
																	* k1 + j1],
															doublew2,
															doublew5,
															ad1,
															(k9 - 1)
																	+ ((k9 + 1) - 1)
																	* k1 + j1);
													ad1[((k9 + 1) - 1)
															+ ((k9 + 1) - 1)
															* k1 + j1] = 0.0D;
													if (k9 < i5 - 1)
														Drot.drot(
																i5 - k9 - 1,
																ad1,
																(k9 - 1)
																		+ ((k9 + 2) - 1)
																		* k1
																		+ j1,
																k1,
																ad1,
																((k9 + 1) - 1)
																		+ ((k9 + 2) - 1)
																		* k1
																		+ j1,
																k1,
																doublew2.val,
																doublew5.val);
													Drot.drot(
															(i5 - k9) + 2,
															ad,
															(k9 - 1)
																	+ (k9 - 1 - 1)
																	* i1 + l,
															i1,
															ad,
															((k9 + 1) - 1)
																	+ (k9 - 1 - 1)
																	* i1 + l,
															i1, doublew2.val,
															doublew5.val);
													if (flag6)
														Drot.drot(
																i,
																ad5,
																(1 - 1)
																		+ (k9 - 1)
																		* l2
																		+ k2,
																1,
																ad5,
																(1 - 1)
																		+ ((k9 + 1) - 1)
																		* l2
																		+ k2,
																1,
																doublew2.val,
																doublew5.val);
													doublew11.val = ad[((k9 + 1) - 1)
															+ (k9 - 1) * i1 + l];
													dlartg_adapter(
															doublew11.val,
															ad[((k9 + 1) - 1)
																	+ (k9 - 1 - 1)
																	* i1 + l],
															doublew2, doublew5,
															ad, ((k9 + 1) - 1)
																	+ (k9 - 1)
																	* i1 + l);
													ad[((k9 + 1) - 1)
															+ (k9 - 1 - 1) * i1
															+ l] = 0.0D;
													Drot.drot(
															(k9 + 1) - j4,
															ad,
															(j4 - 1) + (k9 - 1)
																	* i1 + l,
															1,
															ad,
															(j4 - 1)
																	+ (k9 - 1 - 1)
																	* i1 + l,
															1, doublew2.val,
															doublew5.val);
													Drot.drot(
															k9 - j4,
															ad1,
															(j4 - 1) + (k9 - 1)
																	* k1 + j1,
															1,
															ad1,
															(j4 - 1)
																	+ (k9 - 1 - 1)
																	* k1 + j1,
															1, doublew2.val,
															doublew5.val);
													if (flag8)
														Drot.drot(
																i,
																ad6,
																(1 - 1)
																		+ (k9 - 1)
																		* j3
																		+ i3,
																1,
																ad6,
																(1 - 1)
																		+ (k9 - 1 - 1)
																		* j3
																		+ i3,
																1,
																doublew2.val,
																doublew5.val);
													k9++;
												}

											}
											break label5;
										}
										if (flag3) {
											i4 = j6;
											break label3;
										}
										j6--;
									}

									intw.val = i + 1;
									break label0;
								}
								doublew11.val = ad[(l4 - 1) + (l4 - 1) * i1 + l];
								dlartg_adapter(doublew11.val, ad[(l4 - 1)
										+ (l4 - 1 - 1) * i1 + l], doublew2,
										doublew5, ad, (l4 - 1) + (l4 - 1) * i1
												+ l);
								ad[(l4 - 1) + (l4 - 1 - 1) * i1 + l] = 0.0D;
								Drot.drot(l4 - j4, ad, (j4 - 1) + (l4 - 1) * i1
										+ l, 1, ad, (j4 - 1) + (l4 - 1 - 1)
										* i1 + l, 1, doublew2.val, doublew5.val);
								Drot.drot(l4 - j4, ad1, (j4 - 1) + (l4 - 1)
										* k1 + j1, 1, ad1, (j4 - 1)
										+ (l4 - 1 - 1) * k1 + j1, 1,
										doublew2.val, doublew5.val);
								if (flag8)
									Drot.drot(i, ad6, (1 - 1) + (l4 - 1) * j3
											+ i3, 1, ad6, (1 - 1)
											+ (l4 - 1 - 1) * j3 + i3, 1,
											doublew2.val, doublew5.val);
							}
							if (ad1[(l4 - 1) + (l4 - 1) * k1 + j1] < 0.0D) {
								if (flag7) {
									int k6 = j4;
									for (int i15 = (l4 - j4) + 1; i15 > 0; i15--) {
										ad[(k6 - 1) + (l4 - 1) * i1 + l] = -ad[(k6 - 1)
												+ (l4 - 1) * i1 + l];
										ad1[(k6 - 1) + (l4 - 1) * k1 + j1] = -ad1[(k6 - 1)
												+ (l4 - 1) * k1 + j1];
										k6++;
									}

								} else {
									ad[(l4 - 1) + (l4 - 1) * i1 + l] = -ad[(l4 - 1)
											+ (l4 - 1) * i1 + l];
									ad1[(l4 - 1) + (l4 - 1) * k1 + j1] = -ad1[(l4 - 1)
											+ (l4 - 1) * k1 + j1];
								}
								if (flag8) {
									int l6 = 1;
									for (int j15 = (i - 1) + 1; j15 > 0; j15--) {
										ad6[(l6 - 1) + (l4 - 1) * j3 + i3] = -ad6[(l6 - 1)
												+ (l4 - 1) * j3 + i3];
										l6++;
									}

								}
							}
							ad2[(l4 - 1) + l1] = ad[(l4 - 1) + (l4 - 1) * i1
									+ l];
							ad3[(l4 - 1) + i2] = 0.0D;
							ad4[(l4 - 1) + j2] = ad1[(l4 - 1) + (l4 - 1) * k1
									+ j1];
							l4--;
							if (l4 < j)
								break label1;
							k4 = 0;
							d72 = 0.0D;
							if (flag7 ^ true) {
								i5 = l4;
								if (j4 > l4)
									j4 = j;
							}
							break label2;
						}
						label6: {
							int k5;
							label7: {
								k4++;
								if (flag7 ^ true)
									j4 = i4;
								if ((k4 / 10) * 10 == k4) {
									if (j13
											* d76
											* Math.abs(ad[(l4 - 1 - 1)
													+ (l4 - 1) * i1 + l]) < Math
												.abs(ad1[(l4 - 1 - 1)
														+ (l4 - 1 - 1) * k1
														+ j1]))
										d72 += ad[(l4 - 1 - 1) + (l4 - 1) * i1
												+ l]
												/ ad1[(l4 - 1 - 1)
														+ (l4 - 1 - 1) * k1
														+ j1];
									else
										d72 += 1.0D / (d76 * j13);
									doublew6.val = 1.0D;
									doublew15.val = d72;
								} else {
									Dlag2.dlag2(ad, (l4 - 1 - 1) + (l4 - 1 - 1)
											* i1 + l, i1, ad1, (l4 - 1 - 1)
											+ (l4 - 1 - 1) * k1 + j1, k1,
											d76 * 100D, doublew6, doublew7,
											doublew15, doublew16, doublew14);
									doublew11.val = Math
											.max(doublew6.val,
													d76
															* Util.max(
																	1.0D,
																	Math.abs(doublew15.val),
																	Math.abs(doublew14.val)));
									if (doublew14.val != 0.0D)
										break label6;
								}
								doublew11.val = Math.min(d37, 1.0D)
										* (0.5D * d75);
								double d78;
								if (doublew6.val > doublew11.val)
									d78 = doublew11.val / doublew6.val;
								else
									d78 = 1.0D;
								doublew11.val = Math.min(d54, 1.0D)
										* (0.5D * d75);
								if (Math.abs(doublew15.val) > doublew11.val)
									d78 = Math.min(
											d78,
											doublew11.val
													/ Math.abs(doublew15.val));
								doublew6.val = d78 * doublew6.val;
								doublew15.val = d78 * doublew15.val;
								int i7 = l4 - 1;
								for (int k15 = (((i4 + 1) - (l4 - 1)) + -1)
										/ -1; k15 > 0; k15--) {
									k5 = i7;
									doublew11.val = Math.abs(doublew6.val
											* ad[(i7 - 1) + (i7 - 1 - 1) * i1
													+ l]);
									doublew12.val = Math
											.abs(doublew6.val
													* ad[(i7 - 1) + (i7 - 1)
															* i1 + l]
													- doublew15.val
													* ad1[(i7 - 1) + (i7 - 1)
															* k1 + j1]);
									doublew13.val = Math.max(doublew11.val,
											doublew12.val);
									if ((doublew13.val < 1.0D)
											&& (doublew13.val != 0.0D)) {
										doublew11.val = doublew11.val
												/ doublew13.val;
										doublew12.val = doublew12.val
												/ doublew13.val;
									}
									if (Math.abs(d37
											* ad[((i7 + 1) - 1) + (i7 - 1) * i1
													+ l] * doublew11.val) <= d37
											* d38 * doublew12.val)
										break label7;
									i7--;
								}

								k5 = i4;
							}
							doublew11.val = doublew6.val
									* ad[(k5 - 1) + (k5 - 1) * i1 + l]
									- doublew15.val
									* ad1[(k5 - 1) + (k5 - 1) * k1 + j1];
							doublew12.val = doublew6.val
									* ad[((k5 + 1) - 1) + (k5 - 1) * i1 + l];
							Dlartg.dlartg(doublew11.val, doublew12.val,
									doublew2, doublew5, doublew13);
							int j7 = k5;
							for (int l15 = (l4 - 1 - k5) + 1; l15 > 0; l15--) {
								if (j7 > k5) {
									doublew11.val = ad[(j7 - 1) + (j7 - 1 - 1)
											* i1 + l];
									dlartg_adapter(doublew11.val,
											ad[((j7 + 1) - 1) + (j7 - 1 - 1)
													* i1 + l], doublew2,
											doublew5, ad, (j7 - 1)
													+ (j7 - 1 - 1) * i1 + l);
									ad[((j7 + 1) - 1) + (j7 - 1 - 1) * i1 + l] = 0.0D;
								}
								int k8 = j7;
								for (int i19 = (i5 - j7) + 1; i19 > 0; i19--) {
									doublew11.val = doublew2.val
											* ad[(j7 - 1) + (k8 - 1) * i1 + l]
											+ doublew5.val
											* ad[((j7 + 1) - 1) + (k8 - 1) * i1
													+ l];
									ad[((j7 + 1) - 1) + (k8 - 1) * i1 + l] = -(doublew5.val * ad[(j7 - 1)
											+ (k8 - 1) * i1 + l])
											+ doublew2.val
											* ad[((j7 + 1) - 1) + (k8 - 1) * i1
													+ l];
									ad[(j7 - 1) + (k8 - 1) * i1 + l] = doublew11.val;
									doublew12.val = doublew2.val
											* ad1[(j7 - 1) + (k8 - 1) * k1 + j1]
											+ doublew5.val
											* ad1[((j7 + 1) - 1) + (k8 - 1)
													* k1 + j1];
									ad1[((j7 + 1) - 1) + (k8 - 1) * k1 + j1] = -(doublew5.val * ad1[(j7 - 1)
											+ (k8 - 1) * k1 + j1])
											+ doublew2.val
											* ad1[((j7 + 1) - 1) + (k8 - 1)
													* k1 + j1];
									ad1[(j7 - 1) + (k8 - 1) * k1 + j1] = doublew12.val;
									k8++;
								}

								if (flag6) {
									int k10 = 1;
									for (int j19 = (i - 1) + 1; j19 > 0; j19--) {
										doublew11.val = doublew2.val
												* ad5[(k10 - 1) + (j7 - 1) * l2
														+ k2]
												+ doublew5.val
												* ad5[(k10 - 1)
														+ ((j7 + 1) - 1) * l2
														+ k2];
										ad5[(k10 - 1) + ((j7 + 1) - 1) * l2
												+ k2] = -(doublew5.val * ad5[(k10 - 1)
												+ (j7 - 1) * l2 + k2])
												+ doublew2.val
												* ad5[(k10 - 1)
														+ ((j7 + 1) - 1) * l2
														+ k2];
										ad5[(k10 - 1) + (j7 - 1) * l2 + k2] = doublew11.val;
										k10++;
									}

								}
								doublew11.val = ad1[((j7 + 1) - 1)
										+ ((j7 + 1) - 1) * k1 + j1];
								dlartg_adapter(
										doublew11.val,
										ad1[((j7 + 1) - 1) + (j7 - 1) * k1 + j1],
										doublew2, doublew5, ad1, ((j7 + 1) - 1)
												+ ((j7 + 1) - 1) * k1 + j1);
								ad1[((j7 + 1) - 1) + (j7 - 1) * k1 + j1] = 0.0D;
								int l10 = j4;
								for (int k19 = (Math.min(j7 + 2, l4) - j4) + 1; k19 > 0; k19--) {
									doublew11.val = doublew2.val
											* ad[(l10 - 1) + ((j7 + 1) - 1)
													* i1 + l] + doublew5.val
											* ad[(l10 - 1) + (j7 - 1) * i1 + l];
									ad[(l10 - 1) + (j7 - 1) * i1 + l] = -(doublew5.val * ad[(l10 - 1)
											+ ((j7 + 1) - 1) * i1 + l])
											+ doublew2.val
											* ad[(l10 - 1) + (j7 - 1) * i1 + l];
									ad[(l10 - 1) + ((j7 + 1) - 1) * i1 + l] = doublew11.val;
									l10++;
								}

								l10 = j4;
								for (int l19 = (j7 - j4) + 1; l19 > 0; l19--) {
									doublew11.val = doublew2.val
											* ad1[(l10 - 1) + ((j7 + 1) - 1)
													* k1 + j1]
											+ doublew5.val
											* ad1[(l10 - 1) + (j7 - 1) * k1
													+ j1];
									ad1[(l10 - 1) + (j7 - 1) * k1 + j1] = -(doublew5.val * ad1[(l10 - 1)
											+ ((j7 + 1) - 1) * k1 + j1])
											+ doublew2.val
											* ad1[(l10 - 1) + (j7 - 1) * k1
													+ j1];
									ad1[(l10 - 1) + ((j7 + 1) - 1) * k1 + j1] = doublew11.val;
									l10++;
								}

								if (flag8) {
									int i11 = 1;
									for (int i20 = (i - 1) + 1; i20 > 0; i20--) {
										doublew11.val = doublew2.val
												* ad6[(i11 - 1)
														+ ((j7 + 1) - 1) * j3
														+ i3]
												+ doublew5.val
												* ad6[(i11 - 1) + (j7 - 1) * j3
														+ i3];
										ad6[(i11 - 1) + (j7 - 1) * j3 + i3] = -(doublew5.val * ad6[(i11 - 1)
												+ ((j7 + 1) - 1) * j3 + i3])
												+ doublew2.val
												* ad6[(i11 - 1) + (j7 - 1) * j3
														+ i3];
										ad6[(i11 - 1) + ((j7 + 1) - 1) * j3
												+ i3] = doublew11.val;
										i11++;
									}

								}
								j7++;
							}

							break label2;
						}
						if (i4 + 1 == l4) {
							Dlasv2.dlasv2(ad1[(l4 - 1 - 1) + (l4 - 1 - 1) * k1
									+ j1], ad1[(l4 - 1 - 1) + (l4 - 1) * k1
									+ j1], ad1[(l4 - 1) + (l4 - 1) * k1 + j1],
									doublew1, doublew, doublew9, doublew4,
									doublew8, doublew3);
							if (doublew.val < 0.0D) {
								doublew4.val = -doublew4.val;
								doublew9.val = -doublew9.val;
								doublew.val = -doublew.val;
								doublew1.val = -doublew1.val;
							}
							Drot.drot((i5 + 1) - i4, ad, (l4 - 1 - 1)
									+ (l4 - 1 - 1) * i1 + l, i1, ad, (l4 - 1)
									+ (l4 - 1 - 1) * i1 + l, i1, doublew3.val,
									doublew8.val);
							Drot.drot((l4 + 1) - j4, ad, (j4 - 1)
									+ (l4 - 1 - 1) * i1 + l, 1, ad, (j4 - 1)
									+ (l4 - 1) * i1 + l, 1, doublew4.val,
									doublew9.val);
							if (l4 < i5)
								Drot.drot(i5 - l4, ad1, (l4 - 1 - 1)
										+ ((l4 + 1) - 1) * k1 + j1, k1, ad1,
										(l4 - 1) + ((l4 + 1) - 1) * k1 + j1,
										i1, doublew3.val, doublew8.val);
							if (j4 < l4 - 1)
								Drot.drot(i4 - j4, ad1, (j4 - 1) + (l4 - 1 - 1)
										* k1 + j1, 1, ad1, (j4 - 1) + (l4 - 1)
										* k1 + j1, 1, doublew4.val,
										doublew9.val);
							if (flag6)
								Drot.drot(i, ad5, (1 - 1) + (l4 - 1 - 1) * l2
										+ k2, 1, ad5, (1 - 1) + (l4 - 1) * l2
										+ k2, 1, doublew3.val, doublew8.val);
							if (flag8)
								Drot.drot(i, ad6, (1 - 1) + (l4 - 1 - 1) * j3
										+ i3, 1, ad6, (1 - 1) + (l4 - 1) * j3
										+ i3, 1, doublew4.val, doublew9.val);
							ad1[(l4 - 1 - 1) + (l4 - 1 - 1) * k1 + j1] = doublew.val;
							ad1[(l4 - 1 - 1) + (l4 - 1) * k1 + j1] = 0.0D;
							ad1[(l4 - 1) + (l4 - 1 - 1) * k1 + j1] = 0.0D;
							ad1[(l4 - 1) + (l4 - 1) * k1 + j1] = doublew1.val;
							if (doublew1.val < 0.0D) {
								int k7 = j4;
								for (int i16 = (l4 - j4) + 1; i16 > 0; i16--) {
									ad[(k7 - 1) + (l4 - 1) * i1 + l] = -ad[(k7 - 1)
											+ (l4 - 1) * i1 + l];
									ad1[(k7 - 1) + (l4 - 1) * k1 + j1] = -ad1[(k7 - 1)
											+ (l4 - 1) * k1 + j1];
									k7++;
								}

								if (flag8) {
									int l7 = 1;
									for (int j16 = (i - 1) + 1; j16 > 0; j16--) {
										ad6[(l7 - 1) + (l4 - 1) * j3 + i3] = -ad6[(l7 - 1)
												+ (l4 - 1) * j3 + i3];
										l7++;
									}

								}
							}
							Dlag2.dlag2(ad, (l4 - 1 - 1) + (l4 - 1 - 1) * i1
									+ l, i1, ad1, (l4 - 1 - 1) + (l4 - 1 - 1)
									* k1 + j1, k1, d76 * 100D, doublew6,
									doublew11, doublew15, doublew12, doublew14);
							if (doublew14.val != 0.0D) {
								double d74 = 1.0D / doublew6.val;
								double d1 = ad[(l4 - 1 - 1) + (l4 - 1 - 1) * i1
										+ l];
								double d9 = ad[(l4 - 1) + (l4 - 1 - 1) * i1 + l];
								double d3 = ad[(l4 - 1 - 1) + (l4 - 1) * i1 + l];
								double d11 = ad[(l4 - 1) + (l4 - 1) * i1 + l];
								double d59 = doublew6.val * d1 - doublew15.val
										* doublew.val;
								double d57 = -(doublew14.val * doublew.val);
								double d61 = doublew6.val * d3;
								double d63 = doublew6.val * d9;
								double d67 = doublew6.val * d11 - doublew15.val
										* doublew1.val;
								double d65 = -(doublew14.val * doublew1.val);
								double d71;
								double d85;
								double d87;
								if (Math.abs(d59) + Math.abs(d57)
										+ Math.abs(d61) > Math.abs(d63)
										+ Math.abs(d67) + Math.abs(d65)) {
									double d89 = Dlapy3.dlapy3(d61, d59, d57);
									d71 = d61 / d89;
									d87 = -(d59 / d89);
									d85 = -(d57 / d89);
								} else {
									d71 = Dlapy2.dlapy2(d67, d65);
									if (d71 <= d76) {
										d71 = 0.0D;
										d87 = 1.0D;
										d85 = 0.0D;
									} else {
										doublew13.val = d67 / d71;
										double d94 = d65 / d71;
										double d90 = Dlapy2.dlapy2(d71, d63);
										d71 /= d90;
										d87 = -((d63 * doublew13.val) / d90);
										d85 = (d63 * d94) / d90;
									}
								}
								double d35 = Math.abs(d1) + Math.abs(d3)
										+ Math.abs(d9) + Math.abs(d11);
								double d52 = Math.abs(doublew.val)
										+ Math.abs(doublew1.val);
								double d117 = Math.abs(doublew15.val)
										+ Math.abs(doublew14.val);
								double d69;
								double d81;
								double d83;
								if (doublew6.val * d35 > d117 * d52) {
									d69 = d71 * doublew.val;
									d83 = d87 * doublew1.val;
									d81 = -(d85 * doublew1.val);
								} else {
									double d7 = d71 * d1 + d87 * d3;
									double d5 = d85 * d3;
									double d15 = d71 * d9 + d87 * d11;
									double d13 = d85 * d11;
									d69 = Dlapy2.dlapy2(d7, d5);
									if (d69 <= d76) {
										d69 = 0.0D;
										d83 = 1.0D;
										d81 = 0.0D;
									} else {
										doublew13.val = d7 / d69;
										double d95 = d5 / d69;
										d83 = doublew13.val * d15 + d95 * d13;
										d81 = d95 * d15 - doublew13.val * d13;
									}
								}
								double d91 = Dlapy3.dlapy3(d69, d83, d81);
								d69 /= d91;
								d83 /= d91;
								d81 /= d91;
								doublew13.val = d83 * d87 - d81 * d85;
								double d96 = d83 * d85 + d81 * d87;
								double d44 = d69 * d71 * doublew.val
										+ doublew13.val * doublew1.val;
								double d42 = d96 * doublew1.val;
								double d40 = Dlapy2.dlapy2(d44, d42);
								double d50 = d69 * d71 * doublew1.val
										+ doublew13.val * doublew.val;
								double d48 = -(d96 * doublew.val);
								double d46 = Dlapy2.dlapy2(d50, d48);
								ad4[(l4 - 1 - 1) + j2] = d40;
								ad4[(l4 - 1) + j2] = d46;
								ad2[(l4 - 1 - 1) + l1] = doublew15.val * d40
										* d74;
								ad3[(l4 - 1 - 1) + i2] = doublew14.val * d40
										* d74;
								ad2[(l4 - 1) + l1] = doublew15.val * d46 * d74;
								ad3[(l4 - 1) + i2] = -(doublew14.val * d46 * d74);
								l4 = i4 - 1;
								if (l4 < j)
									break label1;
								k4 = 0;
								d72 = 0.0D;
								if (flag7 ^ true) {
									i5 = l4;
									if (j4 > l4)
										j4 = j;
								}
							}
						} else {
							double d17 = (d37 * ad[(l4 - 1 - 1) + (l4 - 1 - 1)
									* i1 + l])
									/ (d54 * ad1[(l4 - 1 - 1) + (l4 - 1 - 1)
											* k1 + j1]);
							double d25 = (d37 * ad[(l4 - 1) + (l4 - 1 - 1) * i1
									+ l])
									/ (d54 * ad1[(l4 - 1 - 1) + (l4 - 1 - 1)
											* k1 + j1]);
							double d21 = (d37 * ad[(l4 - 1 - 1) + (l4 - 1) * i1
									+ l])
									/ (d54 * ad1[(l4 - 1) + (l4 - 1) * k1 + j1]);
							double d29 = (d37 * ad[(l4 - 1) + (l4 - 1) * i1 + l])
									/ (d54 * ad1[(l4 - 1) + (l4 - 1) * k1 + j1]);
							double d100 = ad1[(l4 - 1 - 1) + (l4 - 1) * k1 + j1]
									/ ad1[(l4 - 1) + (l4 - 1) * k1 + j1];
							double d19 = (d37 * ad[(i4 - 1) + (i4 - 1) * i1 + l])
									/ (d54 * ad1[(i4 - 1) + (i4 - 1) * k1 + j1]);
							double d27 = (d37 * ad[((i4 + 1) - 1) + (i4 - 1)
									* i1 + l])
									/ (d54 * ad1[(i4 - 1) + (i4 - 1) * k1 + j1]);
							double d23 = (d37 * ad[(i4 - 1) + ((i4 + 1) - 1)
									* i1 + l])
									/ (d54 * ad1[((i4 + 1) - 1)
											+ ((i4 + 1) - 1) * k1 + j1]);
							double d31 = (d37 * ad[((i4 + 1) - 1)
									+ ((i4 + 1) - 1) * i1 + l])
									/ (d54 * ad1[((i4 + 1) - 1)
											+ ((i4 + 1) - 1) * k1 + j1]);
							double d33 = (d37 * ad[((i4 + 2) - 1)
									+ ((i4 + 1) - 1) * i1 + l])
									/ (d54 * ad1[((i4 + 1) - 1)
											+ ((i4 + 1) - 1) * k1 + j1]);
							double d102 = ad1[(i4 - 1) + ((i4 + 1) - 1) * k1
									+ j1]
									/ ad1[((i4 + 1) - 1) + ((i4 + 1) - 1) * k1
											+ j1];
							ad8[1 - 1] = ((d17 - d19) * (d29 - d19) - d21 * d25)
									+ d25
									* d100
									* d19
									+ (d23 - d19 * d102)
									* d27;
							ad8[2 - 1] = ((d31 - d19 - d27 * d102 - (d17 - d19) - (d29 - d19)) + d25
									* d100)
									* d27;
							ad8[3 - 1] = d33 * d27;
							int l5 = i4;
							dlarfg_adapter(3, ad8, 1 - 1, ad8, 2 - 1, 1,
									doublew10);
							ad8[1 - 1] = 1.0D;
							int i8 = l5;
							for (int k16 = (l4 - 2 - l5) + 1; k16 > 0; k16--) {
								if (i8 > l5) {
									ad8[1 - 1] = ad[(i8 - 1) + (i8 - 1 - 1)
											* i1 + l];
									ad8[2 - 1] = ad[((i8 + 1) - 1)
											+ (i8 - 1 - 1) * i1 + l];
									ad8[3 - 1] = ad[((i8 + 2) - 1)
											+ (i8 - 1 - 1) * i1 + l];
									dlarfg_adapter(3, ad, (i8 - 1)
											+ (i8 - 1 - 1) * i1 + l, ad8,
											2 - 1, 1, doublew10);
									ad8[1 - 1] = 1.0D;
									ad[((i8 + 1) - 1) + (i8 - 1 - 1) * i1 + l] = 0.0D;
									ad[((i8 + 2) - 1) + (i8 - 1 - 1) * i1 + l] = 0.0D;
								}
								int l8 = i8;
								for (int j20 = (i5 - i8) + 1; j20 > 0; j20--) {
									doublew11.val = doublew10.val
											* (ad[(i8 - 1) + (l8 - 1) * i1 + l]
													+ ad8[2 - 1]
													* ad[((i8 + 1) - 1)
															+ (l8 - 1) * i1 + l] + ad8[3 - 1]
													* ad[((i8 + 2) - 1)
															+ (l8 - 1) * i1 + l]);
									ad[(i8 - 1) + (l8 - 1) * i1 + l] = ad[(i8 - 1)
											+ (l8 - 1) * i1 + l]
											- doublew11.val;
									ad[((i8 + 1) - 1) + (l8 - 1) * i1 + l] = ad[((i8 + 1) - 1)
											+ (l8 - 1) * i1 + l]
											- doublew11.val * ad8[2 - 1];
									ad[((i8 + 2) - 1) + (l8 - 1) * i1 + l] = ad[((i8 + 2) - 1)
											+ (l8 - 1) * i1 + l]
											- doublew11.val * ad8[3 - 1];
									doublew12.val = doublew10.val
											* (ad1[(i8 - 1) + (l8 - 1) * k1
													+ j1]
													+ ad8[2 - 1]
													* ad1[((i8 + 1) - 1)
															+ (l8 - 1) * k1
															+ j1] + ad8[3 - 1]
													* ad1[((i8 + 2) - 1)
															+ (l8 - 1) * k1
															+ j1]);
									ad1[(i8 - 1) + (l8 - 1) * k1 + j1] = ad1[(i8 - 1)
											+ (l8 - 1) * k1 + j1]
											- doublew12.val;
									ad1[((i8 + 1) - 1) + (l8 - 1) * k1 + j1] = ad1[((i8 + 1) - 1)
											+ (l8 - 1) * k1 + j1]
											- doublew12.val * ad8[2 - 1];
									ad1[((i8 + 2) - 1) + (l8 - 1) * k1 + j1] = ad1[((i8 + 2) - 1)
											+ (l8 - 1) * k1 + j1]
											- doublew12.val * ad8[3 - 1];
									l8++;
								}

								if (flag6) {
									int j11 = 1;
									for (int k20 = (i - 1) + 1; k20 > 0; k20--) {
										doublew11.val = doublew10.val
												* (ad5[(j11 - 1) + (i8 - 1)
														* l2 + k2]
														+ ad8[2 - 1]
														* ad5[(j11 - 1)
																+ ((i8 + 1) - 1)
																* l2 + k2] + ad8[3 - 1]
														* ad5[(j11 - 1)
																+ ((i8 + 2) - 1)
																* l2 + k2]);
										ad5[(j11 - 1) + (i8 - 1) * l2 + k2] = ad5[(j11 - 1)
												+ (i8 - 1) * l2 + k2]
												- doublew11.val;
										ad5[(j11 - 1) + ((i8 + 1) - 1) * l2
												+ k2] = ad5[(j11 - 1)
												+ ((i8 + 1) - 1) * l2 + k2]
												- doublew11.val * ad8[2 - 1];
										ad5[(j11 - 1) + ((i8 + 2) - 1) * l2
												+ k2] = ad5[(j11 - 1)
												+ ((i8 + 2) - 1) * l2 + k2]
												- doublew11.val * ad8[3 - 1];
										j11++;
									}

								}
								boolean flag5 = false;
								doublew11.val = Math.max(
										Math.abs(ad1[((i8 + 1) - 1)
												+ ((i8 + 1) - 1) * k1 + j1]),
										Math.abs(ad1[((i8 + 1) - 1)
												+ ((i8 + 2) - 1) * k1 + j1]));
								doublew12.val = Math.max(
										Math.abs(ad1[((i8 + 2) - 1)
												+ ((i8 + 1) - 1) * k1 + j1]),
										Math.abs(ad1[((i8 + 2) - 1)
												+ ((i8 + 2) - 1) * k1 + j1]));
								double d79;
								double d98;
								double d104;
								if (Math.max(doublew11.val, doublew12.val) < d76) {
									d79 = 0.0D;
									d98 = 1.0D;
									d104 = 0.0D;
								} else {
									double d109;
									double d111;
									double d113;
									double d115;
									if (doublew11.val >= doublew12.val) {
										d109 = ad1[((i8 + 1) - 1)
												+ ((i8 + 1) - 1) * k1 + j1];
										d113 = ad1[((i8 + 2) - 1)
												+ ((i8 + 1) - 1) * k1 + j1];
										d111 = ad1[((i8 + 1) - 1)
												+ ((i8 + 2) - 1) * k1 + j1];
										d115 = ad1[((i8 + 2) - 1)
												+ ((i8 + 2) - 1) * k1 + j1];
										d98 = ad1[((i8 + 1) - 1) + (i8 - 1)
												* k1 + j1];
										d104 = ad1[((i8 + 2) - 1) + (i8 - 1)
												* k1 + j1];
									} else {
										d113 = ad1[((i8 + 1) - 1)
												+ ((i8 + 1) - 1) * k1 + j1];
										d109 = ad1[((i8 + 2) - 1)
												+ ((i8 + 1) - 1) * k1 + j1];
										d115 = ad1[((i8 + 1) - 1)
												+ ((i8 + 2) - 1) * k1 + j1];
										d111 = ad1[((i8 + 2) - 1)
												+ ((i8 + 2) - 1) * k1 + j1];
										d104 = ad1[((i8 + 1) - 1) + (i8 - 1)
												* k1 + j1];
										d98 = ad1[((i8 + 2) - 1) + (i8 - 1)
												* k1 + j1];
									}
									if (Math.abs(d111) > Math.abs(d109)) {
										flag5 = true;
										doublew11.val = d111;
										doublew12.val = d115;
										d111 = d109;
										d115 = d113;
										d109 = doublew11.val;
										d113 = doublew12.val;
									}
									doublew11.val = d113 / d109;
									d104 -= doublew11.val * d98;
									d115 -= doublew11.val * d111;
									d113 = 0.0D;
									d79 = 1.0D;
									if (Math.abs(d115) < d76) {
										d79 = 0.0D;
										d104 = 1.0D;
										d98 = -(d111 / d109);
									} else {
										if (Math.abs(d115) < Math.abs(d104))
											d79 = Math.abs(d115 / d104);
										if (Math.abs(d109) < Math.abs(d98))
											d79 = Math.min(d79,
													Math.abs(d109 / d98));
										d104 = (d79 * d104) / d115;
										d98 = (d79 * d98 - d111 * d104) / d109;
									}
								}
								if (flag5) {
									doublew11.val = d104;
									d104 = d98;
									d98 = doublew11.val;
								}
								double d92 = Math.sqrt(Math.pow(d79, 2)
										+ Math.pow(d98, 2) + Math.pow(d104, 2));
								doublew10.val = 1.0D + d79 / d92;
								double d107 = -(1.0D / (d79 + d92));
								ad8[1 - 1] = 1.0D;
								ad8[2 - 1] = d107 * d98;
								ad8[3 - 1] = d107 * d104;
								int k11 = j4;
								for (int l20 = (Math.min(i8 + 3, l4) - j4) + 1; l20 > 0; l20--) {
									doublew11.val = doublew10.val
											* (ad[(k11 - 1) + (i8 - 1) * i1 + l]
													+ ad8[2 - 1]
													* ad[(k11 - 1)
															+ ((i8 + 1) - 1)
															* i1 + l] + ad8[3 - 1]
													* ad[(k11 - 1)
															+ ((i8 + 2) - 1)
															* i1 + l]);
									ad[(k11 - 1) + (i8 - 1) * i1 + l] = ad[(k11 - 1)
											+ (i8 - 1) * i1 + l]
											- doublew11.val;
									ad[(k11 - 1) + ((i8 + 1) - 1) * i1 + l] = ad[(k11 - 1)
											+ ((i8 + 1) - 1) * i1 + l]
											- doublew11.val * ad8[2 - 1];
									ad[(k11 - 1) + ((i8 + 2) - 1) * i1 + l] = ad[(k11 - 1)
											+ ((i8 + 2) - 1) * i1 + l]
											- doublew11.val * ad8[3 - 1];
									k11++;
								}

								k11 = j4;
								for (int i21 = ((i8 + 2) - j4) + 1; i21 > 0; i21--) {
									doublew11.val = doublew10.val
											* (ad1[(k11 - 1) + (i8 - 1) * k1
													+ j1]
													+ ad8[2 - 1]
													* ad1[(k11 - 1)
															+ ((i8 + 1) - 1)
															* k1 + j1] + ad8[3 - 1]
													* ad1[(k11 - 1)
															+ ((i8 + 2) - 1)
															* k1 + j1]);
									ad1[(k11 - 1) + (i8 - 1) * k1 + j1] = ad1[(k11 - 1)
											+ (i8 - 1) * k1 + j1]
											- doublew11.val;
									ad1[(k11 - 1) + ((i8 + 1) - 1) * k1 + j1] = ad1[(k11 - 1)
											+ ((i8 + 1) - 1) * k1 + j1]
											- doublew11.val * ad8[2 - 1];
									ad1[(k11 - 1) + ((i8 + 2) - 1) * k1 + j1] = ad1[(k11 - 1)
											+ ((i8 + 2) - 1) * k1 + j1]
											- doublew11.val * ad8[3 - 1];
									k11++;
								}

								if (flag8) {
									int l11 = 1;
									for (int j21 = (i - 1) + 1; j21 > 0; j21--) {
										doublew11.val = doublew10.val
												* (ad6[(l11 - 1) + (i8 - 1)
														* j3 + i3]
														+ ad8[2 - 1]
														* ad6[(l11 - 1)
																+ ((i8 + 1) - 1)
																* j3 + i3] + ad8[3 - 1]
														* ad6[(l11 - 1)
																+ ((i8 + 2) - 1)
																* j3 + i3]);
										ad6[(l11 - 1) + (i8 - 1) * j3 + i3] = ad6[(l11 - 1)
												+ (i8 - 1) * j3 + i3]
												- doublew11.val;
										ad6[(l11 - 1) + ((i8 + 1) - 1) * j3
												+ i3] = ad6[(l11 - 1)
												+ ((i8 + 1) - 1) * j3 + i3]
												- doublew11.val * ad8[2 - 1];
										ad6[(l11 - 1) + ((i8 + 2) - 1) * j3
												+ i3] = ad6[(l11 - 1)
												+ ((i8 + 2) - 1) * j3 + i3]
												- doublew11.val * ad8[3 - 1];
										l11++;
									}

								}
								ad1[((i8 + 1) - 1) + (i8 - 1) * k1 + j1] = 0.0D;
								ad1[((i8 + 2) - 1) + (i8 - 1) * k1 + j1] = 0.0D;
								i8++;
							}

							i8 = l4 - 1;
							doublew11.val = ad[(i8 - 1) + (i8 - 1 - 1) * i1 + l];
							dlartg_adapter(doublew11.val, ad[((i8 + 1) - 1)
									+ (i8 - 1 - 1) * i1 + l], doublew2,
									doublew5, ad, (i8 - 1) + (i8 - 1 - 1) * i1
											+ l);
							ad[((i8 + 1) - 1) + (i8 - 1 - 1) * i1 + l] = 0.0D;
							int i9 = i8;
							for (int l16 = (i5 - i8) + 1; l16 > 0; l16--) {
								doublew11.val = doublew2.val
										* ad[(i8 - 1) + (i9 - 1) * i1 + l]
										+ doublew5.val
										* ad[((i8 + 1) - 1) + (i9 - 1) * i1 + l];
								ad[((i8 + 1) - 1) + (i9 - 1) * i1 + l] = -(doublew5.val * ad[(i8 - 1)
										+ (i9 - 1) * i1 + l])
										+ doublew2.val
										* ad[((i8 + 1) - 1) + (i9 - 1) * i1 + l];
								ad[(i8 - 1) + (i9 - 1) * i1 + l] = doublew11.val;
								doublew12.val = doublew2.val
										* ad1[(i8 - 1) + (i9 - 1) * k1 + j1]
										+ doublew5.val
										* ad1[((i8 + 1) - 1) + (i9 - 1) * k1
												+ j1];
								ad1[((i8 + 1) - 1) + (i9 - 1) * k1 + j1] = -(doublew5.val * ad1[(i8 - 1)
										+ (i9 - 1) * k1 + j1])
										+ doublew2.val
										* ad1[((i8 + 1) - 1) + (i9 - 1) * k1
												+ j1];
								ad1[(i8 - 1) + (i9 - 1) * k1 + j1] = doublew12.val;
								i9++;
							}

							if (flag6) {
								int i12 = 1;
								for (int i17 = (i - 1) + 1; i17 > 0; i17--) {
									doublew11.val = doublew2.val
											* ad5[(i12 - 1) + (i8 - 1) * l2
													+ k2]
											+ doublew5.val
											* ad5[(i12 - 1) + ((i8 + 1) - 1)
													* l2 + k2];
									ad5[(i12 - 1) + ((i8 + 1) - 1) * l2 + k2] = -(doublew5.val * ad5[(i12 - 1)
											+ (i8 - 1) * l2 + k2])
											+ doublew2.val
											* ad5[(i12 - 1) + ((i8 + 1) - 1)
													* l2 + k2];
									ad5[(i12 - 1) + (i8 - 1) * l2 + k2] = doublew11.val;
									i12++;
								}

							}
							doublew11.val = ad1[((i8 + 1) - 1) + ((i8 + 1) - 1)
									* k1 + j1];
							dlartg_adapter(doublew11.val, ad1[((i8 + 1) - 1)
									+ (i8 - 1) * k1 + j1], doublew2, doublew5,
									ad1, ((i8 + 1) - 1) + ((i8 + 1) - 1) * k1
											+ j1);
							ad1[((i8 + 1) - 1) + (i8 - 1) * k1 + j1] = 0.0D;
							int j12 = j4;
							for (int j17 = (l4 - j4) + 1; j17 > 0; j17--) {
								doublew11.val = doublew2.val
										* ad[(j12 - 1) + ((i8 + 1) - 1) * i1
												+ l] + doublew5.val
										* ad[(j12 - 1) + (i8 - 1) * i1 + l];
								ad[(j12 - 1) + (i8 - 1) * i1 + l] = -(doublew5.val * ad[(j12 - 1)
										+ ((i8 + 1) - 1) * i1 + l])
										+ doublew2.val
										* ad[(j12 - 1) + (i8 - 1) * i1 + l];
								ad[(j12 - 1) + ((i8 + 1) - 1) * i1 + l] = doublew11.val;
								j12++;
							}

							j12 = j4;
							for (int k17 = (l4 - 1 - j4) + 1; k17 > 0; k17--) {
								doublew11.val = doublew2.val
										* ad1[(j12 - 1) + ((i8 + 1) - 1) * k1
												+ j1] + doublew5.val
										* ad1[(j12 - 1) + (i8 - 1) * k1 + j1];
								ad1[(j12 - 1) + (i8 - 1) * k1 + j1] = -(doublew5.val * ad1[(j12 - 1)
										+ ((i8 + 1) - 1) * k1 + j1])
										+ doublew2.val
										* ad1[(j12 - 1) + (i8 - 1) * k1 + j1];
								ad1[(j12 - 1) + ((i8 + 1) - 1) * k1 + j1] = doublew11.val;
								j12++;
							}

							if (flag8) {
								int k12 = 1;
								for (int l17 = (i - 1) + 1; l17 > 0; l17--) {
									doublew11.val = doublew2.val
											* ad6[(k12 - 1) + ((i8 + 1) - 1)
													* j3 + i3]
											+ doublew5.val
											* ad6[(k12 - 1) + (i8 - 1) * j3
													+ i3];
									ad6[(k12 - 1) + (i8 - 1) * j3 + i3] = -(doublew5.val * ad6[(k12 - 1)
											+ ((i8 + 1) - 1) * j3 + i3])
											+ doublew2.val
											* ad6[(k12 - 1) + (i8 - 1) * j3
													+ i3];
									ad6[(k12 - 1) + ((i8 + 1) - 1) * j3 + i3] = doublew11.val;
									k12++;
								}

							}
						}
					}
				}

				intw.val = l4;
				break label0;
			}
			int j8 = 1;
			for (int i14 = (j - 1 - 1) + 1; i14 > 0; i14--) {
				if (ad1[(j8 - 1) + (j8 - 1) * k1 + j1] < 0.0D) {
					if (flag7) {
						int l12 = 1;
						for (int i18 = (j8 - 1) + 1; i18 > 0; i18--) {
							ad[(l12 - 1) + (j8 - 1) * i1 + l] = -ad[(l12 - 1)
									+ (j8 - 1) * i1 + l];
							ad1[(l12 - 1) + (j8 - 1) * k1 + j1] = -ad1[(l12 - 1)
									+ (j8 - 1) * k1 + j1];
							l12++;
						}

					} else {
						ad[(j8 - 1) + (j8 - 1) * i1 + l] = -ad[(j8 - 1)
								+ (j8 - 1) * i1 + l];
						ad1[(j8 - 1) + (j8 - 1) * k1 + j1] = -ad1[(j8 - 1)
								+ (j8 - 1) * k1 + j1];
					}
					if (flag8) {
						int i13 = 1;
						for (int j18 = (i - 1) + 1; j18 > 0; j18--) {
							ad6[(i13 - 1) + (j8 - 1) * j3 + i3] = -ad6[(i13 - 1)
									+ (j8 - 1) * j3 + i3];
							i13++;
						}

					}
				}
				ad2[(j8 - 1) + l1] = ad[(j8 - 1) + (j8 - 1) * i1 + l];
				ad3[(j8 - 1) + i2] = 0.0D;
				ad4[(j8 - 1) + j2] = ad1[(j8 - 1) + (j8 - 1) * k1 + j1];
				j8++;
			}

			intw.val = 0;
		}
		ad7[(1 - 1) + k3] = i;
	}

	private static void dlartg_adapter(double d, double d1, doubleW doublew,
			doubleW doublew1, double ad[], int i) {
		doubleW doublew2 = new doubleW(ad[i]);
		Dlartg.dlartg(d, d1, doublew, doublew1, doublew2);
		ad[i] = doublew2.val;
	}

	private static void dlarfg_adapter(int i, double ad[], int j, double ad1[],
			int k, int l, doubleW doublew) {
		doubleW doublew1 = new doubleW(ad[j]);
		Dlarfg.dlarfg(i, doublew1, ad1, k, l, doublew);
		ad[j] = doublew1.val;
	}
}
