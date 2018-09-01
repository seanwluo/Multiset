import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T extends Comparable<T>> extends Multiset<T>
{
    private SortNode<T> mHead = null;
    private int mLength = 0;
	public SortedLinkedListMultiset() {
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
        SortNode<T> node = new SortNode<T>(item);
        SortNode<T> perNode = mHead;

        if(mLength == 0){
            mHead = node;
        }
        else if(mHead.getItem().compareTo(item) > 0 ){
            node.setNext(mHead);
            mHead = node;
        }
        //The new node item is the smallest one
        else if(mHead.getItem().compareTo(item) < 0){
            for(int i = 1;i < mLength-1;i++){
                SortNode<T> currNode = perNode.getmNext();
                if(currNode.getItem().compareTo(item) > 0){
                    perNode.setNext(node);
                    node.setNext(currNode);
                    break;
                    //node between smallest and biggest
                }
                perNode = perNode.getmNext();
            }
            perNode.getmNext().setNext(node);
            //After loop, the largest one is the currNode,so set the node after currNode is ok;
        }


        mLength++;

	}
	// end of add()
	
	
	public int search(T item) {
	    SortNode<T> node = mHead;
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
	    SortNode<T> perNode = mHead;
	    if(mHead.getItem() == item){
	        mHead = mHead.getmNext();
	        mLength--;
        }else{
            for(int i = 0;i < mLength;i++){
	            SortNode<T> currNode = mHead.getmNext();
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
	    SortNode<T> perNode = mHead;
	    int number = this.getNumber(item);

	    if(mHead.getItem() == item){
	       for(int i = 0;i < number;i++){
	           perNode = perNode.getmNext();
           }
           mHead = perNode.getmNext();
	       //get the number and loop for the number,then move all.
        }
        else{
            for(int j = 0;j < mLength;j++){
	            SortNode<T> currNode = perNode.getmNext();
                if(currNode.getItem() == item){
                    for(int t = 0;t < number;t++){
                        currNode = currNode.getmNext();
                        perNode.setNext(currNode.getmNext());
                    }
                }
                perNode = perNode.getmNext();
            }
        }
        mLength -= number;

		// Implement me!
	} // end of removeAll()



    private int getNumber(T item){
	    SortNode<T> currNode = mHead;
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
	    SortNode<T> currNode = mHead;
	    while (currNode != null){
	        String itemName = currNode.getItem().toString();
            int itemNumber = this.getNumber(currNode.getItem());
            System.out.println(itemName+"|"+itemNumber);
            currNode = currNode.getmNext();

        }



	} // end of print()


}

class SortNode<T> {
    private T item;
    private SortNode mNext;
    public SortNode(T item){
        this.item = item;
        this.mNext = null;
    }

    public T getItem(){
        return item;
    }
    public SortNode getmNext(){
        return mNext;
    }

    public void setItem(T item){
        this.item = item;
    }

    public void setNext(SortNode mNext){
        this.mNext = mNext;
    }



}
// end of class SortedLinkedListMultiset