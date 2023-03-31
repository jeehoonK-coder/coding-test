/**
 *  23.04.01
 *  Back_1644 소수의 연속 합
 *  투 포인터, 에라토스테네스의 체
 *
 */


package algorithm.twopoint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Back_1644 {

    static int N, Count = 0;
    static List<Integer> PrimeList = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        PrimeNumber(N);
        twoPoint(N);
        bw.write(Count+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public void PrimeNumber(int num) {
        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i*i <= num; i++){
            if(isPrime[i]){
                for(int j = i*i; j <= num; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2; i <= num; i++){
            if(isPrime[i])  PrimeList.add(i);
        }
    }

    public void twoPoint(int num){
        for(int i = 0; i < PrimeList.size(); i++){
            int start = i;
            int total = 0;
            for(int j = start; j < PrimeList.size(); j++){
                total += PrimeList.get(j);
                if(total > num) break;
                if(total == num){
                    Count++;
                    break;
                }
            }
            start++;
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_1644().solution();
    }
}
