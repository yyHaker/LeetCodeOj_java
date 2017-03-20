package com.yyHaker.common.utils;

/**
 * CardsProblem
 * 深搜：13种扑克牌，每种扑克牌有4张。从中取13张，共有多少种？
 *
 * 【深搜的基本思路】
 *      main()函数中：先确定第一步，进行初始化。初始化数组、方向数组（如果有）、起始点位置等。
 * 然后进行search()
 *
 * search()函数中
 * 加上方向增量，形成新的坐标。
 * 循环内：
 * ① 先判断（是否出界，是否已经走过，是否……）
 * ② 给值
 * ③ 走向新的坐标
 * ④ 判断是否到了终点
 * ⑤ 如果没有，则search下一层
 * ⑥ 回溯回来，则回复未走标志（因为如果路能走通，是不会回来的）
 * @author Le Yuan
 * @date 2017/3/18
 * @type 搜索
 */

public class CardsProblem {
    //全局变量
    static int[] save=new int[14];//拿的13张牌
    static int[] rest=new int[14];//13种牌的对应剩下数量
    static int num=0; //统计种数
    public static void main(String[] args) {
        for(int i=1;i<14;i++){
            rest[i]=4;
        }
        search(1);

        System.out.println(num);
    }
    //x表示拿的牌的张数，i表示第几种牌
    private static void search(int x) {
        // TODO Auto-generated method stub
        for(int i=1;i<=13;i++){
            if(check(i, x)){      //①先判断（是否出界，是否已经走过，是否……）
                save[x]=i;  //② 给值 ③ 走向新的坐标
                if(x==13) {//④ 判断是否到了终点
                    output();
                } else{
                    rest[i]--;
                    search(x+1);    //⑤ 如果没有，则search下一层
                    rest[i]++;  //⑥ 回溯回来，则回复未走标志（因为如果路能走通，是不会回来的）
                    save[x]=0;
                }
            }
        }
    }

    private static boolean check(int i,int x) {
        if(rest[i]>0 && i>=save[x-1]) //i>=save[x-1]是必要的剪枝操作，保证后一个数大于等于前一个数
            return true;
        return false;
    }

    private static void output() {
        num++;
    }
}
