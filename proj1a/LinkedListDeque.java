/** The implementation of data structure Deque by using LinkedList */
public class LinkedListDeque<T> {
    private class Deque{
        T item;
        Deque prev, next;
        public Deque(T i, Deque p, Deque n) {
            prev = p;
            next = n;
            item= i;
        }
    }
    private int size;
    private Deque sentinel;
    public LinkedListDeque() {
        sentinel= new Deque(null , null, null);
        sentinel.next= sentinel;
        sentinel.prev= sentinel;
        size= 0;
    }

    /** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        size=size+1;
        Deque first= new Deque(item, sentinel, sentinel.next);
        first.next.prev= first;
        sentinel.next= first;
    }

    /**Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        size= size+1;
        Deque last= new Deque(item, sentinel.prev,sentinel);
        sentinel.prev.next= last;
        sentinel.prev= last;
    }

    /**Returns true if deque is empty, false otherwise*/
    public boolean isEmpty() {
        if(sentinel.next.equals(sentinel)) {
            return true;
        }else return false;
    }

    /**Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /**Prints the items in the deque from first to last, separated by a space*/
    public void printDeque() {
        Deque q= sentinel;
        while(!q.next.equals(sentinel)) {
            System.out.print(q.item+" ");
        }
    }

    /**Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.*/
    public T removeFirst() {
        size= size-1;
        sentinel.next.next.prev= sentinel;
        Deque rfirst= sentinel.next;
        sentinel.next= rfirst.next;
        return rfirst.item;
    }

    /**Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast() {
        size= size-1;
        Deque rlast= sentinel.prev;
        sentinel.prev= rlast.prev;
        rlast.prev.next= sentinel;
        return rlast.item;
    }

    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index) {
        Deque getNode= sentinel.next;
        while(index>0) {
            getNode= getNode.next;
            /* when it return the sentinel it means out of range */
            if(getNode.equals(sentinel)) {
                return null;
            }
            index= index-1;
        }
        return getNode.item;
    }

    /**Same as get, but uses recursion*/
    public T getRecursive(int index) {
        if(index<=0) {
            return sentinel.next.item;
        }else return helper(index, sentinel.next);
    }

    private T helper(int index, Deque node) {
        if(index==0||node.equals(sentinel)) {
            return node.item;
        }
        return helper(index-1, node.next);
    }
}
