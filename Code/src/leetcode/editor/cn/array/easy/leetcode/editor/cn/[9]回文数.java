package leetcode.editor.cn.array.easy.leetcode.editor.cn;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 45678
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1470 👎 0


/**
 * 解题思路:
 * 类似于整数反转, 不断地翻转x 看看result是否和x相等,
 * 判断相等的条件:
 * result == x || result == x / 10
 * x是偶数位, 就用result == x判断
 * 例:  4554   45 == 45
 * x是奇数位,就用result == x / 10判断
 * 例:  45554   45 ?= 455/10
 * 判断过后,如果不想等,再更新x.
 * <p>
 * <p>
 * <p>
 * 结果:
 * 执行用时：10 ms,在所有 Java 提交中击败了72.42%的用户.
 * 内存消耗：38 MB, 在所有 Java 提交中击败了35.64%的用户
 */
class IsPalindrome {
    public boolean isPalindrome(int x) {
        //首先排除特殊情况
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        
        //开始反转x
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result == x || result == x / 10) {
                return true;
            }
            x = x / 10;
            
        }
        return false;
        
    }
}

