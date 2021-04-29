package linkdelist;//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 链表 
// 👍 1711 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       /*
       方式1: 使用栈
        Stack<ListNode> stack =new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        ListNode result = new ListNode();
        temp = result;
        while(stack.size() > 0){
            temp.next = stack.pop();
            temp = temp.next;
        }
        //最后一定要让temp.next = null. 否则会构成环形链表,
        temp.next = null;
        return result.next;*/
        
        
        //方式2: 使用迭代.
        ListNode pre = null;
        ListNode behind = head;
        
        while (behind != null) {
            //借助中间变量, 改变指向顺序.
            ListNode temp = behind;
            behind = behind.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
