package leetcode.editor.cn.array.easy.leetcode.editor.cn;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 677 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        
        /*
        思路:
           
            倒序遍历digits. 如果发现最后一位为9. 需要考虑进位的操作.就把它置为0(模拟已经进位),接着判断前一位.
            如果while循环结束.
            有两种可能:
                1. lastIndex没有到头,也就是digits数组中不是全部都是9.
                   那么解决方法就是digits[lastIndex]+1即可.
                   然后返回.
                2. 如果lastIndex < 0 证明数组中元素全是9.
                    那么就创建一个新的数组,第一位改成1,其余为都是0.
                    新数组长度是原来数组长度+1.
                    然后返回新数组.
                
         */
        
        int lastIndex = digits.length - 1;
        while (lastIndex >= 0 && digits[lastIndex] == 9) {
            digits[lastIndex] = 0;
            lastIndex--;
        }
        
        if (lastIndex < 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        
        digits[lastIndex] = digits[lastIndex] + 1;
        return digits;
        
    }
    
    
}
//leetcode submit region end(Prohibit modification and deletion)
