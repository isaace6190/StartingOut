public class QuickSand {
    public static void main(String[] args){
        int[] arr = {2,1,4,5,6,7,8,9,10,11,21,13,34};

        QuickSort(arr, 0, arr.length-1);

        for(int e : arr){
            System.out.print(e + " ");

        }

    }
    public static void QuickSort(int[] arr, int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }
        int pivot = arr[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){
            while(arr[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(arr[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);

        QuickSort(arr, lowIndex, leftPointer -1);
        QuickSort(arr, leftPointer + 1, highIndex);

    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
