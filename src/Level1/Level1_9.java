package Level1;//Level1
//두개 뽑아서 더하기 ( 월간 코드 챌린지 시즌1 )

import java.util.*;

public class Level1_9 {
    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};
        Arrays.sort(numbers);
        HashSet<Integer> numSet = new HashSet<Integer>();
        for(int i = 0; i< numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                numSet.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new int[numSet.size()];
        List arrayList=new ArrayList();
        arrayList.addAll(numSet);
        for(int i = 0; i < numSet.size(); i++){
            answer[i] = (int)arrayList.get(i);
        }
        Arrays.sort(answer);
        for( int ans: answer){
            System.out.println(ans);
        }
    }
}

/*
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<Integer> numSet = new HashSet<Integer>();
        for(int i = 0; i< numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                numSet.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new int[numSet.size()];
        List arrayList=new ArrayList();
        arrayList.addAll(numSet);
        for(int i = 0; i < numSet.size(); i++){
            answer[i] = (int)arrayList.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
 */