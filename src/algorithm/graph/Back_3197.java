//Back_3197 백조의 호수 (플래)
//BFS

package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_3197 {

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int R,C;
    static char[][] Array;
    static int[][] Check, WaterCheck;
    static Queue<Point> IceQueue = new LinkedList<>();
    static Queue<Point> WaterQueue = new LinkedList<>();

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Array = new char[R][C];
        Check = new int[R][C];
        WaterCheck = new int[R][C];
        Point swan1 = null;
        Point swan2 = null;

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                Array[i][j] = str.charAt(j);
                if(Array[i][j] == 'L'){
                    if(swan1 == null) swan1 = new Point(i,j);
                    else swan2 = new Point(i,j);
                }
            }
        }


        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(Array[i][j] == 'X'){
                    for(int k = 0; k < 4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if(Array[nx][ny] == '.' || Array[nx][ny] == 'L'){
                            IceQueue.add(new Point(i,j));
                            Check[i][j] = 1;
                            break;
                        }
                    }
                }
            }
        }
        int answer = 0;
        WaterQueue.add(swan1);
        WaterCheck[swan1.x][swan1.y] = 1;
        while(!BFS(swan2)){
            Melting();
            answer++;
        }


        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }


    public void Melting(){
        int size = IceQueue.size();
        while(size-->0){
            Point p = IceQueue.poll();
            Array[p.x][p.y] = '.';
            for(int k = 0; k < 4; k++){
                int nx = p.x+dx[k];
                int ny = p.y+dy[k];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(Array[nx][ny] == 'X' && Check[nx][ny] == 0){
                    IceQueue.add(new Point(nx,ny));
                    Check[nx][ny] = 1;
                }
            }
        }
    }

    public boolean BFS(Point swan2){
        Queue<Point> q = new LinkedList<>();
        while(!WaterQueue.isEmpty()){
            q.add(WaterQueue.poll());
        }

        while(!q.isEmpty()){
            Point p = q.poll();
            int edge = 0;
            if(p.x == swan2.x && p.y == swan2.y){
                return true;
            }
            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(Array[nx][ny] == 'X') edge = 1;
                else if(Array[nx][ny] == '.' || Array[nx][ny] == 'L'){
                    if(WaterCheck[nx][ny] == 0){
                        q.add(new Point(nx,ny));
                        WaterCheck[nx][ny] = 1;
                    }
                }
            }
            if(edge == 1) {
                WaterQueue.add(new Point(p.x,p.y));
            }
        }
        return false;
    }





    /* 이것도 시간이 오래걸림
    public boolean BFS(Point swan1, Point swan2){
        Queue<Point> q = new LinkedList<>();
        int[][] check = new int[R][C];
        q.add(swan1);
        check[swan1.x][swan1.y] = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == swan2.x && p.y == swan2.y){
                return true;
            }
            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(Array[nx][ny] == '.' || Array[nx][ny] == 'L'){
                    if(check[nx][ny] == 0){
                        q.add(new Point(nx,ny));
                        check[nx][ny] = 1;
                    }
                }
            }
        }
        return false;
    }
    */

    public static void main(String[] args) throws Exception{
        new Back_3197().solution();
    }
}
