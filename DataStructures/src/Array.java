import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T>{
    private int len = 0;
    private int capacity = 0;
    private T[] arr;

    public Array(){
        this(16);
    }
    public Array(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }
    public int size(){
        return len;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public void clear(){
        for(int i = 0; i < len; i++){
            arr[i] = null;
        }
        len = 0;
    }
    public T get(int index){
        if(index < 0 || index >= len){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
    public T getFirst(){
        return arr[0];
    }
    public T getLast(){
        return arr[len-1];
    }
    public void set(int index, T elem){
        if(index < 0 || index >= len){
            throw new IndexOutOfBoundsException();
        }
        arr[index] = elem; 
    }
    public void increaseCapacity(){
        if(capacity == 0){
            capacity = 1;
        }
        else{
            capacity *= 2;
        }
        T[] newArr = (T[]) new Object[capacity];
        for(int i = 0; i < len; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    public void decreaseCapacity(){
        if((len * 2) < capacity){
            capacity /= 2;
            T[] newArr = (T[]) new Object[capacity];
            for(int i = 0; i < len; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }
    public void addLast(T elem){
        if(len == capacity){
            increaseCapacity();
        }
        arr[len] = elem;
        len++;
    }
    public void addFirst(T elem){
        if(len == capacity){
            increaseCapacity();
        }
        for(int i = len - 1; i >=  0; i--){
            arr[i + 1] = arr[i];
        }
        arr[0] = elem;
        len++;
    }
    public void removeLast(){
        arr[len-1] = null;
        len--;
    }
    public T removeAt(int indexToBeRemoved){
        if(indexToBeRemoved < 0 || indexToBeRemoved >= len){
            throw new IndexOutOfBoundsException();
        }
        T data = arr[indexToBeRemoved];

        for(int i = indexToBeRemoved; i < len - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[len-1] = null;
        len--;
        return data;
    }
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }
    public int indexOf(Object obj){
        for(int i = 0; i < len; i++){
            if(obj == null){
                if(arr[i] == null){
                    return i;
                }
            }
            else if(arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            int index = 0;
            @Override
            public boolean hasNext(){
                return index < len;
            }
            @Override
            public T next(){
                return arr[index++];
            }
        };
    }
    @Override
    public String toString(){
        if(len == 0){
            return "[]";
        }
        else{
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i = 0; i < len - 1; i++){
                sb.append(arr[i] + ", ");
            }
            sb.append(arr[len-1] + "]");
            return sb.toString();
        }
    }
}
