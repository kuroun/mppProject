package ruleset;

import ui.AddCopyOfBookInit;

public class AddACopyOfExistingBookRuleSet implements RuleSet {

	private String bookISBN;

	// package access level
	AddACopyOfExistingBookRuleSet() {
	}

	@Override
	public void applyRule(Object ob) throws RuleException {
		AddCopyOfBookInit obj = (AddCopyOfBookInit) ob;

		bookISBN = obj.getTextISDN();

		boolean nonempty = !(bookISBN.isEmpty());
		boolean iSBNNum = bookISBN.contains("-");
		iSBNNum = iSBNNum && !bookISBN.startsWith("-")
				&& !bookISBN.endsWith("-");
		if (iSBNNum) {
			bookISBN = bookISBN.replace('-', '1');
			iSBNNum = bookISBN.matches("-?\\d+(\\.\\d+)?");
		}
		if (nonempty == false) {
			throw new RuleException(ExceptionDefinition.ALL_FIELD_NONEMPTY);
		}

		if (iSBNNum == false) {
			throw new RuleException(ExceptionDefinition.BOOK_ISBN);
		}

	}

}
