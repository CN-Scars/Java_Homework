package org.scars.PayBook;

import org.scars.PayBook.Book;

class OrderItem {
    private Book book;
    private int Num;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public OrderItem(Book book, int num) {
        this.book = book;
        Num = num;
    }
}
