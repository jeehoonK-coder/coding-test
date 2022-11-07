//Back_20920 영단어 암기는 괴로워
//시간이 중요한 문제
//정렬하는 부분이 포인트

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_20920 {

    static int N,M;
    static HashMap<String,Integer> wordMap;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wordMap = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length() >= M){
                wordMap.put(str, wordMap.getOrDefault(str,0)+1);
            }
        }
        List<String> keySetList = new ArrayList<>(wordMap.keySet());
        Collections.sort(keySetList, ((o1, o2) -> {
            int c1 = wordMap.get(o1);
            int c2 = wordMap.get(o2);

            if(c1 == c2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                    return o2.length()-o1.length();
                }
            }
            else{
                return c2-c1;
            }
        }));
        for(String str : keySetList){
            bw.write(str+"\n");
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception{
        new Back_20920().solution();
    }
}
