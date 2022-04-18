//BackJoon Question
//No.14888 연산자 끼워넣기

package Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Operator {

    private HashSet<String> opSet = new HashSet<>();

    private int[] calcul(int[] numberArr, int[] operatorArr){
        List<Integer> opList = new ArrayList<>();
        for(int i=0; i< 4; i++){
            for(int j = 0; j < operatorArr[i];j++){
                opList.add(i);
            }
        }

        int[] output = new int[numberArr.length-1];
        boolean[] visited = new boolean[numberArr.length-1];
        permutation(opList, output, visited, 0, numberArr.length-1);

        int[] outNumber = new int[opSet.size()];
        int k = 0;
        for(String s : opSet){
            int present = numberArr[0];
            for(int i = 1; i< numberArr.length;i++){
                switch(s.charAt(i-1)){
                    case '0':
                        present += numberArr[i];
                        break;
                    case '1':
                        present -= numberArr[i];
                        break;
                    case '2':
                        present *= numberArr[i];
                        break;
                    case '3':
                        if(present < 0){
                            present = present*(-1)/numberArr[i];
                            present *= (-1);
                        }
                        else{
                            present /= numberArr[i];
                        }
                        break;
                    default:
                        break;
                }
            }
            outNumber[k] = present;
            k++;
        }
        int[] answer = new int[2];
        Arrays.sort(outNumber);
        answer[0] = outNumber[opSet.size()-1];
        answer[1] = outNumber[0];

        return answer;
    }

    private void permutation(List<Integer> arr, int[] output, boolean[] visited, int depth, int n){
        if(depth == n){
            String s = "";
            for(int i =0; i<n;i++){
                s += Integer.toString(output[i]);
            }
            opSet.add(s);
        }
        for(int i =0; i< n; i++){
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr.get(i);
                permutation(arr, output, visited, depth + 1, n);
                visited[i] = false;;
            }
        }
    }



    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numberArr = new int[N];
        int[] operatorArr = new int[4];
        for(int i = 0; i <N;i++){
            numberArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< 4;i++){
            operatorArr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = calcul(numberArr,operatorArr);
        for(int i = 0; i< 2; i++){
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Operator().solution();
    }
}
