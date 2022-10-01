//Back_10800 컬러볼

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back_10800 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] ballList = new int[n][3];

        for(int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            ballList[i][0] = Integer.parseInt(st.nextToken());
            ballList[i][1] = Integer.parseInt(st.nextToken());
            ballList[i][2] = i;
        }

        Arrays.sort(ballList, Comparator.comparingInt(o1 -> o1[1]));
        int[] answer = new int[n];
        int[] color = new int[n];
        int weight = 0;
        for(int i = 0; i < n; i++){
            int col = ballList[i][0] -1;
            int size = ballList[i][1];
            int index = ballList[i][2];
            answer[index] = weight - color[col];

            color[col] += size;
            weight += size;
        }

        for(int i = 0; i < n; i++){
            sb.append(answer[i]).append('\n');
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Back_10800().solution();
    }

}
