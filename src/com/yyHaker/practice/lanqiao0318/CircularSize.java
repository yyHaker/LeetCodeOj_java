package com.yyHaker.practice.lanqiao0318;

import java.util.Vector;

/**
 * CircularSize
 *
 * @author Le Yuan
 * @date 2017/3/18
 */
public class CircularSize {
    public static void main(String[] args){
        System.out.println(f(11,13));
    }
    public static int f(int n, int m)
    {
        n = n % m;
        Vector v = new Vector();
        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n==0) return 0;
            if(v.indexOf(n)>=0)  return v.size();
        }
    }
}
