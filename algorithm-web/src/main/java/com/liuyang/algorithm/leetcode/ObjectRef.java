package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/29 上午8:10
 */
public class ObjectRef {

    //基本类型的参数传递
    public static void testBasicType(int m) {
        System.out.println("m=" + m);//m=50
        m = 100;
        System.out.println("m=" + m);//m=100
    }
    //参数为对象，不改变引用的值 ？？？？？？
    public static void add(StringBuffer s) {
        s.append("_add");
    }
    //参数为对象，改变引用的值 ？？？？？
    public static void changeRef(StringBuffer s) {
        s = new StringBuffer("Java");
    }

    public static void main(String[] args) {
        int i = 50;
        testBasicType(i);
        System.out.println(i);//i=50
        StringBuffer sMain = new StringBuffer("init");
        System.out.println("sMain=" + sMain.toString());//sMain=init
        add(sMain);
        System.out.println("sMain=" + sMain.toString());//sMain=init_add
        changeRef(sMain);
        System.out.println("sMain=" + sMain.toString());//sMain=init_add
    }
}
