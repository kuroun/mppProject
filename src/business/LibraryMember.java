package business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {
	
	private String memberID;
	private static final long serialVersionUID = 1008481940058530471L;
	
	public LibraryMember(String f, String l, String t, Address a, String memberId) {
		super(f, l, t, a);
		this.memberID = memberId;
	}
	
	

}
