//Back_1189 컴백홈 (실버)
//DFS

package algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_1189 {

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int  R,C,K, Count = 0;
    static char[][] Array;
    static Point Start, End;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Array = new char[R][C];
        for(int i = 0; i <R ;i++){
            Array[i] = br.readLine().toCharArray();
        }
        Start = new Point(R-1,0);
        End = new Point(0,C-1);
        int[][] check = new int[R][C];
        check[R-1][0] = 1;
        DFS(Start,check,1);
        bw.write(Count+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void DFS(Point point, int[][] check, int dis){
        if(dis == K && point.x == End.x && point.y == End.y){
            Count++;
            return;
        }
        else if(dis == K){
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = point.x+dx[i];
            int ny = point.y+dy[i];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(Array[nx][ny] == '.' && check[nx][ny] == 0){
                check[nx][ny] = 1;
                DFS(new Point(nx,ny), check, dis+1);
                check[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new Back_1189().solution();
    }
}
