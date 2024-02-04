import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class lab1 {
    private static int[] findPair(int[] nums, int target){
        HashMap<Integer, Integer> d = new HashMap<>();
        for (int i : nums) {
            d.put(i, target - i);
        }

        int[] output = new int[]{-1,-1};

        for (int i = 0; i < nums.length; i++){
            if (d.containsKey(d.get(nums[i]))){
                for (int j = i + 1; j < nums.length; j++){
                    if (nums[j] == d.get(nums[i])){
                        output[0] = i;
                        output[1] = j;
                        return  output;
                    }
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {99, 0, 1, 10};
        int t = 108;

        int[] o = findPair(arr, t);

        System.out.println(o[0] + ", " + o[1]);
    }
}