/**
 *  23.04.11
 *  2023 KAKAO BLIND RECRUITMENT
 *  택배 배달과 수거하기
 *  level 2
 *
 *  투 포인터
 *  -> 옛날보다 성장함
 */

package kakaopractice.blind2023;

public class No2 {

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1,0,3,1,2};
        int[] pickups = {0,3,0,4,0};

        int dPoint = n-1;
        int pPoint = n-1;

        long answer = 0;

        while(dPoint >= 0 || pPoint >=0){
            while(dPoint >= 0 && deliveries[dPoint] == 0){
                dPoint--;
            }
            while(pPoint >= 0 && pickups[pPoint] == 0){
                pPoint--;
            }

            int d = 0;
            answer += (Math.max(dPoint,pPoint)+1)*2;
            while(dPoint >= 0){
                if(d+deliveries[dPoint] <= cap){
                    d += deliveries[dPoint];
                    deliveries[dPoint] = 0;
                    dPoint--;
                }
                else{
                    deliveries[dPoint] -= cap - d;
                    break;
                }
            }

            int p = 0;
            while(pPoint >= 0){
                if(p+pickups[pPoint] <= cap){
                    p += pickups[pPoint];
                    pickups[pPoint] = 0;
                    pPoint--;
                }
                else{
                    pickups[pPoint] -= cap - p;
                    break;
                }
            }

        }
        System.out.println(answer);

    }
}
