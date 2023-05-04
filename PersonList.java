package for_project3;

import java.io.*;
import java.util.*;

public class PersonList {
    public LinkedList<Person> list = new LinkedList<Person>();
    

    public boolean add(Person p) {
        if (!list.contains(p)) {
            list.addAlpha(p);
            return true;
        } else {
        	return false;
        }
    }

    public boolean addAlpha(Person p) {
        if (!list.contains(p)) {
            list.addAlpha(p);
            return true;
        } else {
        	return false;
        }
    }

    public Person search(Person p) {
        if (list.contains(p)) {
            return p;
        } else {
        	return null;
        }
    }


    public String saveToFile(String fileName) {
        String messageFromSave = "";
        try {
            ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
            for (int i = 0; i < list.size(); i++) {
                oOS.writeObject(list.get(i));
            }
            oOS.flush();
            oOS.close();
        } catch (Exception e) {
            messageFromSave = e.toString();
        }
        return messageFromSave;
    }

    public String loadFromFile(String fileName) {
        String toReturn = "";
        try {
            ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
            while (oIS.available() > -1) {
                Person fromFile = (Person) (oIS.readObject());
                Person found = search(fromFile);
                if (found == null) {
                    if (add(fromFile)) {
                        toReturn += fromFile + "\n";
                    } else {
                        toReturn += fromFile + " not successfully added to DB.\n";
                    }
                } else {
                    toReturn += found + " already in the DB.\n";
                }
            }
            oIS.close();
        } catch (EOFException eOF) {
        } catch (Exception e) {
            toReturn += e;
        }
        return toReturn;
    }

    public boolean delete(Name n) {
        Iterator<Person> i = list.iterator();
        boolean delete = false;
        while (i.hasNext()) {
            Person p = i.next();
            if (p.getName().equals(n)) {
                i.remove();
                delete = true;
            }
        }
        return delete;
    }

    public String hasBirthdayOn(Date date) {
        for (Person p : list) {
            if(p.getDate().equals(date)){
                return p.toString();
            }
        }
        return "Nobody has a birthday on that date.";
    }
    public String printList() {
        List<String> l = new ArrayList<String>(); 
        for (Person p : list) {
            l.add(p.toString());
        }
        String s = "";
        for (Person p: list) {
        	s += p.toString();
        }
        return s;
    }
    /*public String printList() {
        List<String> l = new ArrayList<String>(); 
        for (Person p : list) {
            l.add(p.toString());
        }
        return l.toString();
    }*/

    public String sortAlphab() {
        return printList();
    }

    public String sortChronol() {
        LinkedList<Person> sortedList = new LinkedList<Person>(new ChronoComparator());
        for (Person p : list) {
            sortedList.add(p);
        }
        sortedList.sort();
        String toReturn = "";
        for (Person p : sortedList) {
            toReturn += p.toString();
        }
        return toReturn;
    }

    public String findPersonByName(Name name) {
        String s = "Person not found.";
        for (Person p : list) {
            if (p.getName().equals(name)) {
                s = p.toString();
                break;
            }
        }
        return s;
    }
}
