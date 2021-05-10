//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设两个字符串均只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 145 👎 0


import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        //方法1： 统计ransom需要的字符个数。
        HashMap<Character, Integer> map = new HashMap<>(20);
        
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) + 1);
            } else {
                map.put(ransomNote.charAt(i), 1);
            }
            
        }
        
        for (int i = 0; i < magazine.length(); i++) {
            if (map.isEmpty()) {
                return true;
            }
            
            if (map.containsKey(magazine.charAt(i))) {
                if (map.get(magazine.charAt(i)).equals(1)) {
                    map.remove(magazine.charAt(i));
                } else {
                    map.put(magazine.charAt(i), map.get(magazine.charAt(i)) - 1);
                }
            }
        }
        
        
        return map.isEmpty();
        
        
        //方法2：
        /*ArrayList<Character> chars = new ArrayList<>();
        
        for (int i = 0; i < magazine.length(); i++) {
            chars.add(magazine.charAt(i));
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = 0;
            while(index < chars.size() && ransomNote.charAt(i) != chars.get(index)){
                index++;
            }
            if (index == chars.size()){
                return false;
            }
            chars.remove(index);
        }
        
        return true;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
