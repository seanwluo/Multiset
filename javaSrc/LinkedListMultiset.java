import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
	private Node mHead = null;
	private int mLength = 0;




    public void add(T item) {
		Node<T> node = new Node<T>(item);
		if(mHead == null){
			mHead = node;
		}else{
			node.setNext(mHead);
			mHead = node;

		}
		mLength ++;
	} // end of add()
	
	
	public int search(T item) {
		Node currNode = mHead;
		int sum = 0;
		for(int i = 0;i < mLength;i++){
			if(currNode.getItem().equals(item)){
				sum++;
			}
			currNode = currNode.getmNext();
	}
		return sum;

		
		// default return, please override when you implement this method

	} // end of add()
	
	
	public void removeOne(T item) {
		Node perNode = mHead;
		if(mHead.getItem() == item){
			mHead = mHead.getmNext();
			mLength--;
		}
		//if its first one,just delete move mead to next;
		else{
			for(int i = 0;i < mLength-1;i++){
			Node currNode = perNode.getmNext();
				if(currNode.getItem() == item){
					perNode.setNext(currNode.getmNext());
					mLength--;
					break;
				}
				perNode = perNode.getmNext();
			}
		}

	} // end of removeOne()
	
	
	public void removeAll(T item) {
		Node perNode = mHead;
		for(int i = 0;i < mLength -1;i++){
			Node currNode = perNode.getmNext();
			if(currNode.getItem() == item){
				perNode.setNext(currNode.getmNext());
			}
			perNode = perNode.getmNext();
			mLength--;

		}


	} // end of removeAll()
	
	
	public void print(PrintStream out) {
	    Node currNode = mHead;
	    for(int i = 0;i < mLength;i++){
	        for(int j =i+1; j < mLength;j++){
	        	Node nextNode = currNode.getmNext();
	            if(currNode.getItem() == nextNode.getItem()){
	                String itemName = currNode.getItem().toString();
	                int itemSum = 0;
	                itemSum++;
                    System.out.println(itemName+"|"+itemSum);
                }
	            nextNode = nextNode.getmNext();


            }
            currNode = currNode.getmNext();
        }



	} // end of print()
	
} // end of class LinkedListMultiset



 class Node<T> {
    private T item;
    private Node mNext;
    public Node(T item){
        this.item = item;
        this.mNext = null;
    }

    public T getItem(){
        return item;
    }
    public Node<T> getmNext(){
        return mNext;
    }

    public void setItem(T item){
        this.item = item;
    }

    public void setNext(Node mNext){
        this.mNext = mNext;
    }

}
