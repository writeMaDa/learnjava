import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void displayDetails() {
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        System.out.println("ISBN: " + isbn);
    }
}

class EBook extends Book {
    private double fileSize;
    private String downloadLink;

    public EBook(String title, String author, String isbn, double fileSize, String downloadLink) {
        super(title, author, isbn);
        this.fileSize = fileSize;
        this.downloadLink = downloadLink;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("파일 크기: " + fileSize + "MB");
        System.out.println("다운로드 링크: " + downloadLink);
    }
}

class PrintedBook extends Book {
    private int pageCount;
    private String publisher;

    public PrintedBook(String title, String author, String isbn, int pageCount, String publisher) {
        super(title, author, isbn);
        this.pageCount = pageCount;
        this.publisher = publisher;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("페이지 수: " + pageCount);
        System.out.println("출판사: " + publisher);
    }
}

interface BookManager {
    void addBook(Book book);
    void removeBook(String isbn);
    void displayAllBooks();
}

class Library implements BookManager {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " 책이 도서관에 추가되었습니다.");
    }

    @Override
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("ISBN이 " + isbn + "인 책이 삭제되었습니다.");
    }

    @Override
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("현재 도서관에 저장된 책이 없습니다.");
            return;
        }

        System.out.println("도서관의 모든 책 정보를 출력합니다:");
        for (Book book : books) {
            book.displayDetails();
            System.out.println("-----");
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("바나나킥", "원숭이", "1234567890");
        EBook ebook1 = new EBook("컴퓨터", "워싱턴", "0987654321", 1.5, "https://www.naver.com");
        PrintedBook printedBook1 = new PrintedBook("해리 포터", "롤링", "1234324425", 500, "회사");

        library.addBook(book1);
        library.addBook(ebook1);
        library.addBook(printedBook1);

        library.displayAllBooks();

        library.removeBook("1234567890");

        library.displayAllBooks();
    }
}
