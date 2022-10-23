//Back_2667 단지번호붙이기 (실버)
//BFS (check를 사용하지 않아도 됨)

package Algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Back_2667 {

    int n;
    int[][] array, check;
    //우,하,상,좌
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        check = new int[n][n];
        for(int i = 0; i < n ; i++){
            String str = br.readLine();
            String[] list = str.split("");
            for(int j = 0; j<list.length;j++){
                array[i][j] = Integer.parseInt(list[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            for(int j = 0; j<n;j++){
                if(array[i][j] == 1){
                    array[i][j] = 0;
                    list.add(BFS(i,j));
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        sb.append(list.size()).append("\n");
        for(int a : list){
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    public int BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int count = 0;
        while(!q.isEmpty()){
            int[] point = q.poll();
            count += 1;
            for(int i = 0; i < 4; i++){
                int nx = point[0]+dx[i];
                int ny = point[1]+dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && array[nx][ny] == 1 /*&& check[nx][ny] == 0*/){
                    q.add(new int[]{nx,ny});
                    array[nx][ny] = 0;
                    //check[nx][ny] = 1;

                }
            }

        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new Back_2667().solution();
    }
}
