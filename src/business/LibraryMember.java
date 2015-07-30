package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

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
	
	public static final Comparator MEMBER_ID = new Comparator(){
		public int compare(Object o1, Object o2) {
			Integer memberID1 = Integer.parseInt(((LibraryMember)o1).getMemberID());
			Integer memberID2 = Integer.parseInt(((LibraryMember)o2).getMemberID());
			return memberID1.compareTo(memberID2);
		}
	};
}
