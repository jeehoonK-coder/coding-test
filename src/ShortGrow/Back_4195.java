/**
 *  23.03.17
 *  Back_4195 친구 네트워크
 *  분리 집합
 *
 *  1. Set구조를 이용해서 List에 저장한다음에 노드들의 관계를 확인하면 시간초과가 발생한다.
 *  2. hashmap을 2개 사용하여 각 노드의 자식 수를 저장하는 방법을 사용하였지만 메모리초과가 발생한다.
 *  3. 입력이 들어오는대로 int배열에 저장한다 -> Union할때만 상위부모의 자식숫자들을 추가해준다.
 */


package ShortGrow;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Back_4195 {

    static int N,F;
    static HashMap<String, Integer> DisjointSet;
    static int[] ParentNum;
    static int[] Cnt;


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            F = Integer.parseInt(br.readLine());
            DisjointSet = new HashMap<>();
            ParentNum = new int[F*2];
            Cnt = new int[F*2];
            for(int j = 0; j < F*2; j++){
                ParentNum[j]= j;
                Cnt[j] = 1;
            }
            int idx = 0;
            for(int j= 0; j < F; j++){
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                if(!DisjointSet.containsKey(f1)){
                    DisjointSet.put(f1,idx++);
                }
                if(!DisjointSet.containsKey(f2)){
                    DisjointSet.put(f2,idx++);
                }
                union(f1,f2);
                bw.write(Cnt[find(DisjointSet.get(f1))]+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public void union(String s1, String s2) {
        int parent1 = find(DisjointSet.get(s1));
        int parent2 = find(DisjointSet.get(s2));
        if(parent1 == parent2) return;
        if(parent1 < parent2){
            ParentNum[parent2] = parent1;
            Cnt[parent1] += Cnt[parent2];
        }
        else{
            ParentNum[parent1] = parent2;
            Cnt[parent2] += Cnt[parent1];
        }
    }

    public int find(int idx) {
        if(ParentNum[idx] == idx){
            return idx;
        }
        else{
            return ParentNum[idx] = find(ParentNum[idx]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_4195().solution();
    }
}
