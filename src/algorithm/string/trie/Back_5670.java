/**
 *  23.03.04
 *  Back_5670 휴대폰 자판 (플레)
 *  문자열, 트라이
 *
 *  1. trie 구현
 *  2. search 구현
 *
 *  ch) childNode의 hashMap사이즈가 1이고 단어의 끝이 아니면 count를 안해주고 진행
 */


package algorithm.string.trie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_5670 {

    static int N;

    static class Node {
        Map<Character, Node> childNode;
        boolean endOfword;

        Node(Map<Character, Node> childNode, boolean endOfword){
            this.childNode = childNode;
            this.endOfword = endOfword;
        }
    }
    static Node RootNode;
    static List<String> WordList;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        //while((str = br.readLine()) != null) { 이렇게 해야 사이트에서 테스트 통과함
        while(!(str = br.readLine()).equals("")){
            RootNode = new Node(new HashMap<>(), false);
            WordList = new ArrayList<>();
            N = Integer.parseInt(str);
            for(int i = 0; i < N; i++){
                String word = br.readLine();
                WordList.add(word);
                Node node = RootNode;
                for(int j = 0; j < word.length(); j++){
                    node = node.childNode.computeIfAbsent(word.charAt(j), key -> new Node(new HashMap<>(), false));
                }
                node.endOfword = true;
            }
            double total = 0;
            for (String s : WordList) {
                total += search(s);
            }
            bw.write(String.format("%.2f", total / N) + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int search(String str){
        int count = 1;
        Node node = RootNode.childNode.get(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            if(node.childNode.size() == 1 && !node.endOfword){
                node = node.childNode.get(str.charAt(i));
            }
            else{
                node = node.childNode.get(str.charAt(i));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new Back_5670().solution();
    }
}
