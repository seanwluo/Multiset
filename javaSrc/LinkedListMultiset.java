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
		Node<T> currNode = mHead;
		int amount = 0;

		for(int i = 0;i < mLength;i++){
			if(item.compareTo(currNode.getItem()) == 0){
				amount++;
			}
			currNode = currNode.getmNext();
		}
		return amount;
		
		/*
	public int search(T item) {
	    Node<T> node = mHead;
	    int sum = 0;
	    for(int i = 0;i < mLength;i++){
	        if(node.getItem() == item){
                sum++;
            }
            node = node.getmNext();
        }

		// Implement me!		
		
		// default return, please override when you implement this method
		return sum;
	} // 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		
		
		// default return, please override when you implement this method

	} // end of add()
	
	
	public void removeOne(T item) {
		Node<T> currNode = mHead;
		for(int i = 0;i < mLength;i++){
			Node<T> nextNode = currNode.getmNext();
			Node<T> preNode = currNode.getmPrevious();
		    if(item.compareTo(currNode.getItem()) == 0){
		        if(currNode == mHead){
		            mHead = currNode.getmNext();
		            mLength--;
		            break;
                }else if(currNode.getmNext() != null){
		        	currNode.setItem(nextNode.getItem());
		        	currNode.setmNext(nextNode.getmNext());
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
        	Node<T> nextNode = currNode.getmNext();
            if(item.compareTo(currNode.getItem()) == 0){
                if(currNode == mHead){
                    currNode.getmNext().setmPrevious(null);
                    mHead = currNode.getmNext();
                    mLength--;
                }else if(currNode.getmNext() == null){
                    currNode.getmPrevious().setmNext(null);
                    mLength--;
                }else{
					currNode.setItem(nextNode.getItem());
					currNode.setmNext(nextNode.getmNext());
					mLength--;
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






