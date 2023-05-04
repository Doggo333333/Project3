package for_project3;
import java.util.Iterator;

public class LinkedListIterator<E extends Comparable<E>> implements Iterator<E> {
	
	private LinkedList<E> ml;
	private Object element;
	private int index;
	private boolean removeGotCalled;
	
	public LinkedListIterator(LinkedList<E> thelist) {
		ml = thelist;
		element = ml.get(0);
		index = 0;
		removeGotCalled = false;
	}
	
	public boolean hasNext() {
		return element != null;
	}
	
	@SuppressWarnings("unchecked")
	public E next() {
	      Object toReturn = element;
	      index++;
	      try {
	         element = ml.get(index);
	      } catch (IndexOutOfBoundsException e) {
	         element = null;
	      }
	      return (E)toReturn;
		}
	
	@Override
	public void remove() {
      if (index == 0 || removeGotCalled) {
         throw new IllegalStateException();
	}
	   ml.remove(ml.get(index-1));
	   index--;
	   removeGotCalled = true;
   } 
}
	    /*private Node<E> current;
        private int count;

        public LinkedListIterator(LinkedList<E> temp) {
            current = temp.head.getLink();
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E temp = (E) current.getData();
            current = current.getLink();
            count += 1;
            return temp;
        } 
        
        public E remove() {
        	if(count == 0) {
    			throw new IllegalStateException();
    		}
    		ml.remove(index - 1);
    		index--;
    		removeGotCalled = true;
        }*/

