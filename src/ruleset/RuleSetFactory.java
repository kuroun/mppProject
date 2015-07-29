package ruleset;

import java.util.HashMap;

import ui.AddNewLibraryMemberInit;

public final class RuleSetFactory {
	
	private RuleSetFactory() {
		
	}
	
	static HashMap<Class<? extends Object>, RuleSet> map = new HashMap<>();
	static {
		map.put(AddNewLibraryMemberInit.class, new AddNewLibraryMemberRuleSet());
		
	}
	
	public static RuleSet getRuleSet(Object c) {
		Class<? extends Object> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException("No RuleSet found for this function");
		}
		return map.get(cl);
	}
}
