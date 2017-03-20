package com.yyHaker.common.utils;

/**
 * Permutation
 * 标准的全排列问题
 * @author Le Yuan
 * @date 2017/3/19
 */
public class Permutation {
     static int count=0;//统计种数
     public static void main(String []args){
           char []chars="12345".toCharArray();
           getFullPermutation(chars,0,4);
           System.out.println("count="+count);
     }

    /**
     * 得到字符数组中元素的全排列
     * @param chars 字符数组
     * @param begin 开始索引
     * @param end    结束索引
     */
     public static void getFullPermutation(char []chars,int begin,int end){
          if(begin==end){
               count++;
              System.out.println(String.valueOf(chars));
          }else{
              for(int i=begin;i<=end;i++){
                  swap(chars,begin,i);
                  getFullPermutation(chars,begin+1,end);
                  swap(chars,begin,i);
              }
          }
     }

     public static void swap(char[]chars,int a,int b){
         char temp=chars[a];
         chars[a]=chars[b];
         chars[b]=temp;
     }
}
