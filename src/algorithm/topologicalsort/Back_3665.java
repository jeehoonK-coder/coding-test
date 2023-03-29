/**
 *  23.03.30
 *  Back_3665 최종 순위
 *  위상 정렬
 *
 *
 *  1. 작년 순위를 바탕으로 Indegree를 작성한 후 추가로 주어진 데이터를 바탕으로 마무리해야 한다.
 *  2. Impossible과 ?의 차이가 없는 것 같지만 아래 블로그에서 설명해준다.
 *  cf) https://maetdori.tistory.com/entry/%EB%B0%B1%EC%A4%80-3665-%EC%B5%9C%EC%A2%85-%EC%88%9C%EC%9C%84-JAVA
 */

package algorithm.topologicalsort;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_3665 {

    static int T,N,M;
    static ArrayList<Integer> LastRank;
    static ArrayList<Integer>[] Reverse;
    static int[] Indegree;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            LastRank = new ArrayList<>();
            Reverse = new ArrayList[N+1];
            for(int j = 1; j <= N; j++){
                Reverse[j] = new ArrayList();
            }
            Indegree = new int[N+1];

            //작년 순위에 의한 위상정렬 정리
            st = new StringTokenizer(br.readLine());
            int check[] = new int[N+1];
            for(int j = 0; j < N; j++){
                int r = Integer.parseInt(st.nextToken());
                LastRank.add(r);
                check[r] = 1;
                for(int k = 1; k <= N; k++){
                    if(check[k] == 0){
                        Reverse[r].add(k);
                        Indegree[k]++;
                    }
                }

            }

            //뒤바퀸 순위에 의한 위상정렬 정리
            M = Integer.parseInt(br.readLine());
            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(LastRank.indexOf(a) < LastRank.indexOf(b)){
                    Reverse[b].add(a);
                    Reverse[a].remove(Integer.valueOf(b));
                    Indegree[a]++;
                    Indegree[b]--;
                }
                else{
                    Reverse[a].add(b);
                    Reverse[b].remove(Integer.valueOf(a));
                    Indegree[a]--;
                    Indegree[b]++;
                }
            }

            ArrayList<Integer> list = Rank();
            if(list.size() == 0) bw.write("IMPOSSIBLE");
            else if(list.size() != N) bw.write("?");
            else{
                for(int r : list){
                    bw.write(r+" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public ArrayList<Integer> Rank(){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> rank = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(Indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int r = queue.poll();
            rank.add(r);
            for(int a : Reverse[r]){
                Indegree[a]--;
                if(Indegree[a] == 0){
                    queue.add(a);
                }
            }
        }
        return rank;
    }

    public static void main(String[] args) throws Exception {
        new Back_3665().solution();
    }
}
