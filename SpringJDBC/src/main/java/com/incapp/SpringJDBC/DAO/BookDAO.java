package com.incapp.SpringJDBC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.incapp.SpringJDBC.beans.Book;

public class BookDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String addBook(Book b) {
        try {
            String query = "insert into books values(?,?,?,?)";
            jdbcTemplate.update(query, new Object[] { b.getName(), b.getPrice(), b.getAname(), b.getPname() });
            return "success";
        } catch (Exception ex) {
            return "Book Already Exist!";
        }
    }

    public List<Book> getAllBook() {
        class BookMapper implements RowMapper<Book> {
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book b = new Book();
                b.setName(rs.getString("name"));
                b.setPrice(rs.getInt("price"));
                b.setAname(rs.getString("aname"));
                b.setPname(rs.getString("pname"));
                return b;
            }
        }
        final String query = "select * from books";
        return jdbcTemplate.query(query, new BookMapper());
    }

    public List<String> getAllBookNames() {
        class DataMapper implements RowMapper<String> {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("name");
            }
        }
        final String query = "select * from books";
        return jdbcTemplate.query(query, new DataMapper());
    }
}
