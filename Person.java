package for_project3;

import java.util.Objects;
import java.io.*;

public class Person implements Comparable<Person>, Serializable{
	
	private Name name;
	private Date date;
	private static int numPeople = 0;
	
	public Person (Name name, Date date) {
		this.name = name;
        this.date = date;
        numPeople++;
		if (name == null && date == null) {
			throw new IllegalArgumentException("Name/Date can't be null!");
		}
	}
	
	public Person(String first, String last, Month month, int day, int year) {
        this(new Name(first, last), new Date (month, day, year));
        numPeople++;
    }

	public Name getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public static int getNumPeople() {
		return numPeople;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(date, other.date) && Objects.equals(name, other.name);
	}
	
	@Override
    public String toString() {
        return name.toString() + ", " + date.toString() + "\n";
    }
	
	public int compareTo(Person other) {
        return this.name.compareTo(other.getName());
    }

	public Person getBirthday() {
		return null;
	}
}

/* Write the Person class:

Instance variables: A Name, A Date (the birthday date), and a static int numPeople that should be initialized to 0.  All should be private.
Two constructors. One should take an already created Name and a Date, and increment numPeople.  The other should take the arguments necessary to create a Name and a Date in the body of the Person constructor, and also increment numPeople.
Getters (but not setters) for all instance variables: getNumPpl(), getDate(), getName(). 
Use Eclipse to override the equals() and hashCode() methods to use your instance variables.
Override the toString() method inherited from the Object class to print the Name and Date toString()s separated by a comma.
This class should implement Comparable to compare Person objects alphabetically by Name.  (You can change the Name class too, now, if you'd like.)
Make the Person class serializable.  Ignore the serialVersionID warning.*/

