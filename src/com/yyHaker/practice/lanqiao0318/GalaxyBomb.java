package com.yyHaker.practice.lanqiao0318;

import java.util.Calendar;

/**
 * GalaxyBomb:2014年11月9日放置，定时为1000天,什么时候爆炸？
 *
 * @author Le Yuan
 * @date 2017/3/18
 */
public class GalaxyBomb {
    public static void main(String []args){
        //System.out.println(1000-52-365-366);
        //System.out.println(61*3+31);
        Calendar c=Calendar.getInstance();
        c.set(2014,10,9);
        c.add(Calendar.DAY_OF_YEAR,1000);
        System.out.println(c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DATE));
    }
}
