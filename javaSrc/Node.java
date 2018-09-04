public class Node<T extends Comparable<T>> {
    private T item;
    private Node<T> mNext;
    private Node<T> mPrevious;
    private int amount;

    public Node (T item){
        this.item = item;
    }

    public void setmNext(Node<T> mNext) {
        this.mNext = mNext;
    }

    public void setmPrevious(Node<T> mPrevious) {
        this.mPrevious = mPrevious;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getmNext() {
        return mNext;
    }

    public Node<T> getmPrevious() {
        return mPrevious;
    }

    public T getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

}
