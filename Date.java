package for_project3;

import java.util.Objects;
import java.io.*;

public class Date implements Serializable{
	
	private Month month;
	private int day;
	private int year;

	public Date (Month month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		if (year < 0 || !month.isValidDay(month, day)) {
			throw new IllegalArgumentException("Invalid!");
		}
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		if (!month.isValidDay(month, day)) {
			throw new IllegalArgumentException("Invalid!");
		}
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (!month.isValidDay(month, day)) {
			throw new IllegalArgumentException("Invalid!");
		}
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year < 0) {
			throw new IllegalArgumentException("Invalid!");
		}
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}
	
	public String toString() {
        return month + " " + day + ", " + year;
    }
}