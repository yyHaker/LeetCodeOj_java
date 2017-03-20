package com.yyHaker.practice.lanqiao0319;

/**
 * CombinedFormula
 *
 * @author Le Yuan
 * @date 2017/3/19
 */
public class CombinedFormula {
    static int count = 0;

    static void swap(char array[], int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static boolean check(char[] str){
        double[] num = new double[10];
        for(int i = 0; i < 9; ++i)
            num[i] = str[i]-'0';

        if(num[0]+num[1]*1.0/num[2]+(num[3]*100+num[4]*10+num[5])*1.0/(num[6]*100+num[7]*10+num[8]) == 10)
            return true;
        return false;
    }
      //a                    length
    //得到一个全排列
    static void permutation(char[] str, int a, int length){
        if(a == length){
            if(check(str)){
                ++count;
                System.out.println(String.valueOf(str));
            }
        }else{
            for(int i = a; i <= length; ++i){
                swap(str, i, a);
                permutation(str, a + 1, length);
                //回朔
                swap(str, i, a);
            }
        }
    }

    public static void main(String[] args) {
        char[] str = "123456789".toCharArray();
        permutation(str, 0, 8);
        System.out.println(count);

    }
}
