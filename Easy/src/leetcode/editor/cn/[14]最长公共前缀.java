//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1574 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //默认最长公共前缀为第一个字符串.
        String commonPrefix = strs[0];
        
        ////拿第一个字符串,分别和剩余的字符串比较
        for (int i = 1; i < strs.length; i++) {
            String str1 = strs[i];
            int index = 0;
            while (index < str1.length() && index < commonPrefix.length() && str1.charAt(index) == commonPrefix.charAt(index)) {
                index++;
            }
            
            //如果发现在比较中, 有两个字符串没有公共前缀,直接返回"".
            if (index == 0) {
                return null;
            } else {
                //否则就更新最长公共前缀.
                commonPrefix = commonPrefix.substring(0, index);
            }
            
        }
        
        return commonPrefix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
