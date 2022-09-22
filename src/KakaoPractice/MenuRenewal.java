//2021 KAKAO BLIND RECRUITMENT
//메뉴리뉴얼
//HashMap 이용



package KakaoPractice;

import java.util.*;

public class MenuRenewal {

    static List<String> answerList = new ArrayList<>();
    static Map<String, Integer> hashMap = new HashMap<>();


    public static void main(String[] args) {

        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

        for(int j = 0 ; j < course.length;j++){
            for(int i = 0; i < orders.length; i++){
                String[] order = orders[i].split("");
                Arrays.sort(order);
                boolean[] visited = new boolean[order.length];
                if(order.length >= course[j])
                    combination(order,visited,order.length, course[j],0);
            }
            System.out.println(hashMap);
            if(!hashMap.isEmpty()){
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);
                if(max > 1){
                    for(String key : hashMap.keySet()){
                        if(hashMap.get(key) == max){
                            answerList.add(key);
                        }
                    }
                }
                hashMap.clear();
            }

        }
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);

        System.out.println(answerList);

    }

    public static void combination(String[] str, boolean[] visited, int n, int r, int depth){
        if(r==0 ){
            String s = "";
            for(int i = 0; i < n ; i++){
                if(visited[i]){
                    s += str[i];
                }
            }
            hashMap.put(s, hashMap.getOrDefault(s,0)+1);
            return;

        }
        if(depth==n){
            return;
        }
        visited[depth] = true;
        combination(str,visited, n, r-1, depth+1);

        visited[depth] = false;
        combination(str,visited, n, r, depth+1);
    }


}
