//Back_3151 합이 0
//투 포인터, 이분탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_3151 {

    static int N;
    static int[] CodingList;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        CodingList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            CodingList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(CodingList);

        bw.write(Search() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public long Search(){
        long count = 0L;
        for(int i = 0; i < N-2; i++){
            if(CodingList[i] > 0) break;
            int begin = i+1, end = N-1;
            int mid = 0;

            while(begin < end){
                int s = 1;
                int e = 1;
                mid = CodingList[begin] + CodingList[end];
                if(mid + CodingList[i] == 0 && CodingList[begin] == CodingList[end]){
                    int a = end - begin +1;
                    count += (a*(a-1)) / 2;
                    break;
                }

                if(mid + CodingList[i] == 0){
                    while (begin + 1 < end && CodingList[begin] == CodingList[begin + 1]) {
                        s++;
                        begin++;
                    }
                    while (begin < end - 1 && CodingList[end] == CodingList[end - 1]) {
                        e++;
                        end--;
                    }
                    count += s * e;
                }
                if(mid + CodingList[i] > 0){
                    end -= 1;
                }
                else{
                    begin +=1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        new Back_3151().solution();
    }
}
