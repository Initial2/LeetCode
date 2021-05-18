//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 493 👎 0


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //1.一次遍历
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
            
        }
        Collection<Integer> values = map.values();
    
        Iterator<Integer> iterator = values.iterator();
        int count ;
        if (iterator.hasNext()){
            count = iterator.next();
        }else{
            return false;
        }
        
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if (next != count){
                return false;
            }
        }
    
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
