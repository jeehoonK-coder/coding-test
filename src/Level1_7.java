//Level1
//예산 ( Summer/Winter Coding)


import java.util.Arrays;

public class Level1_7 {
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;
        int answer = 0;
        Arrays.sort(d);
        for(int bud: d){
            if(budget - bud >= 0 ){
                budget-=bud;
                answer++;
            }
            else{
                break;
            }
        }
        System.out.println(answer);
    }

}
