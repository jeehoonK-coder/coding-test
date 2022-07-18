//백준 10773번
//stack

package Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back_10773 {

    private Stack<Integer> stack = new Stack<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                stack.pop();
            }
            else{
                stack.push(a);
            }
        }
        int m = 0;
        while(!stack.empty()){
            m += stack.pop();
        }
        sb.append(m);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Back_10773().solution();
    }

}
