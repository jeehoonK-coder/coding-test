package Test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        int num_teams = 2;
        String[] remote_tasks = {"design"};
        String[] office_tasks = {"building","supervise"};
        String[] employees = {"2 design","1 supervise building design","1 design","2 design"};

        List<String> office_List = new ArrayList<>();
        office_List = Arrays.asList(office_tasks);
        List<List<Integer>> teamMember = new ArrayList<>();
        for(int i = 0 ; i< num_teams; i++){
            teamMember.add(new ArrayList<Integer>());
        }

        int employeNumber = 1;
        for(String employe : employees){
            String[] split = employe.split(" ");
            for(int i = 1; i< split.length;i++){
                if(office_List.contains(split[i])){
                    teamMember.get(Integer.parseInt(split[0])-1).add(employeNumber);
                    break;
                }
            }
            employeNumber++;
        }

        for(int i = 0 ; i< num_teams; i++){
            if(teamMember.get(i).size() == 0){
                for(int j = 0 ; j < employees.length; j++){
                    String[] split = employees[j].split(" ");
                    if(Integer.parseInt(split[0])-1 == i ){
                        teamMember.get(Integer.parseInt(split[0])-1).add(j+1);
                        break;
                    }
                }
            }
        }

        List<Integer> finalMember = new ArrayList<>();
        for(List<Integer> team : teamMember){
            for(int i = 0; i< team.size(); i++){
                finalMember.add(team.get(i));
            }
        }


        int[] answer = new int[employees.length-finalMember.size()];
        int num = 0;
        for(int i = 0; i< employees.length;i++){
            if(!finalMember.contains(i+1)){
                answer[num] = i+1;
                num++;
            }
        }

        for(int num1: answer){
            System.out.println(num1);
        }

    }
}
