/**
 *  23.03.22
 *  Back_16987 계란으로 계란치기
 *  백트래킹, 브루트포스 알고리즘
 *
 *  1. 전형적인 백트래킹 문제
 *  2. check 변수를 넣어서 아무것도 안깨고 넘어가는 경우를 방지한다. 아무것도 못깰때에만 넘어가야한다.
 */


package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_16987 {

    static int N, Count = 0;
    static Egg[] Eggs;

    static class Egg{
        int durability;
        int weight;

        Egg(int durability, int weight){
            this.durability = durability;
            this.weight = weight;

        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Eggs = new Egg[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        backtracking(0);
        bw.write(Count+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public void backtracking(int idx){
        if(idx == N){
            int count = 0;
            for(Egg egg : Eggs){
                if(egg.durability <= 0) count++;
            }
            Count = Math.max(Count, count);
            return;
        }
        Egg egg = Eggs[idx];
        if(egg.durability <= 0){
            backtracking(idx+1);
            return;
        }
        boolean check = true;
        for(int i = 0; i < N; i++){
            if(i == idx) continue;
            if(Eggs[i].durability > 0){
                check = false;
                egg.durability -= Eggs[i].weight;
                Eggs[i].durability -= egg.weight;
                backtracking(idx+1);
                egg.durability += Eggs[i].weight;
                Eggs[i].durability += egg.weight;
            }
        }
        if(check) backtracking(idx+1);

    }

    public static void main(String[] args) throws Exception {
        new Back_16987().solution();
    }
}
