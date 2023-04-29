//Back_1697 숨바꼭질 (실버)
//

package algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1697 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if(A == B)  System.out.println(0);
        else{
            int answer = BFS(A,B);
            System.out.println(answer);
        }
        //test code
    }

    public int BFS(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,0});
        int depth = 0;
        int[] visited = new int[100001];
        while(true){
            int[] num = q.poll();
            int n;

            if(num[0] > b){
                n = num[0]-1;
                if(n == b){
                    depth = num[1]+1;
                    break;
                }
                else if(n >= 0 && n <= 100000 && visited[n] == 0){
                    q.add(new int[]{n,num[1]+1});
                    visited[n] = 1;
                }
            }
            else{
                n = num[0]+1;
                if(n == b){
                    depth = num[1]+1;
                    break;
                }
                else if(n >= 0 && n <= 100000 && visited[n] == 0){
                    q.add(new int[]{n,num[1]+1});
                    visited[n] = 1;
                }
                n = num[0]-1;
                if(n == b){
                    depth = num[1]+1;
                    break;
                }
                else if(n >= 0 && n <= 100000 && visited[n] == 0){
                    q.add(new int[]{n,num[1]+1});
                    visited[n] = 1;
                }
                n = num[0]*2;
                if(n == b){
                    depth = num[1]+1;
                    break;
                }
                else if(n >= 0 && n <= 100000 && visited[n] == 0){
                    q.add(new int[]{n,num[1]+1});
                    visited[n] = 1;
                }
            }


        }
        return depth;


    }

    public static void main(String[] args) throws Exception{
        new Back_1697().solution();
    }
}







