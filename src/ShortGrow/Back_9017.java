//Back_9017 크로스 컨트리 (실버)
//구현

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Back_9017 {

    static int T,N;
    static List<Integer> List;
    static HashMap<Integer,Integer> ResultMap,NumberMap;
    static int[] TeamArray;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            List = new ArrayList<>();
            ResultMap = new HashMap<>();
            NumberMap = new HashMap<>();
            TeamArray = new int[201];

            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                int a = Integer.parseInt(st.nextToken());
                List.add(a);
                TeamArray[a] += 1;
            }

            for(int k = 0; k < 201; k++){
                if(TeamArray[k] > 0 && TeamArray[k] < 6){
                    int t = k;
                    List.removeIf(a -> a == t);
                }
            }
            int c = 1;
            for(int l : List){
                if(NumberMap.get(l) != null && NumberMap.get(l) == 4){
                    NumberMap.put(l,c);
                }
                else if(NumberMap.get(l) != null && NumberMap.get(l) > 4){

                }
                else{
                    NumberMap.put(l, NumberMap.getOrDefault(l,0)+1);
                    ResultMap.put(l, ResultMap.getOrDefault(l,0)+c);
                }
                c++;
            }
            int answer = 0;
            int min = Integer.MAX_VALUE;
            for(Integer key : ResultMap.keySet()){
                if(ResultMap.get(key) < min){
                    answer = key;
                    min = ResultMap.get(key);
                }
                else if(ResultMap.get(key) == min){
                    if(NumberMap.get(key) < NumberMap.get(answer)){
                        answer = key;
                    }
                }
            }
            bw.write(answer+"\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }



    public static void main(String[] args) throws Exception {
        new Back_9017().solution();
    }

}
