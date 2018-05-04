package datastructure;

public class Element<T> {
    private Element next = null;
    private Element prior = null;
    private T data = null;

    public Element(T data) {
        this.data = data;
    }



    public void setNext(Element next) {
        this.next = next;
    }
    public void setPrior(Element prior) {
        this.prior = prior;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Element<T> getNext() {
        return this.next;
    }
    public Element<T> getPrior() {
        return this.prior;
    }
    public T getData() {
        return this.data;
    }
}
