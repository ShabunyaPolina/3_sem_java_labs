package customclass;

public class Book implements Comparable<Book> {
    private String name;
    private String author;
    private int pagesNumber;

    public Book() {}

    public Book(String name, String author, int pagesNumber) {
        this.name = name;
        this.author = author;
        this.pagesNumber = pagesNumber;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    int getPagesNumber() {
        return pagesNumber;
    }

    void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String toString() {
        return "[" +
                "name: " + name +
                ", author: " + author +
                ", number of pages: " + pagesNumber +
                "]";
    }

    @Override
    public int compareTo(Book book) {
        return Integer.compare(pagesNumber, book.pagesNumber);
    }
}
