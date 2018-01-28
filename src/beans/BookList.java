package beans;

import db.DataBase;
import enums.SearchType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookList {


    private ArrayList<Book> bookList = new ArrayList<Book>();

    private ArrayList<Book> getBooks(String str) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DataBase.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id_b"));
                book.setBook(rs.getString("name_b"));
                book.setContent(rs.getString("content"));
                book.setGenre(rs.getString("name_g"));
                book.setAuthor(rs.getString("name_a"));
                book.setYear(rs.getInt("year"));
                book.setPublisher(rs.getString("name_p"));
                book.setImage(rs.getString("image"));
                bookList.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }

        return bookList;
    }

    public ArrayList<Book> getBookList() {
        if (!bookList.isEmpty()) {
            return bookList;
        } else {
            return getBooks("select * from book inner join author on author.id_a=book.id_a " +
                    "inner join genre on book.id_g=genre.id_g inner join publisher on book.id_p=publisher.id_p");
        }
    }

    public ArrayList<Book> getBooksByGenre(int id) {
        return getBooks("SELECT * from book inner join author on author.id_a=book.id_a "
                + "inner join genre on book.id_g=genre.id_g inner join publisher on book.id_p=publisher.id_p "
                + "where genre.id_g=" + id + " order by name_b "
                + "limit 5");

    }

    public ArrayList<Book> getBooksByLetter(String letter) {
        return getBooks("SELECT * from book inner join author on author.id_a=book.id_a inner join genre on book.id_g=genre.id_g " +
                        "inner join publisher on book.id_p=publisher.id_p "+
                "where lower(name_b) like '"+letter.toLowerCase()+"%' order by name_b limit 5");

    }

    public ArrayList<Book> getBooksBySearch(String searchStr, SearchType type) {
        StringBuilder sql = new StringBuilder("SELECT * from book inner join author on author.id_a=book.id_a inner join genre on book.id_g=genre.id_g " +
                "inner join publisher on book.id_p=publisher.id_p ");

        if (type == SearchType.AUTHOR) {
            sql.append("where lower(name_a) like '%" + searchStr.toLowerCase() + "%' order by name_b ");

        } else if (type == SearchType.TITLE) {
            sql.append("where lower(name_b) like '%" + searchStr.toLowerCase() + "%' order by name_b ");
        }
        sql.append("limit 5");


        return getBooks(sql.toString());


    }
}
