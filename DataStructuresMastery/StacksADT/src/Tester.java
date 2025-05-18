public class Tester {
    public static void main(String[] args) {
        Stack<Integer> list = new LinkedStack<>();

        list.push(1);
        list.push(3);
        list.push(79);
        System.out.println(list.peek());
    }
}
