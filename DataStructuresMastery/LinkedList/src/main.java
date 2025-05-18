public class main {
    public static void main(String[] args) {
        LL<Integer> list = new LL<>();

        DoublyLL<Integer> l = new DoublyLL<>();

        l.addFirst(1);
        
        System.out.println(l);


        

        l.addFirst(2);
        l.addLast(6);
        System.out.println(l);


    }
}
