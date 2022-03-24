//Level1
//소수 만들기 ( Summer/Winter Coding )

public class Level1_10 {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        int answer = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(checkPrimeNum(nums[i]+nums[j]+nums[k])){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    //소수 만드는 함수
   private static boolean checkPrimeNum(int num){
        boolean check = true;
        for(int i = 2 ; i < num ; i++) {
            if (num % i == 0) {
                check = false;
            }
        }
        return check;
    }
}
