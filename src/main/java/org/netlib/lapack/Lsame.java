package org.netlib.lapack;

public final class Lsame
{
    public static boolean lsame(String s, String s1)
    {
        int i = 0;
        int j = 0;
        char c = '\0';
        boolean flag = false;
        flag = s.regionMatches(0, s1, 0, 1);
        if(flag)
            return flag;
        c = "Z".charAt(0);
        i = s.charAt(0);
        j = s1.charAt(0);
        if((c == 'Z') || (c == 'z'))
        {
            if((i >= 97) && (i <= 122))
                i -= 32;
            if((j >= 97) && (j <= 122))
                j -= 32;
        } else
        if((c == '\351') || (c == '\251'))
        {
            if((((i >= 129) && (i <= 137)) || ((i >= 145) && (i <= 153))) || ((i >= 162) && (i <= 169)))
                i += 64;
            if((((j >= 129) && (j <= 137)) || ((j >= 145) && (j <= 153))) || ((j >= 162) && (j <= 169)))
                j += 64;
        } else
        if((c == '\332') || (c == '\372'))
        {
            if((i >= 225) && (i <= 250))
                i -= 32;
            if((j >= 225) && (j <= 250))
                j -= 32;
        }
        flag = i == j;
        return flag;
    }
}
