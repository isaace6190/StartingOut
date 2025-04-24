@SuppressWarnings("unchecked")
public class redoArray<T> implements Iterable<T>{
    private int capacity;
    private int len;
    private T[] arr;

    public redoArray(){
        this(16);
    }
    public redoArray(int capacity){
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
    public T get(int index){
        if(index < 0 || index > len){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
    public void set(int index, T elem){
        if(index < 0 || index > len){
            throw new IndexOutOfBoundsException();
        }
        arr[index] = elem;
    }
    public void clear(){
        for(int i = 0; i < len; i++){
            arr[i] = null;
        }
        len = 0;
    }
    public void add(T elem){
        if(len + 1 >= capacity){
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
        arr[len++] = elem;
    }
    public T removeAt(int indexToBeRemoved){
        if(indexToBeRemoved < 0 || indexToBeRemoved > len){
            throw new IndexOutOfBoundsException();
        }
        T data = arr[indexToBeRemoved];
        for(int i = indexToBeRemoved; i < len -1;i++){
            arr[i]= arr[i+1];
        }
        arr[--len] = null;
        return data;
    }
    public boolean remove(Object obj){
        int index = indexOf(obj);
        if(index == -1){
            return false;
        }
        removeAt(index);
        return true;
    }
    public int indexOf(Object obj){
        for(int i = 0; i < len; i++){
            if(obj == null){
                if(arr[i] == null){
                    return i;
                }
            }
            else{
                if(obj.equals(arr[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }
    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){
            int index = 0;
            @Override
            public boolean hasNext(){
                return index < len;
            }
            @Override
            public T next(){
                return arr[index++];
            }
            @Override
            public void remove(){
                throw new UnsupportedOperationException();
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

            for(int i = 0; i < len-1; i++){
                sb.append(arr[i] + ",");
            }
            return sb.append(arr[len-1] + "]").toString();
        }
    }
}