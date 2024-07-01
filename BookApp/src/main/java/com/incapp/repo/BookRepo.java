package com.incapp.repo;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.incapp.bean.Book;

import jakarta.servlet.http.Part;

@Repository
public class BookRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String addBook(Book b, Part image) {
        try {
            String query;
            Object[] params;
            if (image.getSize() == 0) {
                query = "INSERT INTO books (book, price, aname, pname) VALUES (?, ?, ?, ?)";
                params = new Object[]{b.getName(), b.getPrice(), b.getAname(), b.getPname()};
            } else {
                query = "INSERT INTO books (book, price, aname, pname, image) VALUES (?, ?, ?, ?, ?)";
                InputStream imageStream = image.getInputStream();
                params = new Object[]{b.getName(), b.getPrice(), b.getAname(), b.getPname(), imageStream};
            }
            jdbcTemplate.update(query, params);
            return "Success, Book Successfully got Registered";
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    public String doUpdateBook(Book b, String oldName, Part image) {
        try {
            String query;
            Object[] params;
            if (image.getSize() == 0) {
                query = "UPDATE books SET book = ?, price = ?, aname = ?, pname = ? WHERE book = ?";
                params = new Object[]{b.getName(), b.getPrice(), b.getAname(), b.getPname(), oldName};
            } else {
                query = "UPDATE books SET book = ?, price = ?, aname = ?, pname = ?, image = ? WHERE book = ?";
                InputStream imageStream = image.getInputStream();
                params = new Object[]{b.getName(), b.getPrice(), b.getAname(), b.getPname(), imageStream, oldName};
            }
            int rowsAffected = jdbcTemplate.update(query, params);
            return rowsAffected > 0 ? "Success, Book updated successfully" : "Book with the name " + oldName + " does not exist";
        } catch (Exception e) {
            return "An error occurred while updating the book: " + e.getMessage();
        }
    }

    public List<Book> getBooks() {
        String query = "SELECT * FROM books";
        try {
            return jdbcTemplate.query(query, new BookMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Book> getBooks(String name) {
        String query = "SELECT * FROM books WHERE book LIKE ?";
        try {
            return jdbcTemplate.query(query, new BookMapper(), "%" + name + "%");
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Book getBook(String name) {
        String query = "SELECT * FROM books WHERE book = ?";
        try {
            return jdbcTemplate.queryForObject(query, new BookMapper(), name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public byte[] getBookImage(String name) {
        String query = "SELECT image FROM books WHERE book = ?";
        try {
            return jdbcTemplate.queryForObject(query, new RowMapper<byte[]>() {
                @Override
                public byte[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getBytes("image");
                }
            }, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public boolean deleteBook(String bookName) {
        String query = "DELETE FROM books WHERE book = ?";
        int rowsAffected = jdbcTemplate.update(query, bookName);
        return rowsAffected > 0;
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setName(rs.getString("book"));
            book.setPrice(rs.getInt("price"));
            book.setAname(rs.getString("aname"));
            book.setPname(rs.getString("pname"));
            return book;
        }
    }
}
