//Back_1516 게임 개발
//위상 정렬 , DP(?)

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_1516 {

    static int N;
    static int[] Indegree;
    static class Building {
        int time;
        List<Integer> numberList;
        int maxTime;

        Building (int time, List<Integer> numberList, int maxTime){
            this.time = time;
            this.numberList = numberList;
            this.maxTime = maxTime;
        }

    }
    static Building[] BuildingIMF;



    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] answer = new int[N+1];
        Indegree = new int[N+1];
        Indegree[0] = -1;
        BuildingIMF = new Building[N+1];
        for(int i = 1; i <= N; i++){
            BuildingIMF[i] = new Building(0, new ArrayList<>(),0);
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            BuildingIMF[i].time = t;
            while(true){
                int k = Integer.parseInt(st.nextToken());
                if(k == -1) break;
                BuildingIMF[k].numberList.add(i);
                Indegree[i]++;
            }
        }
        //maxtime을 만들면서 쓸모가 없어짐
        /*
        for(int i = 1; i <= N; i++){
            Collections.sort(BuildingIMF[i].numberList, Comparator.comparingInt(o -> BuildingIMF[o].time));
        }
        */


        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(Indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();
            answer[current] = BuildingIMF[current].time;
            for(int n : BuildingIMF[current].numberList){
                BuildingIMF[n].maxTime = Math.max(BuildingIMF[n].maxTime, BuildingIMF[current].time);
                if(--Indegree[n] == 0){
                    q.add(n);
                    BuildingIMF[n].time += BuildingIMF[n].maxTime;
                }
            }
        }
        for(int i = 1; i <= N; i++){
            bw.write(answer[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_1516().solution();
    }

}
