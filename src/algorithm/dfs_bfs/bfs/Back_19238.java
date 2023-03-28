/**
 *  23.03.28
 *  Back_19238 스타트 택시
 *  BFS, 시뮬레이션
 *
 *  1. ↑ ← → ↓ 이 우선순위가 아니었던것이 틀린 이유
 *  2. 가장 가까운 승객의 위치를 찾는다. -> 승객을 태우고 갈 수 있는 연료가 있는지 체크 -> 반복
 *
 *  cf) https://osnim.tistory.com/entry/백준-19238-스타트-택시-파이썬
 */


package algorithm.dfs_bfs.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_19238 {

    static int N,M,L,Taxi_X, Taxi_Y;
    static int[][] Array;
    static Passenger[] PassengerArray;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};

    static class Passenger{
        int start_x;
        int start_y;
        int end_x;
        int end_y;
        int distance;

        Passenger(int start_x, int start_y, int end_x, int end_y){
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Array = new int[N][N];
        PassengerArray = new Passenger[M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Taxi_X = Integer.parseInt(st.nextToken())-1;
        Taxi_Y = Integer.parseInt(st.nextToken())-1;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            PassengerArray[i] = new Passenger(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
            //승객의 위치를 인덱스+2로 저장
            int x = PassengerArray[i].start_x;
            int y = PassengerArray[i].start_y;
            Array[x][y] = i+2;
            PassengerArray[i].distance = BFS_distance(PassengerArray[i]);
        }
        int answer = 0;
        boolean chk = true;
        //승객을 태워보자
        for(int i = 0; i < M; i++){
            if(simulation()){
                continue;
            }
            else{
                chk = false;
                answer = -1;
            }
        }
        if(chk) answer = L;
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public boolean simulation() {
        //택시로부터 가까운 승객위치, 거리
        int[] info = BFS();
        if(info == null) return false;
        Passenger passenger = PassengerArray[info[0]-2];
        Array[passenger.start_x][passenger.start_y] = 0;
        //왔다갔다 할 수 있는지
        if(passenger.distance == -1) return false;
        if(L >= info[1] + passenger.distance){
            L -= (info[1] + passenger.distance);
            L += (passenger.distance*2);
            Taxi_X = passenger.end_x;
            Taxi_Y = passenger.end_y;
            return true;
        }
        return false;
    }

    //승객의 출발점에서 목적지까지의 거리
    public int BFS_distance(Passenger passenger) {
        int[][] check = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{passenger.start_x, passenger.start_y,0});
        check[passenger.start_x][passenger.start_y] = 1;

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            if(passenger.end_x == point[0] && passenger.end_y == point[1]){
                return point[2];
            }
            for(int i = 0; i < 4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                if(check[nx][ny] == 0 && Array[nx][ny] != 1){
                    queue.add(new int[]{nx,ny,point[2]+1});
                    check[nx][ny] = 1;
                }
            }
        }
        return -1;
    }

    //택시에서 가장 가까운 승객을 찾는 함수
    public int[] BFS(){
        int[][] check = new int[N][N];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] == o2[2]){
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
            return o1[2] - o2[2];
        });
        queue.add(new int[]{Taxi_X,Taxi_Y,0});
        check[Taxi_X][Taxi_Y] = 1;

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            if(Array[point[0]][point[1]] > 1){
                return new int[]{Array[point[0]][point[1]], point[2]};
            }
            for(int i = 0; i < 4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                if(check[nx][ny] == 0 && Array[nx][ny] != 1){
                    queue.add(new int[]{nx,ny,point[2]+1});
                    check[nx][ny] = 1;
                }
            }
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        new Back_19238().solution();
    }
}
