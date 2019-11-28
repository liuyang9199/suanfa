package com.liuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/3 上午9:58
 */
public class MapAll {

    public static void main(String[] args) {
        MapAll mapAll = new MapAll();
        Map<String,String> map = new HashMap<>(8);
        map.put("aaa", "aaa1");
        map.put("bbb", "bbb1");
        map.put("ccc", "ccc1");

        mapAll.method4(map);

    }

    public void method1(Map<String,String> map) {
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void method2(Map<String,String> map) {
        for (String s : map.keySet()) {
            System.out.println(s);
        }

        for (String s : map.values()) {
            System.out.println(s);
        }
    }

    public void method3(Map<String,String> map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> e = (Map.Entry<String, String>) iterator.next();
            System.out.println(e.getKey());
            System.out.println(e.getValue());

        }
    }

    public void method4(Map<String,String> map) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
