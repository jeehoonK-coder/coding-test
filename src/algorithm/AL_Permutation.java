//순열

package algorithm;

public class AL_Permutation {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1,2,3,4};
        int[] output = new int[arr.length];
        boolean[] visited = new boolean[n];

        for(int i = 1; i<=n; i++){
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            permutation(arr, output, visited, 0,n,i);
        }
    }

    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r){
        if(depth == r){
            for(int i =0; i<r;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
        }
        for(int i =0; i< n; i++){
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;;
            }
        }
    }

}
