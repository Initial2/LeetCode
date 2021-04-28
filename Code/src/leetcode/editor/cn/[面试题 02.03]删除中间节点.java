//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。 
//
// 
//
// 示例： 
//
// 输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
// 
// Related Topics 链表 
// 👍 100 👎 0


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
    public void deleteNode(ListNode node) {
        //方法1:  把中间节点后面的节点全部前移一位.
        //然后temp.next.next == null 证明已经遍历到倒数第2位了.
        // 把倒数第1位的值复制过来.  然后让倒数第二位成为倒数第一位即可
        ListNode temp = node;
        while (temp.next != null) {
            if (temp.next.next == null) {
                temp.val = temp.next.val;
                temp.next = null;
                return;
            }
            temp.val = temp.next.val;
            temp = temp.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
