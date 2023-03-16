/**
 *  23.03.16
 *  Back_1717 집합의 표현
 *  분리 집합
 *
 *  1. Union-Find를 구현하는 것이 핵심
 *  2. Union : 부모 번호가 작은쪽을 중심으로 합쳐준다.
 *  3. Find : 부모를 찾을 때마다 최상위 부모로 업데이트를 해주어야지 효율적이다.
 */

package algorithm.disjointset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_1717 {

    static int N,M;
    static int[] ParentNum;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ParentNum = new int[N+1];
        for(int i = 0; i < N+1; i++){
            ParentNum[i] = i;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            //union
            if(Integer.parseInt(st.nextToken()) == 0){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            //find
            else{
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(find(a) == find(b)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return;
        else if(pa < pb){
            ParentNum[pb] = pa;
        }
        else{
            ParentNum[pa] = pb;
        }
    }

    public int find(int a){
        int pa = ParentNum[a];
        if(pa == a) return pa;
        else{
            return ParentNum[a] = find(pa);
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_1717().solution();
    }
}
