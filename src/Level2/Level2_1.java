//Level2
//거리두기 확인하기 ( 2021 카카오 채용연게형 인턴쉽 )
//22.03.25

package Level2;

import java.util.ArrayList;

public class Level2_1 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = new int[places.length];
        int k = 0;
        for(String[] place : places){
            ArrayList<Integer[]> pointP = new ArrayList<Integer[]>();
            for(int i  = 0; i < 5; i++){
                for(int j = 0 ; j <5 ; j++){
                    if(place[i].substring(j,j+1).equals("P")){
                        pointP.add(new Integer[]{i,j});
                    }
                }
            }
            answer[k] = checkDistance(pointP, place);
            k++;
        }
        for ( int i : answer){
            System.out.println(i);
        }

    }

    private static int checkDistance(ArrayList<Integer[]> pointP, String[] place){
        int j = 0;
        for(Integer[] point : pointP){
            for(int i = j ; i < pointP.size()-1; i++){
                Integer[] point2 = pointP.get(i+1);
                int dis = Math.abs(point[0]-point2[0]) + Math.abs(point[1]-point2[1]);
                if( dis == 1){
                    return 0;
                }
                else if (dis == 2){
                    if(point[0] == point2[0]){
                        int p = point[1]>point2[1] ? point[1] - 1: point[1] +1 ;
                        if(!place[point[0]].substring(p,p+1).equals("X")){
                            return 0;
                        }
                    }
                    else if ( point[1] == point2[1]){
                        int p = point[0]>point2[0] ? point[0] - 1: point[0] +1 ;
                        if(!place[p].substring(point[1],point[1]+1).equals("X")){
                            return 0;
                        }
                    }
                    else{
                        if(place[point[0]].substring(point2[1],point2[1]+1).equals("X") && place[point2[0]].substring(point[1],point[1]+1).equals("X")){

                        }
                        else{
                            return 0;
                        }
                    }
                }
            }
            j++;
        }
        return 1;
    }


}
