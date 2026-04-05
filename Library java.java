import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public class BookShelf implements Iterable<Book> {

        private int minYear;

        public BookShelf(int minYear) {
            this.minYear = minYear;
        }

        @Override
        public Iterator<Book> iterator() {
            return new Iterator<Book>() {

                private int index = 0;

                @Override
                public boolean hasNext() {
                    while (index < books.size()) {
                        if (books.get(index).getYear() >= minYear) {
                            return true;
                        }
                        index++;
                    }
                    return false;
                }

                @Override
                public Book next() {
                    return books.get(index++);
                }
            };
        }
    }
}