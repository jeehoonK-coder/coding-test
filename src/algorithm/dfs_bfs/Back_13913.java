//Back_13913 숨바꼭질 4
//BFS
//String을 계속 잇는것은 시간이 오래걸린다. Stack으로 받아서 한번에 적는것이 빠름
//범위 조건문은 &&, || 시간차이가 없다.

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_13913 {

    static class Point{
        int x;
        int d;

        Point(int x, int d){
            this.x = x;
            this.d = d;
        }
    }

    static int N,K;
    static int[] Check = new int[100001];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer = BFS();
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;
        while(index != N){
            stack.push(Check[index]);
            index = Check[index];
        }

        bw.write(answer+"\n");
        while(!stack.isEmpty()){
            bw.write(stack.pop()+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(){
        Queue<Point> q = new LinkedList<>();
        Arrays.fill(Check, -1);
        Check[N] = N;
        q.add(new Point(N,0));

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == K){
                return p.d;
            }
            int x;
            if(p.x > K){
                x = p.x-1;
                if(x >= 0 && x <= 100000 && Check[x] == -1){
                    q.add(new Point(x,p.d+1));
                    Check[x] = p.x;
                }
            }
            else{
                x = p.x+1;
                if(x >= 0 && x <= 100000 && Check[x] == -1){
                    q.add(new Point(x,p.d+1));
                    Check[x] = p.x;
                }

                x = p.x-1;
                if(x >= 0 && x <= 100000 && Check[x] == -1){
                    q.add(new Point(x,p.d+1));
                    Check[x] = p.x;
                }

                x = p.x*2;
                if(x >= 0 && x <= 100000 && Check[x] == -1){
                    q.add(new Point(x,p.d+1));
                    Check[x] = p.x;
                }
            }

        }
        /*
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == K){
                return p.d;
            }
            int x;
            if(p.x > K){
                x = p.x-1;
                if(x < 0 || x > 100000 ) continue;

                if(Check[x] == -1){
                    q.add(new Point(x,p.d+1));
                    Check[x] = p.x;
                }
            }
            else{
                for(int i = 0; i < 3; i++){
                    if(i == 0) x = p.x+1;
                    else if( i == 1) x = p.x-1;
                    else x = p.x*2;

                    if(x < 0 || x > 100000) continue;
                    if(Check[x] == -1){
                        q.add(new Point(x,p.d+1));
                        Check[x] = p.x;
                    }
                }
            }
        }
        */
        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Back_13913().solution();
    }
}
