//Back_7682 틱택토
//구현

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_7682 {

    static char[][] Array = new char[3][3];

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            int k = 0;
            int x = 0;
            int o = 0;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3 ; j++){
                    Array[i][j] = str.charAt(k);
                    if(str.charAt(k) == 'O') o++;
                    else if(str.charAt(k) == 'X') x++;
                    k++;
                }
            }
            int[] answer = checkBingo(str);
            if(answer[0] > 0){
                if(answer[1] > 0) bw.write("invalid\n");
                else if( x - o == 1) bw.write("valid\n");
                else bw.write("invalid\n");
            }
            else if(answer[1] > 0){
                if( x - o == 0) bw.write("valid\n");
                else bw.write("invalid\n");
            }
            else{
                if( x+o == 9 && x-o == 1) bw.write("valid\n");
                else bw.write("invalid\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int[] checkBingo(String str){
        int[][] line = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        int[] count = new int[2];
        for(int[] l : line){
            if(str.charAt(l[0]) == str.charAt(l[1]) && str.charAt(l[1]) == str.charAt(l[2])){
                if(str.charAt(l[0]) == 'O') count[1]++;
                else if(str.charAt(l[0]) == 'X') count[0]++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws Exception {
        new Back_7682().solution();
    }
}
