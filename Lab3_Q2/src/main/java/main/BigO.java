package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BigO {
    public static boolean m1(int[] arr) { // O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(n)
    public static boolean m1Version2(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int val : arr) {
            set.add(val);
        }

        return set.size() != arr.length;
    }

    public static List<List<Integer>> m2(int[] nums) { // O(n^3)
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // avoid duplicates
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }

        return result;
    }

    // O(n^2)
    public static List<List<Integer>> m2Version2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum > target) {
                    right--;
                }

                if (sum < target) {
                    left++;
                }

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[right] == nums[right + 1])
                        right--;

                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                }
            }
        }

        return result;
    }

}
