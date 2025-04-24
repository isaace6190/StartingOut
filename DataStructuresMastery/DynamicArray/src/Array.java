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
        if(capacity < 0)throw new IllegalArgumentException();
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }
    public int size(){return len;}
    public void increaseCap(){
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
    public void addLast(T element){
        if(len == capacity){
            increaseCap();
        }
        arr[len] = element;
        ++len;
    }
    public void addFirst(T element){
        if(len == capacity){
            increaseCap();
        }
        for(int i = len; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = element;
        ++len;
    }
    public T removeAt(int indexRemoved){
        T data = arr[indexRemoved];
        for(int i = indexRemoved; i < len-1; i++){
            arr[i] = arr[i+1];
        }
        --len;
        arr[len] = null;
        return data;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            int index = 0;
            public boolean hasNext(){
                return len < index;
            }
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
            for(int i = 0; i < len -1; i++){
                sb.append(arr[i]).append(", ");
            }
            return sb.append(arr[len-1]).append("]").toString();
        }
    }


}