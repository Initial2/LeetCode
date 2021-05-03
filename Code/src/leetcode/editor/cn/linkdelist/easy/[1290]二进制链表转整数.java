package leetcode.editor.cn.linkdelist.easy;//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
// 请你返回该链表所表示数字的 十进制值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
// 
//
// 示例 2： 
//
// 输入：head = [0]
//输出：0
// 
//
// 示例 3： 
//
// 输入：head = [1]
//输出：1
// 
//
// 示例 4： 
//
// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
// 
//
// 示例 5： 
//
// 输入：head = [0,0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 链表不为空。 
// 链表的结点总数不超过 30。 
// 每个结点的值不是 0 就是 1。 
// 
// Related Topics 位运算 链表 
// 👍 80 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        if (head.next == null) {
            return head.val;
        }
        
        //把所有节点按次序加到list中
        ListNode temp = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        
        //获取权值.
        int weight = list.size();
        int result = 0;
        
        //开始计算
        for (int i = 0; i < list.size(); i++) {
            //首先获取每一个节点的值
            int val = list.get(i).val;
            if (val == 0) {
                weight--;
                continue;
            }
            result += Math.pow(2, --weight);
        }
        
        return result;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
