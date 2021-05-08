//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 104 
// 0 <= prices[i] <= 104 
// 
// Related Topics 贪心算法 数组 
// 👍 1208 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //从头开始遍历。
        //最大收益
        int maxProfit = 0;
        //最低购入价
        int minBuyPrice = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            //如果之后价格比之前购入价低，更新购入价
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
                continue;
            }
            /*如果后续出售价格大于之前出售价格. 就要分情况
            情况1:　当前ｉ没到末尾，后续的出售价格比当前ｉ低．那么就卖出股票，更新收益．　重设购入价为默认值．
            情况2：　当前ｉ已经到结尾了，　那么就直接卖了即可．　
            */
            if (prices[i] > minBuyPrice && (i + 1 == prices.length || prices[i + 1] <= prices[i])) {
                maxProfit += prices[i] - minBuyPrice;
                minBuyPrice = Integer.MAX_VALUE;
            }
            
        }
        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
