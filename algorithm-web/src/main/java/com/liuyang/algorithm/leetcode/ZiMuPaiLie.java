package com.liuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/3 上午10:11
 */
public class ZiMuPaiLie {

    public static void main(String[] args) {
        ZiMuPaiLie ziMuPaiLie = new ZiMuPaiLie();
        List<String> list = ziMuPaiLie.paiLie("abc");
        for (String s : list) {
            System.out.println(s);
        }
    }

    List<String> list = new ArrayList<>();
    int len = 0;
    boolean[] bs;
    Map<String, String> map = new HashMap<>(32);

    public List paiLie(String s) {
        if (s == null || s.equals("") ) return list;

        len = s.length();
        bs = new boolean[len];

        paiLieCore(s, "");


        for (Map.Entry<String,String> e : map.entrySet()) {
            list.add(e.getKey());
        }

        return list;


    }

    public void paiLieCore(String s, String curr) {

        if (curr.length() == len) {
            if (map.get(curr) == null) {
                map.put(curr, curr);
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            if (bs[i] == true) {
                continue;
            }
            bs[i] = true;
            String curr1 = curr + s.substring(i , i+1);
            paiLieCore(s, curr1);
            bs[i] = false;
        }
    }
}
