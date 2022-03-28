//Level2
//124 나라의 숫자

package Level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_2 {
    public static void main(String[] args) {
        int n = 3;
        String answer = "";
        List<Integer> list = new ArrayList<>();

        while(true){
            if(n>3){
                if(n%3 == 0){
                    list.add(3);
                    n = n/3 -1 ;
                }
                else if( n / 3 <= 3){
                    list.add(n%3);
                    list.add(n/3);
                    break;
                }
                else{
                    list.add(n%3);
                    n = n/3;
                }
            }
            if(n <= 3 ){
                list.add(n);
                break;
            }
        }

        for(int i = list.size()-1 ; i >= 0 ; i-- ){
            if(list.get(i) == 3){
                answer += 4;
            }
            else{
                answer += list.get(i);
            }
        }
        System.out.println(answer);
        System.out.println(list);


    }
}

/*
class Solution {
  public String solution(int n) {
      String[] num = {"4","1","2"};
      String answer = "";

      while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;
      }
      return answer;
  }
}
 */
