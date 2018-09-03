import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T extends Comparable<T>> extends Multiset<T>
{
    private Node<T> mHead;
    private int mLength ;


    public SortedLinkedListMultiset() {
	    mHead = null;
	    mLength = 0;
	} // end of SortedLinkedListMultiset()


	public void add(T item) {
        Node<T> node = new Node(item);
        if(mHead == null){
            mHead = node;
        }else{
            node.setmNext(mHead);
            mHead = node;
        }
        mLength ++;
        this.sortList();
	}
	// end of add()
	
	
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
	} // end of add()
	
	
	public void removeOne(T item) {
	    Node<T> currNode = mHead;
	    Node<T> perNode = null;
 	    if(mHead.getItem() == item){
	        mHead = mHead.getmNext();
	        mLength--;
        }else{
           while (currNode.getmNext() != null){
                perNode = currNode.getmPrevious();
                if(currNode.getItem() == item){
                    perNode.setmNext(currNode.getmNext());
                    mLength--;
                    break;
                }
                currNode = currNode.getmNext();
            }

        }

	} // end of removeOne()
	
	
	public void removeAll(T item) {
	    Node<T> currNode = mHead;
	    Node<T> perNode = null;
	    int number = this.getNumber(item);

	    if(mHead.getItem() == item){
	        for(int i = 0;i < number;i++){
	           currNode = currNode.getmNext();
	        }
	        mHead = currNode.getmNext();
	       //get the number and loop for the number,then move all.
        }
        else{
            for(int j = 0;j < mLength;j++){
	            perNode = currNode.getmPrevious();
                if(currNode.getItem() == item){
                    for(int t = 0;t < number;t++){
                        currNode = currNode.getmNext();
                        perNode.setmNext(currNode.getmNext());
                    }
                }
                currNode = currNode.getmNext();
            }
        }
        mLength -= number;

	} // end of removeAll()



    private int getNumber(T item){
	    Node<T> currNode = mHead;
	    int number = 0;
	    while (currNode != null){
	        if(currNode.getItem() == item){
	            number++;
            }
            currNode = currNode.getmNext();
        }
	    return number;
    }
	
	public void print(PrintStream out) {
	    Node<T> currNode = mHead;
	    while (currNode != null){
	        String itemName = currNode.getItem().toString();
            int itemNumber = this.getNumber(currNode.getItem());
            System.out.println(itemName+"|"+itemNumber);
            currNode = currNode.getmNext();

        }



	}// end of print()

    private void sortList(){
        Node<T> nextNode = null;
	    T tmp;
	    Node<T> currNode = mHead;
	    while (currNode.getmNext() != null){
	        nextNode = currNode.getmNext();
	        while (nextNode != null){
	            if(currNode.getItem().compareTo(nextNode.getItem()) > 0){
	                tmp = currNode.getItem();
	                currNode.setItem(nextNode.getItem());
	                nextNode.setItem(tmp);
                }
                nextNode = nextNode.getmNext();
            }
            currNode = currNode.getmNext();
        }
    }

}

// end of class SortedLinkedListMultiset