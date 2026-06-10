package org.example.array.exercice.easy;

public class LongestSubarrayWithGivenSum {

    public int longestSubArrayWithGivenSum(int[] arr, int k){
        if(arr.length == 0) return 0;

        int longest = 0;
        for(int i = 0; i < arr.length; i++){
            // Set up
            int total = 0;
            int j = i;

            // Main loop
            while(total < k && j < arr.length){
              total += arr[j];
              j++;
            }

            // Assignation
            if(total == k){
                longest = Math.max(longest, (j - i));
            }
        }

        return longest;
    }

    public int correctionSlidingWindowAndTwoPointers(int[] arr, int k){
        int left = 0;
        int right = 0;
        int len = 0;

        int n = arr.length;
        int total = arr[0];

        while(right < n){
            while (left <= right && total > k){
                total -= arr[left];
                left++;
            }

            if(total == k){
                len = Math.max(len, right - left + 1);
            }

            right++;
            if(right < n){
                total += arr[right];
            }
        }
        return len;
    }

}
