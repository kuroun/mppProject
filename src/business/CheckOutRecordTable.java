package business;

import java.time.LocalDate;

public class CheckOutRecordTable {
	private String bookTitle;
	private int copyNumber;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	
	
	
	public CheckOutRecordTable(String bookTitle, int copyNumber,
			LocalDate checkOutDate, LocalDate dueDate) {
		//super();
		this.bookTitle = bookTitle;
		this.copyNumber = copyNumber;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
	}



	public String getBookTitle() {
		return bookTitle;
	}



	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}



	public int getCopyNumber() {
		return copyNumber;
	}



	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}



	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}



	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}



	public LocalDate getDueDate() {
		return dueDate;
	}



	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
}
