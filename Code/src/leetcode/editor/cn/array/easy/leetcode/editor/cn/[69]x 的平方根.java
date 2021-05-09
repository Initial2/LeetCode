package leetcode.editor.cn.array.easy.leetcode.editor.cn;//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 666 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        
        if (x == 0) {
            return 0;
        }
        
        /*方法1: 求x的平方根, 为根号x.
            就把根号x转换成以e为底的对数, 就是Math.log(x). 然后*0.5 就是二分之一次方.
            最后用exp方法求出结果即可.
            算出来的结果可能会很长,用long接收.

        long ans = (long) Math.exp(Math.log(x) * 0.5);
        return (int)((ans + 1) * (ans + 1) <= x ? ans + 1 : ans);
        
        */
        
        /*
          方法2:
          使用二分查找法.
            查找范围0-x;
         */
        int left = 0;
        int right = x;
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            /*
            因为可能出现一种情况:
                例: x=5  那么2*2 < 5 但是 3*3>5.
                所以每次比x小都记录下来. 可能他就是结果.
             */
            if ((long) mid * mid <= x) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
