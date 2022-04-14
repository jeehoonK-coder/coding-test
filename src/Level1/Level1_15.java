//Level1
//다트 게임

package Level1;

import java.util.LinkedList;
import java.util.Queue;

public class Level1_15 {
    public static void main(String[] args) {
        String dartResult = "1D2S#10S";

        int answer = 0;

        Queue<Integer> score = new LinkedList<>();
        int present = -11;
        String after = "";
        for(int i = 0; i<dartResult.length();i++){
            String s = "";

            if(i == dartResult.length()-1){
                s = dartResult.substring(i);
            }
            else{
                s = dartResult.substring(i,i+1);
            }

            if( s.equals("S")){
                present *= 1;
            }
            else if(s.equals("D")){
                present = present*present;
            }
            else if(s.equals("T")){
                present = present*present*present;
            }
            else if(s.equals("*")){
                if(score.isEmpty()){
                    present *= 2;
                }
                else{
                    int pre = score.poll();
                    answer += pre*2;
                    present *= 2;
                }
            }
            else if(s.equals("#")){
                present *= (-1);
            }
            else{
                 if(after.equals("1") && s.equals("0")){
                    present = 10;
                }
                else if(present != -11){
                    if(!score.isEmpty()){
                        answer += score.poll();
                    }
                    score.add(present);
                    present = Integer.parseInt(s);
                }

                else{
                    present = Integer.parseInt(s);
                }
            }

            after = s;
            System.out.print(i);
            System.out.println(after);
        }
        if(!score.isEmpty()){
            answer += score.poll();
        }
        answer += present;


        System.out.println(answer);

    }

}
