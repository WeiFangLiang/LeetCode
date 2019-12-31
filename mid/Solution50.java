package com.LeetCode.mid;
/**
 * x 的 n 次方
 * 		1、直接调用库函数（面试肯定不许）
 * 		2、傻乘法，挨个乘出来
 * 		3、分治：算出一半的结果y，再 y * y，需要分奇、偶
 * 		4、每一种递归解法，都要会写非递归版本
 * @author WeiFangLiang
 *
 */
public class Solution50 {
	//这是我写的，存在栈溢出问题。bug案例：x = 0.00001   n = 2147483647
	//这个 n 设的这么大，就是让你用分治递归的，而不是傻乘          而且没考虑 n<0 的情况
	public  double myPow1(double x, int n) {
        if(n < 2 ) return x;
        return x * myPow(x,--n); //傻乘
    }
	
	//分治递归,先定义一个法2的辅助函数
	private  double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);//先算一半
        if (n % 2 == 0) { //如果 n 是偶次幂
            return half * half;
        } else { //奇次幂
            return half * half * x;
        }
    }
	//法2  99.95%  72%
	public  double myPow(double x, int n) {
/**
 * 注意：
 * n = -n  是不能把 n 变为正数的！！，会死递归
 * 因为 int 最大值为2147483647，本次 n = -2147483648, -n之后会溢出，所以
 * n = -n 赋值失败，n还是负数，就此无限递归调用自己
 */
		long N = n;
		if(N < 0) { //如果是负次幂，转为正次幂的情况
			x = 1/x;
			N = -N;
		}
		return fastPow(x,N);
	}
}
