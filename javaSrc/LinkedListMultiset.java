import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T extends Comparable<T>> extends Multiset<T>
{
	private Node<T> mHead;

	private int mLength;




	public LinkedListMultiset(){
	    mHead = null;
	    mLength = 0;

    }

    public void add(T item) {
		Node<T> node = new Node(item);
		if(mHead == null){
			mHead = node;
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
			if(currNode.getItem().compareTo(item) == 0){
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
		    if(currNode.getItem().compareTo(item) == 0){
		        if(currNode == mHead){
		            currNode.getmNext().setmPrevious(null);
		            mHead = currNode.getmNext();
		            mLength--;
		            break;
                }else if(currNode.getmNext() == null){
		            currNode.getmPrevious().setmNext(null);
		            mLength--;
		            break;
                }else{
		            Node<T> preNode = currNode.getmPrevious();
		            Node<T> nextNode = currNode.getmNext();
		            preNode.setmNext(nextNode);
		            mLength--;
		            break;
                }
            }
            currNode = currNode.getmNext();
        }

	} // end of removeOne()
	
	
	public void removeAll(T item) {
        Node<T> currNode = mHead;
        for(int i = 0;i < mLength;i++){
            if(currNode.getItem().compareTo(item) == 0){
                if(currNode == mHead){
                    currNode.getmNext().setmPrevious(null);
                    mHead = currNode.getmNext();
                    mLength--;
                }else if(currNode.getmNext() == null){
                    currNode.getmPrevious().setmNext(null);
                    mLength--;
                }else{
                    Node<T> preNode = currNode.getmPrevious();
                    Node<T> nextNode = currNode.getmNext();
                    preNode.setmNext(nextNode);
                    mLength--;
                }
            }
            currNode = currNode.getmNext();
        }


    }// end of removeAll()
	
	
	public void print(PrintStream out) {
	    Node currNode = mHead;
	    for(int i = 0;i < mLength;i++){
	    	Node nextNode = currNode.getmNext();
	        for(int j =i+1; j < mLength;j++){
	            if(currNode.getItem() == nextNode.getItem()){
	                String itemName = currNode.getItem().toString();
	                int itemSum = 0;
	                itemSum++;
                    System.out.println(itemName+"|"+itemSum);
                }
	            nextNode = currNode.getmNext();


            }
            currNode = currNode.getmNext();
        }



	} // end of print()
	
} // end of class LinkedListMultiset






