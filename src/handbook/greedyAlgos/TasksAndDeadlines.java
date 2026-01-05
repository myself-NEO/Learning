package handbook.greedyAlgos;

/*
You are given n tasks with durations and deadline.
Your task is to choose order to perform the task.
For each task, you earn d-x points, where d is deadline and x is moment from start of events where the task ends.
What is the largest possible score?
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TasksAndDeadlines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] duration = new int[n];
        int[] deadline = new int[n];

        for(int i=0; i<n; i++) duration[i] = sc.nextInt();
        for(int i=0; i<n; i++) deadline[i] = sc.nextInt();

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new int[]{duration[i], deadline[i]});
        }

//        list.sort((a, b) -> a[0] - b[0]);
        list.sort(Comparator.comparingInt(a -> a[0]));

        int ans = 0;
        int x = 0; // moment from start
        for(int[] tasks : list) {
            x += tasks[0];
            ans += tasks[1] - x;
        }

        System.out.println(ans);
    }
}
