public class main {
    public static void main(String[] args) {
        LL1<Integer> list = new LL1<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(5);

        list.addAt(2, 8);

        System.out.println(list);



    }
}
