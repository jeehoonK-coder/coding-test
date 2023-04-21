//Back_2468 안전 영역 (실버)
//BFS (DFS도 가능)

package algorithm.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_2468 {

    int N;
    int[][] Array;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Array = new int[N][N];
        StringTokenizer st;
        int min = 101;
        int max = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j < N;j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
                if(Array[i][j] < min ) min = Array[i][j];
                if(Array[i][j] > max ) max = Array[i][j];
            }
        }
        int answer = 1;
        for(int i = min -1 ; i <= max ;i++){
            int a = BFS(i);
            if(answer < a) answer = a;
        }
        System.out.println(answer);
    }

    //Array를 복사하는것보다 check 배열을 만드는것이 조금 더 빠름( 320ms -> 288ms )
    public int BFS(int h){
        int[][] check = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j= 0; j < N;j++){
                if(Array[i][j] > h && check[i][j] == 0){
                    q.add(new int[]{i,j});
                    check[i][j] = 1;
                    while(!q.isEmpty()){
                         int[] num = q.poll();
                         for(int k = 0; k<4;k++){
                             int nx = num[0]+dx[k];
                             int ny = num[1]+dy[k];
                             if(nx>=0 && nx <N && ny >=0 && ny < N && Array[nx][ny] > h && check[nx][ny] == 0){
                                 q.add(new int[]{nx,ny});
                                 check[nx][ny] = 1;
                             }
                         }
                    }
                    count++;
                }
            }
        }
        return count;
    }
    /*
    public int BFS(int h){
        int[][] temp = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j= 0; j < N;j++){
                temp[i][j] = Array[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j= 0; j < N;j++){
                if(temp[i][j] > h){
                    q.add(new int[]{i,j});
                    temp[i][j] = 0;
                    while(!q.isEmpty()){
                         int[] num = q.poll();
                         for(int k = 0; k<4;k++){
                             int nx = num[0]+dx[k];
                             int ny = num[1]+dy[k];
                             if(nx>=0 && nx <N && ny >=0 && ny < N && temp[nx][ny] > h){
                                 q.add(new int[]{nx,ny});
                                 temp[nx][ny] = 0;
                             }
                         }
                    }
                    count++;
                }
            }
        }
        return count;
    }
     */

    public static void main(String[] args) throws Exception {
        new Back_2468().solution();
    }
}
