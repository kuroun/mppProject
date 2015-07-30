package ruleset;

import java.util.HashMap;

import ui.AddNewLibraryMemberInit;
<<<<<<< HEAD
import ui.CheckOutBookFormInit;
=======
import ui.LoginInit;
>>>>>>> 202a2f3fab5eaaf2d52d7f6e0b97fb9d8c513990

public final class RuleSetFactory {
	
	private RuleSetFactory() {
		
	}
	
	static HashMap<Class<? extends Object>, RuleSet> map = new HashMap<>();
	static {
		map.put(AddNewLibraryMemberInit.class, new AddNewLibraryMemberRuleSet());
<<<<<<< HEAD
		map.put(CheckOutBookFormInit.class, new AddNewCheckoutRecordRuleSet());
		
=======
		map.put(LoginInit.class, new LoginRuleSet());
>>>>>>> 202a2f3fab5eaaf2d52d7f6e0b97fb9d8c513990
	}
	
	public static RuleSet getRuleSet(Object c) {
		Class<? extends Object> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException("No RuleSet found for this function");
		}
		return map.get(cl);
	}
}
