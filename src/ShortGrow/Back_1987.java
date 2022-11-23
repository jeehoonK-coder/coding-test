//Back_1987 알파벳
//DFS

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_1987 {

    static int N,M,Max;
    static char[][] Array;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new char[N][M];

        for(int i = 0; i < N; i++){
            Array[i] = br.readLine().toCharArray();
        }

        int[] check = new int[26];
        check[Array[0][0] - 'A'] = 1;
        DFS(new int[]{0,0}, check, 1);
        bw.write(Max+"");
        bw.flush();
    }

    public void DFS(int[] point, int[] check, int depth){

        Max = Math.max(Max,depth);

        for(int i = 0; i < 4; i++){
            int nx = point[0]+dx[i];
            int ny = point[1]+dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                int c = Array[nx][ny]-'A';
                if(check[c] == 0){
                    check[c] = 1;
                    DFS(new int[]{nx,ny} , check, depth+1);
                    check[c] = 0;
                }
            }
        }

    }



    public static void main(String[] args) throws Exception{
        new Back_1987().solution();
    }
}
