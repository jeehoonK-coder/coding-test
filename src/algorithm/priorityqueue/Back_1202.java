/**
 *  23.03.15
 *  Back_1202 보석 도둑
 *  우선순위 큐, (이분 탐색)
 *
 *  1. 보석을 가치 순으로 우선순위 큐에 넣고 보석을 하나씩 비교하여 가방의 위치를 이분탐색으로 찾는 것은 시간초과가 발생한다.
 *  2. 현재 가방이 담을 수 있는 최대 무게보다 작거나 같은 무게를 가진 보석을 우선순위 큐에 담아준다.
 *      -> 우선순위 큐의 제일 첫 번째 값(가장 가격이 비싼 보석)을 꺼내어 더해준다.
 *      -> 반복
 *  -> 1,2번 둘다 정답에 도달할 수 있지만 이분탐색을 사용하면 리스트에서 remove하는 과정에서 O(n)의 시간이 걸려 시간초과가 발생한다.
 */


package algorithm.priorityqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_1202 {

    static class Jewel {
        int weight;
        int value;

        Jewel (int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    static int N,K;


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> {
            if(o2.weight == o1.weight) return o2.value - o1.value;
            return o1.weight - o2.weight;
        });
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Jewel(w,v));
        }
        List<Integer> bags = new ArrayList<>();
        for(int i = 0; i < K; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags);

        long answer = 0;
        PriorityQueue<Jewel> jewels = new PriorityQueue<>((o1, o2) -> {
            if(o2.value == o1.value) return o1.weight - o2.weight;
            return o2.value - o1.value;
        });

        for(int c : bags){
            while(!pq.isEmpty()){
                Jewel j = pq.peek();
                if(j.weight <= c){
                    jewels.add(pq.poll());
                }
                else break;
            }
            if(!jewels.isEmpty()) answer += jewels.poll().value;

        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();


    }




    public static void main(String[] args) throws Exception {
        new Back_1202().solution();
    }
}

/* 시간초과 (우선순위큐, 이분탐색)
public class Back_1202 {

    static class Jewel {
        int weight;
        int value;

        Jewel (int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    static int N,K;


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> {
            if(o2.value == o1.value) return o1.weight - o2.weight;
            return o2.value - o1.value;
        });
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Jewel(w,v));
        }
        List<Integer> bags = new ArrayList<>();
        for(int i = 0; i < K; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags);

        long answer = 0;
        while(!bags.isEmpty() && !pq.isEmpty()){
            Jewel j = pq.poll();
            int index = binarySearch(j.weight, bags);
            if(index == -1) continue;
            answer += j.value;
            bags.remove(index);
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();


    }

    public int binarySearch(int target, List<Integer> bags){
        int start = 0, end = bags.size();
        int mid, pivot;
        int result = -1;
        while(start < end){
            pivot = (start + end) >> 1;
            mid = bags.get(pivot);

            if(mid == target){
                return pivot;
            }
            if(mid > target){
                result = pivot;
                end = pivot;
            }
            else {
                start = pivot + 1;
            }
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
        new Back_1202().solution();
    }
}

 */