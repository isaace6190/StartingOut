import java.util.Iterator;
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
    public T removeFirst(){
        if(head == null)throw new NoSuchElementException();
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    public T removeLast(){
        if(head == null)throw new NoSuchElementException();
        Node<T> current = head;
        if(head.next == null){
            return removeFirst();
        
        }
        while(current.next.next != null){
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    public T removeAt(int index){
        if(index < 0 || index > size)throw new IndexOutOfBoundsException();
        if(index == 0){
            return removeFirst();
        }
        Node<T> current = head;
        for(int i = 0; i < index -1; i++){
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    } 
    public Iterator<T> iterator(){
        return new Iterator<>(){
            Node<T> current = head;
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
    public String toString(){
        if(size() == 0)return "null";
        else{
            StringBuilder sb = new StringBuilder();
            Node<T> current = head;
            while(current.next != null){
                sb.append(current.data).append("->");
                current = current.next;
            }
            return sb.append("null").toString();
        }
    }
}