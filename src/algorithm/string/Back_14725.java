//Back_14725 개미굴
//문자열, 트라이

package algorithm.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back_14725 {

    static int N,K;
    static class Node {
        Map<String, Node> childNode;
        boolean end;

        Node(Map<String, Node> childNode, boolean end){
            this.childNode = childNode;
            this.end = end;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Node root_node = new Node(new HashMap<>(), false);
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            Node node = root_node;
            for(int i = 0; i < K; i++){
                String str = st.nextToken();
                node = node.childNode.computeIfAbsent(str, key -> new Node(new HashMap<>(), false));
            }
            node.end = true;
        }
        print(root_node, 0);

        br.close();
    }

    public void print(Node root_node, int cnt){
        Object[] key = root_node.childNode.keySet().toArray();
        Arrays.sort(key);
        for(Object s : key){
            for(int i = 0; i < cnt*2; i++){
                System.out.print("-");
            }
            System.out.println(s);
            if(!root_node.childNode.get(s).end){
                print(root_node.childNode.get(s), cnt+1);
            }
        }

        /*root_node.childNode.forEach((strKey, strValue) -> {
            for(int i = 0; i < cnt*2; i++){
                System.out.print("-");
            }
            System.out.println(strKey);
            if(!strValue.end){
                print(strValue, cnt+1);
            }
        });*/
    }

    public static void main(String[] args) throws Exception {
        new Back_14725().solution();
    }
}
