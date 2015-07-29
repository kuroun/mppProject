package ruleset;

public interface RuleSet {
	
	public abstract void applyRule(Object ob) throws RuleException;
	
}