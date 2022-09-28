//Back_10830 행렬 제곱
//분할 정복(Divde and Conquer) 사용

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_10830 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[][] matrix = new long[n][n];
        for(int i =0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                matrix[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] result = matrixDC(matrix,k);

        for(int i =0; i < n;i++){
            for(int j = 0; j < n; j++){
                if(j == n-1) System.out.print(result[i][j]%1000);
                else System.out.print(result[i][j]%1000 + " ");
            }
            if(i != n-1) System.out.println();
        }
    }

    public long[][] matrixDC(long[][] arr, long k){
        if (k == 1){
            return arr;
        }
        long[][] memo = matrixDC(arr,k/2);
        if(k%2 == 1){
            return matrixMul(matrixMul(memo,memo),arr);
        }
        else{
            return matrixMul(memo,memo);
        }

    }

    public long[][] matrixMul(long[][] arr, long[][] arr2){
        int n = arr.length;
        long[][] temp = new long[n][n];
        for(int i =0; i < n;i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n;k++){
                    temp[i][j] += arr[i][k]*arr2[k][j] %1000;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) throws Exception{
        new Back_10830().solution();
    }
}