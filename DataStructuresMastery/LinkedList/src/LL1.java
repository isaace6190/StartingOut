import java.util.NoSuchElementException;

@SuppressWarnings("uncheked")
public class LL1<T> implements Iterable<T>{
    private static class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    Node<T> head;
    int size;
    LL1(){}
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public T getFirst(){
        if(size() == 0)throw new NoSuchElementException();
        return head.data;
    }
    public T getLast(){
        if(size() == 0) throw new NoSuchElementException();
        Node<T> current = head;

        while(current.next != null){
            current = current.next;
        }
        return current.data;
    }
    public T get(int index){
        if(index < 0 || index >= size)throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        Node<T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        size++;
    }
    public void addAt(int index, T data){
        if(index < 0 || index > size)throw new IndexOutOfBoundsException();
        if(index == 0){
            addFirst(data);
        }
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for(int i = 0; i < index-1; i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
}