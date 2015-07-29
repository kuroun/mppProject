package business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {
	
	private String memberID;
	private static final long serialVersionUID = 6110690276685962829L;
	
	public LibraryMember(String f, String l, String t, Address a, String memberId) {
		super(f, l, t, a);
		this.memberID = memberId;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	

}
