//Back_2110 공유기 설치

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_2110 {

    static int N,M;
    static int[] Array;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N];
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Array);

        int right = Array[N-1] - Array[0] + 1;
        int left = 1;
        int mid;
        while(left < right){
            mid = (right + left)/2;
            if(install(mid) < M ){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        System.out.println(left-1);
    }

    public int install(int mid){
        int count = 1;
        int lastLocate = Array[0];

        for(int i = 1; i < Array.length; i++){
            int locate = Array[i];
            if(locate - lastLocate >= mid){
                count++;
                lastLocate = locate;
            }
        }

        return count;
    }



    public static void main(String[] args) throws Exception {
        new Back_2110().solution();
    }
}
