package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import ui.CheckOutBookFormInit;
import ui.MainFrameInit;
import ui.WindowController;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;
//import dnl.utils.text.table.TextTable;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;

	public void login(String id, String password) throws LoginException {
		HashMap<String, User> map = DataAccessFacade.usersMap;
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

		
		HashMap<String, LibraryMember> map = DataAccessFacade.membersMap;
		if (map.containsKey(memberId))
			throw new LibrarySystemException(
					LibrarySystemExceptionDefinition.DUPLICATE_MEMEBER_ID);
		else {
			LibraryMember mem = new LibraryMember(firstName, lastName,
					telNumber, addr, memberId);
			DataAccess da = new DataAccessFacade();
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
		
		//book.addCopy();
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> map = da.readBooksMap();
		map.get(isbn).addCopy();
		List<Book> allBooks = new ArrayList<Book>();
		for (Book value : map.values()) {
			allBooks.add(value);
		}		
		DataAccessFacade.loadBookMap(allBooks);
	
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
					Alert alert = messageDialog("INFORMATION");
					alert.setContentText("Checkout Book Entry was add successfully");
					alert.showAndWait();
					setLblStudentName(m);
					queryCheckoutRecordToTable(m);
					
				}
			}
			
		}catch(LibrarySystemException e){
			Alert alert = messageDialog("WARNING");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
	}
	
	public void setLblStudentName(LibraryMember member){
		MainFrameInit.checkoutController.getLblStudentName().setText(member.getFirstName() + " " + member.getLastName());
	}
	
	public void queryCheckoutRecordToTable(LibraryMember member){
		//A list that allows listeners to track changes when they occur
		ObservableList<CheckOutRecordTable> bookRecordData = FXCollections
				.observableArrayList();

		List<CheckOutRecordTable> checkOutRecordTable = new ArrayList<CheckOutRecordTable>();
		List<CheckoutRecordEntry> record = member.getCheckoutRecord().getCheckoutRecordEntry();
		for(CheckoutRecordEntry x: record){
			checkOutRecordTable.add(new CheckOutRecordTable(
					x.getBookCopy().getBook().getTitle(),
					x.getBookCopy().getCopyNum(),
					x.getCheckoutDate(),
					x.getDueDate()
					));
		}
		//System.out.println(checkOutRecordTable);
		bookRecordData.addAll(checkOutRecordTable);
		MainFrameInit.checkoutController.getTblCheckOutRecord().setItems(bookRecordData);
		
		MainFrameInit.checkoutController.getThBook().setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, String>("bookTitle"));
		MainFrameInit.checkoutController.getThCopyNumber().setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, Integer>("copyNumber"));
		MainFrameInit.checkoutController.getThCheckOutDate().setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, LocalDate>("checkOutDate"));
		MainFrameInit.checkoutController.getThDueDate().setCellValueFactory(new PropertyValueFactory<CheckOutRecordTable, LocalDate>("dueDate"));
		
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

	@Override
	public void printBookRecord(String memberId) {
		try{
			DataAccess da = new DataAccessFacade();
			LibraryMember m = da.searchMember(memberId);
			if(m == null) throw new LibrarySystemException(LibrarySystemExceptionDefinition.MEMBER_NOT_FOUND);
			else{
				Alert alert = messageDialog("INFORMATION");
				alert.setContentText("Member Id is found and Checkout Record is printing to console");
				alert.showAndWait();
				printToConsole(m);
				
			}
		}catch(LibrarySystemException e){
			Alert alert = messageDialog("WARNING");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
	}
	
	public void printToConsole(LibraryMember member){
		List<CheckoutRecordEntry> record = member.getCheckoutRecord().getCheckoutRecordEntry();
		System.out.print("\n\nMember Name: " + member.getFirstName() + " " + member.getLastName());
		System.out.println(", Member ID: " + member.getMemberID());
		String leftAlignFormat = "| %-32s | %-10d | %-13s | %-13s |%n";

		System.out.format("+----------------------------------+------------+---------------+---------------+%n");
		System.out.printf("| Book Title                       |Copy Number | Checkout Date | Due Date      |%n");
		System.out.format("+----------------------------------+------------+---------------+---------------+%n");
		for(CheckoutRecordEntry x: record){
			System.out.format(leftAlignFormat, x.getBookCopy().getBook().getTitle(), x.getBookCopy().getCopyNum(), x.getCheckoutDate().toString(), x.getDueDate().toString());
		}
		System.out.format("+----------------------------------+------------+---------------+---------------+%n");                                              

	}


}

