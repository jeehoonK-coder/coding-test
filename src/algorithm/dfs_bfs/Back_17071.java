//Back_17071 숨바꼭질 5 (플래)
//BFS
//홀수, 짝수로 나누어서 방문을 저장한다.

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_17071 {

    static class Point{
        int x;
        int d;

        Point(int x, int d){
            this.x = x;
            this.d = d;
        }
    }

    static int N,K;
    static int[][] Check = new int[2][500001];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer = BFS();
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(){
        Queue<Point> q = new LinkedList<>();
        Arrays.fill(Check[0],-1);
        Arrays.fill(Check[1],-1);
        Check[0][N] = 0;
        q.add(new Point(N,0));

        int count = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.d == count){
                K += count;
                if(K > 500000) return -1;
                if(Check[count % 2][K] != -1){
                    return count;
                }
                count++;
            }

            if(p.x == K){
                return p.d;
            }
            int x;
            int dtwo = (p.d+1)%2;
            x = p.x+1;
            if(x >= 0 && x <= 500000 && Check[dtwo][x] == -1){
                q.add(new Point(x,p.d+1));
                Check[dtwo][x] = p.d+1;
            }

            x = p.x-1;
            if(x >= 0 && x <= 500000 && Check[dtwo][x] == -1){
                q.add(new Point(x,p.d+1));
                Check[dtwo][x] = p.d+1;
            }

            x = p.x*2;
            if(x >= 0 && x <= 500000 && Check[dtwo][x] == -1){
                q.add(new Point(x,p.d+1));
                Check[dtwo][x] = p.d+1;
            }
        }

        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Back_17071().solution();
    }
}
