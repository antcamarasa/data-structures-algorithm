package org.example.data_structure.fundamental.arrays.exercices.medium;

/**
 * Instruction : Given an array nums consisting of only 0, 1 or 2. Sort the array in non decreasing order. The sorting must be in place without making a copy of the orignal array.
 */
public class SortArrayOf0s1s2s {

    public void brutForce(int[] arr){
        int index = arr.length - 1;
        while (index > 0){
            int maxElement = Integer.MIN_VALUE;

            for (int j = 0; j < index; j++) {
                if (arr[j] >= maxElement) {
                    maxElement = arr[j];
                }
            }

            // 2. Trouve l'index de maxElement.
            int indexOfMaxElement = 0;
            for(int i = 0; i < index; i++){
                if(arr[i] == maxElement){
                    indexOfMaxElement = i;
                    break;
                }
            }

            // 3. Swap
            int temp = arr[index];
            arr[index] = maxElement;
            arr[indexOfMaxElement] = temp;
            index--;

        }
    }
    public void brutForcev2(int[] arr){
        int pointer = arr.length - 1; // 4 valeur 0

        while(pointer > 0){
            boolean swap = false;
            for(int i = 0; i < pointer; i++){
                if(arr[i] > arr[i + 1]){
                    swap = true;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if(!swap)return;
            pointer--;
        }
    }
    public void brutForceSolution(int[] arr){
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) count0++;
            else if (arr[i] == 1) count1++;
            else count2++;
        }

        int index = 0;
        // Si count0 est supérieur a 0 alors on décrément et on entre dans le while
        while(count0-- > 0){
            // on ajout 0 a index et on incrémente index
            arr[index++] = 0;
        }

        while (count1-- > 0)
            arr[index++] = 1;

        while (count2-- > 0)
            arr[index++] = 2;
    }


    public void deutchNationalFlag(int[] arr){
        int element = 0;
        int pointer = 0;

        while(element < 3){
            int j = pointer + 1;

            while (j < arr.length){
                if(arr[pointer] != element && arr[j] != element){
                    j++;
                    continue;
                }

                else if(arr[pointer] != element && arr[j] == element){
                    int temp = arr[pointer];
                    arr[pointer] = arr[j];
                    arr[j] = temp;
                }

                pointer++;
                j++;
            }
            System.out.println("Pointeur vaut : " + pointer);
            element++;
        }
    }

    /**
     * On divise le tableau en trois partitions à l'aide de trois pointeurs :
     * Low, Middle et high
     */
    public void deutchNationalFlagInstruction(int[] arr){
        int low = 0; // low - 1 => 0
        int middle = 0; // low à middle - 1 => 1
        int high = arr.length; // middle a high => 2

        // High et fixe ce qu'il faut identifier et low et middle
        for(int item :arr){
            if(item == 0)
                low++;
            else if (item == 1)
                middle++;
        }
        middle = middle + low;

        System.out.println(low + " low");
        System.out.println(middle + " Middle");
        System.out.println(high + " high");
        int counter = 0;
        while (counter < high){
            if(counter < low)
                arr[counter] = 0;
            else if(counter < middle)
                arr[counter] = 1;
            else
                arr[counter] = 2;
            counter++;
        }
    }
    public void deutchNationalFlagSecond(int[] arr){
        int low = 0;
        int middle = 0;
        int high = arr.length - 1;

        while (middle <= high){
            if(arr[middle] == 0){
                int tmp = arr[low];
                arr[low] = arr[middle];
                arr[middle] = tmp;

                low++;
                middle++;
            }
            else if(arr[middle] == 1){
                middle++;
            }
            else{
                int temp = arr[middle];
                arr[middle] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

    }

}
