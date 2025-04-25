public class main {
    public static void main(String[] args) {
        LL<Integer> list = new LL<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(5);

        System.out.println(list);

    }
}
