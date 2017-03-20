package com.yyHaker.practice.lanqiao0318;

import java.util.HashSet;
import java.util.Set;

/**
 * NineNumber
 *
 * @author Le Yuan
 * @date 2017/3/18
 */
public class NineNumber {
    public static void main(String []args){
        int a,b,c;
        for(a=123;a<=329;a++){
            b=2*a;
            c=3*a;
            if(isMeetCondition(a,b,c)){
                System.out.println("a="+a);
            }
        }
    }
    public static Set<Integer> getEveryBit(int num){
        HashSet<Integer> hashSet=new HashSet<>();
        int ge=num%10;
        int shi=(num%100)/10;
        int bai=num/100;
        hashSet.add(ge);
        hashSet.add(shi);
        hashSet.add(bai);
        return hashSet;
    }
    public static Boolean isMeetCondition(int a,int b,int c){
        HashSet<Integer> aSet=(HashSet<Integer>)getEveryBit(a);
        HashSet<Integer> bSet=(HashSet<Integer>)getEveryBit(b);
        HashSet<Integer> cSet=(HashSet<Integer>)getEveryBit(c);
        aSet.addAll(bSet);
        aSet.addAll(cSet);
        for(int i=1;i<=9;i++){
            if(!aSet.contains(i)){
                return false;
            }
        }
        return true;

    }
}

/**
 * 另外一种做法，或许在某些情况下会很快
 */
/*
 class Main3 {
    static  int[] a=new int[10];
    public static void main(String[] args) {

        int A,B,C;
        for(int k=123;k<=329;k++){
            init();
            A=k;
            if(check(A)){
                B=2*A;
                if(check(B)){
                    C=3*A;
                    if(check(C)){
                        System.out.println(A);
                    }
                }
            }
        }
    }

    private static boolean check(int A) {
        int bai=A/100;
        int shi=A%100/10;
        int ge=A%10;
        if(bai!=shi && shi!=ge && bai!=ge && a[bai]>0 && a[shi]>0 && a[ge]>0){
            a[bai]--;
            a[shi]--;
            a[ge]--;
            return true;
        }
        return false;
    }

    private static void init(){
        for(int i=1;i<=9;i++){
            a[i]=1;
        }
    }
}  */
