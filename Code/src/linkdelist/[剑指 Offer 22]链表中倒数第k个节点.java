package linkdelist;//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 184 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


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
    public ListNode getKthFromEnd(ListNode head, int k) {
       
       /*
        方法1:   创建一个list接收遍历的节点.
                最后遍历完 list(arr.size()-k) 就是倒数第K个节点.
                
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp);
            temp = temp.next;
        }
        
        return arr.get(arr.size() - k);*/
    
       
        
        
        /*
        方法2: 使用双指针
            先让behind 后移k步.
            然后让pre 和behind一起后移. 只要behind == null. 证明已经遍历到末尾.
            此时pre就是倒数第K个节点.
        */
        ListNode pre = head;
        ListNode behind = head;
        for (int i = 0; i < k; i++) {
            if (behind != null) {
                behind = behind.next;
            }
        }
        while (behind != null) {
            pre = pre.next;
            behind = behind.next;
        }
        return pre;
        
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
