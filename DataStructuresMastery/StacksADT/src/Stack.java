public interface Stack<T>{
    void push(T item); //pushes an element to the top of the stack

    T pop();           //removes and returns the element at the top of the stack. Throw if empty

    T peek();          //returns but does not remove the element and the top of stack. Throw if empty

    boolean isEmpty(); //check if the stack is empty

    int size();        //returns the size of the stack
}
