//Back_2749 피보나치 수3
//피사노 주기


package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back_2749 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        n = n%1500000;
        Queue<Long> queue = new LinkedList<>();
        queue.add((long)0);
        queue.add((long)1);
        for(int i = 0; i < n-1; i++){
            queue.add((queue.poll()+queue.peek())%1000000);
        }
        queue.poll();
        System.out.println(queue.poll());
    }

    public static void main(String[] args) throws Exception {
        new Back_2749().solution();
    }

}
