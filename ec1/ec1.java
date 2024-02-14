package ec1;

public class ec1 {

    private static int fibonacci(int n){
        if (n <= 1) {
            return n;
        }
        int output = 0;
        int x = 1;
        for (int i = 0; i < n; i++) {
            int temp = output;
            output = output + x;
            x = temp;
        }

        return output;
    }

    public static void main(String[] args) {
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += fibonacci(i) + " ";
        }

        System.out.println(s);
    }
}