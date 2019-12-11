/**
 * com.tydic.commons.utils.Md5.java
 */
package com.chinauicom.research.commons.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

 /**
 * @file  Md5.java
 * @author weishaojia(viscar)
 * @version 0.1
 * @todo MD5加密功能
 * Copyright(C), 2013-2014
 *			Guangzhou Sunrise Electronics Development Co., Ltd.
 * History
 *   	1. Date: 2013-4-18
 *      	Author: weishaojia(viscar)
 *      	Modification: this file was created
 *   	2. ...
 */
public class Md5 {
	 private static String a(byte abyte0[])
	    {
	        StringBuffer stringbuffer = new StringBuffer(2 * abyte0.length);
	        for(int i = 0; i < abyte0.length; i++)
	        {
	            int j = (abyte0[i] & 0xf0) >> 4;
	            int k = abyte0[i] & 0xf;
	            stringbuffer.append(new Character((char)(j <= 9 ? 48 + j : (97 + j) - 10)));
	            stringbuffer.append(new Character((char)(k <= 9 ? 48 + k : (97 + k) - 10)));
	        }

	        return stringbuffer.toString();
	    }

	    private final int a(int i, int j, int k)
	    {
	        return i & j | ~i & k;
	    }

	    private final int b(int i, int j, int k)
	    {
	        return i & k | j & ~k;
	    }

	    private final int c(int i, int j, int k)
	    {
	        return i ^ j ^ k;
	    }

	    private final int d(int i, int j, int k)
	    {
	        return j ^ (i | ~k);
	    }

	    private final int a(int i, int j)
	    {
	        return i << j | i >>> 32 - j;
	    }

	    private final int a(int i, int j, int k, int l, int i1, int j1, int k1)
	    {
	        i += a(j, k, l) + i1 + k1;
	        return i = (i = a(i, j1)) + j;
	    }

	    private final int b(int i, int j, int k, int l, int i1, int j1, int k1)
	    {
	        i += b(j, k, l) + i1 + k1;
	        return i = (i = a(i, j1)) + j;
	    }

	    private final int c(int i, int j, int k, int l, int i1, int j1, int k1)
	    {
	        i += c(j, k, l) + i1 + k1;
	        return i = (i = a(i, j1)) + j;
	    }

	    private final int d(int i, int j, int k, int l, int i1, int j1, int k1)
	    {
	        i += d(j, k, l) + i1 + k1;
	        return i = (i = a(i, j1)) + j;
	    }

	    private final void a(int ai[], byte abyte0[], int i, int j)
	    {
	        int k = 0;
	        for(int l = 0; l < j; l += 4)
	        {
	            ai[k] = abyte0[i + l] & 0xff | (abyte0[i + l + 1] & 0xff) << 8 | (abyte0[i + l + 2] & 0xff) << 16 | (abyte0[i + l + 3] & 0xff) << 24;
	            k++;
	        }

	    }

