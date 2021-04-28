package leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2348 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class IsValid {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        
        char[] chars = s.toCharArray();
        Stack<Character> symbol = new Stack<>();
        //遍历给定字符串
        for (char aChar : chars) {
            //如果是左括号,就入栈
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                symbol.push(aChar);
            } else {
                //如果chars[i]是右括号, 就从栈中取出一个左括号,看看是否匹配
                //首先进行非空判断, 如果栈已经空了,就没必要再比较了,返回false即可.
                if (symbol.isEmpty()) {
                    return false;
                }
                char pop = symbol.pop();
                if (aChar != getMarch(pop)) {
                    return false;
                }
            }
            
        }
        //遍历完所有的字符以后,如果栈为空,证明给定的字符串是有效的括号
        return symbol.isEmpty();
        
    }
    
    
    private char getMarch(char c) {
        switch (c) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return c;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
