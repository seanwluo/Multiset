import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T extends Comparable<T>> extends Multiset<T>
{
	
	Node root;
	public BstMultiset() {
		
		// Implement me!
	} // end of BstMultiset()

	public void add(T item) {
		
		Node<T> newNode=new Node<T>(item);
		
		if (root==null) {
			root=newNode;    // the fiset case:when the root node is null or the bst is empty,then lets set the root is the added node
		}else {
			Node<T> currentnode=root;
			boolean done=true;
		
			for(;done=true;) {
				
				if(item.equals(currentnode.getValue())){
					currentnode.addLeaf();
					break;
				}else if(item.compareTo(currentnode.getValue())<0) {
					if(currentnode.getLeftchild()==null) {
						currentnode.setLeftchild(newNode);
						break;
					}else {
						currentnode=currentnode.getLeftchild();
						done=true;
					}
				}else if(item.compareTo(currentnode.getValue())>0) {
					if(currentnode.getRightchild()==null) {
						currentnode.setRightchild(newNode);
						break;
					}else {
						currentnode=currentnode.getRightchild();
						done=true;
					}
				}
			}
				
		}
		
		// Implement me!
	} // end of add()


	public int search(T item) {
		// Implement me!
		
		if(root==null) {
			return 0; 
		}else {
			Node<T> currentNode=root;
			boolean done=false;
			int found=0;
			
			for(;done=false;) {
				if(item.compareTo(currentNode.getValue())==0) {
					found=currentNode.getCount();
					break;
				}else if(item.compareTo(currentNode.getValue())<0) {
					if(currentNode.getLeftchild()==null) {
						found=0;
						break;
					}else {
						currentNode=currentNode.getLeftchild();
						done=false;
					}
				}else if(item.compareTo(currentNode.getValue())>0) {
					if(currentNode.getRightchild()==null) {
						found=0;
						break;
					}else {
						currentNode=currentNode.getRightchild();
						done=false;
					}
				}	
			}
			return found;
			}
			
		}
			
			
			
		
		// default return, please override when you implement this method
		// end of add()


	public void removeOne(T item) {
		// Implement me!
		if(root!=null) {
			Node<T> currentNode=root;
			boolean done=false;
			while(!done) {
				if(item.compareTo(currentNode.getValue())==0) {
					int count=currentNode.removeLeaf();
					if(count==0) {
						removeAll(item);
					}
					done=true;
				}else if(item.compareTo(currentNode.getValue())<0) {
					if(currentNode.getLeftchild()==null) {
							done=true;
					}else {
						currentNode=currentNode.getLeftchild();
					}
				}else if(item.compareTo(currentNode.getValue())>0) {
					if(currentNode.getRightchild()==null) {
						done=true;
					}else {
						currentNode=currentNode.getRightchild();
					}
				}
			}
		}
	}
		
// end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
		if(root!=null) {
			root=myDelete(root.item);
		}
	} // end of removeAll()
	private Node<T> myDelete(Node<T> point, T item) {
		// Case: Job already done
		if (point == null) {
			return null;
		}

		// Case: Node with the required value is to the left or right of point
		// Move to next node
		if (item.compareTo(point.getValue()) < 0) {
			point.setLeftchild(myDelete(point.getLeftchild(), item));
		} else if (item.compareTo(point.getValue()) > 0) {
			point.setRightchild(myDelete(point.getRightchild(), item));
		}

		else { // Case: This is the node with the required value
				// No children
			if (point.getLeftchild() == null && point.getRightchild() == null) {
				return null; // delete reference to point
			} else if (point.getLeftchild() == null) {
				// One child to the right
				// join point's parent to point's right child
				return point.getRightchild();
			} else if (point.getRightchild() == null) {
				// One child to the left
				// join point's parent to point's right child
				return point.getLeftchild();
			} else {
				// Both children exist
				// Find node with min value
				Node<T> min = minNode(point.getRightchild());
				point.setValue(min.getValue());
				point.setCount(min.getCount());
				// Delete the node
				point.setRightchild(myDelete(point.getRightchild(), min.getValue()));
			}
		}
		return point;
	}

	private Node<T> minNode(Node<T> point) {
		while (point.getLeftchild() != null) {
			point = point.getLeftchild();
		}
		return point;
	}

	@SuppressWarnings("unused")
	private T minValue(Node<T> point) {
		T minValue = point.getValue();
		while (point.getLeftchild() != null) {
			minValue = point.getLeftchild().getValue();
			point = point.getLeftchild();
		}
		return minValue;
	}
	
	
	public void print(PrintStream out) {
		// Implement me!
		
		if (root != null) {
			travelPrint(root, out);
		} else {
			out.println("Structure is empty");
		}
	} // end of print()
	
	private void travelPrint(Node<T> top, PrintStream out) {
		if (top != null) {
			travelPrint(top.getLeftchild(), out);
			out.println(top.getValue() + printDelim + top.getCount());
			travelPrint(top.getRightchild(), out);
		}
	}
	
	
	
	private class Node<Y extends Comparable<Y>>{
		//一个节点的基本元素，任何类型的值，相应的key。
		private Y value;
		private int count=0;
		
		private Node<Y>leftchild;
		private Node<Y>rightchild;
		
		public Node(Y value) {
			this.value=value;
			leftchild=null;
			rightchild=null;
			count=1;
		}
		
		public int addLeaf() {
			count++;
			return count;
		}
		
		public int removeLeaf(){
			count--;
			return count;
		}
		
		public Y getValue() {
			return value;
		}
		public void setValue(Y value) {
			this.value = value;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public Node<Y> getLeftchild() {
			return leftchild;
		}
		public void setLeftchild(Node<Y> leftchild) {
			this.leftchild = leftchild;
		}
		public Node<Y> getRightchild() {
			return rightchild;
		}
		public void setRightchild(Node<Y> rightchild) {
			this.rightchild = rightchild;
		}
		
		
		
		
	}

} // end of class BstMultiset
