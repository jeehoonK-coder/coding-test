//Back_19941 햄버거 분배(실버)
//그리디 알고리즘

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_19941 {

    static int N,K;
    static String HP;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        HP = br.readLine();
        int answer = 0;
        char[] array = HP.toCharArray();
        for(int i = 0; i < N ; i++){
            if(array[i] == 'P'){
                for(int j = Math.max(i-K,0); j < Math.min(i+K+1,N) ; j++){
                    if(array[j] == 'H'){
                       answer++;
                       array[j] = 'A';
                       break;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception{
        new Back_19941().solution();
    }
}
