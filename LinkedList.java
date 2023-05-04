package for_project3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class LinkedList<E extends Comparable<E>> implements Iterable<E>, Serializable  {
	
	public Node<E> head;
	public int size;
	//public LinkedList<E> returnstatement;
	private Comparator<E> myComparator;	
	//public Person toReturn;

	public LinkedList(Comparator<E> theComparator) {
		head = null;
		myComparator = theComparator;
	}
	public LinkedList() {
		head = null;
		size = 0;
	}
	/*public LinkedList(LinkedList<E> curr) {
		head = null;
		size = 0;
		//returnstatement = curr;
	}*/

	public void add(E data) {
		Node<E> newNode = new Node<>(data);
		if (head == null || data.compareTo(head.getData()) >= 0) {
			newNode.setLink(head);
			head = newNode;
		} else {
			Node<E> mover = head;
			while (mover.getLink() != null) {
				if(data.compareTo(mover.getLink().getData()) >= 0) {
					mover = mover.getLink();
				}
				else {
					break;
				}
			}
			newNode.setLink(mover.getLink());
			mover.setLink(newNode);
		}
		size++;
	}
	
	public void addFirst(E data) {
		Node<E> n = new Node<>(data);
		n.setLink(head);
		head = n;
		size++;
	}
	
	public String toString() {
		String toReturn = "";
		Node<E> mover = head;
		while(mover != null) {
			toReturn += mover.getData() + " - ";
			mover = mover.getLink();
		}
		if(size == 0) {
			toReturn = "Empty list";
		}
		return toReturn;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> mover = head;
		for(int i = 0; i < index; i++) {
			mover = mover.getLink();
		}
		return mover.getData();
	}
	
	public void set(int index, E data) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> mover = head;
		for(int i = 0; i < index; i++) {
			mover = mover.getLink();
		}
		mover.setData(data);
	}
	
	public void addAlpha(E data) {
		Node<E> newNode = new Node<>(data);
		if (head == null || data.compareTo(head.getData()) < 0) {
			newNode.setLink(head);
			head = newNode;
		} else {
			Node<E> mover = head;
			while (mover.getLink() != null) {
				if(data.compareTo(mover.getLink().getData()) >= 0) {
					mover = mover.getLink();
				}
				else {
					break;
				}
			}
			newNode.setLink(mover.getLink());
			mover.setLink(newNode);
		}
		size++;
	}
	/*public void addAlpha(Person p) {
		Node<Person> newNode = new Node<Person>(p);
		if (head == null || p.compareTo((Person)head.getData()) < 0) {
			newNode.setLink((Node<Person>)head);
			head = (Node<E>)newNode;
		} else {
			Node<Person> mover = (Node<Person>)head;
			while (mover.getLink() != null && p.compareTo((Person)mover.getLink().getData()) >= 0) {
				mover = mover.getLink();
			}
			newNode.setLink(mover.getLink());
			mover.setLink(newNode);
		}
		size++;
	}*/
	
	public boolean contains(E data) {
		Node<E> mover = head;
		while (mover != null) {
			if (mover.getData().equals(data)) {
				return true;
			}
			mover = mover.getLink();
		}
		return false;
	}
	/*public boolean contains(Person p) {
		Node<Person> mover = (Node<Person>) head;
		while (mover != null) {
			if (mover.getData().getName().equals(p.getName())) {
				return true;
			}
			if (mover.getData().getDate().equals(p.getDate())) {
				return true;
			}
			mover = mover.getLink();
		}
		return false;
	}
	public boolean contains(Date data) {
		Node<Person> mover = (Node<Person>)head;
		while (mover != null) {
			if (mover.getData().getBirthday().equals(data)) {
				this.toReturn = mover.getData();
				return true;
			}
			mover = mover.getLink();
		}
		return false;
	}*/
	
	public int size() {
		return size;
	}
	
	public boolean remove(E data) {
		if(head == null) {
			return false;
		}
		else if(head.getData().equals(data) && head.getLink() == null) {
			head = null;
			size--;
			return true;
		}
		else if(head.getData().equals(data) && head.getLink() != null) {
			head = head.getLink();
			size--;
			return true;
		}
		
		Node<E> mover1 = head;
		Node<E> mover2 = head.getLink();
		
		while(mover2 != null) {
			if(mover2.getData().equals(data)) {
				mover1.setLink(mover2.getLink());
				size--;
				return true;
			}else {
				mover1 = mover1.getLink();
				mover2 = mover2.getLink();
			}
		}
		return false;
	}
	public Node<E> getMiddle(Node<E> head){ 
		Node<E> slow = head;
		Node<E> fast = head;
		while(fast.getLink() != null && fast.getLink().getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
		}
		return slow; 
	}
	
	private int myCompare(E first, E second) {
        if(myComparator == null) {
           return first.compareTo(second);
        }
        return myComparator.compare(first, second);
     }
	
	public Node<E> merge(Node<E> a, Node<E> b){ 
		Node<E> result = null;
		if(a == null) { 
			return b;
		}
		if(b == null) {
			return a;
		}
		if(myCompare(a.getData(), b.getData()) <= 0) { 
			result = a;
			result.setLink(merge(a.getLink(), b)); 
		} else {
			result = b;
			result.setLink(merge(a, b.getLink())); 
		}
		return result; 
	}
	
	public Node<E> mergeSort(Node<E> h) { 
		if(h == null || h.getLink() == null) {
			return h; 
		}
		Node<E> middle = getMiddle(h); 
		Node<E> nexttomiddle = middle.getLink(); 
		middle.setLink(null);
		Node<E> left = mergeSort(h);
		Node<E> right = mergeSort(nexttomiddle); 
		Node<E> sortedlist = merge(left, right); 
		return sortedlist;
	}
	
	public void sort() {
		head = this.mergeSort(head);
	}
	 public List<E> toList() {
        List<E> returnList = new ArrayList<E>();
        Node<E> pointer = head.getLink();
        while (pointer != head) {
            returnList.add((E) pointer.getData());
            pointer = pointer.getLink();
        }
        return returnList;
	    }
	@Override
	public LinkedListIterator<E> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator<E>(this);
		}
}

/*Most of the challenge of this project will come from this and the PersonList class.  Please reach out for help if you need it.

Add a method: public void addAlpha(E data).  This method should insert a new Node<E> into the list in the order specified by the 
implementation of Comparable in the E class.  For example, if the Node<E> is of type Person (Node<Person>), then the addAlpha method 
should insert the "Kristin Jones" Node<E> before "Brunhilda Twinkletoes."   If "Zachary Zakaria" is inserted next, he should be inserted 
after "Brunhilda Twinkletoes." Add a method: public boolean contains(E data).  This method should return true if a Node<E> containing 
data is in the list, and false otherwise. Add multiple methods needed to accomplish a merge sort of the list.  (Merge sort will be 
covered in Week Thirteen, and we will talk about how to approach this part of Project 3 in class.) Make your LinkedList class iterable. 
(When we wrote an Iterator for MyList in our ZyLab on April 5, we made MyList iterable: this ZyLab will be an excellent model for your 
task). This task might still be quite challenging: please reach out for help if you need it.  Please note: The Iterator MUST be in a 
separate class (you should add an Iterator class to your project). */
