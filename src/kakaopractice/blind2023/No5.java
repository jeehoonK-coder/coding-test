/**
 *  23.04.12
 *  2023 KAKAO BLIND RECRUITMENT
 *  표 병합
 *  level 3
 *
 *  1. Union-find를 써야하는 문제 -> 범위가 작아 그냥 구현하여도 풀림림
*
 */


package kakaopractice.blind2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No5 {

    static class Cell {
        String value;
        Set<Integer> mergeList;

        Cell(String value, Set<Integer> mergeList){
            this.value = value;
            this.mergeList = mergeList;
        }
    }

    //i*51+j
    static Cell[] Graph = new Cell[2602];

    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        for(int i = 1; i < 2602; i++){
            Graph[i] = new Cell("", new HashSet<>());
        }
        List<String> ans = new ArrayList<>();
        for(String str : commands){
            System.out.println("str = " + str);

            String[] strSplit = str.split(" ");
            switch(strSplit[0]){
                case "UPDATE":
                    if(strSplit.length == 4){
                        update(Integer.parseInt(strSplit[1]),Integer.parseInt(strSplit[2]),strSplit[3]);
                    }
                    else updateStr(strSplit[1], strSplit[2]);
                    break;
                case "MERGE":
                    merge(Integer.parseInt(strSplit[1]),Integer.parseInt(strSplit[2]),Integer.parseInt(strSplit[3]),Integer.parseInt(strSplit[4]));
                    break;
                case "UNMERGE":
                    unmerge(Integer.parseInt(strSplit[1]),Integer.parseInt(strSplit[2]));
                    break;
                case "PRINT":
                    ans.add(print(Integer.parseInt(strSplit[1]),Integer.parseInt(strSplit[2])));
                    break;
                default:
                    break;
            }
        }
        String[] answer = ans.toArray(new String[ans.size()]);

        System.out.println(ans);

    }

    private static void update(int x, int y, String str){
        for(int point : Graph[x*51+y].mergeList){
            Graph[point].value = str;
        }
        Graph[x*51+y].value = str;
    }

    private static void updateStr(String fromStr, String toStr){
        for(int i = 1; i < 2602; i++){
            if(Graph[i].value.equals(fromStr)) Graph[i].value = toStr;
        }
    }

    private static void merge(int x1, int y1, int x2, int y2){
        if(x1 == x2 && y1 == y2) return;
        Cell c1 = Graph[x1*51+y1];
        Cell c2 = Graph[x2*51+y2];
        if(c1.mergeList.contains(x2*51+y2)) return;

        c1.mergeList.add(x2*51+y2);
        c2.mergeList.add(x1*51+y1);

        if(!c1.value.equals("")){
            for(int point : c1.mergeList){
                Graph[point].value = c1.value;
            }
            for(int point : c2.mergeList){
                Graph[point].value = c1.value;
            }
            c2.value = c1.value;
        }
        else if(!c2.value.equals("")){
            for(int point : c1.mergeList){
                Graph[point].value = c2.value;
            }
            for(int point : c2.mergeList){
                Graph[point].value = c2.value;
            }
            c1.value = c2.value;
        }
        HashSet<Integer> temp1 = new HashSet<>();
        temp1.addAll(c1.mergeList);
        HashSet<Integer> temp2 = new HashSet<>();
        temp2.addAll(c2.mergeList);
        c1.mergeList.addAll(temp2);
        c2.mergeList.addAll(temp1);
        for(int point : temp1){
            if(point == x2*51+y2) continue;
            Graph[point].mergeList.addAll(temp2);
            Graph[point].mergeList.add(x2*51+y2);
        }
        for(int point : temp2){
            if(point == x1*51+y1) continue;
            Graph[point].mergeList.addAll(temp1);
            Graph[point].mergeList.add(x1*51+y1);
        }


    }

    private static void unmerge(int x, int y){
        for(int point : Graph[x*51+y].mergeList){
            if(point == x*51+y) continue;
            Graph[point].value = "";
            Graph[point].mergeList = new HashSet<>();
        }
        Graph[x*51+y].mergeList = new HashSet<>();
    }

    private static String print(int x, int y ){
        if(Graph[x*51+y].value.equals("")) return "EMPTY";
        return Graph[x*51+y].value;
    }


}
