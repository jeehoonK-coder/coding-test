//Back_2531 회전 초밥(실버)
//브루트포스 알고리즘, 투포인터
//접시종류만큼의 인트배열 생성해서 구현하면 시간이 더 단축됨

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Back_2531 {

    static int N,d,k,c,Answer;
    static int[] Array;
    static HashMap<Integer,Integer> Map = new HashMap<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Array = new int[N];

        for(int i = 0; i < N;i++){
            Array[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = k-1;
        for(int i = 0; i < k; i++){
            Map.put(Array[i], Map.getOrDefault(Array[i],0)+1);
        }
        Answer = couponCheck();

        for(int i = 1; i < N; i++){
            if(Map.get(Array[start]) > 1) Map.put(Array[start], Map.get(Array[start])-1);
            else{
                Map.remove(Array[start]);
            }
            start++;
            end++;
            if(end == N) end = 0;
            Map.put(Array[end], Map.getOrDefault(Array[end],0)+1);

            Answer = Math.max(Answer, couponCheck());
        }

        System.out.println(Answer);
    }

    public int couponCheck(){
        if(Map.containsKey(c)) return Map.size();
        else{
            return Map.size() +1;
        }
    }




    public static void main(String[] args) throws Exception{
        new Back_2531().solution();
    }
}
