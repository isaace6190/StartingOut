import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class LL<T> implements Iterable<T>{
    private static  class Node<T>{
        T data;
        Node<T> next;
    
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;
    private int size = 0;

    public LL(){
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size() == 0;
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
        }
        else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public T removeFirst(){
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    public T getFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        return head.data;
    }
    public T getLast(){
        if(isEmpty()) throw new NoSuchElementException();
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
    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>(){
            private Node<T> current = head;
            @Override
            public boolean hasNext(){
                return current != null;
            }
            @Override
            public T next(){
                if(!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while(current != null){
            sb.append(current.data).append("->");
            current = current.next;
        }
        return sb.append("null").toString();
    }

}