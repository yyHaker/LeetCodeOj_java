package com.yyHaker.practice.lanqiao0318;

import java.awt.*;
import java.util.Scanner;

/**
 * MoveDistance
 *
 * @author Le Yuan
 * @date 2017/3/18
 */
public class MoveDistance {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
         int w=sc.nextInt();
         int m=sc.nextInt();
         int n=sc.nextInt();
         Point mPoint=getNumberPoint(m,w);
         Point nPoint=getNumberPoint(n,w);
          System.out.println("m:"+mPoint.x+" "+mPoint.y);
         System.out.println("n:"+nPoint.x+" "+nPoint.y);
         System.out.println(Math.abs(mPoint.x-nPoint.x)+Math.abs(mPoint.y-nPoint.y));
    }

    public static Point getNumberPoint(int num, int w){
         int i,j;
         int a=num/(2*w);
         int b=num%(2*w);
         if(b>w){
             i=2*a+2;
             j=2*w-b+1;
         }else{
             i=2*a+1;
             j=b;
         }
        return new Point(i,j);
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
