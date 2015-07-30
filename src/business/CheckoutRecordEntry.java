package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntry implements Serializable {

	private static final long serialVersionUID = -8272800923661353744L;

	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	private String title;
	private CheckoutRecordEntry(BookCopy bookCopy,LocalDate checkoutDate, LocalDate dueDate) {
		super();
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.bookCopy = bookCopy;
		this.title = this.bookCopy.getBook().getTitle();
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	
	public static CheckoutRecordEntry createEntry(BookCopy bookCopy, LocalDate checkoutDate, LocalDate dueDate){
		return new CheckoutRecordEntry(bookCopy,checkoutDate, dueDate);
	}
}
