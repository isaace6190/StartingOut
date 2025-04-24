import java.util.Random;
public class ArrayUsage {
    public static void main(String[] args){
        
        Random randy = new Random();
        

        Array<Integer> arr = new Array<>();

        //System.out.println(arr);
        
        // for(int i = 0; i < 10; i++){
        //     arr.add(randy.nextInt(1,11));
        // }

        arr.addLast(5);
        System.out.println(arr);
        arr.addLast(2);
        System.out.println(arr);
        arr.addLast(3);
        System.out.println(arr);
        arr.addFirst(3);
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
        
        System.out.println(arr.contains(4));
    }
}
