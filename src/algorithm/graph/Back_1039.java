//Back_1039 교환
//BFS
//check배열을 이차원으로해서 푸는것이 포인트

package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_1039 {

    static int N, K;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer = BFS();
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[1000001][K+1];
        q.add(new int[]{N,0});
        check[N][0] = true;

        int result = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[1] == K){
                result = Math.max(result, cur[0]);
                continue;
            }

            int len = String.valueOf(cur[0]).length();
            for(int i = 0; i < len -1; i++){
                for(int j = i + 1; j < len; j++){
                    int next = switching(cur[0],i,j);
                    if(next != -1 && !check[next][cur[1]+1]){
                        q.add(new int[]{next,cur[1]+1});
                        check[next][cur[1]+1] = true;
                    }
                }
            }

        }

        return result;

    }

    public int switching(int n, int i, int j){
        char[] num_str = String.valueOf(n).toCharArray();

        if(i == 0 && num_str[j] == '0')
            return -1;

        char temp = num_str[i];
        num_str[i] = num_str[j];
        num_str[j] = temp;

        return Integer.parseInt(new String(num_str));
    }

    public static void main(String[] args) throws Exception {
        new Back_1039().solution();
    }
}
