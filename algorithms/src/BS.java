import java.util.Random;

public class BS {
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
         System.out.printf("\nTarget is location in position %d", binarySearch(nums, 3));
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1;i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int binarySearch(int[] arr, int target){
        int front = 0;
        int back = arr.length - 1;

        while(front <= back){
            int middlePosition = front + (front + back)/2;
            int midNum = arr[middlePosition];
            if(midNum == target){
                return middlePosition;
            }
            if(target < midNum){
                back = middlePosition - 1;
            }
            else{
                front = middlePosition + 1;
            }
        }
        return -1;
    }




    // public static int binarySearch(int[] arr, int target){
    //     int front = 0;
    //     int end = arr.length - 1;

    //     while(front < end){
    //         int middlePosition = (front + end)/2;
    //         int middleNumber  = arr[middlePosition];
    //         if(target == middleNumber){
    //             return middlePosition;
    //         }
    //         if(target <= middleNumber){
    //             end = middleNumber - 1;
    //         }
    //         else{
    //             front = middleNumber + 1;
    //         }
    //     }
    //     return -1;
    // }
    // public static int binarySearch(int[] arr, int target){
    //     int front = 0;
    //     int end = arr.length-1;
    //     while(front < end){
    //         int middlePosition = (front + end)/2;
    //         int middleNum = arr[middlePosition];
    //         if(target == middleNum){
    //             return middlePosition;
    //         }
    //         if(target > middleNum){
    //             end = middlePosition - 1;
    //         }
    //         else{
    //             front = middlePosition + 1;
    //         }
    //     }
    //     return -1;
    // } 
        // int front = 0;
        // int end = arr.length-1;
        // while(front < end){
        //     int middlePosition = (front + end)/2;
        //     int middleNumber = arr[middlePosition];
        //     if(middleNumber == target){
        //         return middlePosition;
        //     }
        //     if(middleNumber < target){   
        //         front = middlePosition + 1;
        //     }
        //     else{
        //         end = middlePosition - 1;
        //     }
        // }
        // return -1;
    
    // public static int binarySearch(int[] arr, int target){
    //     int front = 0;
    //     int end = arr.length-1;
    //     while(front <= end){
    //         int middlePosition = (front + end)/2;
    //         int middleNumber = arr[middlePosition];
    //         if(middleNumber == target){
    //             return middlePosition;
    //         }
    //         if(middleNumber < target){
    //             front = middlePosition +1;
    //         }
    //         else{
    //             end = middlePosition -1;
    //         }
    //     }
    //     return -1;
    // }
    // public static void selectionSort(int[] arr){
    //     int n = arr.length;
    //     for(int i = 0; i < n - 1; i++){
    //         int minIndex = i;
    //         for(int j = i + 1; j < n; j++){
    //             if(arr[j] < arr[minIndex]){
    //                 minIndex = j;
    //             }
    //         }
    //         int temp = arr[i];
    //         arr[i] = arr[minIndex];
    //         arr[minIndex] = temp;
    //     }
    // }
    // public static int binarySearch(int[] arr, int target){
    //     int front = 0;
    //     int end = arr.length-1;
    //     while(front <= end){
    //         int middlePosition = (front + end)/2;
    //         int middleNumber = arr[middlePosition];
    //         if(middleNumber == target){
    //             return middlePosition;
    //         }
    //         if(target < middleNumber){
    //             end = middlePosition - 1;
    //         }
    //         else{
    //             front = middlePosition + 1;
    //         }
    //     }
    //     return -1;
    // }

    // public static void selectionSort(int[] arr){
    //     int n = arr.length;
    //     for(int i = 0; i < n-1; i++){
    //         int minIndex = i;
    //         for(int j = i + 1; j < n; j++){
    //             if(arr[j] < arr[minIndex]){
    //                 minIndex = j;
    //             }
    //         }
    //         int temp = arr[i];
    //         arr[i] = arr[minIndex];
    //         arr[minIndex] = temp;
    //     }
    // }
    
    // public static int binarySearch(int[] arr, int target){
    //     int front = 0;
    //     int end = arr.length-1;

    //     while(front <= end){
    //         int middlePosition = (front + end)/2;
    //         int middleNumber = arr[middlePosition];
    //         if(middleNumber == target){
    //             return middlePosition;
    //         }
    //         if(middleNumber < target){
    //             front = middlePosition + 1;
    //         }
    //         else{
    //             end = middlePosition -1;
    //         }
    //     }
    //     return -1;
    // }
//     public static int binarySearch(int[] arr, int target){
//         int front = 0;
//         int back = arr.length-1;

//         while(front <= back){
//             int midPosition = (front + back)/2;
//             int midNumber = arr[midPosition];
            
//             if(midNumber == target){
//                 return midPosition;
//             }
//             if(midNumber < target){
//                 front = midPosition + 1;
//             }
//             else{
//                 back = midPosition - 1;
//             }
//         }
//         return -1;
//     }
//     public static void selectionSort(int[] arr){
//         int n = arr.length;

//         for(int i = 0 ; i < n - 1;i++){
//             int minIndex = i;
//             for(int j = i + 1; j < n; j++){
//                 if(arr[j] < arr[minIndex]){
//                     minIndex = j;
//                 }
//             }
//             int temp = arr[i];
//             arr[i] = arr[minIndex];
//             arr[minIndex] = temp;
//         }
//     }
// public static int binarySearch(int[] arr, int target){
//     int front = 0;
//     int end = arr.length-1;
     
//     while(front <= end){
//         int middlePosition = (front + end)/2;
//         int middleNumber = arr[middlePosition];
//         if(target == middleNumber){
//             return middlePosition;
//         }
//         if(target <= middleNumber){
//             end = middlePosition -1;
//         }
//         else {
//             front = middlePosition + 1;
//         }
//     }
//     return front;
// }
}
