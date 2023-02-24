//Back_15732 도토리 숨기기
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_15732 {

    static class Rule {
        int start;
        int end;
        int gap;

        Rule(int start, int end, int gap){
            this.start = start;
            this.end = end;
            this.gap = gap;
        }
    }

    static int N,K;
    static long D;
    static Rule[] rules;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Long.parseLong(st.nextToken());
        rules = new Rule[K];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int gap = Integer.parseInt(st.nextToken());
            Rule rule = new Rule(start,end,gap);
            rules[i] = rule;
        }

        bw.write(binarySearch()+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch(){
        int begin = 0, end = N, pivot = 0;
        long mid = 0;
        int result = 0;
        while(begin <= end){
            pivot = (begin + end) >> 1;
            mid = 0;
            for(Rule r : rules){
                if(pivot < r.start) continue;
                if(pivot > r.end) mid += ((r.end - r.start) / r.gap) + 1;
                else{
                    mid += ((pivot - r.start) / r.gap) + 1;
                }
            }
            if(mid >= D){
                result = pivot;
                end = pivot -1;
            }
            else{
                begin = pivot + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        new Back_15732().solution();
    }
}
