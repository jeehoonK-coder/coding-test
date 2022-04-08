//Level2
//소수찾기

package Level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Level2_4 {
    static HashSet<Integer> outputNum = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "17";
        int answer = 0;
        List<Character> numberChar = new ArrayList<>();
        char[] output = new char[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];
        int n = numbers.length();

        for(int i =0; i < numbers.length();i++){
            numberChar.add(numbers.charAt(i));
        }
        for(int i = 1; i<=n; i++){
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            permutation(numberChar, output, visited, 0,n,i);
        }

        answer = outputNum.size();
        System.out.println();
        System.out.println(answer);


    }

    static void permutation(List<Character> arr, char[] output, boolean[] visited, int depth, int n, int r){
        if(depth == r){
            String number = "";
            for(int i =0; i<r;i++){
                number+= output[i];
            }
            if(checkPrime(Integer.parseInt(number))){
                System.out.println(Integer.parseInt(number));
                outputNum.add(Integer.parseInt(number));
            }
//            System.out.println(number);
//            System.out.println(Integer.parseInt(number));
//            System.out.println();
        }
        for(int i =0; i< n; i++){
            if (visited[i] != true) {
                visited[i] = true;
                output[depth]= arr.get(i);
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;;
            }
        }
    }

    //소수찾기
    static boolean checkPrime(int n){
        if(n==2){
            return true;
        }
        if(n==0 || n==1){
            return false;
        }
        for(int i = 2; i< n ; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
