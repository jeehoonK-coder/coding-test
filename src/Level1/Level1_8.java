package Level1;//Level1
//3진법 뒤집기

import java.util.ArrayList;
import java.util.List;

public class Level1_8 {
    public static void main(String[] args) {
        int n = 125;
        int answer = 0;
        List<Integer> nReverse = new ArrayList<Integer>();
        while( n > 2){
            nReverse.add(n%3);
            n = n/3;
        }
        nReverse.add(n);
        for(int i = 0 ; i< nReverse.size() ; i++){
            answer += Math.pow(3,nReverse.size()-1-i)*nReverse.get(i);
        }
        System.out.println(answer);
    }
}

