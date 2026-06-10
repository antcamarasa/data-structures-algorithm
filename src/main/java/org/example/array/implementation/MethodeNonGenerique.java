package org.example.array.implementation;

public class MethodeNonGenerique {

    public int binarySearch(int[] arr, int target){
        int low = 0;
        int hight = arr.length - 1;

        while(low <= hight){
            int middle = (low + hight) / 2;

            if(arr[middle] == target) return middle;
            else if (target < arr[middle]){hight = middle - 1;}
            else {low = middle + 1;}
        }
        return -1;
    }

}
