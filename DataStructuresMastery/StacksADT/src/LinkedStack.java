import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T>{
    
    private static class Node<U>{
        U data;
        Node<U> next;
        Node(U data, Node<U> next){
            this.data = data;
            this.next = next;
        }
    }
    private Node<T> head;
    private int size = 0;
    @Override
    public void push(T item) {
        head = new Node<>(item, head);
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }
    
}
