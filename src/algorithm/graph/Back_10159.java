/**
 *  23.04.22
 *  Back_10159 저울
 *  플로이드-워셜
 *
 *  1. 그냥 재귀로 구현했다.
 *  2. 플로이드-워셜을 사용하면 빨리 풀 수 있다.
 *  //플로이드 돌려준다.
 * 	for (int k = 1; k <= n; k++) {
 * 		for (int i = 1; i <= n; i++) {
 * 			for (int j = 1; j <= n; j++) {
 * 				if (map[i][k] && map[k][j])map[i][j] = 1;
 *          }
 *      }
 *  }
 */

package algorithm.graph;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_10159 {

    static int N,M;
    static class Relation {
        int n;
        Set<Integer> bigger;
        Set<Integer> smaller;
        int bigCnt;
        int smallCnt;

        Relation(int n, Set<Integer> bigger, Set<Integer> smaller, int bigCnt, int smallCnt){
            this.n = n;
            this.bigger = bigger;
            this.smaller = smaller;
            this.bigCnt = bigCnt;
            this.smallCnt = smallCnt;
        }
    }

    static Relation[] relations;
    static int[] checkBig;
    static int[] checkSmall;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        relations = new Relation[N+1];
        checkBig = new int[N+1];
        checkSmall = new int[N+1];
        for(int i = 1;i <=N; i++){
            relations[i] = new Relation(i, new HashSet<>(), new HashSet<>(),-1,-1);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            relations[b].smaller.add(s);
            relations[s].bigger.add(b);
        }

        for(int i = 1; i <= N; i++){
            bw.write((N - 1 - Small(i).size() - Big(i).size()) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public Set<Integer> Small(int n){
        if(relations[n].smallCnt != -1){
            return relations[n].smaller;
        }
        if(relations[n].smaller.isEmpty()){
            relations[n].smallCnt = 0;
            return relations[n].smaller;
        }

        Set<Integer> temp = new HashSet<>();
        for(int k : relations[n].smaller){
            temp.add(k);
            temp.addAll(Small(k));
        }
        relations[n].smallCnt = temp.size();
        relations[n].smaller.addAll(temp);
        return relations[n].smaller;
    }

    public Set<Integer> Big(int n){
        if(relations[n].bigCnt != -1){
            return relations[n].bigger;
        }
        if(relations[n].bigger.isEmpty()){
            relations[n].bigCnt = 0;
            return relations[n].bigger;
        }

        Set<Integer> temp = new HashSet<>();
        for(int k : relations[n].bigger){
            temp.add(k);
            temp.addAll(Big(k));
        }
        relations[n].bigCnt = temp.size();
        relations[n].bigger.addAll(temp);
        return relations[n].bigger;
    }


    public static void main(String[] args) throws Exception {
        new Back_10159().solution();
    }
}
