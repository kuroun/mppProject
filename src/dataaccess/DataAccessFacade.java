package dataaccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import business.Book;
import business.LibraryMember;

public class DataAccessFacade implements DataAccess {

	enum StorageType {
		BOOKS, MEMBERS, USERS;
	}

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "//src//dataaccess//storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	public static HashMap<String, Book> booksMap;
	public static HashMap<String, LibraryMember> membersMap;
	public static HashMap<String, User> usersMap;

	static {
		DataAccess da = new DataAccessFacade();
		booksMap = da.readBooksMap();
		if (booksMap == null) {
			booksMap = new HashMap<String, Book>();
		}

		membersMap = da.readMemberMap();
		if (membersMap == null) {
			membersMap = new HashMap<String, LibraryMember>();
		}
		
		usersMap = da.readUserMap();
		if(usersMap==null) {
			usersMap = new HashMap<String, User>();
		}
	}

	// //specialized lookup methods
	// public LibraryMember searchMember(String memberId) {
	// implement
	// }

	public Book searchBook(String isbn) {
		// HashMap<String, Book> booksMap = readBooksMap();
		//booksMap = readBooksMap();
//		Book b = booksMap.get(isbn);
//		return b;
		// HashMap<String, Book> booksMap = readBooksMap();
				booksMap = readBooksMap();
				Book b = booksMap.get(isbn);
				return b;
	}

	public Auth login(String id, String pwd) {
		//HashMap<String, User> userMap = readUserMap();
		if (!usersMap.containsKey(id))
			return null;
		User user = usersMap.get(id);
		if (!pwd.equals(user.getPassword())) {
			return null;
		}
		return user.getAuthorization();
	}

	// /////save methods
	// saveNewMember

	// public void updateMember(LibraryMember member)
	// save new lendable item
	public void saveNewBook(Book book) {
		//HashMap<String, Book> bookMap = booksMap;
		String isbn = book.getIsbn();
		booksMap.put(isbn, book);
		saveToStorage(StorageType.BOOKS, booksMap);
	}

	// ////read methods that return full maps

	@SuppressWarnings("unchecked")
	public HashMap<String, Book> readBooksMap() {
		return (HashMap<String, Book>) readFromStorage(StorageType.BOOKS);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		return (HashMap<String, User>) readFromStorage(StorageType.USERS);
	}

	// ///load methods - these place test data into the storage area
	// /// - used just once at startup
	// static void loadMemberMap(List<LibraryMember> memberList) {

	public static void loadBookMap(List<Book> bookList) {
		HashMap<String, Book> books = new HashMap<String, Book>();
		bookList.forEach(book -> books.put(book.getIsbn(), book));
		saveToStorage(StorageType.BOOKS, books);
	}

	static void loadUserMap(List<User> userList) {
		HashMap<String, User> users = new HashMap<String, User>();
		userList.forEach(user -> users.put(user.getId(), user));
		saveToStorage(StorageType.USERS, users);
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return retVal;
	}

	final static class Pair<S, T> implements Serializable {

		S first;
		T second;

		Pair(S s, T t) {
			first = s;
			second = t;
		}

		@Override
		public boolean equals(Object ob) {
			if (ob == null)
				return false;
			if (this == ob)
				return true;
			if (ob.getClass() != getClass())
				return false;
			@SuppressWarnings("unchecked")
			Pair<S, T> p = (Pair<S, T>) ob;
			return p.first.equals(first) && p.second.equals(second);
		}

		@Override
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}

		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}

		private static final long serialVersionUID = 5399827794066637059L;
	}

	@Override
	public void saveNewMember(LibraryMember member) {
		//HashMap<String, LibraryMember> members = membersMap;
		membersMap.put(member.getMemberID(), member);
		saveToStorage(StorageType.MEMBERS, membersMap);
	}

	@Override
	public void saveNewCheckoutRecordEntry(LibraryMember member, Book book) {
		saveToStorage(StorageType.MEMBERS, membersMap);
		saveToStorage(StorageType.BOOKS, booksMap);
	}

	@Override
	public LibraryMember searchMember(String memberId) {
		//membersMap = readMemberMap();
		LibraryMember lm = membersMap.get(memberId);
		return lm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, LibraryMember> readMemberMap() {
		// System.out.println(readFromStorage(StorageType.MEMBERS).getClass().getSimpleName());
		return (HashMap<String, LibraryMember>) readFromStorage(StorageType.MEMBERS);
	}

	public static HashMap<String, Book> getBooksMap() {
		return booksMap;
	}

	public static HashMap<String, LibraryMember> getMembersMap() {
		return membersMap;
	}

}
