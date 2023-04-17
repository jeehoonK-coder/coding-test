/**
 *  23.04.14
 *  2023 KAKAO BLIND RECRUITMENT
 *  미로 탈출 명령어
 *  level 3
 *
 *  1. 평범하게 BFS, DFS하면 시간초과가 발생한다.
 *  2. 그리디 방법으로 풀어야한다.
 *  -> 아래, 왼쪽, 오른쪽, 위쪽 순서대로 쭉 가다가 그 위치에서 목적지까지의 거리가 딱 맞을 때 return을 한다.
 *
 */


package kakaopractice.blind2023;


public class No6 {

    static int N,M,R,C;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static char[] charArr = {'d', 'l', 'r', 'u'};
    static String answer = "";

    public static void main(String[] args) {
        int n = 2, m = 2;
        int x = 1, y = 1;
        int r = 2, c = 2;
        int k = 2;

        N = n;
        M = m;
        R = r-1;
        C = c-1;


        int dis = Math.abs(x-r) + Math.abs(y-c);
        if(dis > k || (k-dis) % 2 == 1) System.out.println("impossible");

        char[] str = new char[k];
        DFS(x-1, y-1, 0, str, k);


        System.out.println(answer);

    }

    private static boolean DFS(int x, int y, int depth, char[] str, int k){
        int dis = Math.abs(x-R) + Math.abs(y-C);
        if(depth+dis == k){

            if(x < R){
                for(int i = 0; i < R-x; i++){
                    str[depth] = 'd';
                    depth++;
                }
            }
            if(y > C){
                for(int i = 0; i < y-C; i++){
                    str[depth] = 'l';
                    depth++;
                }
            }
            else if( y < C){
                for(int i = 0; i < C-y; i++){
                    str[depth] = 'r';
                    depth++;
                }
            }
            if(x > R){
                for(int i = 0; i < x-R; i++){
                    str[depth] = 'u';
                    depth++;
                }
            }
            String s = new String(str);
            answer = s;
            return true;
        }

        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(Math.abs(nx-R) + Math.abs(ny-C) +depth + 1 > k) continue;
            str[depth] = charArr[i];
            if(DFS(nx,ny, depth+1, str, k)) return true;
        }
        return false;
    }

}

/*


package kakaopractice.blind2023;

        import java.util.LinkedList;
        import java.util.Queue;

public class No6 {

    static String Str = "";
    static int N,M;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static char[] charArr = {'d', 'l', 'r', 'u'};

    public static void main(String[] args) {
        int n = 3, m = 4;
        N = n;
        M = m;
        int x = 2, y = 3;
        int r = 3, c = 1;
        int k = 5;

        int[][] map = new int[n][m];
        map[x-1][y-1] = 1;
        map[r-1][c-1] = 2;
        for(int i = 0; i < k; i++){
            Str += "z";
        }

        int shortCnt = BFS(map, x-1,y-1);
        if((k - shortCnt) % 2 == 1){
            System.out.println("impossible");
            return;
        }
        int cut = (k-shortCnt)/2;
        int[][] check = new int[n][m];
        check = BFSFull(check, r-1,c-1, cut);

        char[] str = new char[k];
        DFS(map, check, x-1, y-1, 0, str, k, cut);

        if(Str.charAt(0) == 'z'){
            System.out.println("impossible");
        }

        System.out.println(Str);

    }

    private static int BFS(int[][] map, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});
        int[][] check = new int[N][M];
        check[x][y] = 1;

        while(!queue.isEmpty()){
            int[] p = queue.poll();
            if(map[p[0]][p[1]] == 2){
                return p[2];
            }
            for(int i = 0; i < 4; i++){
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(check[nx][ny] == 0){
                    queue.add(new int[]{nx,ny,p[2]+1});
                    check[nx][ny] = 1;
                }
            }
        }

        return -1;
    }

    private static int[][] BFSFull(int[][] check1, int x, int y, int cut){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});
        int[][] check = new int[N][M];
        check[x][y] = 1;
        check1[x][y] = cut;
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            if(p[2] == cut+1) return check1;

            for(int i = 0; i < 4; i++){
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(check[nx][ny] == 0){
                    queue.add(new int[]{nx,ny,p[2]+1});
                    check[nx][ny] = 1;
                    check1[nx][ny] = cut - p[2];
                }
            }
        }

        return check1;
    }

    private static boolean DFS(int[][] map, int[][] check, int x, int y, int depth, char[] str, int k, int cut){
        if(k == depth){
            if(map[x][y] == 2){
                String s = new String(str);
                if(Str.compareTo(s) > 0) {
                    Str = s;
                    return true;
                }
            }
            return false;
        }

        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(check[nx][ny] < 0) continue;
            str[depth] = charArr[i];
            check[nx][ny]--;
            if(DFS(map, check, nx,ny, depth+1, str, k, cut)) return true;
            check[nx][ny]++;
        }
        return false;
    }

}

 */
