import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class lab2 {
    private static boolean anagram(String s, String t){
        if (s.length() != t.length())
            return false;
        HashMap<String, Integer> d = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            String character = s.substring(i, i+1);
            if (d.containsKey(character))
                d.put(character, d.get(character) + 1);
            d.put(character, 1);
        }

        for (int i = 0; i < t.length(); i++){
            String character = t.substring(i, i + 1);
            //System.out.println(character + " " + d.get(character));
            if (!d.containsKey(character) || d.get(character) < 1)
                return false;
            d.put(character, d.get(character) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "string";
        String s2 = "tsting";

        System.out.println(s1 + ", " + s2 + (anagram(s1, s2)?": anagram":": not anagram"));
    }
}