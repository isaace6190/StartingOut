public class SelectionSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {10,11,5};

        // swap(arr, arr[0], arr[1]);

        for(int num : arr){
            System.out.print(num + " ");
        }
        selectionSort(arr);
        System.out.println("\nAfter sort");
        for(int num : arr){
            System.out.print(num + " ");
        }

    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int min_idx = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[min_idx]){
                    min_idx = j;  
                }
            }
            swap(arr, i, min_idx);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}
