import sys
from typing import List


class lab8:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # use dynamic programming
        matrix = [sys.maxsize] * (amount + 1)
        matrix[0] = 0

        for i in range(1, amount + 1):
            for coin in coins:
                if coin <= i:
                    #subtract index of matrix by value of current coin, add 1 to min
                    # value pointed to by index, representing current coin

                    matrix[i] = min(matrix[i], matrix[i - coin] + 1)

        if matrix[amount] == sys.maxsize:
            return -1
        return matrix[amount]

l8 = lab8()
# Test Case 1:
# Input: coins = [1,2,5], amount = 11
# Output: 3
# Explanation: 11 = 5 + 5 + 1
print(l8.coinChange([1,2,5],11))
# Test Case 2:
# Input: coins = [2], amount = 3
# Output: -1
print(l8.coinChange([2],3))
# Test Case 3:
# Input: coins = [1], amount = 0
# Output: 0
print(l8.coinChange([1],0))
