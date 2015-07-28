package ruleset;

public class ExceptionDefinition {
	
	public static final String ALL_FIELD_NONEMPTY = "All fields must be nonempty";
	public static final String ZIP = "Zip must be numeric with exactly 5 digits";
	public static final String STATE = "State must have exactly two characters in the range A-Z";
	public static final String FIRSTNAME  = "Firstname fields may not contain spaces or characters other than a-z, A-Z";
	public static final String LASTNAME  = "Firstname fields may not contain spaces or characters other than a-z, A-";
	public static final String MEMBER_ID = "Member ID field must be numeric";
	public static final String PHONENUMBER = "Phonenumber field must be numeric with exactly 10 digits";
}
