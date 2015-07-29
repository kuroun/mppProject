package ruleset;

import ui.AddNewLibraryMemberInit;

public final class AddNewLibraryMemberRuleSet implements RuleSet {

	private String id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;

	// package level access
	AddNewLibraryMemberRuleSet() {
	}

	@Override
	public void applyRule(Object ob) throws RuleException {
		AddNewLibraryMemberInit addMem = (AddNewLibraryMemberInit) ob;

		id = addMem.getTxtMemberID();
		firstName = addMem.getTxtFirstName();
		lastName = addMem.getTxtLastName();
		street = addMem.getTxtStreet();
		city = addMem.getTxtCity();
		state = addMem.getTxtState();
		zip = addMem.getTxtZip();
		phoneNumber = addMem.getTxtPhoneNumber();

		boolean nonempty = !(id.isEmpty() || firstName.isEmpty()
				|| lastName.isEmpty() || street.isEmpty() || city.isEmpty()
				|| state.isEmpty() || zip.isEmpty());
		boolean idNum = id.matches("-?\\d+(\\.\\d+)?");
		boolean zipFormat = zip.matches("-?\\d+(\\.\\d+)?")
				&& zip.length() == 5;
		boolean stateFormat = state.matches("\\p{javaUpperCase}*")
				&& state.length() == 2;
		boolean firstNameFormat = firstName.matches("[a-zA-Z]+");
		boolean lastNameFormat = lastName.matches("[a-zA-Z]+");
		boolean phoneNumberFormat = phoneNumber.matches("-?\\d+(\\.\\d+)?") && phoneNumber.length() == 10;

		if (nonempty == false) {
			throw new RuleException(ExceptionDefinition.ALL_FIELD_NONEMPTY);
		}

		if (idNum == false) {
			throw new RuleException(ExceptionDefinition.MEMBER_ID);
		}

		if (firstNameFormat == false) {
			throw new RuleException(ExceptionDefinition.FIRSTNAME);
		}

		if (lastNameFormat == false) {
			throw new RuleException(ExceptionDefinition.LASTNAME);
		}
		
		if (stateFormat == false) {
			throw new RuleException(ExceptionDefinition.STATE);
		}
		
		if (zipFormat == false) {
			throw new RuleException(ExceptionDefinition.ZIP);
		}
		
		if (phoneNumberFormat == false) {
			throw new RuleException(ExceptionDefinition.PHONENUMBER);
		}

		

	}

}
