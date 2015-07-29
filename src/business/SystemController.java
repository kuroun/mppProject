package business;

import java.time.LocalDate;
import java.util.HashMap;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ui.WindowController;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;

	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if (!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if (!passwordFound.equals(password)) {
			throw new LoginException(
					"Passord does not match password on record");
		}
		currentAuth = map.get(id).getAuthorization();

	}

	/**
	 * This method checks if memberId already exists -- if so, it cannot be
	 * added as a new member, and an exception is thrown. If new, creates a new
	 * LibraryMember based on input data and uses DataAccess to store it.
	 * 
	 */
	public void addNewMember(String memberId, String firstName,
			String lastName, String telNumber, Address addr)
			throws LibrarySystemException {

		DataAccessFacade da = new DataAccessFacade();
		HashMap<String, LibraryMember> map = da.getMembersMap();
		if (map.containsKey(memberId))
			throw new LibrarySystemException(
					LibrarySystemExceptionDefinition.DUPLICATE_MEMEBER_ID);
		else {
			LibraryMember mem = new LibraryMember(firstName, lastName,
					telNumber, addr, memberId);

			da.saveNewMember(mem);
		}

	}

	/**
	 * Reads data store for a library member with specified id. Ids begin at
	 * 1001... Returns a LibraryMember if found, null otherwise
	 * 
	 */
	// public LibraryMember search(String memberId) {

	/**
	 * Same as creating a new member (because of how data is stored)
	 */
	// public void updateMemberInfo(String memberId, String firstName, String
	// lastName,

	/**
	 * Looks up Book by isbn from data store. If not found, an exception is
	 * thrown. If no copies are available for checkout, an exception is thrown.
	 * If found and a copy is available, member's checkout record is updated and
	 * copy of this publication is set to "not available"
	 */
	// public void checkoutBook(String memberId, String isbn) throws
	// LibrarySystemException {

	@Override
	public Book searchBook(String isbn) {
		DataAccess da = new DataAccessFacade();
		return da.searchBook(isbn);
	}

	/**
	 * Looks up book by isbn to see if it exists, throw exceptioni. Else add the
	 * book to storage
	 */
	// public boolean addBook(String isbn, String title, int maxCheckoutLength,
	// List<Author> authors)
	// throws LibrarySystemException {

	public boolean addBookCopy(String isbn) throws LibrarySystemException {
		Book book = searchBook(isbn);
		if (book == null)
			throw new LibrarySystemException("No book with isbn " + isbn
					+ " is in the library collection!");
		book.addCopy();
		return true;
	}

	public static void main(String[] args) throws LibrarySystemException {

	}

	@Override
	public void checkoutBook(String memberId, String isbn) throws LibrarySystemException {
		try{
			DataAccess da = new DataAccessFacade();
			LibraryMember m = da.searchMember(memberId);
			Book b = da.searchBook(isbn);
			if(m == null) throw new LibrarySystemException(LibrarySystemExceptionDefinition.MEMBER_NOT_FOUND);
			else{
				
			}
			if(b == null) throw new LibrarySystemException(LibrarySystemExceptionDefinition.BOOK_NOT_FOUND);
			else{
				
				if(!b.isAvailable()){
					throw new LibrarySystemException(LibrarySystemExceptionDefinition.BOOK_NOT_AVAILABLE);
				}
				else{
					BookCopy cb = b.getNextAvailableCopy();
					int getMaxCheckoutLenght = b.getMaxCheckoutLength();
					da.searchMember(memberId).checkout(cb, LocalDate.now(), LocalDate.now().plusDays(getMaxCheckoutLenght));
					da.saveNewCheckoutRecordEntry(m,b);
					//System.out.println(m.getCheckoutRecord().getCheckoutRecordEntry());
					
				}
			}
			
		}catch(LibrarySystemException e){
			Alert alert = messageDialog("WARNING");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
	}
	
	public Alert messageDialog(String type) {
		Alert alert;
		if (type.equalsIgnoreCase("warning"))
			alert = new Alert(AlertType.WARNING);
		else
			alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Library System");
		alert.setHeaderText(null);
		return alert;
	}


}

