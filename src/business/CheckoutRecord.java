package business;

import java.util.List;

public class CheckoutRecord {
	List<CheckoutRecordEntry> checkoutRecordEntry;

	
	public CheckoutRecord(List<CheckoutRecordEntry> checkoutRecordEntry) {
		super();
		this.checkoutRecordEntry = checkoutRecordEntry;
	}


	public List<CheckoutRecordEntry> getCheckoutRecordEntry() {
		return checkoutRecordEntry;
	}
	

}
