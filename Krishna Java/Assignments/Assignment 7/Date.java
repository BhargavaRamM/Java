import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Date implements Serializable {
	private int month;
	private int day;
	private int year;
	public Date() {
		this.month = 0;
		this.day = 0;
		this.year = 0;
	}
	public Date(int month, int day, int year) {
		this.month = editMonth(month);
		this.day = editDay(day);
		this.year = editYear(year);
	}
	public void setDate(int month, int day, int year) {
		this.month = editMonth(month);
		this.day = editDay(day);
		this.year = editYear(year);
	}
	public String getDate()	{
		String str = this.month + "/" + this.day + "/" + this.year;
		return str;
	}
	public int getMonth() {
		return this.month;
	}
	public int getDay()	{
		return this.day;
	}
	public int getYear() {
		return this.year;
	}
	protected int editMonth(int month) {
		int i = month;
		int j = 0;

		while (j == 0)
		{
			if ((i >= 1) && (i <= 12))
			{
				j = 1;
			}
			else
			{
				i = Input.getInt("Month must be 1 - 12");
				j = 0;
			}
		}
		return i;
	}
	protected int editDay(int day) {
		int i = day;
		int j = 0;
		int[] arrayOfInt = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((this.month < 1) || (this.month > 12)) {
			this.month = editMonth(this.month);
		}
		while (j == 0)
		{
			if ((i >= 1) && (i <= arrayOfInt[(this.month - 1)])) {
				j = 1;
			}
			else {
				i = Input.getInt("Day must be 1 - " + arrayOfInt[(this.month - 1)]);
				j = 0;
			}
		}
		return i;
	}
	protected int editYear(int year) {
		int i = year;
		int j = 0;

		while (j == 0)
		{
			if (i > 0) {
				j = 1;
			}
			else {
				i = Input.getInt("Year must be greater than 0");
				j = 0;
			}
		}

		return i;
	}
	private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
		out.writeInt(getMonth());
		out.writeInt(getDay());
		out.writeInt(getYear());
	}
	private void readObject(ObjectInputStream in) throws IOException {
		setDate(in.readInt(), in.readInt(), in.readInt());
	}
} 