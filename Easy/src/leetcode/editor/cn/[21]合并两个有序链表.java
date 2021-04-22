//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1677 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * 解题思路:
 * 创建一个新链表result,存放结果
 * 创建两个指针, 分别指向这两个链表l1,l2.
 * <p>
 * 如果l1,val <= l2.val 就把l2放到l1后面.
 * 然后让l1后移一位,比较l1.next.val 和l2.val.
 * <p>
 * 如果l1,val > l2.val 就把l2放到l1前面.
 * 然后让l2后移一位,比较l2.next.val 和l1.val.
 * <p>
 * 如果有任何一个遍历到头了, 那么只需把result.next 指向那个还没有遍历完的链表即可.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //存放结果的链表
        ListNode resultHead = new ListNode();
        
        ListNode temp = resultHead;
        
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        
        //只要有一个链表遍历到头了就退出.
        while (l1Head != null && l2Head != null) {
            
            if (l1Head.val <= l2Head.val) {
                temp.next = l1Head;
                l1Head = l1Head.next;
            } else {
                temp.next = l2Head;
                l2Head = l2Head.next;
            }
            //每添加一个新节点, temp就后移到新节点位置.
            temp = temp.next;
            
        }
        
        //如果是l1遍历完了
        if (l1Head == null) {
            temp.next = l2Head;
        }
        
        //如果是l1遍历完了
        if (l2Head == null) {
            temp.next = l1Head;
        }
        
        
        return resultHead.next;
        
    }
    
    
    class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
