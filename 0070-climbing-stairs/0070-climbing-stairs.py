class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [-1] * (n+1)
        return self.helper(0, n, dp)

    def helper(self, currentLevel, n, dp):

        if currentLevel == n:
            return 1

        if currentLevel > n:
            return 0

        if dp[currentLevel] != -1:
            return dp[currentLevel]

        dp[currentLevel] = self.helper(currentLevel + 1, n, dp) + self.helper(currentLevel + 2, n, dp)

        return dp[currentLevel]