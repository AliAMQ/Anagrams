/*
Two strings "a"  and "b" are called anagrams if they contain all the same characters
in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.
 */
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()){
            return false;
        }
        HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();

        char[] a_array = a.toLowerCase().toCharArray();
        char[] b_array = b.toLowerCase().toCharArray();

        for (int i=0; i<a.length(); i++){
            if (hm1.get(a_array[i]) == null){
                hm1.put(a_array[i], 1);
            }
            else{
                hm1.put(a_array[i], hm1.get(a_array[i])+1);
            }

            if (hm2.get(b_array[i]) == null){
                hm2.put(b_array[i], 1);
            }
            else{
                hm2.put(b_array[i], hm2.get(b_array[i])+1);
            }
        }

        if (hm1.size() != hm2.size()){
            return false;
        }

        Set<Character>keys = hm1.keySet();

        for (Character character: keys){
            if (hm1.get(character) != hm2.get(character)){
                return false;
            }
        }

        return true;

    }
}
