package buoi8.btvn;

import java.util.Arrays;

public class Library implements ILibrary {
    private Book[] books;
    public int size;

    public Library() {
        books = new Book[10];
        size = 0;
    }

    @Override
    public void addBook(Book book) {
        if (size == books.length) {
            books = Arrays.copyOf(books, size * 2);
        }
        books[size] = book;
        size++;
        System.out.println("Đã thêm sách thành công!");
    }

    @Override
    public void updateBook(int id, Book bookUpdate) {
        for(int i = 0; i < size; i++) {
            if(books[i].getId() == id){
                books[i] = bookUpdate;
                System.out.println("Đã cập nhật sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã: " + id);
    }

    @Override
    public void deleteBook(int id) {
        for (int i = 0; i < size; i++) {
            if(books[id].getId() == id){
                for (int j = i; j < size; j++) {
                    books[j] = books[j + 1];
                }
                books[size - 1] = null;
                size--;
                System.out.println("Đã xóa sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã: " + id);
    }

    @Override
    public void searchByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                books[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách của tác giả: " + author);
        }
    }

    @Override
    public void displayAllBooks() {
        if (size == 0) {
            System.out.println("Thư viện trống!");
            return;
        }
        for (int i = 0; i < size; i++) {
            books[i].displayInfo();
        }
    }
}
