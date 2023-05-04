package for_project3;

import java.util.Comparator;

public class ChronoComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		Date date1 = o1.getDate();
        Date date2 = o2.getDate();
        
        if (date1.getYear() < date2.getYear()) {
            return -1;
        } else if (date1.getYear() > date2.getYear()) {
            return 1;
        } else {
            if (date1.getMonth().getNum() < date2.getMonth().getNum()) {
                return -1;
            } else if (date1.getMonth().getNum() > date2.getMonth().getNum()) {
                return 1;
            } else {
                if (date1.getDay() < date2.getDay()) {
                    return -1;
                } else if (date1.getDay() > date2.getDay()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

	}
	
	
}
/*Write a Comparator class called "ChronoComparator":

This separate class should be able to compare Person objects by Date (not by Name). 
 For example, April 19, 2021 should come before March 18, 2023.  
 Be sure to take all parts of a Date into consideration: Month, day, and year. */