import java.util.Random;

public class InsertionSort {
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

         insertionSort(nums);
         System.out.print("\nAfter sorting \n ");
         for(int num : nums){
            System.out.print(num + " ");
         }
    }
    public static void insertionSort(int[] arr){
        int n = arr.length;
        //start at 1 because we assume that the first element is sorted so we start from the second element
        //compare all elements to the left and check if they are greater than the temp variable
        //if the condition is satisfied then we move the temp variable to left.
        for(int i = 1; i < n; i++){
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1]= temp;
        }
    }
}

