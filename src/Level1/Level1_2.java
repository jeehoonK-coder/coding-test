//Level1
//폰켓몬
package Level1;

import java.util.*;

public class Level1_2 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int num = nums.length/2;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int number:nums){
            set.add(number);
        }
        System.out.println(num>set.size() ? set.size() : num);

    }
}

/*
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int num = nums.length/2;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int number:nums){
            set.add(number);
        }
        return num>set.size() ? set.size() : num;
    }
}
 */
