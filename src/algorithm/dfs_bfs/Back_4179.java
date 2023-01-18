//Back_4179 불!
//BFS

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Back_4179 {

    static int R,C,X,Y;
    static char[][] Array;
    static List<int[]> FireList = new ArrayList<>();
    //우,하,상,좌
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Array = new char[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            Array[i] = str.toCharArray();
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(Array[i][j] == 'F'){
                    FireList.add(new int[]{i,j});
                }
                else if(Array[i][j] == 'J'){
                    X = i;
                    Y = j;
                }
            }
        }

        int answer = BFS();
        if(answer == 0) System.out.println("IMPOSSIBLE");
        else{
            System.out.println(answer);
        }
    }

    public int BFS(){
        boolean[][] check = new boolean[R][C];
        if(X == 0 || Y == 0 || X == R-1 || Y == C-1){
            return 1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X,Y,1});
        check[X][Y] = true;
        int count = 2;

        while(!q.isEmpty()){
            int[] a = q.poll();
            if(a[2] == count){
                fire();
                count++;
            }
            if(a[0] == 0 || a[1] == 0 || a[0] == R-1 || a[1] == C-1){
                if(Array[a[0]][a[1]] == '.')
                    return a[2];
            }
            if(Array[a[0]][a[1]] == 'F'){
                continue;
            }
            for(int k = 0; k < 4; k++){
                int nx = a[0]+dx[k];
                int ny = a[1]+dy[k];
                if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                    if(Array[nx][ny] == '.' && !check[nx][ny]){
                        q.add(new int[]{nx,ny,a[2]+1});
                        check[nx][ny] = true;
                    }
                }
            }
        }
        return 0;

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
                if(nx >= 0 && nx < R && ny >=  0 && ny < C){
                    if(Array[nx][ny] == 'J' || Array[nx][ny] == '.' ) {
                        Array[nx][ny] = 'F';
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
        new Back_4179().solution();
    }
}
