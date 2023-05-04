package for_project3;

import java.util.Objects;
import java.io.*;


public class Name implements Serializable{
	private String first;
	private String middle;
	private String last;
	
	public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }
	
	public Name(String first, String last) {
        this(first, "", last);
    }

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, last, middle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return Objects.equals(first, other.first) && Objects.equals(last, other.last)
				&& Objects.equals(middle, other.middle);
	}
	
	public String toString() {
		if (middle == null) {
			return first + " " + last;
		} else {
			return first + " " + middle + " " + last;
		}
	}

	public int compareTo(Name name) {
		int l = last.compareTo(name.last);
		int m = middle.compareTo(name.middle);
        if (l != 0) {
            return l;
        } else if (m != 0) {
        	return m;
        } else {
            return first.compareTo(name.first);
        }
	}
}
/*Write the Name class:

A Name should consist of three Strings: first, middle, and last.
You should be able to construct a Name in two ways (two constructors): with and without a middle name.
Use Eclipse to generate standard getters and setters for all three instance variables.
Use Eclipse to generate the equals() and hashCode() method to use your three instance variables.  
Override the inherited toString() to return the Name String in two possible formats: for example "Kristin Alise Jones" or "Kristin Jones" depending on whether the middle name is empty or not.
Make Name serializable.  Ignore the serialVersionID warning.*/