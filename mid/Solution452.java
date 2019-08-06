package com.LeetCode.mid;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少的箭引爆气球
 * 		精选题解
 * @author WeiFangLiang
 *
 */
public class Solution452 {
	public int findMinArrowShots(int[][] points) {
		int plen = points.length;
        if (plen < 2) {  //气球个数小于2
            return plen;
        }

        // 按照起点进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0]; //如果结果>0，就交换o1、02，即升序，若<0，就不交换，这样还是升序
                }
                return o1[1] - o2[1];
            }
        });

        // 最少的数量
        int minCount = 1;
        // 第 1 个区间的末尾，目前线段能够达到的最远位置
        int end = points[0][1];
        // 贪心法，基于上一个箭，记录当前能够射穿的所有的区间
        for (int i = 1; i < plen; i++) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                minCount++;
                end = points[i][1];
            }
        }
        return minCount;
    }
}
