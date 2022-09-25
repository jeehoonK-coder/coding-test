//Back_10816 숫자 카드2
//이분탐색

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_10816 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];

        for(int i = 0 ; i <n ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int k = Integer.parseInt(br.readLine());
        //int[] findNum = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < k ; i++) {
            //findNum[i] = Integer.parseInt(st.nextToken());
            int findN = Integer.parseInt(st.nextToken());
            int idxD = lowerBound(numbers,findN);
            int idxU = upperBound(numbers,findN);
            if(i == k-1) sb.append(idxU-idxD);
            else sb.append(idxU-idxD).append(" ");

        }
        System.out.println(sb);
    }

    public static int upperBound(int[] values, int num) {
        int begin = 0, end = values.length;
        int mid = 0, pivot = 0;

        while (begin < end) {
            pivot = (end + begin) >> 1;
            mid = values[pivot];

            if (mid > num) end = pivot;
            else begin = pivot + 1;
        }
        return end;
    }

    public static int lowerBound(int[] values, int num) {
        int begin = 0, end = values.length;
        int mid = 0, pivot = 0;

        while (begin < end) {
            pivot = (end + begin) >> 1;
            mid = values[pivot];

            if (mid >= num) end = pivot;
            else begin = pivot + 1;
        }

        return begin;
    }


    public static void main(String[] args) throws Exception{
        new Back_10816().solution();
    }
}
