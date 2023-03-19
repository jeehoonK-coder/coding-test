//Back_1493 박스채우기
//분할 정복 사용

package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back_1493 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        Map<Long,Long> cubes = new HashMap<>();
        long large = 0;
        for(int i =0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            long key = Long.parseLong(st.nextToken());
            long count = Long.parseLong(st.nextToken());
            if(i == n-1) large = key;
            cubes.put(key,count);
        }

        long before = 0;
        long totalCount = 0;
        for(int i = 0; i < n; i++){
            long w = (long)Math.pow(2,large);
            long possible = (length / w) * (width/w)*(height/w);
            possible -= before / (w*w*w);

            if(cubes.get(large) >= possible){
                before += possible * (w*w*w);
                totalCount += possible;
            }
            else{
                before += cubes.get(large) * (w*w*w);
                totalCount += cubes.get(large);
            }

            large -= 1;

        }

        if(before == (long)length*width*height) System.out.println(totalCount);
        else System.out.println(-1);

    }


    public static void main(String[] args) throws Exception{
        new Back_1493().solution();
    }

}
