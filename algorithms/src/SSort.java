import java.util.*;
public class SSort {
    public static void main(String[] args){
        Random randy = new Random();
        int[] nums = new int[10];
         for(int i = 0; i < 10; i++){
            nums[i] = randy.nextInt(1, 10);
         }
         System.out.print("Before sorting \n ");
         for(int num : nums){
            System.out.print(num + " ");
         }

         selectionSort(nums);
         System.out.print("\nAfter sorting \n ");
         for(int num : nums){
            System.out.print(num + " ");
         }

         System.out.printf("The target number was found in position %d in the array", binarySearch(nums, 4));
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n-1;i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int num1, int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
    public static int binarySearch(int[] arr, int target){
        int front = 0;
        int back = arr.length-1;

        while(front <= back){
            int midPosition = (front + back)/2;
            int midNumber = arr[midPosition];
            if(midNumber == target){
                return midPosition;
            }
            if(midNumber > target){
                back = midPosition - 1;
            }
            else{
                front = midPosition + 1;
            }
        }

        return -1;
        
    }
}
