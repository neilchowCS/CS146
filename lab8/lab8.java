package lab8;

public class lab8 {
    public static int coinChange(int[] coins, int amount) {
        int[] matrix = new int[amount + 1];
        //[sys.maxsize] * (amount + 1)
        for (int i = 1; i < matrix.length; i++){
            matrix[i] = amount + 1;
        }


        for (int i = 1; i < matrix.length; i++){
            for (int coin : coins){
                if (coin <= i){
                    matrix[i] = Math.min(matrix[i], matrix[i - coin] + 1);
                }
            }
        }
/*
        if matrix[amount] == sys.maxsize:
        return -1*/
        if (matrix[amount] > amount) return -1;
        return matrix[amount];
    }

    public static void main(String[] args) {
    /*
    Test Case 1:
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
     */
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }
}
