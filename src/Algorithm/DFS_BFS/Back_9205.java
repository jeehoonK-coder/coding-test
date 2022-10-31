//Back_9205 맥주 마시면서 걸어가기 (실버)
//플로이드와샬 알고리즘으로 가능
//양방향 그래프로 BFS탐색을 하면 가능

package Algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back_9205 {

    int N,K;
    List<int[]> List;
    boolean[][] isSearch;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            List = new ArrayList<>();
            K = Integer.parseInt(br.readLine());
            isSearch = new boolean[K+2][K+2];
            for(int j = 0; j < K + 2; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                List.add(new int[]{a,b});
            }

            for (int x = 0; x < K + 2; x++) {
                for (int y = x + 1; y < K + 2; y++) {
                    if (Manhattan(List.get(x), List.get(y)) <= 1000) {
                        isSearch[x][y] = isSearch[y][x] = true;
                    }
                }
            }
            fload();
            sb.append((isSearch[0][K + 1] ? "happy" : "sad") + '\n');

        }
        System.out.println(sb);
    }


    public void fload(){
        for(int k = 0; k < K + 2; k++) {
            for(int i = 0; i < K + 2; i++) {
                for(int j = 0; j < K + 2; j++) {
                    if(isSearch[i][k] && isSearch[k][j]) {
                        isSearch[i][j] = true;
                    }
                }
            }
        }
    }

    public int Manhattan(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1]-b[1]);
    }

    public static void main(String[] args) throws Exception {
        new Back_9205().solution();
    }
}
