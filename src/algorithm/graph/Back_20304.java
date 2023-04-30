/**
 *  23.04.30
 *  Back_20304 비밀번호 제작 (플래)
 *  BFS + 비트마스킹
 *
 *  1. XOR과 SHIFT를 활용한 비트마스킹
 *  2. 안전거리가 1인것부터해서 최대까지 찾아가는 것 (https://imksh.com/47)
 */

package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_20304 {

    static int  N,M;
    static int[] Array, PassWord;


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Array = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        PassWord = new int[N+1];
        Arrays.fill(PassWord, Integer.MIN_VALUE);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < M; i++){
            q.add(Array[i]);
            PassWord[Array[i]] = 0;
        }
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i = 0; i < 20; i++){
                int nx = x^(1<<i);
                if(nx > N || PassWord[nx] != Integer.MIN_VALUE) continue;
                PassWord[nx] = PassWord[x]+1;
                q.add(nx);
            }
        }
        int answer = 0;
        for(int i : PassWord){
            answer = Math.max(answer, i);
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception{
        new Back_20304().solution();
    }
}
