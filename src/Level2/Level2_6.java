//Level2 (Programmers)
//다리를 지나는 트럭

package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_6 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        Queue<Integer> truckQ = new LinkedList<Integer>();
        int answer = 0;
        int present_weight = 0;

        for(int i = 0; i< truck_weights.length;i++){
            while(true){
                if(truckQ.isEmpty()){
                    truckQ.add(truck_weights[i]);
                    present_weight += truck_weights[i];
                    answer += 1;
                    break;
                }
                else if(truckQ.size() == bridge_length){
                    present_weight -= truckQ.poll();
                }
                else{
                    if(present_weight+truck_weights[i] <= weight){
                        truckQ.add(truck_weights[i]);
                        present_weight += truck_weights[i];
                        answer += 1;
                        break;
                    }
                    else{
                        truckQ.add(0);
                        answer+=1;
                    }
                }
            }
        }
        answer += bridge_length;
        System.out.println(answer);
    }
}
