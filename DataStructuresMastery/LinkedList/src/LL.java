import java.util.Iterator;
import java.util.NoSuchElementException;

public class LL<T> implements Iterable<T>{
    private static class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    public LL(){
        /*this sets both head & tail to null
        meaning it is initialized as empty list 
        */
        
        head = tail = null;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
        tail.next = newNode;
        tail = newNode;
        }
        size++;
    }
    public void addAt(T data, int index){
        if(index < 0 || index > size)throw new IndexOutOfBoundsException();
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size){
            addLast(data);
            return;
        }
        Node<T> current = head;
        for(int i = 0; i < index -1; i++){
            current = current.next;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = current.next;
        current.next = newNode;
        size++;

    }
    public T removeFirst(){
        if(isEmpty())throw new NoSuchElementException();

        T data = head.data;
        if(head == tail){
            head = tail = null;
        }else{
        head = head.next;
        }
        size--;
        return data;
    }
    public T removeLast(){
        if(isEmpty())throw new NoSuchElementException();
        
        T data = tail.data;
        if(head == tail){
            head = tail = null;
        }
        else{
            Node<T> current = head;
            while(current.next != tail){
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return data;
    }
    public T removeAt(int index){
        if(index < 0 || index > size)throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for(int i = 0; i < index - 1;i++){
            current = current.next;
        }
        if(index == 0){
            removeFirst();
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext(){
                return current.next != null;
            }
            public T next(){
                if(!hasNext())throw new NoSuchElementException();
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
        while(current.next != null){
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append(current.data).append(" -> ");
        return sb.append("null").toString();
    }
}