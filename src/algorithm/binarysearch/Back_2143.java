//Back_2143 두 배열의 합
//이분 탐색, 투 포인터

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_2143 {

    static long T;
    static int N,M;
    static long[] ArrayA,ArrayB;
    static List<Long> ListA = new ArrayList<>();
    static List<Long> ListB = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        ArrayA = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            ArrayA[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        ArrayB = new long[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            ArrayB[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += ArrayA[j];
                ListA.add(sum);
            }
        }

        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += ArrayB[j];
                ListB.add(sum);
            }
        }

        ListA.sort(Comparator.naturalOrder());
        ListB.sort(Comparator.naturalOrder());

        bw.write(Search() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public long Search() {
        int startA = 0, endA = ListA.size() - 1;
        int startB = 0, endB = ListB.size() - 1;
        long sum = 0L;
        long count = 0;
        while(startA <= endA && endB >= 0){
            sum = ListA.get(startA) + ListB.get(endB);
            if(sum == T) {
                long a = ListA.get(startA);
                long b = ListB.get(endB);
                long aCnt = 0;
                long bCnt = 0;

                while (startA < ListA.size() && ListA.get(startA) == a) {
                    aCnt++;
                    startA++;
                }
                while (endB >= 0 && ListB.get(endB) == b) {
                    bCnt++;
                    endB--;
                }
                System.out.println("aCnt = " + aCnt);
                System.out.println("bCnt = " + bCnt);
                count += aCnt * bCnt;

                /*long s = 1;
                long e = 1;
                while(startA < endA && ListA.get(startA) == ListA.get(startA + 1) ){
                    startA++;
                    s++;
                }
                startA++;
                while(endB > 0 && ListB.get(endB) == ListB.get(endB -1) ){
                    endB--;
                    e++;
                }
                endB--;
                System.out.println("s = " + s);
                System.out.println("e = " + e);
                count += s*e;*/
            }
            else if(sum > T) {
                endB -= 1;
            }
            else if(sum < T) {
                startA += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        new Back_2143().solution();
    }

}
