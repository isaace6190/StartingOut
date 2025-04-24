public class main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(5);
        arr.addLast(1);
        System.out.println(arr);
        arr.addLast(2);
        System.out.println(arr);
        arr.addLast(3);
        System.out.println(arr);
        arr.addLast(4);
        // arr.addLast(7);
        arr.addLast(4);
        arr.addLast(4);
        arr.addLast(1);
        System.out.println(arr);
        arr.addLast(2);
        System.out.println(arr);
        arr.addLast(3);
        System.out.println(arr);
        arr.addLast(9);
        System.out.println(arr);
        arr.addLast(7);
        System.out.println(arr);
        
        arr.addFirst(arr.removeAt(5));

        
        

        System.out.println(arr);
    }

}
