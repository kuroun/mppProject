package business;

import java.io.Serializable;
import java.util.List;

public class CheckoutRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<CheckoutRecordEntry> checkoutRecordEntry;

	public CheckoutRecord(List<CheckoutRecordEntry> checkoutRecordEntry) {
		super();
		this.checkoutRecordEntry = checkoutRecordEntry;
	}
	public List<CheckoutRecordEntry> getCheckoutRecordEntry() {
		return checkoutRecordEntry;
	}
	public void addEntry(CheckoutRecordEntry checkOutRecordEntry){
		checkoutRecordEntry.add(checkOutRecordEntry);
	}
	

}
