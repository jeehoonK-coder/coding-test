/**
 *  23.03.03
 *  Back_9202 Boggle (플레)
 *  문자열, 트라이
 *
 *  1. trie 구현
 *  2. DFS를 통하여 탐색
 */

package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_9202 {

    static int N,B;
    static char[][] Board;
    static int[] dx = {1,-1,0,0,1,-1,1,-1};
    static int[] dy = {0,0,1,-1,1,1,-1,-1};
    static int [] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static class Node {
        Map<Character, Node> childNode;
        boolean endOfword;

        Node(Map<Character, Node> childNode, boolean endOfword){
            this.childNode = childNode;
            this.endOfword = endOfword;
        }
    }
    static Node RootNode = new Node(new HashMap<>(), false);
    static Set<String> StrList = new HashSet<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            Node node = RootNode;
            for(int j = 0; j <  str.length(); j++){
                node = node.childNode.computeIfAbsent(str.charAt(j), key -> new Node(new HashMap<>(), false));
            }
            node.endOfword = true;
        }
        br.readLine();
        B = Integer.parseInt(br.readLine());
        for(int n = 0; n < B; n++){
            Board = new char[4][4];
            for(int i = 0; i < 4; i++){
                String str = br.readLine();
                Board[i] = str.toCharArray();
            }
            if(n != B-1) br.readLine();
            search();
            String[] array = StrList.toArray(new String[0]);
            Arrays.sort(array, (o1, o2) -> {
                if(o2.length() == o1.length()) return o1.compareTo(o2);
                return o2.length() - o1.length();
            });
            int total = 0;
            for(int i = 0; i < array.length; i++){
                int len = array[i].length();
                total += score[len];
            }
            bw.write(total + " " + array[0] + " " + array.length + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public void search() {
        StrList = new HashSet<>();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(RootNode.childNode.containsKey(Board[i][j])){
                    int[][] check = new int[4][4];
                    check[i][j] = 1;
                    DFS(RootNode.childNode.get(Board[i][j]),i,j,Board[i][j]+"",check);
                }
            }
        }

    }

    public void DFS(Node node, int i, int j, String str, int[][] check) {
        if(node.endOfword){
            StrList.add(str);
        }
        for(int k = 0; k < 8; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
            if(check[nx][ny] == 1) continue;
            if(node.childNode.containsKey(Board[nx][ny])){
                check[nx][ny] = 1;
                DFS(node.childNode.get(Board[nx][ny]), nx, ny, str+Board[nx][ny], check);
                check[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_9202().solution();
    }
}
