//Back_5430 AC
//구현, 디큐

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Back_5430 {

    static int T, N;
    static Deque<Integer> DQ;
    static String P;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        roop:
        while (T-- > 0) {
            DQ = new ArrayDeque<>();
            P = br.readLine();
            N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1,str.length()-1);
            if(str.length() != 0){
                String[] strArray = str.split(",");
                for(String s : strArray){
                    DQ.add(Integer.parseInt(s));
                }
            }
            boolean first = true;
            for (int i = 0; i < P.length(); i++) {
                if (P.charAt(i) == 'R') {
                    if(first) first = false;
                    else first = true;
                }
                else if (P.charAt(i) == 'D') {
                    if (DQ.isEmpty()) {
                        bw.write("error\n");
                        continue roop;
                    } else {
                        if(first) DQ.poll();
                        else DQ.pollLast();
                    }
                }
            }
            if(!first) DQ = R();
            if(DQ.isEmpty()){
                bw.write("[]\n");
            }
            else{
                bw.write("[" + DQ.poll());
                while (!DQ.isEmpty()) {
                    bw.write("," + DQ.poll());
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public Deque<Integer> R() {
        Deque<Integer> dq = new ArrayDeque<>();
        while (!DQ.isEmpty())
            dq.add(DQ.pollLast());

        return dq;
    }

    public static void main(String[] args) throws Exception {
        new Back_5430().solution();
    }

}
