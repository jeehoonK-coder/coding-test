//Back_14658 하늘에서 별똥별이 빗발친다
//브루트포스 알고리즘

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Back_14658 {

    static class Star{
        int x;
        int y;

        Star(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N,M,L,K;
    static List<Star> starList = new ArrayList<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            starList.add(new Star(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int max = 0;
        for(Star s : starList){
            for(Star s2 : starList){
                max = Math.max(max,count(s.x,s2.y));
            }

        }
        System.out.println(K-max);
    }

    public int count(int i, int j){
        int max = 0;
        for(Star s:starList){
            if(i<=s.x && s.x <= i+L && j <= s.y && s.y <= j+L ) max++;
        }
        return max;
    }


    public static void main(String[] args) throws Exception{
        new Back_14658().solution();
    }
}
