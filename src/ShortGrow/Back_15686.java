//Back_15686 치킨 배달
//백트래킹, 브루트포스 알고리즘

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_15686 {

    static int N,M,Answer = Integer.MAX_VALUE;
    static int[][] Array;
    static List<Point> houseList = new ArrayList<>();
    static List<Point> chickenList = new ArrayList<>();

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int a = Integer.parseInt(st.nextToken());
                Array[i][j] = a;
                if(a == 1) houseList.add(new Point(i,j));
                else if(a == 2) chickenList.add(new Point(i,j));
            }
        }
        int chickenNumber = chickenList.size();
        boolean[] visited = new boolean[chickenNumber];
        combination(visited, 0, chickenNumber, M);
        System.out.println(Answer);

        bw.flush();
        bw.close();
        br.close();
    }

    public void combination(boolean[] visited, int start, int n, int r){
        if(r==0){
            int min = col(visited);
            Answer = Math.min(min, Answer);
            return;
        }
        for(int i = start ; i<n; i++){
            visited[i] = true;
            combination(visited,i+1,n,r-1);
            visited[i] = false;
        }
    }

    public int col(boolean[] visited){
        int totalDis = 0;
        for(Point p : houseList){
            int dis = Integer.MAX_VALUE;
            for(int i = 0; i < chickenList.size();i++){
                if(visited[i]){
                    int d = Math.abs(p.x - chickenList.get(i).x) + Math.abs(p.y - chickenList.get(i).y);
                    dis = Math.min(dis, d);
                }
            }
            totalDis += dis;
        }
        return totalDis;
    }

    public static void main(String[] args) throws Exception {
        new Back_15686().solution();
    }
}
