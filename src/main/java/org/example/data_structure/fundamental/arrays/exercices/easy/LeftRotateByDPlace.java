package org.example.data_structure.fundamental.arrays.exercices.easy;


import java.util.Arrays;

/**
 *   Input  : nums = [1, 2, 3, 4, 5, 6, 7], k = 2, right
 *   Output : [6, 7, 1, 2, 3, 4, 5]
 */

public class LeftRotateByDPlace<T> {

    /**
     * Dans cette implémentation je duplique mon tableau est récupère le sous tableau correspondant.
     */
    public int[] firstImplementation(int[] arr, int k){
        // #1. On crée un nouveau tableau du double de la taille de arr.
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < newArr.length; i++) {
            if(i > arr.length - 1){
                newArr[i] = arr[i - arr.length];
            }
            else{
                newArr[i] = arr[i];
            }
        }


        int startIndex = arr.length - k;
        int[] rs = copyOfRangeCustom(newArr, startIndex, startIndex + arr.length);
        System.out.println(Arrays.toString(rs));
        return rs;
    }

    public int[] copyOfRangeCustom(int[] source, int from, int toExclusive){
        int[] output = new int[toExclusive - from];

        if(source.length == 0 || source.length > toExclusive){
            throw new IllegalArgumentException("Array size should be greater than 0 and toExclusive should by inferior to original array length");
        }

        int newLength = toExclusive - from;

        for(int curr = from; curr < Math.min(source.length, newLength + from); curr++){
            output[curr - from] = source[curr];
        }
        return output;
    }

    // TODO = Code Review.
    public void secondImplementationInPlace(int[] arr, int k){
        boolean isNull = true;
        int nextToInsert = -1; // Valeur radom si non compilateur plante a cause nextToInsert par initialisé.

        int index = 0;
        while (k > 0){
         int lastItem = arr[arr.length - 1];

         for(int i = 0; i < arr.length - 1; i++){
            if(isNull){
                nextToInsert = arr[i+1];
                arr[i + 1] = arr[i];
                isNull = false;
            }
            else{
                int temp = arr[i+1];
                arr[i + 1] = nextToInsert;
                nextToInsert = temp;
            }
         }
         arr[index] = lastItem;
         index++;
         k--;
        }

        System.out.println(Arrays.toString(arr));
    }


    /**
     *  Right rotation is equals to :
     *  Rotate to k = reverse the array et reverse from 0 to k.
     */
    public void swap(int[] dest, int i, int j){
        var temp  = dest[i];
        dest[i] = dest[j];
        dest[j] = temp;
    }
    public void optimalApproach(int[] arr, int k){
        // 1. Rotate the entire array.
        // Two pointers
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }

        // 2. Rotate from 0 to k
        int reStart = 0;
        int reEnd = k - 1;
        while (reStart < reEnd){
            swap(arr, reStart, reEnd);
            reStart++;
            reEnd--;
        }

        // 3. Reverse from k to end
        int rereStart = k;
        int rereEnd = arr.length -1;

        while (rereStart < rereEnd){
            swap(arr, rereStart, rereEnd);
            rereStart++;
            rereEnd--;
        }
    }

    public void betterOptimal(int[] arr, int k){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length - k){
                newArr[i + k] = arr[i];
                continue;
            }
            System.out.println(i);
            arr[i - (arr.length - k)] = arr[i];
        }
        System.out.println("newArr => " + Arrays.toString(newArr));
    }
}
