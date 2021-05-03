package leetcode.editor.cn.array.easy;//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 488 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //动态规划算法
        //1.初始化三角形. 三角形每一行都用List<Integer>表示
        List<List<Integer>> triangle = new ArrayList<>();
        //开始一行一行创建
        for (int i = 0; i < numRows; ++i) {
            //初始化行
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                //把每行的第一个和最后一个置为1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    /*
                    如果不是第一个和最后一个.
                    就让它 =  上一行的前一个位置 + 上一行对应的位置
                     */
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            //然后把这一行添加进三角形
            triangle.add(row);
        }
        return triangle;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
