public class Node<T> {
    private T item;
    private Node<T> mNext;
    private Node<T> mPrevious;

    public Node (T item){
        this.item = item;
    }

    public void setmNext(Node<T> mNext) {
        this.mNext = mNext;
    }

    public void setmPrevious(Node<T> mPrevious) {
        this.mPrevious = mPrevious;
    }

    public Node<T> getmNext() {
        return mNext;
    }

    public Node<T> getmPrevious() {
        return mPrevious;
    }
}
