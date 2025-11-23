import java.util.Random;

public class Anagram {

    public static void main(String[] args) {
        // Test preProcess
        System.out.println("Testing preProcess:");
        System.out.println(preProcess("Nag a Ram")); 
        System.out.println(preProcess("Debit Card!"));
        System.out.println(preProcess("LISTEN"));

        // Test isAnagram
        System.out.println("\nTesting isAnagram:");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("Debit Card!", "Bad Credit"));
        System.out.println(isAnagram("anagram", "Nag a Ram"));
        System.out.println(isAnagram("hello", "world"));
        System.out.println(isAnagram("a", "b"));
        System.out.println(isAnagram("a", "a"));

        // Test randomAnagram
        System.out.println("\nTesting randomAnagram:");
        System.out.println("Original: java, Anagram: " + randomAnagram("java"));
        System.out.println("Original: listen, Anagram: " + randomAnagram("listen"));
    }

    public static String preProcess(String s) {
        String result = s.toLowerCase();
        
        String processed = "";
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (c >= 'a' && c <= 'z') {
                processed = processed + c;
            }
        }
        return processed;
    }

    public static boolean isAnagram(String s1, String s2) {
        String p1 = preProcess(s1);
        String p2 = preProcess(s2);
        
        if (p1.length() != p2.length()) {
            return false;
        }

        if (p1.length() == 0) {
            return true;
        }

        String tempP2 = p2;
        
        for (int i = 0; i < p1.length(); i++) {
            char charFromP1 = p1.charAt(i);
            boolean found = false;
            
            for (int j = 0; j < tempP2.length(); j++) {
                if (charFromP1 == tempP2.charAt(j)) {
                    tempP2 = tempP2.substring(0, j) + tempP2.substring(j + 1);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                return false;
            }
        }
        
        return true;
    }

    public static String randomAnagram(String s) {
        StringBuilder sb = new StringBuilder(s);
        String randomAnagram = "";
        Random random = new Random();
        
        while (sb.length() > 0) {
            int randomIndex = random.nextInt(sb.length());
            
            randomAnagram = randomAnagram + sb.charAt(randomIndex);
            
            sb.deleteCharAt(randomIndex);
        }
        
        return randomAnagram;
    }
}