package org.example.data_structure.fundamental.arrays.exercices.easy;

public class MoveZerosToTheEnd {

    public void brutForce(int[] array) {
        int target = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] == 0 && array[target] == 0) {
                continue;
            } else if (array[target] == 0) {
                swap(array, target, j);
                target++;
                continue;
            }
            target++;
        }
    }

    public void swap(int[] dest, int i, int j) {
        int temp = dest[i];
        dest[i] = dest[j];
        dest[j] = temp;
    }


    public void twoPointersSolution(int[] arr) {
        if(arr == null || arr.length <2)return;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {

                int search = i;
                while (search < arr.length && arr[search] == 0) {
                    search++;
                }
                if (search >= arr.length) return;
                swap(arr, i, search);
            }
        }
    }

    public void correctionBrutForceTwoPointers(int[] a){
        if (a == null || a.length < 2) return;

        int left = 0; // où placer le prochain non-zéro
        for (int right = 0; right < a.length; right++) {
            if (a[right] != 0) {
                if(left != right) swap(a, left, right);
                left++;
            }
        }
    }

}
