package leetcode.editor.cn.array.easy.leetcode.editor.cn;
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 602 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    public String addBinary(String a, String b) {
        //获取它俩最后一位索引
        int aLastIndex = a.length() - 1;
        int bLastIndex = b.length() - 1;
        
        StringBuilder result = new StringBuilder();
        
        //标记是否进位
        int flag = 0;
        
        //当其中任何一个字符串遍历完,就退出
        while (aLastIndex >= 0 && bLastIndex >= 0) {
            //分别获取对应位置的数值
            int i = Integer.parseInt(String.valueOf(a.charAt(aLastIndex--)));
            int j = Integer.parseInt(String.valueOf(b.charAt(bLastIndex--)));
            
            //添加这一位的计算结果结果
            int num = (i + j + flag) % 2;
            result.append(num);
            
            //如果(i + j + flag) < 2 不进位, flag=0;
            if ((i + j + flag) < 2) {
                flag = 0;
            } else {
                flag = 1;
            }
            
        }
        
        
        if (aLastIndex >= 0) {
            //a还没遍历完,继续便利a
            while (aLastIndex >= 0) {
                int i = Integer.parseInt(String.valueOf(a.charAt(aLastIndex--)));
                int num = (i + flag) % 2;
                result.append(num);
                if (i + flag < 2) {
                    flag = 0;
                } else {
                    flag = 1;
                }
                
            }
            
            
        }
        
        if (bLastIndex >= 0) {
            //b没遍历完同理
            while (bLastIndex >= 0) {
                int j = Integer.parseInt(String.valueOf(b.charAt(bLastIndex--)));
                int num = (j + flag) % 2;
                result.append(num);
                if (j + flag < 2) {
                    flag = 0;
                } else {
                    flag = 1;
                }
            }
            
            
        }
        
        //如果两个都遍历完, flag=1, 证明第一位运算也发生了进位.
        //再在头部拼接一个1即可.
        if (flag == 1) {
            result.append("1");
        }
        
        return result.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
