package org.netlib.lapack;

public final class Ieeeck {
	public static int ieeeck(int i, float f, float f1) {
		float f2 = 0.0F;
		float f3 = 0.0F;
		float f4 = 0.0F;
		float f5 = 0.0F;
		float f6 = 0.0F;
		float f7 = 0.0F;
		float f8 = 0.0F;
		float f9 = 0.0F;
		float f10 = 0.0F;
		float f11 = 0.0F;
		int j = 0;
		j = 1;
		f11 = f1 / f;
		if (f11 <= f1) {
			j = 0;
			return j;
		}
		f8 = -(f1 / f);
		if (f8 >= f) {
			j = 0;
			return j;
		}
		f9 = f1 / (f8 + f1);
		if (f9 != f) {
			j = 0;
			return j;
		}
		f8 = f1 / f9;
		if (f8 >= f) {
			j = 0;
			return j;
		}
		f10 = f9 + f;
		if (f10 != f) {
			j = 0;
			return j;
		}
		f11 = f1 / f10;
		if (f11 <= f1) {
			j = 0;
			return j;
		}
		f8 *= f11;
		if (f8 >= f) {
			j = 0;
			return j;
		}
		f11 *= f11;
		if (f11 <= f1) {
			j = 0;
			return j;
		}
		if (i == 0)
			return j;
		f2 = f11 + f8;
		f3 = f11 / f8;
		f4 = f11 / f11;
		f5 = f11 * f;
		f6 = f8 * f9;
		f7 = f6 * 0.0F;
		if (f2 == f2) {
			j = 0;
			return j;
		}
		if (f3 == f3) {
			j = 0;
			return j;
		}
		if (f4 == f4) {
			j = 0;
			return j;
		}
		if (f5 == f5) {
			j = 0;
			return j;
		}
		if (f6 == f6) {
			j = 0;
			return j;
		}
		if (f7 == f7) {
			j = 0;
			return j;
		} else {
			return j;
		}
	}
}
