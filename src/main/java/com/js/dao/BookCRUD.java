package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Book;

//data accessing object    ?=placeholder/delimiters

public class BookCRUD {
 
	 final static String path="com.mysql.cj.jdbc.Driver";
	 final static String address="jdbc:mysql://localhost:3306/book_store?user=root&password=9008336783";
	 
	 
	public int insertBook(Book b) {
		Connection c=null;
	try {
		Class.forName(path);
		 c=DriverManager.getConnection(address);
		PreparedStatement ps=c.prepareStatement("insert into book values(?,?,?,?,?)");
		ps.setInt(1,b.getBid()); //  ps.set is used to set the values for placeholder.
		ps.setString(2,b.getBname());
		ps.setString(3, b.getBauthor());
		ps.setInt(4,b.getBpage());
		ps.setDouble(5,b.getBprice());
		return ps.executeUpdate();
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return 0;
	
	

}
	
	
	
	public int deleteBookById(int Bid) {
		Connection c=null;
		try {
			Class.forName(path);
			 c=DriverManager.getConnection(address);
			 PreparedStatement ps=c.prepareStatement("delete from book where Bid=? ");
			 ps.setInt(1,Bid); //  ps.set is used to set the values for placeholder.
				
				return ps.executeUpdate();
		
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		
		
	}

	public int updateBookById(int id, Book b) {
		Connection c=null;
		try {
			Class.forName(path);
			 c=DriverManager.getConnection(address);
			 PreparedStatement ps=c.prepareStatement("update book set Bname=?,Bauthor=?,Bpage=?,Bprice=? where Bid=? ");
			 //  ps.set is used to set the values for placeholder.
			ps.setString(1, b.getBname());
			ps.setString(2, b.getBauthor());
			ps.setInt(3, b.getBpage());
			ps.setDouble(4,b.getBprice());
			 ps.setInt(5,id);
				return ps.executeUpdate();
		
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
}
	public Book getBookById(int id) {
		Book b=null;
		Connection c=null;
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement(" select * from book where Bid=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				b=new Book();
				b.setBid(rs.getInt(1));
				b.setBname(rs.getString(2)); //process the result
				b.setBauthor(rs.getString(3));
				b.setBpage(rs.getInt(4));
				b.setBprice(rs.getDouble(5));
				return b;
			}else {
				return b;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
	
	}
	
	 public ArrayList<Book> GetAllBooks(){
		 Connection c=null;
		 ArrayList <Book> al=new ArrayList<Book>();
		 try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement(" select * from book");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Book b=new Book();
				b.setBid(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setBauthor(rs.getString(3));
				b.setBpage(rs.getInt(4));
				b.setBprice(rs.getDouble(5));
				al.add(b);
			}
			return al;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
			 try {
				c.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		 }
		return al;//null
	 }
	 
	 public boolean batchExecution(ArrayList<Book> books) {
		 Connection c=null;
		 try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("insert into book values(?,?,?,?,?)");
			for(Book b:books) {
				ps.setInt(1,b.getBid()); //  ps.set is used to set the values for placeholder.
				ps.setString(2,b.getBname());
				ps.setString(3, b.getBauthor());
				ps.setInt(4,b.getBpage());
				ps.setDouble(5,b.getBprice());
				ps.addBatch();
			}
			ps.executeBatch();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
			 try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		return false;
		 
		 
	 }
	
	
}