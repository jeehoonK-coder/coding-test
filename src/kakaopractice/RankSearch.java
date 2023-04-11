//2021 KAKAO BLIND RECRUITMENT
//순위 검색

package kakaopractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RankSearch {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};



        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        for (String str : info) {
            String[] data = str.split(" ");
            String[] languages = { data[0], "-" };
            String[] jobs = { data[1], "-" };
            String[] exps = { data[2], "-" };
            String[] foods = { data[3], "-" };
            Integer value = Integer.parseInt(data[4]);
            for (String lang : languages)
                for (String job : jobs)
                    for (String exp : exps)
                        for (String food : foods) {
                            String[] keyData = { lang, job, exp, food };
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>());
                            arr.add(value);
                            hashMap.put(key, arr);
                        }
        }

        for (ArrayList<Integer> scoreList : hashMap.values())
            scoreList.sort(null);

        int[] answer = new int[query.length];
        int i = 0;
        for(String q : query){
            String[] queryData = q.split(" ");
            queryData = removeElement(queryData,"and");
            int target = Integer.parseInt(queryData[4]);
            queryData = Arrays.copyOfRange(queryData,0,4);
            String key = String.join(" ", queryData);

            if(hashMap.containsKey(key)){
                ArrayList<Integer> list = hashMap.get(key);
                int left = 0;
                int right = list.size();
                while(left< right){
                    int mid = (left+right) / 2;
                    if(list.get(mid) >= target)
                        right = mid;
                    else
                        left = mid+1;
                }

                answer[i] = list.size() - left;

            }
            i++;

        }

        for(int ans : answer)
            System.out.println(ans);
        //return answer;

    }

    public static String[] removeElement(String[] arr, String item) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(item);
        list.remove(item);
        list.remove(item);
        return list.toArray(String[]::new);
    }

}


//단순배열 비교를 하면 효율성에서 시간초과가 발생
/*
public class RankSearch {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] answer = new int[query.length];

        for(int i = 0 ; i < query.length; i++){
            String[] eachQuery = query[i].split(" ");
            eachQuery = removeElement(eachQuery, "and");

            for(String each : info){
                String[] eachInfo = each.split(" ");
                for(int j = 0; j < 4; j++){
                    if(!eachInfo[j].equals(eachQuery[j])  && !eachQuery[j].equals("-")){
                        break;
                    }
                    if(j==3 && Integer.parseInt(eachInfo[4]) >= Integer.parseInt(eachQuery[4]) ){
                        answer[i] += 1;
                    }
                }
            }
        }

        for(int ans : answer)
            System.out.println(ans);
        //return answer;

    }

    public static String[] removeElement(String[] arr, String item) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(item);
        list.remove(item);
        list.remove(item);
        return list.toArray(String[]::new);
    }
}
*/
