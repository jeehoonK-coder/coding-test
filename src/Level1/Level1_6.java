//Level1
//실패율 ( 2019 KAKAO BLIND )

package Level1;

import java.util.Arrays;

public class Level1_6 {
    public static void main(String[] args) {
        int N = 4;
        int[] stages = {4,4,4,4,4};
        double[][] rate = new double[N][2];
        for(int i = 0; i< N ; i++){
            rate[i][0] = i+1;
        }
        Arrays.sort(stages);
        int[] answer = new int[N];
        int totalNum = stages.length;
        int stageNum = 0;
        double count = 1;

        for(int i = 0; i < stages.length; i++){
            stageNum = stages[i];
            if(i < stages.length-1 && stageNum == stages[i+1]){
                count++;
            }
            else{
                if(stages[i] > N){
                    //rate[stageNum-2][1] = totalNum==0 ? 0 :totalNum-count / totalNum ;
                }
                else{
                    rate[stageNum-1][1] = totalNum==0 ? 0 :count / totalNum ;
                    totalNum -= count;
                    count = 1;
                }
            }
        }
        for(int i = 0; i< N; i++){
            for(int  j = 0 ; j<2; j++){
                System.out.println(rate[i][j]);
            }
        }
        Arrays.sort(rate, (num1, num2) -> {
            return Double.compare(num2[1],num1[1]);
        });
        System.out.println("------------------------");
        for(int i = 0; i< N; i++){
            answer[i] += (int)rate[i][0];
        }
        for(int i = 0; i< N; i++){
            System.out.println(answer[i]);
        }

    }
}

/*
import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] rate = new double[N][2];
        for(int i = 0; i< N ; i++){
            rate[i][0] = i+1;
        }
        Arrays.sort(stages);
        int[] answer = new int[N];
        int totalNum = stages.length;
        int stageNum = 0;
        double count = 1;

        for(int i = 0; i < stages.length; i++){
            stageNum = stages[i];
            if(i < stages.length-1 && stageNum == stages[i+1]){
                count++;
            }
            else{
                if(stages[i] <= N){
                    rate[stageNum-1][1] = totalNum==0? 0 :count / totalNum ;
                    totalNum -= count;
                    count = 1;
                }
            }
        }
        Arrays.sort(rate, (num1, num2) -> {
            return Double.compare(num2[1],num1[1]);
        });
        for(int i = 0; i< N; i++){
            answer[i] += (int)rate[i][0];
        }
        return answer;
    }
}
 */