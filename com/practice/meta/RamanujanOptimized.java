package com.practice.meta;

import java.util.*;

public class RamanujanOptimized {
    public static void main(String[] args) {
        int N = 3;
        Map<Integer, List<int[]>> sumMap = new HashMap<>();

        // Step 1: Precompute sums i^3 + j^3
        for (int i = 0; i < N; i++) {
            int i3 = i * i * i;
            for (int j = 0; j < N; j++) {
                int sum = i3 + j * j * j;
                sumMap.computeIfAbsent(sum, x -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        // Step 2: For each sum, print all pairs (i, j) and (k, l)
        for (Map.Entry<Integer, List<int[]>> entry : sumMap.entrySet()) {
            List<int[]> pairs = entry.getValue();
            if (pairs.size() > 1) { // at least two pairs match
                for (int m = 0; m < pairs.size(); m++) {
                    for (int n = m + 1; n < pairs.size(); n++) {
                        int[] p1 = pairs.get(m);
                        int[] p2 = pairs.get(n);
                        System.out.println(p1[0] + " - " + p1[1] + " - " + p2[0] + " - " + p2[1]);
                    }
                }
            }
        }
        System.out.println("============================================");
        for (int i = 0; i < 3; i++) {
            int i3 = i * i * i;
            for (int j = 0; j < 3; j++) {
                int s = i3 + j * j * j;
                for (int k = 0; k < 3; k++) {
                    int k3 = k * k * k;
                    for (int l = 0; l < 3; l++) {
                        if (s == k3 + l * l * l) {
                            System.out.println(i + " - " + j + " - " + k + " - " + l);
                        }
                    }
                }
            }
        }
    }
}
