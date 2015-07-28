package ruleset;

import ui.LoginInit;

public class LoginRuleSet implements RuleSet {

	@Override
	public void applyRule(Object ob) throws RuleException {
		LoginInit login = (LoginInit) ob;
		String username = login.getTxtUsername();
		String password = login.getTxtPassword();
		
		if(username.isEmpty() || password.isEmpty())
			throw new RuleException(ExceptionDefinition.ALL_FIELD_NONEMPTY);
	}

}
