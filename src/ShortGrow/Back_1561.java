//Back_1561 놀이공원
//이분 탐색

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1561 {

    static long N,M;
    static int[] Array;
    static long[] Count;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        Array = new int[(int)M];
        Count = new long[(int)M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }

        if(N <= M){
            bw.write(N+"");
        }
        else{
            bw.write(binarySearch()+1+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch() {
        long begin = 0 , end = 30 * N;
        long mid = 0, pivot = 0;
        long[] temp = new long[(int)M];
        int gap = 0;
        //이분탐색을 이용하여 N명을 태우는 분을 찾음
        //모두가 타고난 후의 시간을 구하는 것이 아니기때문에 그 시간에 타기 시작하는 것도 고려하여 +1을 해줌
        while(begin <= end){
            pivot = (begin + end) >> 1;
            mid = 0;
            for(int i = 0; i < M; i++){
                //+1을 해줌
                if(pivot % Array[i] == 0){
                    mid += (pivot/ Array[i]) + 1;
                    temp[i] = pivot;
                }
                else{
                    long n = pivot / Array[i];
                    mid += n + 1;
                    temp[i] = n * Array[i];
                }

            }
            //사람 수가 똑같으면 딱 맞는 것이기때문에 temp배열에서의 가장 뒤쪽에 있는 최댓값의 인덱스를 구해서 반환해준다.
            if(mid == N){
                long max = temp[0];
                int index = 0;
                for(int i = 1; i < M; i++){
                    if(max <= temp[i]){
                        max = temp[i];
                        index = i;
                    }
                }
                return index;
            }
            else if(mid > N){
                for(int i =0;i < M; i++){
                    Count[i] = temp[i];
                }
                gap = (int)mid - (int)N;
                end = pivot - 1;
            }
            else{
                begin = pivot + 1;
            }
        }

        //사람수가 안맞는 경우 초과로 몇명이 더 타는 것이기 때문에 그 차이만큼의 최대값의 위치를 구해주면된다. 예를들어 30명인데 mid가 33이면 3번째로 큰 수의 위치를 구해주면된다.
        //Count배열에서의 몇번째로 큰 수의 위치를 구하는 로직
        //빈 배열하나를 만들어서 sort를 하고 index의 위치와 값을 구한다음 그 똑같은 값이 몇개 있는지 찾아준다.
        //그 후에 sort안된 Count배열을 앞에서부터 서치하여 target값이 cnt만큼 나온 후의 index값을 반환해준다.
        long[] temp2 = new long[(int)M];
        for(int i = 0; i < M; i++){
            temp2[i] = Count[i];
        }
        Arrays.sort(temp2);
        int index = (int)M-gap-1;
        long target = temp2[index];
        int cnt = 0;
        for(int i = index-1 ; i >= 0; i--){
            if(target == temp2[i]){
                cnt++;
            }
            else break;
        }
        int answer = 0;
        for(int i = 0; i < M; i++){
            if(target == Count[i]){
                if(cnt == 0){
                    answer = i;
                    break;
                }
                cnt--;
            }
        }
        return answer;
    }



    public static void main(String[] args) throws Exception {
        new Back_1561().solution();
    }
}
