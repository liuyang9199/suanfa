package com.liuyang.algorithm.leetcode;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/10/20 下午12:52
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1,2,3,4};

        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double d = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(d);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0D;
        }

        if (nums1 == null) {
            nums1 = new int[0];
        }

        if (nums2 == null) {
            nums2 = new int[0];
        }

        /*if (nums1 == null || nums1.length == 0) {
            return ((nums2.length & 1) != 0 )? nums2[nums2.length - 1] : (nums2[(nums2.length-2)/2] +
                    nums2[(nums2.length -
                    1)/2])
                    * 0.5D;
        }

        if (nums2 == null || nums2.length == 0) {
            return ((nums1.length & 1) != 0 )? nums1[nums1.length - 1] : (nums1[nums1.length-2] + nums1[nums1.length -
                    1])
                    * 0.5D;
        }*/

        int lena = nums1.length;
        int lenb = nums2.length;

        int k1 = (lena + lenb + 1) / 2;
        int k2 = (lena + lenb + 2) / 2;

        int left =  getKth(nums1, 0, lena -1, nums2, 0, lenb - 1, k1);
        int right = getKth(nums1, 0, lena -1, nums2, 0, lenb - 1, k2);
        return (left + right) * 0.5D;

    }

    public int getKth(int[] a, int starta, int enda, int[] b, int startb, int endb, int k) {

        int lena = enda - starta + 1;
        int lenb = endb - startb + 1;

        if (lena == 0) {
            return b[startb + k -1];
        }
        if (lenb == 0) {
            return a[starta + k -1];
        }

        if (k == 1) {
            return Math.min(a[starta], b[startb]);
        }

        int comparea = Math.min(starta + k/2 - 1, enda);
        int compareb = Math.min(startb + k/2 - 1, endb);

        if (a[comparea] < b[compareb]) {
            return getKth(a, comparea + 1, enda, b, startb, endb, k - (comparea - starta + 1));
        } else {
            return getKth(a, starta, enda, b, compareb + 1, endb, k - (compareb - startb + 1));
        }
    }

}
