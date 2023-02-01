//Back_18869 멀티버스2
//좌표압축 (18870이랑 연결)
//좌표압축 알고리즘 (hashmap이 아닌 이분탐색으로 자신의 위치를 판단할 수 있음, lowerbound) -> 그러면 이분탐색 문제

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_18869 {

    static int M,N;
    static int[][] PlanetList;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        PlanetList = new int[M][N];
        int[][] temp = new int[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                PlanetList[i][j] = Integer.parseInt(st.nextToken());
                temp[i][j] = PlanetList[i][j];
            }
        }
        int[][] zip = new int[M][N];
        for(int i = 0; i < M; i++){
            Arrays.sort(temp[i]);
            int cnt = 0;
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for(int j = 0; j < N;j++){
                if(!hashMap.containsKey(temp[i][j])){
                    hashMap.put(temp[i][j], cnt++);
                }
            }
            for(int j = 0; j < N; j++){
                zip[i][j] = hashMap.get(PlanetList[i][j]);
            }
        }

        int answer = 0;

        for(int i = 0; i < M - 1; i++){
            for(int j = i + 1; j < M; j++){
                boolean equal = true;
                for(int k = 0; k < N; k++){
                    if(zip[i][k] != zip[j][k]) {
                        equal = false;
                        break;
                    }
                }
                if(equal) answer++;
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }



    public static void main(String[] args) throws Exception {
        new Back_18869().solution();
    }
}
