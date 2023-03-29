/**
 *  23.03.29
 *  Back_14867 물통
 *  BFS
 *
 *  1. 100000 * 100000 크기의 2차원 boolean 배열을 Heap Space가 부족하기 때문에 생성할 수 없다.
 *  2. HashSet을 이용하여 방문 체크를 한다.
 *
 *  -> 최소시간, 최단시간 나오면 무조건 BFS / 이 문제처럼 모든 경우의 수를 다 집어넣어도 된다.
 */


package algorithm.dfs_bfs.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_14867 {

    static int c,d;
    static int[] Full = new int[2];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //a,b
        Full[0] = Integer.parseInt(st.nextToken());
        Full[1] = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int answer = BFS();

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("0_0");
        while(!queue.isEmpty()){
            int[] water = queue.poll();
            if(water[0] == c && water[1] == d){
                return water[2];
            }

            //BFS
            int[] temp = water.clone();
            Fill(0, temp);
            String str = temp[0]+"_"+temp[1];
            if(!hashSet.contains(str)){
                temp[2] += 1;
                hashSet.add(str);
                queue.add(new int[]{temp[0],temp[1],temp[2]});
            }

            temp = water.clone();
            Fill(1, temp);
            str = temp[0]+"_"+temp[1];
            if(!hashSet.contains(str)){
                temp[2] += 1;
                hashSet.add(str);
                queue.add(new int[]{temp[0],temp[1],temp[2]});
            }
            //-------------//
            temp = water.clone();
            Empty(0, temp);
            str = temp[0]+"_"+temp[1];
            if(!hashSet.contains(str)){
                temp[2] += 1;
                hashSet.add(str);
                queue.add(new int[]{temp[0],temp[1],temp[2]});
            }

            temp = water.clone();
            Empty(1, temp);
            str = temp[0]+"_"+temp[1];
            if(!hashSet.contains(str)){
                temp[2] += 1;
                hashSet.add(str);
                queue.add(new int[]{temp[0],temp[1],temp[2]});
            }

            //--------------//

            temp = water.clone();
            Move(0,1, temp);
            str = temp[0]+"_"+temp[1];
            if(!hashSet.contains(str)){
                temp[2] += 1;
                hashSet.add(str);
                queue.add(new int[]{temp[0],temp[1],temp[2]});
            }

            temp = water.clone();
            Move(1,0, temp);
            str = temp[0]+"_"+temp[1];
            if(!hashSet.contains(str)){
                temp[2] += 1;
                hashSet.add(str);
                queue.add(new int[]{temp[0],temp[1],temp[2]});
            }

        }
        return -1;
    }

    public void Fill(int idx, int[] water){
        water[idx] = Full[idx];
    }

    public void Empty(int idx, int[] water){
        water[idx] = 0;
    }

    public void Move(int x, int y, int[] water){
        int move = Full[y] - water[y];
        if(water[x] <= move){
            water[y] += water[x];
            water[x] = 0;
        }
        else{
            water[x] -= move;
            water[y] += move;
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_14867().solution();
    }
}
