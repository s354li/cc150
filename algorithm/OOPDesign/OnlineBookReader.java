// 5. Design the data structures for an online book reader system
// user membership creation; searching the database of the books; reading the books
public class Book {
	public UUID bookName;
	public String realName;
	public BufferedReader bookReader;
	public File bookFile;
	public String bookPath;
	public Book(String name, String path) {
		bookName = UUID.randomUUID();
		realName = name;
		bookPath = path;
	}
	public void rename(String newName) {
		this.realName = newName;
	}
	public void openBook() {
		try {
    		bookFile = new File(path);
    		bookReader = new BufferedReader(new FileReader(bookFile));
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public void closeBook() {
		try {
       		reader.close();
   		}
    	catch (IOException e) {
        	e.printStackTrace();
    	}
	}

}
public class User {
	public UUID ID;
	public String name;
	public int level;
	public Date membershipDate;
	public BookShelf shelf;
	public OnlineBookSystem bookSystem;
	public User(String name) {
		this.ID = UUID.randomUUID();
		this.name = name;
		this.level = 0;
		this.shelf = new BookShelf("Default shelf");
		membershipDate = new Date();
		bookSystem = new OnlineBookSystem();
	}
	public void increaseMembership(int level) {
		this.level = level;
	}
	public void renewMembership() {
		this.membershipDate = new Date();
	}
	public boolean expired() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.membershipDate);
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		Date nextYear = cal.getTime();
		return (new Date()).getTime() - nextYear.getTime() < 0
	}
	public void addToBookShelf(Book itembook) {
		shelf.addBook(itembook);
	}
	public void removeFromBookShelf(UUID bookName) {
		shelf.removeBook(bookName);
	}
}
public class BookShelf {
	public Hashtable<UUID, Book> books;
	public User owner;
	public String name;
	public BookShelf(String name) {
		this.name = name;
		books = new Hashtable<String, Book>();
	}
	public void addBook(Book addedBook) {
		books.put(addedBook.bookName, addedBook);
	}
	public void removeBook(UUID bookName) {
		books.remove(bookName);
	}
	public void renameBook(UUID oldName, String newName) {
		Book current = books.get(oldName);
		current.rename(newName);
		books.put(oldName, current);
	}
	public void renameShelf(String newName) {
		this.name = newName;
	}
	private boolean existBook(String bookName) {
		return books.containsKey(bookName);
	}
	public Book searchBook(String bookName) {
		return existBook(bookName) ? books.get(bookName) : null;
	}
}
public class OnlineBookSystem {
	public HashSet<User> users;
	public HashSet<Book> books;
	public OnlineBookSystem() {
		users = new HashSet<User>();
		books = new HashSet<Book>();
		// initialize all the users and books into the system from DB
	}
	public Book findBook(UUID bookName) {
		for(Book item : books) {
			if (item.bookName == bookName) {
				return item;
			}
		}
		return null;
	}
	public void addBook(Book newBook) {
		books.add(newBook);
	}
	public User addUser(String name) {
		User newUser = new User(name);
		users.add(newUser);
	}
}