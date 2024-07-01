package com.incapp.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.incapp.beans.Book;

import jakarta.servlet.http.Part;

@Repository
public class BookRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String addBook(Book b, Part image ) {
		try {
			if(image.getSize()==0) {
				String query="insert into books (book,price,aname,pname) values(?,?,?,?)";
				jdbcTemplate.update(query,new Object[] {b.getName(),b.getPrice(),b.getAname(),b.getPname()});
			}else {
				String query="insert into books values(?,?,?,?,?)";
				jdbcTemplate.update(query,new Object[] {b.getName(),b.getPrice(),b.getAname(),b.getPname(),image.getInputStream()});
			}
			return "success";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Book Already Exist!";
		}
	}
	public String doUpdateBook(Book b,String oldName, Part image) {
		try {
			if(image.getSize()==0) {
				String query="update books set book=? , price=? , aname=? , pname=?  where book=?";
				jdbcTemplate.update(query,new Object[] {b.getName(),b.getPrice(),b.getAname(),b.getPname(),oldName});
			}else {
				String query="update books set book=? , price=? , aname=? , pname=?, image=?  where book=?";
				jdbcTemplate.update(query,new Object[] {b.getName(),b.getPrice(),b.getAname(),b.getPname(),image.getInputStream(),oldName});
			}
			
			return "success";
		}catch(Exception ex) {
			return "Book Already Exist!";
		}
	}
	//get all books 
	public List<Book>  getBooks() {
		class BookMapper implements RowMapper{
			public Book mapRow(ResultSet rs,int rowNum)throws SQLException{
				Book b=new Book();
				b.setName(rs.getString("book"));
				b.setPrice(rs.getInt("price"));
				b.setAname(rs.getString("aname"));
				b.setPname(rs.getString("pname"));
				return b;
			}
		}
		try {
			final String query ="select * from books";
			List<Book>  b=jdbcTemplate.query(query,new BookMapper());
			return b;
		}catch(EmptyResultDataAccessException ex) {
			return null;
		}
    }
	//get all books like name 
	public List<Book>  getBooks(String name) {
		class BookMapper implements RowMapper{
			public Book mapRow(ResultSet rs,int rowNum)throws SQLException{
				Book b=new Book();
				b.setName(rs.getString("book"));
				b.setPrice(rs.getInt("price"));
				b.setAname(rs.getString("aname"));
				b.setPname(rs.getString("pname"));
				return b;
			}
		}
		try {
			final String query ="select * from books where book like '%"+name+"%'";
			List<Book>  b=jdbcTemplate.query(query,new BookMapper());
			return b;
		}catch(EmptyResultDataAccessException ex) {
			return null;
		}
    }

		public Book  getBook(String name) {
			class BookMapper implements RowMapper{
				public Book mapRow(ResultSet rs,int rowNum)throws SQLException{
					Book b=new Book();
					b.setName(rs.getString("book"));
					b.setPrice(rs.getInt("price"));
					b.setAname(rs.getString("aname"));
					b.setPname(rs.getString("pname"));
					return b;
				}
			}
			try {
				final String query ="select * from books where book = '"+name+"'";
				Book  b=(Book)jdbcTemplate.queryForObject(query,new BookMapper());
				return b;
			}catch(EmptyResultDataAccessException ex) {
				return null;
			}
	    }
		
		public byte[] getBookImage(String name) {
			class BookMapper implements RowMapper{
				public byte[] mapRow(ResultSet rs,int rowNum)throws SQLException{
					return rs.getBytes("image");
				}
			}
			try {
				final String query ="select image from books where book = '"+name+"'";
				byte[] image=(byte[])jdbcTemplate.queryForObject(query,new BookMapper());
				return image;
			}catch(EmptyResultDataAccessException ex) {
				return null;
			}
	    }
		
		
	//delete book by name
	public boolean deleteBook(String name){
		String query ="delete from books where book = '"+name+"'";
		int x=jdbcTemplate.update( query);
		if(x!=0)
			return true;
		else
			return false;
	}
}
