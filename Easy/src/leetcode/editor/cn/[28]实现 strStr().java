//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 875 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 解题思路:
 * 使用KMP算法
 */
class Solution {
    public int strStr(String haystack, String needle) {
        //1.首先排除特殊情况
        if (needle.length() == 0) {
            return 0;
        }
        
        int[] march = getMarch(needle);
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = march[j - 1];
            }
            
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            
            if (j == needle.length()) {
                return i - j + 1;
            }
            
        }
        
        return 0;
        
        
    }
    
    /**
     * 获取needle字符串对应的部分匹配表
     *
     * @param needle 需要获取对应的部分匹配表的字符串
     * @return 返回needle字符串对应的部分匹配表
     */
    private int[] getMarch(String needle) {
        
        int[] march = new int[needle.length()];
        
        if (march.length == 1) {
            return march;
        }
        
        for (int i = 1, j = 0; i < needle.length(); i++) {
            //如果不匹配,就让j回溯到上一个匹配的位置.
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = march[j - 1];
            }
            
            //如果匹配,部分匹配值+1
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            
            //更新部分匹配表
            march[i] = j;
        }
        
        return march;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
