//Back_2573 빙산
//DFS
//영역을 한군데 찾고 또 발생했을 때 스킵하는 코드는 생각보다 시간을 줄여주지는 않음
//melting 배열을 구하는 것을 check을 할 때 같이 하면 시간을 줄일 수 잇음

package algorithm.dfs_bfs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2573 {
    int N,M;
    int[][] Array,check,melt;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while(true){
            int cnt = check();
            if(cnt > 1) break;
            else if(cnt == 0){
                answer = 0;
                break;
            }
            else{
                melting();
                answer++;
            }
        }
        System.out.println(answer);
    }

    public void melting(){
        melt = new int[N][M];
        int count;
        for(int i = 1; i < N-1; i++){
            for(int j = 1; j < M-1; j++){
                count = 0;
                if(Array[i][j] > 0){
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx<0||ny<0||nx>=N||ny>=M) continue;
                        if(Array[nx][ny] == 0){
                            count++;
                        }
                    }
                }
                melt[i][j] = count;
            }
        }

        for(int i = 1; i < N-1; i++){
            for(int j = 1; j < M-1; j++){
                if(Array[i][j] - melt[i][j] < 0) Array[i][j] = 0;
                else{
                    Array[i][j] -= melt[i][j];
                }

            }
        }

    }

    public int check(){
        int count = 0;
        check = new int[N][M];
        for(int i = 1; i < N-1; i++){
            for(int j = 1; j < M-1; j++){
                if(Array[i][j] > 0 && check[i][j] == 0){
                    if(count == 1){
                        return 2;
                    }
                    dfs(i,j);
                    count++;
                }

            }
        }
        return count;
    }

    public void dfs(int x, int y){
        check[x][y]=1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||ny<0||nx>=N||ny>=M) continue;
            if(Array[nx][ny] > 0 && check[nx][ny]== 0 ){
                dfs(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_2573().solution();
    }
}
