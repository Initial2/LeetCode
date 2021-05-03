package leetcode.editor.cn.linkdelist.easy;//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= k <= 50 
// 
// Related Topics 链表 
// 👍 585 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
    public ListNode removeElements(ListNode head, int val) {
        //特殊情况[7,7,7,7] 要删除7.
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        if (head == null) {
            return null;
        }
        
        //到这里我们能保证head不是要删除的元素. 所以直接从head下一个开始
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
