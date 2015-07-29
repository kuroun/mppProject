package dataaccess;

import java.util.HashMap;

import business.Book;
import business.CheckoutRecordEntry;
import business.LibraryMember;

public interface DataAccess {
	// public LibraryMember searchMember(String memberId);
	public Book searchBook(String isbn);

	// /////save methods
	public void saveNewMember(LibraryMember member);
	public LibraryMember searchMember(String memberId);

	// public void updateMember(LibraryMember member);

	// save new book
	public void saveNewBook(Book book);
	
	//Save new checkout record entry
	public void saveNewCheckoutRecordEntry(LibraryMember member, Book book);

	// ////read methods
	public HashMap<String, Book> readBooksMap();

	public HashMap<String, User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
}
