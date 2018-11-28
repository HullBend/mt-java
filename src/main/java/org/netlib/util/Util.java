package org.netlib.util;

import java.util.Enumeration;
import java.util.Formatter;
import java.util.Vector;

public final class Util {
    public static double dsign(double d, double d1)
    {
        return d1 < 0.0D ? -Math.abs(d) : Math.abs(d);
    }
    public static int max(int i, int j, int k)
    {
        return Math.max(i <= j ? j : i, Math.max(j, k));
    }

    public static float max(float f, float f1, float f2)
    {
        return Math.max(f <= f1 ? f1 : f, Math.max(f1, f2));
    }

    public static double max(double d, double d1, double d2)
    {
        return Math.max(d <= d1 ? d1 : d, Math.max(d1, d2));
    }
    public static int min(int i, int j, int k)
    {
        return Math.min(i >= j ? j : i, Math.min(j, k));
    }

    public static float min(float f, float f1, float f2)
    {
        return Math.min(f >= f1 ? f1 : f, Math.min(f1, f2));
    }

    public static double min(double d, double d1, double d2)
    {
        return Math.min(d >= d1 ? d1 : d, Math.min(d1, d2));
    }
    public static double log10(double d)
    {
        return Math.log(d) / 2.30258509D;
    }

    public static float log10(float f)
    {
        return (float)(Math.log(f) / 2.30258509D);
    }
    public static int nint(float f)
    {
        return (int)(f < 0.0F ? f - 0.5D : f + 0.5D);
    }
    public static String stringInsert(String s, String s1, int i, int j)
    {
        String s2 = new String(s.substring(0, i - 1) + s1.substring(0, (j - i) + 1) + s.substring(j, s.length()));
        return s2;
    }

    public static String stringInsert(String s, String s1, int i)
    {
        return stringInsert(s, s1, i, i);
    }
//    public static void f77write(String s, Vector<?> vector)
//    {
//        if(s == null)
//        {
//            f77write(vector);
//            return;
//        }
//        try
//        {
//            Formatter formatter = new Formatter(s);
//            Vector vector1 = processVector(vector);
//            formatter.write(vector1, System.out);
//            System.out.println();
//        }
//        catch(Exception exception)
//        {
//            String s1 = exception.getMessage();
//            if(s1 != null)
//                System.out.println(s1);
//            else
//                System.out.println();
//        }
//    }
//
//    public static void f77write(Vector<?> vector)
//    {
//        Vector<?> vector1 = processVector(vector);
//        Enumeration<?> enumeration = vector1.elements();
//        if(enumeration.hasMoreElements())
//        {
//            Object obj = enumeration.nextElement();
//            if(obj instanceof String)
//                System.out.print(" ");
//            output_unformatted_element(obj);
//        }
//        for(; enumeration.hasMoreElements(); output_unformatted_element(enumeration.nextElement()));
//        System.out.println();
//    }
//
//    static Vector<?> processVector(Vector<?> vector)
//    {
//        Vector<?> vector1 = new Vector();
//        for(Enumeration<?> enumeration = vector.elements(); enumeration.hasMoreElements();)
//        {
//            Object obj = enumeration.nextElement();
//            if(obj instanceof ArraySpec)
//                vector1.addAll(((ArraySpec)obj).get_vec());
//            else
//                vector1.addElement(obj);
//        }
//
//        return vector1;
//    }
//
//    private static void output_unformatted_element(Object obj)
//    {
//        if(obj instanceof Boolean)
//        {
//            if(((Boolean)obj).booleanValue())
//                System.out.print(" T");
//            else
//                System.out.print(" F");
//        } else
//        if((obj instanceof Float) || (obj instanceof Double))
//            System.out.print("  " + obj);
//        else
//        if(obj instanceof String)
//            System.out.print(obj);
//        else
//            System.out.print(" " + obj);
//    }
}