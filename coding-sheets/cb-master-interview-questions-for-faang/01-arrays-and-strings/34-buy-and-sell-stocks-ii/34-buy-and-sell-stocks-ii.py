class Solution(object):
  def maxProfit(self, prices):
    """
    :type prices: List[int]
    :rtype: int
    """
    ans = 0
    for i in range(1,len(prices)):
      ans += max(prices[i]-prices[i-1],0)
    return ans