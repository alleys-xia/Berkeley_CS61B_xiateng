/**As your second deque implementation, you’ll build the ArrayDeque class.
 * This deque must use arrays as the core data structure.*/
public class ArrayDeque<T> {
    private int size= 0;
    private T[] array;
    private T[] temp;
    private int initial;
    //private int first= array.length-1;
    //private int last= 0;
    private int first;
    private int last;
    /* create the array and assign the first and last address */
    public ArrayDeque() {
        array= (T[]) new Object[8];
        initiate();
    }

    private void initiate() {
        initial= array.length/2;
        last= initial+initial/2;
        first= initial/2-1;
    }
    /** add the first node */
    public void addFirst(T item) {
        isResize();
        /* judge the first wheather < 0*/
        size+=1;
        if(first<0) first= array.length-1; // move the the end to form a circular array
        array[first]= item;
        first-=1;
    }
    /** add the last node */
    public void addLast(T item) {
        isResize();
        size+=1;
        if(last==array.length) last= 0;
        array[last]= item;
        last+=1;
    }

    /** resize and relocated the array */
    private void resize() {
        temp= (T[]) new Object[size*2];
        if(first<initial) {
            System.arraycopy(array,first+1, temp, initial, size-first-1);
            System.arraycopy(array, 0, temp, initial+size-first-1, first+1);
        }else {
            System.arraycopy(array, first+1, temp, initial, size-first);
            System.arraycopy(array, 0, temp, initial+size-first, first);
        }
        /* relocate the position of first and last */
        array= temp;
        initiate();
    }

    /** judge the size is full or not */
    private void isResize() {
        if(size==array.length) {
            resize();
        }
    }

    /* judge the array empty or not*/
    public boolean isEmpty() {
        if(size==0) {
            return true;
        }else {
            return false;
        }
    }

    /* return the size */
    public int size() {
        return size;
    }

    /* print the deque */
    public void printDeque() {
        int sum= 0;
        if(isEmpty()) {
            return;
        }
        for(int i= first+1;i<array.length;++i) {
            sum++;
            System.out.print(array[i]+" ");
            if(sum==size) return;
        }
        for(int j=0;j<array.length;++j) {
            sum++;
            System.out.print(array[j]+" ");
            if(sum==size) return;
        }
    }

    /* remove the first node */
    public T removeFirst() {
        T node;
        if(isEmpty()) {
            System.out.println("The deque is empty! Error!");
            return null;
        }else {
            size--;
            first+=1;
            if(first==array.length) {
                first= 0;
                node= array[first];
                array[first]= null;
                return node;
            }else {
                node= array[first];
                array[first]= null;
                return node;
            }
        }
    }

    /* remove the last node */
    public T removeLast() {
        T node;
        if(isEmpty()) {
            System.out.println("The deque is empty! Error!");
            return null;
        }else {
            size--;
            last-=1;
            if(last==-1){
                last= array.length-1;
                node= array[last];
                array[last]= null;
                return node;
            }else {
                node= array[last];
                array[last]= null;
                return node;
            }
        }
    }

    public T get(int index) {
        if(index>size) {
            System.out.println("the index is out of range!");
            return null;
        }
        if(index+first<array.length) {
            return array[index+first-1];
        }else {
            return array[index-array.length+first];
        }
    }
}
