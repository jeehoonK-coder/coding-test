//Back_2623 음악 프로그램
//위상 정렬

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_2623 {

    static int N,M;
    static int[] Indegree;
    static Set<Integer>[] SingerList;

    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        SingerList = new Set[N+1];
        for(int i = 1; i <= N; i++){
            SingerList[i] = new HashSet<>();
        }
        Indegree = new int[N+1];
        Indegree[0] = -1;

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < cnt ; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            for(int i = 0; i < cnt; i++){
                int a = list.get(i);
                for(int j = i+1; j < cnt; j++){
                    if(!SingerList[a].contains(list.get(j))) {
                        SingerList[a].add(list.get(j));
                        Indegree[list.get(j)]++;
                    }
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(Indegree[i] == 0) q.add(i);
        }
        Queue<Integer> printQ = new LinkedList<>();
        while(!q.isEmpty()){
            int current = q.poll();
            Indegree[current] = -1;
            printQ.add(current);
            for(int i : SingerList[current]){
                Indegree[i]--;
                if(Indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        if(printQ.size() != N){
            bw.write(0+"");
        }
        else{
            while(!printQ.isEmpty()) bw.write(printQ.poll()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception {
        new Back_2623().solution();
    }
}
