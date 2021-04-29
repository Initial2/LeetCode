package linkdelist;//编写一个函数，检查输入的链表是否是回文的。
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 58 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        if (head.next == null) {
            return true;
        }
        
        //先把链表中所有值,放到数组中
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        
        //建立双指针比较
        int start = 0;
        int last = arr.size() - 1;
        
        while (start < last) {
            if (arr.get(start).equals(arr.get(last))) {
                start++;
                last--;
            } else {
                return false;
            }
            
        }
        
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
