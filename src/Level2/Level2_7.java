//Level2 (programmers)
//타겟넘버


package Level2;

public class Level2_7 {
    private static int ans = 0;
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int answer = 0;
        boolean[] visited = new boolean[numbers.length];
        dfs(numbers,visited,0, numbers.length, target);
        answer = ans;
        //return answer;
        System.out.println(answer);

    }

    private static void dfs(int[] numbers, boolean[] visited, int depth, int n, int target){
        if(depth == n){
            int score = 0;
            for(int i =0 ; i<n;i++){
                if(visited[i]){
                    score += numbers[i];
                }
                else{
                    score -= numbers[i];
                }
            }
            if(score == target){
                ans++;
            }
            return;
        }

        visited[depth] = false;
        dfs(numbers,visited,depth+1, n, target);

        visited[depth] = true;
        dfs(numbers,visited,depth+1, n, target);

    }
}
