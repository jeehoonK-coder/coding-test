//Back_10828 스택 (실버)
//스택

package Algorithm.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back_10828 {
    static int N;
    static Stack<Integer> Stack = new Stack<>();


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() == 1) {
                String str = st.nextToken();
                switch(str){
                    case "pop":
                        bw.write(pop()+"\n");
                        break;
                    case "size":
                        bw.write(stackSize()+"\n");
                        break;
                    case "empty":
                        bw.write(empty()+"\n");
                        break;
                    case "top":
                        bw.write(top()+"\n");
                        break;
                    default:
                        break;
                }
            }
            else{
                st.nextToken();
                push(Integer.parseInt(st.nextToken()));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void push(int x) {
        Stack.push(x);
    }

    public int pop() {
        if(Stack.isEmpty()) return -1;
        return Stack.pop();
    }

    public int stackSize(){
        return Stack.size();
    }

    public int empty(){
        if(Stack.isEmpty()) return 1;
        else return 0;
    }

    public int top(){
        if(Stack.isEmpty()) return -1;
        return Stack.peek();
    }


    public static void main(String[] args) throws Exception {
        new Back_10828().solution();
    }

}
