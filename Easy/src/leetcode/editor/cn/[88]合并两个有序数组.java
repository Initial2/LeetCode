//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 935 👎 0


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //方法1, 直接把两个数组进行合并,然后再排序.  哪种排序方法都行
        
        
        //方法2:  利用逆向双指针,倒序遍历
        int index1 = m - 1;
        int index2 = n - 1;
        int last = nums1.length - 1;
        //index1比index2大, 所以index2 < 0遍历结束
        while (index2 >= 0) {
            
            /*
             nums1[index1] < nums2[index2]  就把nums2[index2] 放到最后一位,
             nums1[index1] >=  nums2[index2]  就把nums1[index1] 放到最后一位,
             如果index1 < 0, 证明nums1已经全部遍历完了.  只需把nums2剩下的全部添加到nums1前面即可.
             */
            if (index1 < 0 || nums1[index1] < nums2[index2]) {
                nums1[last--] = nums2[index2--];
            } else {
                nums1[last--] = nums1[index1--];
            }
        }
        
    }
    
    
}
//leetcode submit region end(Prohibit modification and deletion)
