//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1340 👎 0


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        方法1: 使用栈 或者 列表都行
            Stack<ListNode> stack = new Stack<ListNode>();
            ListNode temp = head;
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }
    
            ListNode deleteNode = null;
            for(int i = 0; i < n ; i++){
                deleteNode = stack.pop();
            }
    
            if(stack.size() == 0){
                return deleteNode.next;
            }
    
            ListNode pre = stack.pop();
            pre.next =  pre.next.next;
            return head;
            
         */
        
        
        /*
        方法2: 使用双指针. 在链表头部再添加一个元素,作为新头.
        所以pre 和 behind天生差一位
        pre时刻保持在要删除元素前一个位置.
         */
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        ListNode behind = head;
        //pre 和 behind 差距为 n+1
        for (int i = 0; i < n; i++) {
            behind = behind.next;
        }
        
        while (behind != null) {
            behind = behind.next;
            pre = pre.next;
        }
        
        pre.next = pre.next.next;
        return newHead.next;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
