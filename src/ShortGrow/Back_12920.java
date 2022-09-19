//Back_12920 평범한 배낭2

package ShortGrow;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_12920 {
    static int dp[][],k[];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        List<Integer> w = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        k = new int[n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int wei = Integer.parseInt(st.nextToken());
            w.add(wei);
            int val = Integer.parseInt(st.nextToken());
            v.add(val);
            k[i] = Integer.parseInt(st.nextToken());
            double a = 1;
            int total = 1;
            while(Math.pow(2,a) <= k[i]){
                if(k[i] - total < Math.pow(2,a) ){
                    w.add(wei*(k[i] - total));
                    v.add(val*(k[i] - total));
                }
                else {
                    w.add(wei * (int)Math.pow(2,a));
                    v.add(val * (int)Math.pow(2,a));
                }
                total += (int)Math.pow(2,a);
                a++;
            }
        }

        dp = new int [w.size()+1][weight+1];
        for(int i=1;i<=w.size();i++) {
            for(int j=1;j<=weight;j++) {
                dp[i][j] = dp[i-1][j];
                if(j - w.get(i-1)>=0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w.get(i-1)]+v.get(i-1));
                }
            }
        }

        sb.append(dp[w.size()][weight]);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Back_12920().solution();
    }
}
