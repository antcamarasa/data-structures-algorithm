package org.example.data_structure.arrays.exercices.medium;

public class ReorderList {

    public void sort(int[] arr){
        int firstPointer = 0;

        while(firstPointer < arr.length){
            int lastPointer = arr.length - 1;
            int lastItem = arr[lastPointer];

            //2. Slide from firstPointer + 1 => Throw end.
            if(firstPointer + 1 > lastPointer) break;


            int index = firstPointer + 1;
            int prev =  arr[index - 1]; // 0

            while(index < arr.length){
                int tmp = arr[index];
                arr[index] = prev;
                prev = tmp;
                index++;
            }

            firstPointer++;
            arr[firstPointer] = lastItem;
            displayList(arr);
            firstPointer++;
        }
    }

    public void betterSort(int[] arr){
        int[]dest = new int[arr.length];

        int middle = arr.length / 2 + 1;
        int[] first = new int[middle];
        int[] second = new int[arr.length - middle];

        for(int i = 0; i < middle; i++){
            first[i] = arr[i];
        }

        int idx = 0;
        for(int i = second.length - 1; i >= 0; i--){
            int currentIndex = middle + i;
            second[idx] = arr[middle + i];
            idx++;
        }


        int firstSize = first.length;
        int secondSize = second.length;

        int index = 0;
        int destIdx = 0;
        while(firstSize > 0 && secondSize > 0){
            dest[destIdx] = first[index];
            destIdx++;
            dest[destIdx] = second[index];
            destIdx++;

            index++;
            firstSize--;
            secondSize--;
        }

        if(firstSize > 0){
            dest[destIdx] = first[index];
        } else if (secondSize > 0) {
            dest[destIdx] = first[index];
        }
    }

    public void better(int[] arr){
        int[] dest = new int[arr.length];

        int start = 0;
        int end = arr.length - 1;

        int idx = 0;
        while(start <= end){
            if(start == end){
                dest[idx] = arr[start];
                break;
            }
            dest[idx] = arr[start];
            dest[idx + 1] = arr[end];
            idx++; idx++;
            start++;
            end--;
        }


        displayList(dest);
    }


    public void displayList(int[] arr){
        System.out.print("[");
        for(int el : arr){
            System.out.print(el + ", ");
        }
        System.out.print("]");
    }
}
