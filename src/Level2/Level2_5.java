//Level2 (Programmers)
//기능개발 (큐/스택)

package Level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_5 {
    public static void main(String[] args) {
        int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1,1,1,1,1,1};
        List<Integer> ans = new ArrayList<Integer>();
        boolean progress = true;
        int count = 0;
        while(progress){
            int pre = count;
            System.out.println(pre);
            for(int i = count; i< progresses.length; i++){
                progresses[i] += speeds[i];
            }
            if(progresses[count] >= 100){
                for(int j = count+1; j<progresses.length; j++){
                    if(progresses[j] < 100){
                        count = j;
                        ans.add(count-pre);
                        break;
                    }
                    else if(j == progresses.length-1){
                        count = j;
                    }
                }
                if(count == progresses.length-1 && progresses[count] >=100){
                    progress = false;
                    count+=1;
                    ans.add(count-pre);
                }
            }

        }
        System.out.println(ans);
//        int[] answer = new int[ans.size()];
//        for(int i = 0; i< ans.size();i++){
//            answer[i] = ans.get(i);
//        }
    }
}

//Queue
/*
for (int i = 0; i < speeds.length; i++) {
    double remain = (100 - progresses[i]) / (double) speeds[i];
    int date = (int) Math.ceil(remain);

    if (!q.isEmpty() && q.peek() < date) {
        answerList.add(q.size());
        q.clear();
    }

    q.offer(date);
}

answerList.add(q.size());
*/