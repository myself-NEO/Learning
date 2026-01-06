package handbook.greedyAlgos;

/*
Huffman coding2 is a greedy algorithm that constructs an optimal code for
compressing a given string. Its basically data compression.

You are given a string. You have to encode it based on Huffman Coding.

Steps:
1. Find frequency of each elements.
2. For left we choose bit as 0, for right we choose bit as 1.
3. We join elements with same weight (frequency)
4. Binary representatiojn from root to node of that element is its Huffman coding.
 */

import java.util.Scanner;

public class HuffmanCoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        encode(s);
    }

    static void encode(String s) {

    }
}

