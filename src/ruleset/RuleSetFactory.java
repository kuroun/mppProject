package ruleset;

import java.util.HashMap;

import ui.AddCopyOfBookInit;
import ui.AddNewLibraryMemberInit;
import ui.CheckOutBookFormInit;
import ui.LoginInit;
import ui.PrintCheckoutRecord;


public final class RuleSetFactory {
	
	private RuleSetFactory() {
		
	}
	
	static HashMap<Class<? extends Object>, RuleSet> map = new HashMap<>();
	static {
		map.put(AddNewLibraryMemberInit.class, new AddNewLibraryMemberRuleSet());
		map.put(CheckOutBookFormInit.class, new AddNewCheckoutRecordRuleSet());
		map.put(LoginInit.class, new LoginRuleSet());
		map.put(AddCopyOfBookInit.class, new AddACopyOfExistingBookRuleSet());
		map.put(PrintCheckoutRecord.class, new PrintRecordRuleSet());
	}
	
	public static RuleSet getRuleSet(Object c) {
		Class<? extends Object> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException("No RuleSet found for this function");
		}
		return map.get(cl);
	}
}
