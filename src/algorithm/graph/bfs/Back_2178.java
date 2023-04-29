//Back_2178 미로탐색 (실버)
//BFS(최단거리)

package algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_2178 {

    static int N,M;
    static int[][] Array,Check;
    //우,하,좌,상
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N][M];
        Check = new int[N][M];
        for(int i = 0; i< N;i++){
            String str = br.readLine();
            String[] array = str.split("");
            for(int j = 0; j<M;j++){
                Array[i][j] = Integer.parseInt(array[j]);
            }
        }
        Check[0][0] = 1;
        int answer = BFS();
        System.out.println(answer);
    }

    public int BFS(){
        Queue<int[]> queue = new LinkedList<>();
        int[][] dxy = new int[N][M];
        dxy[0][0] = 1;
        int x,y;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            x = pos[0];
            y = pos[1];

            for(int i = 0; i< 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=N){
                    continue;
                }
                if(ny < 0 || ny>=M){
                    continue;
                }
                if(Array[nx][ny] == 1 && Check[nx][ny] == 0){
                    int[] a = new int[]{nx,ny};
                    queue.add(a);
                    Check[nx][ny] = 1;
                    dxy[nx][ny] = dxy[x][y] +1;
                    if(nx == N-1 && ny == M-1){
                        return dxy[nx][ny];
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Back_2178().solution();
    }


}
