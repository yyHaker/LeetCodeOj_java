package com.yyHaker.practice.lanqiao0318;

/**
 * AddToMultiply: 1+2+3+ ... + 49 = 1225  x 2015
 *
 * @author Le Yuan
 * @date 2017/3/18
 */
public class AddToMultiply {
    public static void main(String[]args){
         for(int i=1;i<=46;i++){
             for(int j=i+2;j<=48;j++){
                 if(calculate(i,j)==2015){
                     System.out.println("i="+i+",j="+j);
                 }
             }
         }
    }
    public static int calculate(int i,int j){
        int total=1225;
       //换i的代价
        total=total+i*(i+1)-(i+i+1);
        //换j的代价
        total=total+j*(j+1)-(j+j+1);
        return total;
    }

}
