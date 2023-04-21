//Back_14503 로봇 청소기
//DFS(단순 구현)

package algorithm.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14503 {

    int N,M,r,c,d;
    int[][] Array;
    int[] dr = {-1,0,1,0}; // 인덱스 방향
    int[] dc = {0,1,0,-1};
    int[] drL = {0,-1,0,1}; //인덱스 방향에서의 왼쪽방향
    int[] dcL = {-1,0,1,0};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // 0 : 북, 1 : 동, 2 : 남, 3 : 서

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = DFS(r,c,d,1);
        System.out.println(answer);

    }

    public int DFS(int r, int c, int d, int depth){
        Array[r][c] = 2;
//        if(checking4(r,c,d)){
//            return depth;
//        }

        if(Array[r+drL[d]][c+dcL[d]] == 0){
            int nd = turnLeft(d);
            return DFS(r+drL[d],c+dcL[d],nd,depth+1);
        }

        for(int i = 0; i < 4; i++){
            int nr,nc;
            nr = r+drL[d];
            nc = c+dcL[d];
            d = turnLeft(d);
            if(Array[nr][nc] > 0){
                continue;
            }
            else{
                return DFS(nr,nc,d,depth+1);
            }
        }
        int nd = (d+2)% 4;
        if(Array[r+dr[nd]][c+dc[nd]] != 1){
            return DFS(r+dr[nd],c+dc[nd],d,depth);
        }
        else{
            return depth;
        }

    }

    //왼쪽으로 회전
    public int turnLeft(int d){
        if(d == 0) return 3;
        return d-1;
    }

//    public boolean checking4(int r, int c, int d){
//        int nr,nc;
//        int nd = (d+2)% 4;
//
//        for(int i = 0; i < 4; i++){
//            nr = r+drL[i];
//            nc = c+dcL[i];
//            if(Array[nr][nc] > 0) continue;
//            else{
//                return false;
//            }
//        }
//        if(Array[r+dr[nd]][c+dc[nd]] == 1){
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) throws Exception {
        new Back_14503().solution();
    }
}
