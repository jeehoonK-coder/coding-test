//Back_1863 스카이라인 쉬운거
//스택

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back_1863 {

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    static int N;
    static Stack<Point> Stack = new Stack<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!Stack.isEmpty() && Stack.peek().y > y){
                answer++;
                Stack.pop();
            }

            if(!Stack.isEmpty() && Stack.peek().y == y) continue;
            Stack.push(new Point(x,y));
        }

        while(!Stack.isEmpty() && Stack.peek().y > 0){
            answer++;
            Stack.pop();
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_1863().solution();
    }
}
