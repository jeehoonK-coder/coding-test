//Back_9328 열쇠
//BFS

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_9328 {

    static class Point{
        int x;
        int y;
        char c;

        Point(int x, int y, char c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static int  K,H,W;
    static char[][] Array;
    static List<Character> KeyList;
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
            Array = new char[H][W];
            KeyList = new ArrayList<>();
            for(int i = 0; i < H; i++){
                Array[i] = br.readLine().toCharArray();
            }
            //key리스트 만들기 (아스키 32차이)
            String str = br.readLine();
            if(!str.equals("0")){
                for(int i = 0; i < str.length(); i++){
                    KeyList.add(str.charAt(i));
                }
            }
            Queue<Point> q = new LinkedList<>();
            int[][] check = new int[H][W];
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    if(i == 0 || i == H-1 || j == 0 || j == W-1){
                        if(Array[i][j] != '*'){
                            q.add(new Point(i,j,Array[i][j]));
                            check[i][j] = 1;
                        }
                    }
                }
            }
            bw.write(BFS(q,check)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(Queue<Point> q, int[][] check){
        List<Point> doorList = new ArrayList<>();
        int count = 0;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.c == '$'){
                count++;
            }
            if('a' <= p.c && 'z' >= p.c){
                if(!KeyList.contains(p.c)){
                    KeyList.add(p.c);
                    for(Point door : doorList){
                        if((char)(door.c+32) == p.c){
                            q.add(door);
                        }
                    }
                }
            }
            if('A' <= p.c && 'Z' >= p.c){
                if(!KeyList.contains((char)(p.c+32))){
                    doorList.add(p);
                    continue;
                }

            }
            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if(Array[nx][ny] != '*' && check[nx][ny] == 0){
                    q.add(new Point(nx,ny,Array[nx][ny]));
                    check[nx][ny] = 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        new Back_9328().solution();
    }
}
