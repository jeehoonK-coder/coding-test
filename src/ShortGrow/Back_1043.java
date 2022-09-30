//Back_1043 거짓말
//유니온 파인드로 하는 방법 공부..?

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back_1043 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashSet<Integer> know = new HashSet<>();
        for(int i = 0; i < n;i++){
            know.add(Integer.parseInt(st.nextToken()));
        }

        List<HashSet<Integer>> partyMember = new ArrayList<>();
        for(int i = 0; i < N;i++){
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> member = new HashSet<>();
            int a = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < a; j++){
                member.add(Integer.parseInt(st.nextToken()));
            }
            partyMember.add(member);
        }

        int answer = 0;
        for(int i = 0; i < K;i++){
            for(HashSet<Integer> member : partyMember){
                for(int a : know){
                    if(member.contains(a)){
                        know.addAll(member);
                        break;
                    }
                }
            }
        }

        for(HashSet<Integer> member : partyMember){
            boolean check = true;
            for(int a : know){
                if(member.contains(a)){
                    check = false;
                    break;
                }
            }
            if(check) answer += 1;
        }

        System.out.println(answer);
    }


    public static void main(String[] args) throws Exception{
        new Back_1043().solution();
    }

}
