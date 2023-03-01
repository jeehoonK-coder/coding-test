//Back_5052 전화번호 목록
//문자열, 트라이

package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_5052 {

    static int T,N;
    static String[] NumArray;
    static class Node {
        Map<Character, Node> childNode;
        boolean endOfword;

        Node(Map<Character, Node> childNode, boolean endOfword){
            this.childNode = childNode;
            this.endOfword = endOfword;
        }

    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            NumArray = new String[N];
            for(int i = 0; i < N ;i++){
                NumArray[i] = br.readLine();
            }
            Arrays.sort(NumArray, (o1, o2) -> o1.length() - o2.length());
            Node root_node = new Node(new HashMap<>(), false);
            boolean check = false;
            roop:
            for(int i = 0; i < N; i++){
                Node node = root_node;
                for(int j = 0; j < NumArray[i].length(); j++){
                    node = node.childNode.computeIfAbsent(NumArray[i].charAt(j), key -> new Node(new HashMap<>(), false));
                    if(node.endOfword){
                        bw.write("NO\n");
                        check = true;
                        break roop;
                    }
                }
                node.endOfword = true;
            }
            if(!check) bw.write("YES\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_5052().solution();
    }

}
