package linkdelist;//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 67 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
         /*
        方法: 使用双指针
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
        return pre.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
