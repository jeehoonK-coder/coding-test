//Back_20006 랭킹전 대기열 (실버)
//

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_20006 {

    static int P,M;
    static List<List<Player>> List = new LinkedList<>();

    static class Player implements Comparable<Player> {
        int p;
        String n;

        Player(int p, String n){
            this.p = p;
            this.n = n;
        }

        @Override
        public int compareTo(Player o) {

            return n.compareTo(o.n);
//            int result = 0;
//            int len1 = n.length();
//            int len2 = o.n.length();
//            int len = (len1 < len2) ? len1 : len2;
//            for (int i=0; i<len; i++) {
//                if (n.charAt(i) > o.n.charAt(i)) {
//                    result = 1;
//                    break;
//                } else if (n.charAt(i) < o.n.charAt(i)) {
//                    result = -1;
//                    break;
//                }
//            }
//
//            if (result == 0) {
//                if (len1 > len2) {
//                    result = 1;
//                } else if (len1 < len2) {
//                    result = -1;
//                }
//            }
//
//            return result;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()),st.nextToken());

            int index = 0;
            while(true) {
                if (List.size() == 0 || List.size() <= index) {
                    List.add(new ArrayList<Player>(Arrays.asList(player)));
                    break;
                }
                else {
                    List<Player> list = List.get(index);
                    if (list.size() == M) {
                        index++;
                        continue;
                    }
                    if (Math.abs(list.get(0).p - player.p) <= 10) {
                        list.add(player);
                        break;
                    } else {
                        index++;
                    }

                }
            }

        }

        for(List<Player> list : List){
            Collections.sort(list);
            if(list.size() < M){
                bw.write("Waiting!"+"\n");
                for (Player p : list) {
                    bw.write(p.p + " " + p.n + "\n");
                }
            }
            else{
                bw.write("Started!" + "\n");
                for (Player p : list) {
                    bw.write(p.p + " " + p.n + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_20006().solution();
    }
}
