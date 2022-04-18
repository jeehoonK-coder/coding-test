//Level2(Programmers)
//짝지어 제거하기

package Level2;

import java.util.Stack;

public class Level2_8 {
    public static void main(String[] args) {
        String s = "cdcd";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length();i++){
            if(!stack.isEmpty()){
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }

        if(stack.isEmpty()){
            System.out.println(1);
        }
        else{
            System.out.println(0);;
        }

    }
}
