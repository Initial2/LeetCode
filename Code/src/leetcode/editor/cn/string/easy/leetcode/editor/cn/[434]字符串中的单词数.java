//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "   Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 
// 👍 85 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        int count = 0;
        
        /*
         *思路：
         *  如果该下标前一个是空格，或者是第一个字符， 并且该下标对应的字符不是空格.  那么有效单词就+1
         */
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1)  == ' ' ) &&  s.charAt(i) != ' '){
                count++;
            }
        
        }
        return count;
        
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
