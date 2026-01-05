package handbook.greedyAlgos;

/*
Given n events with their starting and ending point.
You need to find how many events can be covered for the whole time.
You can't select an event partially.

So the greedy solution would be to selecting those whose end time is before.
So that we can cover more events.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchedulingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> events = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int[] arr = new int[2];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            events.add(arr);
        }

        events.sort((a, b) -> a[1] - b[1]);

        int ans = 0;
        int pos = 0;

        for(int[] curr : events) {
            if(curr[0] > pos) {
                ans++;
                pos = curr[1];
            }
        }

        System.out.println(ans);
    }
}
