package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class LibraryMember extends Person implements Serializable {
	
	private static final long serialVersionUID = 6110690276685962829L;
	private String memberID;
	private CheckoutRecord checkoutRecord;
	public LibraryMember(String f, String l, String t, Address a, String memberId) {
		super(f, l, t, a);
		this.memberID = memberId;
		checkoutRecord = new CheckoutRecord(new ArrayList<CheckoutRecordEntry>());
	}
	

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public void checkout(BookCopy bookCopy, LocalDate todayDate, LocalDate dueDate ){
		bookCopy.isAvailable(false); // mean change it to false;
		CheckoutRecordEntry newBookEntry = CheckoutRecordEntry.createEntry(bookCopy, todayDate, dueDate);
		checkoutRecord.addEntry(newBookEntry);
	}
	
}
