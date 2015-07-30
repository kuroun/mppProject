package ruleset;

import ui.CheckOutBookFormInit;

public final class AddNewCheckoutRecordRuleSet implements RuleSet {

	private String memberId;
	private String bookISBN;

	// package level access
	AddNewCheckoutRecordRuleSet() {
	}

	@Override
	public void applyRule(Object ob) throws RuleException {
		CheckOutBookFormInit addCheckout = (CheckOutBookFormInit) ob;

		memberId = addCheckout.getTxtMemberId().getText();
		bookISBN = addCheckout.getTxtISBN().getText();

		boolean nonempty = !(memberId.isEmpty() || bookISBN.isEmpty());
		boolean idNum = memberId.matches("-?\\d+(\\.\\d+)?");
		boolean iSBNNum = bookISBN.contains("-");
		iSBNNum = iSBNNum && !bookISBN.startsWith("-") && !bookISBN.endsWith("-");
		if(iSBNNum){
			bookISBN = bookISBN.replace('-','1');
			iSBNNum = bookISBN.matches("-?\\d+(\\.\\d+)?");
		}
		if (nonempty == false) {
			throw new RuleException(ExceptionDefinition.ALL_FIELD_NONEMPTY);
		}

		if (idNum == false) {
			throw new RuleException(ExceptionDefinition.MEMBER_ID);
		}
		if (iSBNNum == false) {
			throw new RuleException(ExceptionDefinition.BOOK_ISBN);
		}
	}
}
