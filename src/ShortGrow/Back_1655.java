//Back_1655 가운데를 말해요
//PriorityQueue를 사용

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Back_1655 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        minQueue.add(-10001);
        maxQueue.add(10001);
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            if(i%2 == 0){
                if(maxQueue.peek() > a) {
                    minQueue.add(a);
                }
                else{
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(a);
                }
            }
            else{
                if(minQueue.peek() < a){
                    maxQueue.add(a);
                }
                else{
                    maxQueue.add(minQueue.poll());
                    minQueue.add(a);
                }
            }
            sb.append(minQueue.peek()).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Back_1655().solution();
    }

}

//배열로 하니까 메모리 초과가 발생함
/*
public class Back_1655 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int number[] = new int[n];
        for(int i = 0; i<n;i++){
            number[i] = 10001;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            number[i] = a;
            Arrays.sort(number);
            sb.append(number[(int)i/2]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Back_1655().solution();
    }

}*/