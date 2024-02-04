import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class lab1 {
    private static int[] findPair(int[] nums, int target){
        HashMap<Integer, Integer> d = new HashMap<>();
        for (int i : nums) {
            d.put(i, target - i);
        }

        for (int i : nums){
            if (d.containsKey(d.get(i))){
                return new int[] {i, d.get(i)};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {99, 0, 1, 10};
        int t = 109;

        int[] o = findPair(arr, t);

        System.out.println(o == null?"no pair":o[0] + " " + o[1]);
    }
}