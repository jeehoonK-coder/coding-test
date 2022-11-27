//Back_11723 집합 (실버)
//집합, 비트마스킹..?

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Back_11723 {

    static int M;
    static String Str;
    static Set<Integer> set = new HashSet<>();

    /*
    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            Str = st.nextToken();
            switch(Str){
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;

                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;

                case "check":
                    if(set.contains(Integer.parseInt(st.nextToken()))) bw.write(1+"\n");
                    else{
                        bw.write(0+"\n");
                    }
                    break;

                case "toggle":
                     int k = Integer.parseInt(st.nextToken());
                     if(set.contains(k)) set.remove(k);
                     else{
                         set.add(k);
                     }
                     break;

                case "all":
                    set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
                    break;

                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }

        bw.flush();

    }
     */

    //비트마스킹 활용
    static int switchForNums = 0;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            Str = st.nextToken();
            int num;
            switch(Str){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    switchForNums = switchForNums | (1<<num);
                    break;

                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    switchForNums = switchForNums & ~(1<<num);
                    break;

                case "check":
                    num = Integer.parseInt(st.nextToken());
                    bw.write(((switchForNums & (1<<num)) >> num) + "\n");
                    break;

                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    switchForNums = switchForNums ^ (1<<num);
                    break;

                case "all":
                    switchForNums = ~0;
                    break;

                case "empty":
                    switchForNums = 0;
                    break;
            }
        }

        bw.flush();
        bw.close();

    }


    public static void main(String[] args) throws Exception {
        new Back_11723().solution();
    }
}
