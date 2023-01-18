//Back_5014 스타트링크
//BFS

package algorithm.dfs_bfs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_5014 {

    int F,S,H,U,D;
    boolean[] check;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        check = new boolean[F+1];
        int answer = BFS();
        if(answer == -1) System.out.println("use the stairs");
        else{
            System.out.println(answer);
        }

    }

    public int BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S,0});

        while(true){
            int[] a = q.poll();
            if(a[0] == H){
                return a[1];
            }
            else{
                if(a[0]-D >0 && !check[a[0]-D]){
                    check[a[0]-D] = true;
                    q.add(new int[]{a[0]-D,a[1]+1});
                }
                if(a[0]+U <= F && !check[a[0]+U]){
                    check[a[0]+U] = true;
                    q.add(new int[]{a[0]+U,a[1]+1});
                }
            }
            if(q.isEmpty()) return -1;

        }
    }

    public static void main(String[] args) throws Exception {
        new Back_5014().solution();
    }

}
