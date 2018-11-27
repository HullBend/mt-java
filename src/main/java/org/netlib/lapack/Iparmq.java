package org.netlib.lapack;

import org.netlib.util.Util;

public final class Iparmq {
	public static int iparmq(int i, String s, String s1, int j, int k, int l,
			int i1) {
		int j1 = 0;
		int k1 = 0;
		int l1 = 0;
		if (((i == 15) || (i == 13)) || (i == 16)) {
			j1 = (l - k) + 1;
			k1 = 2;
			if (j1 >= 30)
				k1 = 4;
			if (j1 >= 60)
				k1 = 10;
			if (j1 >= 150)
				k1 = Math.max(
						10,
						j1
								/ Util.nint((float) Math.log(j1)
										/ (float) Math.log(2.0F)));
			if (j1 >= 590)
				k1 = 64;
			if (j1 >= 3000)
				k1 = 128;
			if (j1 >= 6000)
				k1 = 256;
			k1 = Math.max(2, k1 - k1 % 2);
		}
		if (i == 12)
			l1 = 75;
		else if (i == 14)
			l1 = 14;
		else if (i == 15)
			l1 = k1;
		else if (i == 13) {
			if (j1 <= 500)
				l1 = k1;
			else
				l1 = (3 * k1) / 2;
		} else if (i == 16) {
			l1 = 0;
			if (k1 >= 14)
				l1 = 1;
			if (k1 >= 14)
				l1 = 2;
		} else {
			l1 = -1;
		}
		return l1;
	}
}
