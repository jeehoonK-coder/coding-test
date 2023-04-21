//Back_7569 토마토
//while문으로 반복을 하거나 DFS를 돌리면 시간초과가 발생
//DFS를 돌릴 경우 DFS는 우선적으로 하나의 익은 토마토를 기점으로 확산시키기 때문에 과부하 발생
//BFS를 사용한 이유는 토마토들이 점차 확산되어가고 익는데 며칠이 걸리는지 구해야 하기 때문


package algorithm.graph;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_7569 {
    int M,N,H;
    int[][][] array;
    int[] dx = {0,1,0,-1,0,0};
    int[] dy = {1,0,-1,0,0,0};
    int[] dz = {0,0,0,0,1,-1};
    Queue<int[]> q = new LinkedList<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        array = new int[N][M][H];
        boolean check = false;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k< M ; k++){
                    array[j][k][i] = Integer.parseInt(st.nextToken());
                    if(array[j][k][i] == 1){
                        q.add(new int[]{j,k,i});
                    }
                    else if(array[j][k][i] == 0){
                        check = true;
                    }
                }
            }
        }
        if(check){
            BFS();
            int max = 0;
            for(int i = 0; i < H; i++){
                for(int j = 0; j < N ; j++){
                    for(int k = 0; k< M ; k++){
                        if(array[j][k][i] == 0){
                            System.out.println(-1);
                            return;
                        }
                        else{
                            if(array[j][k][i] > max) max =array[j][k][i];
                        }
                    }
                }
            }
            System.out.println(max-1);
        }
        else{
            System.out.println(0);
            return;
        }

    }

    public void BFS(){
        while(!q.isEmpty()){
            int[] xyz = q.poll();
            for(int a = 0;a<6 ; a++){
                int dj = xyz[0]+dx[a];
                int dk = xyz[1]+dy[a];
                int di = xyz[2]+dz[a];
                if(dj>= 0 && dj < N && dk>= 0 && dk < M && di>= 0 && di < H){
                    if(array[dj][dk][di] == 0 || array[dj][dk][di] > array[xyz[0]][xyz[1]][xyz[2]]+1){
                        array[dj][dk][di] = array[xyz[0]][xyz[1]][xyz[2]]+1;
                        q.add(new int[]{dj,dk,di});
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Back_7569().solution();
    }

}

//시간초과
/*
public class Back_7569 {
    int M,N,H;
    int[][][] array,temp;
    int[] dx = {0,1,0,-1,0,0};
    int[] dy = {1,0,-1,0,0,0};
    int[] dz = {0,0,0,0,1,-1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        array = new int[N][M][H];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k< M ; k++){
                    array[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }
        int count = 0;
        while(true){
            if(change()) array = temp;
            else{
                break;
            }
            count++;
        }
        if(check()) System.out.println(count);
        else{
            System.out.println(-1);
        }


    }

    public boolean change(){
        boolean ch = false;
        temp = new int[N][M][H];
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N ; j++){
                for(int k = 0; k< M ; k++){
                    if(array[j][k][i] == 1){
                        for(int a = 0;a<6 ; a++){
                            int dj = j+dx[a];
                            int dk = k+dy[a];
                            int di = i+dz[a];
                            temp[j][k][i] = 1;
                            if(dj>= 0 && dj < N && dk>= 0 && dk < M && di>= 0 && di < H){
                                if(array[dj][dk][di] == 0){
                                    temp[dj][dk][di] = 1;
                                    ch = true;
                                }
                            }
                        }
                    }
                    else if(array[j][k][i] == -1) temp[j][k][i] = -1;
                }
            }
        }

        return ch;
    }

    public boolean check(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N ; j++){
                for(int k = 0; k< M ; k++){
                    if(array[j][k][i] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Back_7569().solution();
    }

}
 */