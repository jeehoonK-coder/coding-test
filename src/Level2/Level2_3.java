//Level2
//멀쩡한 사각형 찾기

package Level2;

public class Level2_3 {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        long total = w*h;
        long answer = 0;
        if( w == h){
            answer = w*h -w;
            //System.out.println(answer);
        }
        int gcd = commonDivisor(w,h);
        w /= gcd;
        h /= gcd;
        System.out.println(w);
        System.out.println(h);
        long count = 0;
        for(int i = 0; i < w; i++){
            count += Math.ceil((double)h*(i+1)/w)-Math.floor((double)h*i/w);
        }
        answer = total - count*gcd;

        System.out.println(answer);


    }

    //최대 공약수 구하기기(재귀 O(logn))
   public static int commonDivisor(int a, int b){
        if(a% b == 0){
            return b;
        }
        return commonDivisor(b,a%b);
    }

}
