package leetcode.editor.cn.linkdelist.easy;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public int[] reversePrint(ListNode head) {
        
        
        //方法1,使用栈
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        
        //创建结果数组
        int[] ints = new int[stack.size()];
        
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop();
        }
        
        return ints;
        
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
