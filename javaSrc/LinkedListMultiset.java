import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
	private Node<T> mHead;
	private Node<T> mTail;
	private int mLength;




	public LinkedListMultiset(){
	    mHead = null;
	    mTail = null;
	    mLength = 0;

    }

    public void add(T item) {
		Node<T> node = new Node<T>(item);
		if(mHead == null){
			mHead = node;
			mTail = node;
		}else{
			node.setmNext(mHead);
			mHead = node;
		}
		mLength ++;
	} // end of add()
	
	
	public int search(T item) {
		Node currNode = mHead;
		int amount = 0;

		for(int i = 0;i < mLength;i++){
			if(currNode.getItem().equals(item)){
				amount++;
			}
			currNode = currNode.getmNext();
		}
		currNode.setAmount(amount);

		return amount;
		// default return, please override when you implement this method

	} // end of add()
	
	
	public void removeOne(T item) {
		Node<T> currNode = mHead;
		for(int i = 0;i < mLength;i++){
		    if(currNode.getItem().equals(item)){

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





}