	    private final void a(byte abyte0[], int i)
	    {
	        int j = d[0];
	        int k = d[1];
	        int l = d[2];
	        int i1 = d[3];
	        int ai[] = new int[16];
	        a(ai, abyte0, i, 64);
	        j = a(j, k, l, i1, ai[0], 7, 0xd76aa478);
	        i1 = a(i1, j, k, l, ai[1], 12, 0xe8c7b756);
	        l = a(l, i1, j, k, ai[2], 17, 0x242070db);
	        k = a(k, l, i1, j, ai[3], 22, 0xc1bdceee);
	        j = a(j, k, l, i1, ai[4], 7, 0xf57c0faf);
	        i1 = a(i1, j, k, l, ai[5], 12, 0x4787c62a);
	        l = a(l, i1, j, k, ai[6], 17, 0xa8304613);
	        k = a(k, l, i1, j, ai[7], 22, 0xfd469501);
	        j = a(j, k, l, i1, ai[8], 7, 0x698098d8);
	        i1 = a(i1, j, k, l, ai[9], 12, 0x8b44f7af);
	        l = a(l, i1, j, k, ai[10], 17, -42063);
	        k = a(k, l, i1, j, ai[11], 22, 0x895cd7be);
	        j = a(j, k, l, i1, ai[12], 7, 0x6b901122);
	        i1 = a(i1, j, k, l, ai[13], 12, 0xfd987193);
	        l = a(l, i1, j, k, ai[14], 17, 0xa679438e);
	        k = a(k, l, i1, j, ai[15], 22, 0x49b40821);
	        j = b(j, k, l, i1, ai[1], 5, 0xf61e2562);
	        i1 = b(i1, j, k, l, ai[6], 9, 0xc040b340);
	        l = b(l, i1, j, k, ai[11], 14, 0x265e5a51);
	        k = b(k, l, i1, j, ai[0], 20, 0xe9b6c7aa);
	        j = b(j, k, l, i1, ai[5], 5, 0xd62f105d);
	        i1 = b(i1, j, k, l, ai[10], 9, 0x2441453);
	        l = b(l, i1, j, k, ai[15], 14, 0xd8a1e681);
	        k = b(k, l, i1, j, ai[4], 20, 0xe7d3fbc8);
	        j = b(j, k, l, i1, ai[9], 5, 0x21e1cde6);
	        i1 = b(i1, j, k, l, ai[14], 9, 0xc33707d6);
	        l = b(l, i1, j, k, ai[3], 14, 0xf4d50d87);
	        k = b(k, l, i1, j, ai[8], 20, 0x455a14ed);
	        j = b(j, k, l, i1, ai[13], 5, 0xa9e3e905);
	        i1 = b(i1, j, k, l, ai[2], 9, 0xfcefa3f8);
	        l = b(l, i1, j, k, ai[7], 14, 0x676f02d9);
	        k = b(k, l, i1, j, ai[12], 20, 0x8d2a4c8a);
	        j = c(j, k, l, i1, ai[5], 4, 0xfffa3942);
	        i1 = c(i1, j, k, l, ai[8], 11, 0x8771f681);
	        l = c(l, i1, j, k, ai[11], 16, 0x6d9d6122);
	        k = c(k, l, i1, j, ai[14], 23, 0xfde5380c);
	        j = c(j, k, l, i1, ai[1], 4, 0xa4beea44);
	        i1 = c(i1, j, k, l, ai[4], 11, 0x4bdecfa9);
	        l = c(l, i1, j, k, ai[7], 16, 0xf6bb4b60);
	        k = c(k, l, i1, j, ai[10], 23, 0xbebfbc70);
	        j = c(j, k, l, i1, ai[13], 4, 0x289b7ec6);
	        i1 = c(i1, j, k, l, ai[0], 11, 0xeaa127fa);
	        l = c(l, i1, j, k, ai[3], 16, 0xd4ef3085);
	        k = c(k, l, i1, j, ai[6], 23, 0x4881d05);
	        j = c(j, k, l, i1, ai[9], 4, 0xd9d4d039);
	        i1 = c(i1, j, k, l, ai[12], 11, 0xe6db99e5);
	        l = c(l, i1, j, k, ai[15], 16, 0x1fa27cf8);
	        k = c(k, l, i1, j, ai[2], 23, 0xc4ac5665);
	        j = d(j, k, l, i1, ai[0], 6, 0xf4292244);
	        i1 = d(i1, j, k, l, ai[7], 10, 0x432aff97);
	        l = d(l, i1, j, k, ai[14], 15, 0xab9423a7);
	        k = d(k, l, i1, j, ai[5], 21, 0xfc93a039);
	        j = d(j, k, l, i1, ai[12], 6, 0x655b59c3);
	        i1 = d(i1, j, k, l, ai[3], 10, 0x8f0ccc92);
	        l = d(l, i1, j, k, ai[10], 15, 0xffeff47d);
	        k = d(k, l, i1, j, ai[1], 21, 0x85845dd1);
	        j = d(j, k, l, i1, ai[8], 6, 0x6fa87e4f);
	        i1 = d(i1, j, k, l, ai[15], 10, 0xfe2ce6e0);
	        l = d(l, i1, j, k, ai[6], 15, 0xa3014314);
	        k = d(k, l, i1, j, ai[13], 21, 0x4e0811a1);
	        j = d(j, k, l, i1, ai[4], 6, 0xf7537e82);
	        i1 = d(i1, j, k, l, ai[11], 10, 0xbd3af235);
	        l = d(l, i1, j, k, ai[2], 15, 0x2ad7d2bb);
	        k = d(k, l, i1, j, ai[9], 21, 0xeb86d391);
	        d[0] += j;
	        d[1] += k;
	        d[2] += l;
	        d[3] += i1;
	    }

