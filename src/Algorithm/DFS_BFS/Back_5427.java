//Back_5427 불
//BFS

package Algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_5427 {

    static class Point{
        int x;
        int y;
        int d;

        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int K,W,H,X,Y;
    static char[][] Array;
    static List<int[]> FireList;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        while(K-->0){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            Array = new char[W][H];
            FireList = new ArrayList<>();
            for(int i = 0; i < W; i++){
                Array[i] = br.readLine().toCharArray();
            }
            for(int i = 0; i < W; i++){
                for(int j = 0; j < H; j++){
                    if(Array[i][j] == '*'){
                        FireList.add(new int[]{i,j});
                    }
                    else if(Array[i][j] == '@'){
                        X = i;
                        Y = j;
                    }
                }
            }
            int answer = BFS();
            if(answer == -1) bw.write("IMPOSSIBLE\n");
            else{
                bw.write(answer+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(){
        int[][] check = new int[W][H];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(X,Y,0));
        check[X][Y] = 1;

        int count = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.d == count){
                fire();
                count++;
            }
            if(p.x == 0 || p.y == 0 || p.x == W-1 || p.y == H-1){
                if(Array[p.x][p.y] == '.' || Array[p.x][p.y] == '@')
                    return p.d+1;
            }
            if(Array[p.x][p.y] == '*'){
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx >= 0 && ny >= 0 && nx < W && ny < H){
                    if(Array[nx][ny] == '.' && check[nx][ny] == 0){
                        q.add(new Point(nx,ny,p.d+1));
                        check[nx][ny] = 1;
                    }
                }
            }
        }
        return -1;
    }

    public void fire(){
        int size = FireList.size();
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int[] a = FireList.get(i);
            boolean ch = false;
            for(int k = 0; k < 4; k++){
                int nx = a[0]+dx[k];
                int ny = a[1]+dy[k];
                if(nx >= 0 && nx < W && ny >=  0 && ny < H){
                    if(Array[nx][ny] == '@' || Array[nx][ny] == '.' ) {
                        Array[nx][ny] = '*';
                        list.add(new int[]{nx,ny});
                        ch = true;
                    }
                }
            }
            if(ch) list.add(a);
        }
        FireList = list;
    }


    public static void main(String[] args) throws Exception {
        new Back_5427().solution();
    }

}
