//Level1
//로또의 최고 순위와 최저 순위
//22.03.24

import java.util.stream.IntStream;

public class Level1_13 {
    public static void main(String[] args) {
        int[] lottos = {44,1,0,0,31,25};
        int[] win_nums = {31,10,45,1,6,19};
        int[] answer = new int[2];
        int correct = 0;
        int zeroCnt = 0;

        for(int i = 0 ; i < 6; i++){
            int num = lottos[i];
            if(lottos[i] == 0){
                zeroCnt++;
            }
            else if(IntStream.of(win_nums).anyMatch(x->x==num)){
                correct++;
            }
        }
        answer[0] = 7- (correct+zeroCnt) == 7 ? 6 :  7-(correct+zeroCnt);
        answer[1] = 7- correct == 7 ? 6 :  7-correct;

        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
}
