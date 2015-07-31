package ruleset;

import ui.CheckOutBookFormInit;
import ui.PrintCheckoutRecord;

public final class PrintRecordRuleSet implements RuleSet {

	private String memberId;
	// package level access
	PrintRecordRuleSet() {
	}

	@Override
	public void applyRule(Object ob) throws RuleException {
		PrintCheckoutRecord printCheckout = (PrintCheckoutRecord) ob;

		memberId = printCheckout.getTxtMemberId().getText();
		boolean nonempty = !(memberId.isEmpty());
		boolean idNum = memberId.matches("-?\\d+(\\.\\d+)?");
		if (nonempty == false) {
			throw new RuleException(ExceptionDefinition.ALL_FIELD_NONEMPTY);
		}
		if (idNum == false) {
			throw new RuleException(ExceptionDefinition.MEMBER_ID);
		}
	}
}
