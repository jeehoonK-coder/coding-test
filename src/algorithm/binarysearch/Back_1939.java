//Back_1939 중량제한
//BFS + 이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_1939 {

    static int N,M,F1,F2;
    static List<int[]>[] ArrayList;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList = new List[N+1];
        for(int i = 1; i< N+1; i++){
            ArrayList[i] = new ArrayList();
        }
        int max = 0;
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            ArrayList[x].add(new int[]{y,weight});
            ArrayList[y].add(new int[]{x,weight});
            max = Math.max(max, weight);
        }
        st = new StringTokenizer(br.readLine());
        F1 = Integer.parseInt(st.nextToken());
        F2 = Integer.parseInt(st.nextToken());

        int begin = 0, end = max;
        int mid = 0, pivot = 0;
        int result = 0;
        while(begin <= end){
            pivot = (begin + end) >> 1;
            mid = BFS(F1,F2,pivot);
            if(mid == 1){
                result = pivot;
                begin = pivot + 1;
            }
            else{
                end = pivot - 1;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(int start, int des, int max) {
        Queue<Integer> q = new LinkedList<>();
        int[] check = new int[N+1];
        q.add(start);
        check[start] = 1;
        while(!q.isEmpty()){
            int point = q.poll();
            if(point == des){
                return 1;
            }
            for(int[] ary : ArrayList[point]){
                if(ary[1] >= max && check[ary[0]] == 0){
                    check[ary[0]] = 1;
                    q.add(ary[0]);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Back_1939().solution();
    }
}
