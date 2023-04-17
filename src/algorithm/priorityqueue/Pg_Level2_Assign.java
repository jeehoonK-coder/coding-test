/**
 *  23.04.15
 *  Programmers Level2 과제 진행하기
 *  우선순위 큐 , 구현
 *
 *
 */

package algorithm.priorityqueue;

import java.util.PriorityQueue;

public class Pg_Level2_Assign {

    static class plan {
        String name;
        int min;
        int time;

        plan(String name, int min, int time){
            this.name = name;
            this.min = min;
            this.time = time;
        }
    }


    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"},{"history", "14:00", "30"}, {"computer", "12:30", "100"}};


        PriorityQueue<plan> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.min - o2.min;
        });

        PriorityQueue<plan> pqStop = new PriorityQueue<>((o1, o2) -> {
            return o2.min - o1.min;
        });


        for(int i = 0; i < plans.length; i++){
            pq.add(new plan(plans[i][0]
                    , Integer.parseInt(plans[i][1].substring(0,2)) * 60 + Integer.parseInt(plans[i][1].substring(3,5))
                    , Integer.parseInt(plans[i][2])));
        }

        String[] answer = new String[plans.length];
        int idx = 0;
        while(!pq.isEmpty()){
            plan p = pq.poll();

            if(pq.isEmpty()){
                answer[idx] = p.name;
                idx++;
            }
            else if(p.min+p.time > pq.peek().min){
                int gap = pq.peek().min - p.min;
                p.min = pq.peek().min;
                p.time -= gap;
                pqStop.add(p);
            }
            else{
                answer[idx] = p.name;
                idx++;
                int diff = pq.peek().min - p.min-p.time;
                while(!pqStop.isEmpty() && diff > 0){
                    if(diff >= pqStop.peek().time){
                        diff -= pqStop.peek().time;
                        answer[idx] = pqStop.poll().name;
                        idx++;
                    }
                    else{
                        pqStop.peek().time -= diff;
                        pqStop.peek().min = pq.peek().min;
                        diff = 0;
                    }
                }
            }
        }
        while(!pqStop.isEmpty()){
            plan p = pqStop.poll();
            answer[idx] = p.name;
            idx++;
        }


        System.out.println(answer);

    }
}
