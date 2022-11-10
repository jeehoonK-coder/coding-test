//Back_22251 빌런 호석
//DFS로 풀이 , 비트마스크로도 가능

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_22251 {

    static int N,K,P;
    static long Answer;
    static String X;

    //각각의 숫자의 LED위치
    static int[][] numberArray = {{1,1,1,0,1,1,1}
                                 ,{0,0,1,0,0,1,0}
                                 ,{1,0,1,1,1,0,1}
                                 ,{1,0,1,1,0,1,1}
                                 ,{0,1,1,1,0,1,0}
                                 ,{1,1,0,1,0,1,1}
                                 ,{1,1,0,1,1,1,1}
                                 ,{1,0,1,0,0,1,0}
                                 ,{1,1,1,1,1,1,1}
                                 ,{1,1,1,1,0,1,1}};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = st.nextToken();
        Answer = 0;
        if(K > X.length()){
            int a = K-X.length();
            for(int i = 0; i < a; i++){
                X = '0'+X;
            }
        }

        DFS(0,"",0);
        System.out.println(Answer);

    }

    public void DFS(int count, String s, int depth){
        if(count > P){
            return;
        }

        if(depth == K){
            int num = Integer.parseInt(s);

            if(num <= N && num != 0 && num != Integer.parseInt(X)){
                Answer++;


            }
            return;
        }

        int n = X.charAt(depth) - '0';
        for(int i = 0; i < 10; i++){
            if(i == n) {
                DFS(count,s+i,depth+1);
                continue;
            }
            int gap = 0;
            for(int j = 0; j < 7; j++){
                gap += Math.abs(numberArray[n][j] - numberArray[i][j]);
            }
            DFS(count+gap,s+i,depth+1);
        }
    }


    public static void main(String[] args) throws Exception {
        new Back_22251().solution();
    }
}
