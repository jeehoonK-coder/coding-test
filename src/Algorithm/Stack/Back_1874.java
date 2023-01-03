//Back_1874 스택 수열(실버)
//스택

package Algorithm.Stack;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Back_1874 {
    static int N;
    static int[] Array;
    static Stack<Integer> Stack = new Stack<>();
    static Queue<Character> Q = new LinkedList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Array = new int[N];
        for(int i = 0; i < N; i++)
            Array[i] = Integer.parseInt(br.readLine());

        int index = 0;
        for(int i = 1; i <= N; i++){
            while(!Stack.isEmpty() && Stack.peek() == Array[index]){
                Q.add('-');
                Stack.pop();
                index++;
            }
            if(Array[index] == i){
                Q.add('+');
                Q.add('-');
                index++;

            }
            else if(Array[index] > i){
                Q.add('+');
                Stack.push(i);
            }
            continue;
        }
        while(true){
            if(index == N) break;
            if(Array[index] == Stack.peek()){
                Q.add('-');
                Stack.pop();
                index++;
            }
            else{
                break;
            }
        }

        if(index != N){
            bw.write("NO");
        }
        else{
            while(!Q.isEmpty())
                bw.write(Q.poll()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_1874().solution();
    }

}
