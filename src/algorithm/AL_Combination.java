//조합


package algorithm;

public class AL_Combination {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1,2,3,4};
        boolean[] visited = new boolean[n];

        for(int i = 1; i<=n; i++){
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, visited, 0,n,i);
        }

        for(int i = 1; i<=n; i++){
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combi(arr, visited, 0,n,i);
        }


    }

    //백트래킹 사용
    static void combination(int[] arr, boolean[] visited, int start, int n, int r){
        if(r==0){
            for(int i = 0; i < n;i++){
                if(visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        for(int i = start ; i<n; i++){
            visited[i] = true;
            combination(arr, visited,i+1,n,r-1);
            visited[i] = false;
        }
    }

    //재귀함수 사용
    static void combi(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r==0){
            for(int i =0; i< n ; i++){
                if(visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if(depth==n){
            return;
        }

        visited[depth] = true;
        combi(arr,visited, depth+1, n, r-1);

        visited[depth] = false;
        combi(arr,visited, depth+1, n, r);
    }


}