	    private final void b(byte abyte0[], int i)
	    {
	        int j = (int)(e >> 3) & 0x3f;
	        e += i << 3;
	        int k = 64 - j;
	        int l = 0;
	        if(i >= k)
	        {
	            System.arraycopy(abyte0, 0, f, j, k);
	            a(f, 0);
	            for(l = k; l + 63 < i; l += 64)
	                a(abyte0, l);

	            j = 0;
	        } else
	        {
	            l = 0;
	        }
	        System.arraycopy(abyte0, l, f, j, i - l);
	    }

	    private byte[] a()
	    {
	        byte abyte0[] = new byte[8];
	        for(int i = 0; i < 8; i++)
	            abyte0[i] = (byte)(int)(e >>> i * 8 & 255L);

	        int j;
	        int k = (j = (int)(e >> 3) & 0x3f) >= 56 ? 120 - j : 56 - j;
	        b(a, k);
	        b(abyte0, 8);
	        return a(d, 16);
	    }

	    private byte[] a(int ai[], int i)
	    {
	        byte abyte0[] = new byte[i];
	        int j = 0;
	        for(int k = 0; k < i; k += 4)
	        {
	            abyte0[k] = (byte)(ai[j] & 0xff);
	            abyte0[k + 1] = (byte)(ai[j] >> 8 & 0xff);
	            abyte0[k + 2] = (byte)(ai[j] >> 16 & 0xff);
	            abyte0[k + 3] = (byte)(ai[j] >> 24 & 0xff);
	            j++;
	        }

	        return abyte0;
	    }

	    public byte[] getDigest()
	        throws IOException
	    {
	        byte abyte0[] = new byte[1024];
	        int i = 0;
	        if(g != null)
	            return g;
	        while((i = b.read(abyte0)) > 0) 
	            b(abyte0, i);
	        g = a();
	        return g;
	    }

	    public byte[] processString() throws IOException
	    {
	        if(!c)
	            throw new RuntimeException(getClass().getName() + "[processString]" + " not a string.");
	        return this.getDigest();
	    }

	    public String getStringDigest()
	    {
	        if(g == null)
	            throw new RuntimeException(getClass().getName() + "[getStringDigest]" + ": called before processing.");
	        else
	            return a(g);
	    }

	    public Md5(String s, String s1)
	    {
	        b = null;
	        c = false;
	        d = null;
	        e = 0L;
	        f = null;
	        g = null;
	        byte abyte0[] = null;
	        try
	        {
	            abyte0 = s.getBytes(s1);
	        }
	        catch(UnsupportedEncodingException _ex)
	        {
	            throw new RuntimeException("no " + s1 + " encoding!!!");
	        }
	        c = true;
	        b = new ByteArrayInputStream(abyte0);
	        d = new int[4];
	        f = new byte[64];
	        e = 0L;
	        d[0] = 0x67452301;
	        d[1] = 0xefcdab89;
	        d[2] = 0x98badcfe;
	        d[3] = 0x10325476;
	    }

	    public Md5(String s)
	    {
	        this(s, "UTF8");
	    }

	    public Md5(InputStream inputstream)
	    {
	        b = null;
	        c = false;
	        d = null;
	        e = 0L;
	        f = null;
	        g = null;
	        c = false;
	        b = inputstream;
	        d = new int[4];
	        f = new byte[64];
	        e = 0L;
	        d[0] = 0x67452301;
	        d[1] = 0xefcdab89;
	        d[2] = 0x98badcfe;
	        d[3] = 0x10325476;
	    }

	    public static void main(String args[])
	        throws IOException
	    {
	        //if(args.length != 1)
	        //{
	           // System.out.println("Md5 <file>");
	            //System.exit(1);
	        //}
//	        Md5 md5;
//	        byte abyte0[] = (md5 = new Md5(new FileInputStream(new File("c:\\ok6.txt")))).getDigest();
//	        System.out.println(a(abyte0));
	    	//Md5 md5=new Md5("123456");
	    	System.out.println(Md5.En("123456"));
	    }
	    
	    public static String En(String s) throws IOException{
	    	Md5 md5=new Md5(s);
	    	return Md5.a(md5.getDigest());
	    }

	    private static byte a[] = {
	        -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
	        0, 0, 0, 0
	    };
	    private InputStream b;
	    private boolean c;
	    private int d[];
	    private long e;
	    private byte f[];
	    private byte g[];
}
