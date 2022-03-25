//Level1
//2021 카카오 채용연계형 인턴쉽
//2022.03.23


import java.util.*;

public class Level1_12 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        String ans = "";
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ze", 4);
        map.put("on", 3);
        map.put("tw", 3);
        map.put("th", 5);
        map.put("fo", 4);
        map.put("fi", 4);
        map.put("si", 3);
        map.put("se", 5);
        map.put("ei", 5);
        map.put("ni", 4);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("ze", 0);
        map2.put("on", 1);
        map2.put("tw", 2);
        map2.put("th", 3);
        map2.put("fo", 4);
        map2.put("fi", 5);
        map2.put("si", 6);
        map2.put("se", 7);
        map2.put("ei", 8);
        map2.put("ni", 9);

        for(int i = 0; i < s.length(); i++){
            if((byte) s.charAt(i) >= 48 && (byte)s.charAt(i) <= 57){
                System.out.println(s.charAt(i));
                ans += s.charAt(i);
            }
            else{
                int space = map.get(s.substring(i,i+2));
                ans += map2.get(s.substring(i,i+2));
                i += space-1;
            }
        }
        answer = Integer.parseInt(ans);
        System.out.println(answer);
    }
}

/*
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder("");
        int len = s.length();
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(alphabets[i],digits[i]);
        }

        return Integer.parseInt(s);
    }
}
 */
