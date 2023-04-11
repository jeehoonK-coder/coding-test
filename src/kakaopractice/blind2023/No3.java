/**
 *  23.04.11
 *  2023 KAKAO BLIND RECRUITMENT
 *  이모티콘 할인행사
 *  level 2
 *
 */



package kakaopractice.blind2023;


public class No3 {

    static int[] discount = {40,30,20,10};
    static int[][] Users;
    static int[] Emoticons;
    static int Count = -1;
    static int Money = -1;

    public static void main(String[] args) {
        int[][] users = {{40,10000},{25,10000}};
        int[] emoticons = {7000,9000};
        Users = users;
        Emoticons = emoticons;

        int[] number = new int[emoticons.length];
        combination(emoticons.length, 0, number);

        int[] answer = {Count, Money};

        System.out.println("Count = " + Count);
        System.out.println("Money = " + Money);

    }

    private static void combination(int n, int k, int[] number){
        if(k == n){
            check(number);
            return;
        }

        number[k] = 0;
        combination(n,k+1, number);
        number[k] = 1;
        combination(n,k+1, number);
        number[k] = 2;
        combination(n,k+1, number);
        number[k] = 3;
        combination(n,k+1, number);
    }

    private static void check(int[] number){
        int count = 0;
        int total = 0;

        for(int i = 0; i < Users.length; i++){
            int sum = 0;
            int cutLine = Users[i][1];
            for(int j = 0; j < number.length; j++){
                if(discount[number[j]] >= Users[i][0]){
                    sum += Emoticons[j] / 100 * (100-discount[number[j]]) ;

                }
                if(cutLine <= sum){
                    count++;
                    sum = 0;
                    break;
                }
            }
            total+= sum;
        }

        if(count > Count){
            Count = count;
            Money = total;
        }
        else if(count == Count){
            Money = Math.max(Money, total);
        }

    }

}
