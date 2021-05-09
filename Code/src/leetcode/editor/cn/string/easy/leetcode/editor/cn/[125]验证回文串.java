//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 378 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //使用双指针.
        String s1 = s.toUpperCase();
        int head = 0;
        int rear = s1.length() - 1;
        while (head < rear) {
            if (!Character.isLetterOrDigit(s1.charAt(head))) {
                head++;
                continue;
            }
            if (!Character.isLetterOrDigit(s1.charAt(rear))) {
                rear--;
                continue;
            }
            if (s1.charAt(head) == s1.charAt(rear)) {
                head++;
                rear--;
            } else {
                return false;
            }
            
        }
        
        return true;
        
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
