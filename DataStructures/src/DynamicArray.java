@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T>{
    private int len = 0;
    private int capacity = 0;
    private T[] arr;

    public DynamicArray(){
        this(10);
    }
    public DynamicArray(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size(){
        return len;
    }
    public void clear(){
        for(int i = 0; i < len; i++){
            arr[i] = null;
        }
        len = 0;
    }
    public T get(int index){
        return arr[index];
    }
    public void set(int index, T element){
        if(index < 0 || index >= len){
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
    }
    public void addLast(T element){
        if(len == capacity){
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
        arr[len] = element;
        len++;
    }
    public void removeAt(int indexToBeRemoved){
        if(indexToBeRemoved < 0 || indexToBeRemoved >= len){
            throw new IndexOutOfBoundsException();
        }

        for(int i = indexToBeRemoved; i < len - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[--len] = null;
    }
}
