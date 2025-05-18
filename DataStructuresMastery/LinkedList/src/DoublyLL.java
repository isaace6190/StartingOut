import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLL<T> implements Iterable<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0;

    private static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;
        Node(T data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
    
    DoublyLL(){}
    
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
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++; 
    }
    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            head = tail = newNode;
            size++;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    public T removeFirst(){
        if(isEmpty())throw new NoSuchElementException();
        T data = head.data;
        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
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
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while(current.next != null){
            sb.append(current.data).append(" <-> ");
            current = current.next;
        }
        sb.append(current.data).append(" -> ");
        return sb.append("null").toString();
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
