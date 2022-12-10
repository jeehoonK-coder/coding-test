//Back_2138 전구와 스위치
//그리디 알고리즘

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_2138 {

    static int N;
    static char[] Array, Goal;


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        Array = str.toCharArray();
        str = br.readLine();
        Goal = str.toCharArray();

        char[] temp = Array.clone();
        int a = onoff(temp);

        temp = Array.clone();
        temp[0] = (temp[0] == '1') ? '0' : '1';
        temp[1] = (temp[1] == '1') ? '0' : '1';
        int b = onoff(temp);
        b = ( b == -1) ? b : b+1;

        if( a == -1 && b == -1){
            bw.write(a+"");
        }
        else if( a == -1){
            bw.write(b+"");
        }
        else if( b == -1){
            bw.write(a+"");
        }
        else{
            int min = Math.min(a,b);
            bw.write(min+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int onoff(char[] temp){
        int answer = 0;
        for(int i = 1; i < N;i++){
            if(i == N-1){
                if(temp[i-1] == Goal[i-1] && temp[i] == Goal[i]) return answer;
                else{
                    temp[i-1] = (temp[i-1] == '1') ? '0' : '1';
                    temp[i] = (temp[i] == '1') ? '0' : '1';
                    answer++;
                    if(temp[i-1] == Goal[i-1] && temp[i] == Goal[i]) return answer;
                }
                answer = -1;
            }

            else{
                if(temp[i-1] == Goal[i-1]) continue;
                else{
                    temp[i-1] = (temp[i-1] == '1') ? '0' : '1';
                    temp[i] = (temp[i] == '1') ? '0' : '1';
                    temp[i+1] = (temp[i+1] == '1') ? '0' : '1';
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        new Back_2138().solution();
    }
}
