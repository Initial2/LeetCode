//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 367 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int last1 = num1.length() - 1;
        int last2 = num2.length() - 1;
        boolean flag = false;
        StringBuilder result = new StringBuilder();
        
        while (last1 >= 0 || last2 >= 0) {
            int ele1 = (last1 >= 0) ? num1.charAt(last1) - '0' : 0;
            int ele2 = (last2 >= 0) ? num2.charAt(last2) - '0' : 0;
            int cul = (flag) ? ele1 + ele2 + 1 : ele1 + ele2;
            flag = cul >= 10;
            last2--;
            last1--;
            result.append(cul % 10);
        }
        
        if (flag) {
            result.append(1);
        }
        
        return result.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
