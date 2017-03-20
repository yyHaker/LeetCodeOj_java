package com.yyHaker.practice.lanqiao0318;

/**
 * BearEatWalnut
 *
 * @author Le Yuan
 * @date 2017/3/18
 */
public class BearEatWalnut {
    public static void main(String []args){
         int n=1543;
         int abandon=0;
        while(n>=1){
            if(n%2==0){
                n=n/2;
            }else{
                n--;
                abandon++;
                n=n/2;
            }
        }
        System.out.println(abandon);
    }

}
