/**
 *  23.03.25
 *  Back_1941 소문난 칠공주
 *  DFS, BFS, 백트래킹
 *
 *  1. 단순한 DFS, BFS로 구현하면 시간초과가 발생 (구현도 복잡하다)
 *  2. 조합을 이용하여 25개중 7개를 뽑고, 7개가 다 붙어있는지 확인한다음, S가 4개 이상 포홤되어있는지 확인한다.
 *
 *  --> 칸 수가 적은 DFS나 BFS 문제일 경우 조합도 항상 생각해보자!
 */


package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Back_1941 {

    static int Answer = 0;
    static Point[] Girls = new Point[25];
    static int[] Check = new int[25];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Point{
        int x;
        int y;
        char c;

        Point (int x, int y, char c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            for(int j = 0; j < 5; j++){
                Girls[i*5+j] = new Point(i,j,str.charAt(j));
            }
        }
        combination(0,0);


        bw.write(Answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void combination(int idx, int depth){
        if(depth == 7){
            for(int i = 0; i< 25; i++){
                if(Check[i] == 1){
                    boolean chk = BFS(i);
                    if(chk) Answer++;
                    break;
                }
            }
            return;
        }
        for(int i = idx; i < 25; i++){
            Check[i] = 1;
            combination(i+1, depth+1);
            Check[i] = 0;
        }

    }

    public boolean BFS(int idx) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(Girls[idx]);
        int[] newCheck = new int[25];
        newCheck[idx] = 1;
        int count = 0;
        int cntS = 0;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            count++;
            if(point.c == 'S') cntS++;
            for(int i = 0; i < 4; i++){
                int nx = point.x+dx[i];
                int ny = point.y+dy[i];
                if(nx >= 5 || nx < 0 || ny >= 5 || ny < 0) continue;
                if(newCheck[nx*5+ny] == 0 && Check[nx*5+ny] == 1){
                    newCheck[nx*5+ny] = 1;
                    queue.add(Girls[nx*5+ny]);
                }
            }
        }
        if(count == 7 && cntS >= 4){
            return true;
        }
        return false;

    }


    public static void main(String[] args) throws Exception {
        new Back_1941().solution();
    }
}
