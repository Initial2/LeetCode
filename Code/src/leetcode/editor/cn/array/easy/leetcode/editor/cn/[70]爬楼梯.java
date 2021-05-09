package leetcode.editor.cn.array.easy.leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1626 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        /*
        方法2: 使用动态规划
            同样也是根据斐波那契数列,
            每走一步就更新有几种走法
         */
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i < n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        
        return steps[n];
    }
    
    
    public int climbStairs(int n) {
           /*
            方法1: 使用递归
            此题目其实就是一个斐波那契数列
            注意:
                 如果不优化, 时间复杂度为O(n*n) 非常慢
                 所以需要优化, 每次运算过后,把结果记下来.
                 下次就不用运算了.
         */
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
        
    }
    
    
    private int climbStairsMemo(int n, int[] memo) {
        //走到n这个台阶有几种,如果memo[n] > 0, 证明前面已经计算过了,不需要再计算了.
        if (memo[n] > 0) {
            return memo[n];
        }
        
        //递归终止条件. 已经到第一层或者第二层了.
        if (n == 1) {
            memo[n] = 1;
        } else if (n == 2) {
            memo[n] = 2;
        } else {
            //还没到就继续算
            return memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }
        
        return memo[n];
        
    }
//leetcode submit region end(Prohibit modification and deletion)
}