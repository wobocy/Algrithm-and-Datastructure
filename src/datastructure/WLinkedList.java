package datastructure;

/**
 * One way linked list.
 * @param <T>
 */
public class WLinkedList<T> {
    private int size;
    private Element<T> first = null;
    private Element<T> last = null; // the last node
    private Element<T> secondLast = null; // the second last node

    public WLinkedList() {

    }

    /**
     *  add an element to the end of linked list
     * @param data
     */
    public boolean add(T data) {
        if(first == null) {
            first = new Element<T>(data);
            last = first;
            secondLast = first;
        } else {
            Element<T> element = new Element<T>(data);
            last.setNext(element);
            secondLast = last;
            last = element;
        }
        size ++;
        return true;
    }

    /**
     * Add an element to the position defined by index
     * @param index
     * @param data
     * @return
     */
    public boolean add(int index, T data) {
        if(index > size - 1 || index < 0) {
            return false;
        }
        if(index == size - 1) {
            return add(data);
        }
        Element<T> element = new Element<T>(data);
        if(index == 0) {
            element.setNext(first);
            first = element;
            size ++;
            return true;
        }
        Element<T> next = first;
        int currentIndex = 0;
        while(currentIndex != index - 1) {
            next = next.getNext();
            currentIndex ++;
        }
        element.setNext(next.getNext());
        next.setNext(element);
        size ++;
        return true;
    }

    /**
     * Remove the last element
     */
    public void remove() {
        last = secondLast;
        secondLast.setNext(null);
        size --;
    }

    /**
     * Get the element in index
     * @param index
     * @return
     */
    public T get(int index) {
        if(index < 0 || index > size - 1) {
            return null;
        }
        int currentIndex = 0;
        Element<T> next = first;
        while (currentIndex != index) {
            next = next.getNext();
            currentIndex ++;
        }
        return next.getData();
    }


    /**
     * return the size of the list
     * @return
     */
    public int size() {
        return size;
    }


}
