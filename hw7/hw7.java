package hw7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class hw7 {
    public static int minMeetingRooms(int[][] intervals) {  // Your code here
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        Queue<Integer> endTimes = new LinkedList<>();
        for (int[] interval : intervals) {
            endTimes.add(interval[1]);
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Queue<Integer> startTimes = new LinkedList<>();
        for (int[] interval : intervals) {
            startTimes.add(interval[0]);
        }

        int maxRooms = 0;
        int minRooms = 0;

        while (!startTimes.isEmpty()){
            int time = 0;
            if (startTimes.peek() <= endTimes.peek()){
                time = startTimes.peek();
            }else{
                time = endTimes.peek();
            }

            while (!startTimes.isEmpty() && startTimes.peek() == time){
                startTimes.remove();
                minRooms++;
            }
            while (!endTimes.isEmpty() && endTimes.peek() == time){
                endTimes.remove();
                minRooms--;
            }

            if (minRooms > maxRooms){
                maxRooms = minRooms;
            }
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        int[][] interval = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(interval));

        int[][] interval2 = {{0,1},{1,2},{2,3}};
        System.out.println(minMeetingRooms(interval2));
    }

}

