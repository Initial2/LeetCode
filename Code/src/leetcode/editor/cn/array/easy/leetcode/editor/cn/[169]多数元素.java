//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 974 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        //方法2: 使用投票算法
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
            }
            count += (candidate == nums[i]) ?  1 : -1;
        }
        return candidate;
        
        
        
        
        //方法1:使用哈希算法
        /*int times = (nums.length % 2 == 0) ? nums.length / 2 : nums.length / 2 + 1;
        HashMap<Integer, Integer> map = new HashMap<>(20);
        for (int i = 0; i < nums.length; i++) {
            
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                if (count == times) {
                    return nums[i];
                }
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
            
        }
        return nums[0];*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
