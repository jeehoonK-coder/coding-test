//Back_5073 삼각형과 세 변 (브론즈)
//수학, 기하학

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_5073 {

    static int[] Array = new int[3];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++){
                Array[i] = Integer.parseInt(st.nextToken());
            }
            if(Array[0] == 0 && Array[1] == 0 && Array[2] == 0){
                break;
            }
            Arrays.sort(Array);
            if(Array[0]+Array[1] <= Array[2]) bw.write("Invalid\n");
            else if(Array[0] == Array[1] && Array[1] == Array[2]) bw.write("Equilateral\n");
            else if(Array[0] == Array[1] || Array[1] == Array[2] || Array[2] == Array[0]) bw.write("Isosceles\n");
            else{
                bw.write("Scalene\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_5073().solution();
    }
}
