//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 149 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int head = 0;
        int rear = chars.length - 1;
        while (head < rear) {
            if (!isVowels(chars[head])) {
                head++;
                continue;
            }
            if (!isVowels(chars[rear])) {
                rear--;
                continue;
            }
            char temp = chars[head];
            chars[head] = chars[rear];
            chars[rear] = temp;
            head++;
            rear--;
        }
        return new String(chars);
    }
    
    
    private boolean isVowels(char c) {
        char c1 = Character.toLowerCase(c);
        switch (c1) {
            case 'a':
            case 'e':
            case 'i':
            case 'u':
            case 'o':
                return true;
            default:
                return false;
        }
    }
    
}
//leetcode submit region end(Prohibit modification and deletion)




