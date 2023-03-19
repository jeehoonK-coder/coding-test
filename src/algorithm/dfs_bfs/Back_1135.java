//Back_1135 뉴스 전하기
//DFS, DP
//BFS로 했으나 실패 -> DP로 재귀돌리는 방법도 있음

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_1135 {

    static int N;
    static class TreeNode{
        int count;
        List<Integer> list;

        TreeNode (int count, List<Integer> list){
            this.count = count;
            this.list = list;
        }

    }
    static TreeNode[] Array;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Array = new TreeNode[N];
        for(int i = 0; i < N; i++){
            Array[i] = new TreeNode(0, new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int bossNum = Integer.parseInt(st.nextToken());
            if(i == 0) continue;
            Array[bossNum].list.add(i);
        }

        for(int i = N-1; i >=0; i--){
            int size = Array[i].list.size();
            int max = 0;
            int c = 1;
            Collections.sort(Array[i].list, (o1, o2) -> Array[o2].count - Array[o1].count);
            for(int j = 0; j < size; j++){
                max = Math.max(Array[Array[i].list.get(j)].count + c, max);
                c++;
            }
            Array[i].count = max;
        }

        bw.write(Array[0].count+"");
        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception {
        new Back_1135().solution();
    }

}
