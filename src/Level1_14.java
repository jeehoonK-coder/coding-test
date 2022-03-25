//Level1
//신고 결과 받기 ( 2020 KAKAO BLIND RECRUITMENT )
//22.03.24

import java.util.Arrays;
import java.util.HashSet;

public class Level1_14 {
    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con" };
        int k = 3;
        HashSet<String> reportSet = new HashSet<>();
        for(String str : report){
            reportSet.add(str);
        }

        int[] answer = new int[id_list.length];
        int[] callCnt = new int[id_list.length];
        String[] str = {};
        for(String rep : reportSet){
            str= rep.split(" ");
            callCnt[Arrays.asList(id_list).indexOf(str[1])]++;
        }

        for(String rep : reportSet){
            str = rep.split(" ");
            if(callCnt[Arrays.asList(id_list).indexOf(str[1])] >= k){
                answer[Arrays.asList(id_list).indexOf(str[0])]++;
            }
        }
        for(int cnt : answer){
            System.out.println(cnt);
        }
        System.out.println(answer);
    }
}
