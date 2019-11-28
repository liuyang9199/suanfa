package com.liuyang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/8 上午10:14
 */
public class ShaiziGailv {

    public static void main(String[] args) {
        ShaiziGailv main = new ShaiziGailv();
        main.doAction();
    }

    public void doAction() {
        int num = 2;
        //int total = 10;
        getTotal(num);
    }

    public void getTotal(int num) {
        if (num < 1) {
            return;
        }

        getTotalCore(num, 0);

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    Map<Integer, Integer> map = new HashMap<>();

    public void getTotalCore(int leftNum, int total) {
        if (leftNum == 0) {
            Integer count = map.get(total);
            if (count == null) {
                map.put(total, 1);
            } else {
                map.put(total, count + 1);
            }
            return;
        }

        for (int i = 1; i <= 6; i++) {
            getTotalCore(leftNum - 1, total + i);
        }
    }

}
