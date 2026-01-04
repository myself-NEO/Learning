package handbook.completeSearch;

/*
This is to illustrate meet in the middle technique.
You are given an array arr, and a number x.
Find if there is a subset of arr with sum of elements as x.
 */

import java.util.*;

public class SubsetWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int x = sc.nextInt();

        // JVM warm-up (important for fair comparison)
        System.out.println("Answer without splitting: ");
        solveWithoutSplitting(arr, x);
        System.out.println("Answer by splitting: ");
        solveBySplitting(arr, x);

        System.out.println("Answer without splitting:");
        measure("Without splitting", () -> solveWithoutSplitting(arr, x));

        System.out.println("Answer by splitting:");
        measure("By splitting", () -> solveBySplitting(arr, x));
    }

    static void solveWithoutSplitting(int[] arr, int x) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        getAllSubsets(arr, allSubsets, new ArrayList<>(), 0);
        allSubsets.forEach(set -> {
            if(set.stream().mapToInt(Integer::intValue).sum() == x){ // In Java 16+, we can also do as set.stream().mapToInt(i -> i).sum()
                set.forEach(e -> System.out.print(e + " "));
                System.out.println();
            }
        });
    }

    static void getAllSubsets(int[] arr, List<List<Integer>> allSubsets, List<Integer> curr, int index) {
        if(index== arr.length) {
            allSubsets.add(new ArrayList<>(curr));
            return;
        }

        getAllSubsets(arr, allSubsets, curr, index+1);

        curr.add(arr[index]);
        getAllSubsets(arr, allSubsets, curr, index+1);

        curr.remove(curr.size()-1);
    }

    static void solveBySplitting(int[] arr, int x) {
        int mid = arr.length / 2;

        int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
        int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);

        Map<Integer, List<List<Integer>>> allSubsets1 = new HashMap<>();
        getAllMapSubsets(arr1, allSubsets1, new ArrayList<>(), 0);

        Map<Integer, List<List<Integer>>> allSubsets2 = new HashMap<>();
        getAllMapSubsets(arr2, allSubsets2, new ArrayList<>(), 0);

        allSubsets1.forEach((key, val) -> {
            int needed = x - key;
            if(allSubsets2.containsKey(needed)) {
                for(List<Integer> l1 : val) {
                    for(List<Integer> l2 : allSubsets2.get(needed)) {
                        l1.forEach(v -> System.out.print(v + " "));
                        l2.forEach(v -> System.out.print(v + " "));
                        System.out.println();
                    }
                }
            }
        });
    }

    static void getAllMapSubsets(int[] arr, Map<Integer, List<List<Integer>>> allSubsets, List<Integer> curr, int index) {
        if(index== arr.length) {
            int sum = curr.stream().mapToInt(i -> i).sum();
            allSubsets.computeIfAbsent(sum, k -> new ArrayList<>()).add(new ArrayList<>(curr));
            return;
        }

        getAllMapSubsets(arr, allSubsets, curr, index+1);

        curr.add(arr[index]);
        getAllMapSubsets(arr, allSubsets, curr, index+1);

        curr.remove(curr.size()-1);
    }




    static void measure(String name, Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();

        double ms = (end - start) / 1_000_000.0;
        System.out.printf("%s took %.3f ms%n", name, ms);
    }

}
