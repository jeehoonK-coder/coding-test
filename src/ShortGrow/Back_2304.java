//Back_2304 창고 다각형 (실버)
//브루트포스, 스택(?)


package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Back_2304 {

    static class Pillar implements Comparable<Pillar> {
        int l;
        int h;

        Pillar(int l,int h){
            this.l = l;
            this.h = h;
        }

        @Override
        public int compareTo(Pillar o) {
            return l - o.l;
        }
    }

    static int N;
    static List<Pillar> PillarList = new ArrayList<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Pillar maxP = new Pillar(0,0);
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(maxP.h < h){
                maxP = new Pillar(l,h);
            }
            PillarList.add(new Pillar(l,h));
        }
        Collections.sort(PillarList);
        int answer = 0;
        Pillar currentP = PillarList.get(0);
        if(currentP.l != maxP.l){
            for(int i = 1; i < PillarList.size(); i++){
                Pillar p = PillarList.get(i);
                if(p.l == maxP.l){
                    answer += currentP.h*(p.l-currentP.l);
                    break;
                }
                if(currentP.h <= p.h){
                    answer += currentP.h*(p.l-currentP.l);
                    currentP = p;
                }
            }
        }
        currentP = PillarList.get(PillarList.size()-1);
        if(currentP.l != maxP.l){
            for(int i = PillarList.size()-2 ; i >= 0; i--){
                Pillar p = PillarList.get(i);
                if(p.l == maxP.l){
                    answer += currentP.h*(currentP.l-p.l);
                    break;
                }
                if(currentP.h <= p.h){
                    answer += currentP.h*(currentP.l-p.l);
                    currentP = p;
                }
            }
        }

        answer += maxP.h;
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_2304().solution();
    }

}
