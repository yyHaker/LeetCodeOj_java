package com.yyHaker.common.utils;

import java.util.Scanner;

/**
 * MazeProblem
 *深搜走迷宫算法
 *   判断是否能从迷宫的入口到达出口
 * 输入： 先输入两个整数表示迷宫的行数m和列数n，
 * 再输入口和出口的坐标，最后分m行输入迷宫，
 * 其中1表示墙，0表示空格每个数字之间都有空格。
 * 输出： 若能到达，则输出"Yes"，否则输出"No"，结果占一行。
 * @author Le Yuan
 * @date 2017/3/18
 * @type 搜索
 */
public class MazeProblem {
    //为了方便函数访问它，所以定义为类内全局变量
    static int num=0;
    static int minnum=0;
    static int Rownum,Colnum;
    static int Beginrow,Begincol,Endrow,Endcol;
    static int state;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            Rownum=sc.nextInt();//迷宫行数
            Colnum=sc.nextInt();//迷宫列数
            Beginrow=sc.nextInt();Begincol=sc.nextInt();//起点坐标
            Endrow=sc.nextInt();Endcol=sc.nextInt();//终点坐标
            state=0;//迷宫走通与否状态

            int[][] Arr = new int[Rownum][Colnum];//存储迷宫

            //将输入数据读入迷宫数组
            for(int i=0;i<Rownum;i++){
                for(int j=0;j<Colnum;j++){
                    Arr[i][j]=sc.nextInt();
                }
            }

            //开始走迷宫，标记开始走的一步（以及之后走的地方）为1（墙）
            //即不再回头走（回头走也没有意义的）
            Arr[Beginrow][Begincol]=1;
            //在这一步上查找下一个可以前进的地方，即开始归溯
            //这里为了不让数组变成全局变量（不太好初始化）
            //所以把数组作为参数传进去了
            search(Beginrow,Begincol,Arr);
            //一个迷宫搜索路径后的最终状态，起始点接通与否
            int step_num=Arr[Endrow][Endcol]-1;

            /*第一个问题：是否可以走通迷宫？*/
            if(state==1){
                System.out.println("1: Yes");
            }else{
                System.out.println("1: No");
            }

            /*第二个问题：共有多少种不重复的走法？*/
            if(state==1){
                System.out.println("2: "+num);
            }
        }
    }

    private static void search(int row, int col, int[][] Arr) {
        //第一步判断，是否当前已经走到终点，如果是，更新走通状态，返回
        if(row==Endrow && col==Endcol){
            state=1;
            num++;
        }
        //r-new row,c-new col
        int r,c;

        Arr[row][col]=1;//对可以走通的点进行标记

        //接下来开始上下左右尝试走了

        //上
        r=row-1;c=col;
        //如果路可以走通，则继续开始找新路
        if(canplace(r,c,Arr)) {
            Arr[r][c]=num+1;
            search(r,c,Arr);//深搜定义体现出来了，一条道走到黑就是这样~
        }
        //下
        r=row+1;c=col;
        if(canplace(r,c,Arr)){
            Arr[r][c]=num+1;
            search(r,c, Arr);
        }

        //左
        r=row;c=col-1;
        if(canplace(r,c,Arr)){
            Arr[r][c]=num+1;
            search(r,c, Arr);
        }

        //右
        r=row;c=col+1;
        if(canplace(r,c,Arr)){
            Arr[r][c]=num+1;
            search(r,c, Arr);
        }
    }

    /*本函数用于判断Arr(r,c)是否可以访问*/
    private static boolean canplace(int row, int col, int[][] Arr) {
        //首先，不能越界，四个条件
        if(row>=0 && col >=0 && row<Rownum && col<Colnum){
            //其次，该处可以通行
            if(Arr[row][col]==0)
                return true;
        }
        return false;
    }
}
