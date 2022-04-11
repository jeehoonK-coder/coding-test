//BackJoon Question
//No.1759 암호 만들기

package Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PWMaking {
    StringBuilder sb = new StringBuilder();

    private void findPW(char[] charPW, int L, int C){
        boolean[] visited = new boolean[C];
        combi(charPW, visited, 0, C, L);
    }

    private void combi(char[] arr, boolean[] visited, int depth, int n, int r){
        if(r==0){
            String s = "";
            int a = 0;
            int b = 0;
            for(int i =0; i< n ; i++){
                if(visited[i]){
                    if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                        a++;
                    }
                    else{
                        b++;
                    }
                    s += arr[i];
                }
            }
            if(a>=1 && b>= 2){
                sb.append(s).append('\n');
            }
            return;
        }

        if(depth==n){
            return;
        }

        visited[depth] = true;
        combi(arr,visited, depth+1, n, r-1);

        visited[depth] = false;
        combi(arr,visited, depth+1, n, r);
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[] charPW = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            charPW[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(charPW);
        findPW(charPW,L,C);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new PWMaking().solution();
    }
}


