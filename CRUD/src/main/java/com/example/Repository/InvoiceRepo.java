package com.example.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.Model.InvoiceModel;



@Repository
public class InvoiceRepo {
	
	
	@Autowired
	DataSource dataSource;

//	
//	String url = "jdbc:mysql://localhost:3306/Task1";
//	String userName = "root";
//	String passWord = "Arunraj@45";
	
	private static final Log log = LogFactory.getLog(InvoiceRepo.class);
	
	
	
	public List<InvoiceModel> getAll(){//select All
		
		
		List<InvoiceModel> ll= new ArrayList<>();
//		
//		String url = "jdbc:mysql://localhost:3306/Task1";
//		String userName = "root";
//		String passWord = "Arunraj@45";
		String query = "select * from invoice";
		
		try {
			Connection con=dataSource.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
                             ResultSet     rs= ps.executeQuery();
                             
                             while(rs.next()) {
                            	 ll.add(getValue(rs));
//                            	 System.out.println("Id is " + rs.getInt(1));
//                     			System.out.println("Name is " + rs.getDouble(2));
//                     			System.out.println("Salary is " + rs.getInt(3));
//                     			System.out.println("Salary is " + rs.getInt(4));
//                     			System.out.println("Salary is " + rs.getDate(5));
//                     			System.out.println("Salary is " + rs.getDate(6));
                     			
                             }
			con.close();
		} catch (SQLException e) {
			log.error("Invalid Request",e);
			e.printStackTrace();
		}
		
		return ll;
		
		
	}
	
	public InvoiceModel getValue(ResultSet rs) throws SQLException {     //get value
		InvoiceModel  im = new InvoiceModel();
		
		im.setInvoice_no(rs.getInt("invoice_no"));
		im.setProduct_id(rs.getInt("product"));
		im.setAmount(rs.getDouble("amount"));
		im.setUser_id(rs.getInt("user_id"));
		im.setSeller_id(rs.getInt("seller"));
		im.setOrder_date(rs.getDate("order_date"));
		im.setDue_date(rs.getDate("due_date"));
		

		return im;

	}
	
	public InvoiceModel getById(int invoice_no) {         //get valueby Id
		String query = "select*from invoice where invoice_no =?";
//		String url = "jdbc:mysql://localhost:3306/Task1";
//		String userName = "root";
//		String passWord = "Arunraj@45";
		
		try {Connection con=dataSource.getConnection();
				PreparedStatement ps=con.prepareStatement(query); 

			ps.setInt(1, invoice_no);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return getValue(rs);
			} else {
				 
				throw new SQLException();
			}
           
		}

		catch (Exception e) {
			
			log.error("Invalid Id " + invoice_no,e);
			
			throw new RuntimeException();
		}
		
	}
	public void insertValue(InvoiceModel im) {  //insert
		
		
		String query1 = "insert into invoice (Invoice_no,Product_Id,Amount,User_Id,Seller_Id,Order_date,due_date) values (?,?,?,?,?,?,?)";
		
		

		try {
			Connection con =dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement(query1);
			pst.setInt(1, im.getInvoice_no());
			pst.setInt(2, im.getProduct_id());
			pst.setDouble(3,im.getAmount() );
			pst.setInt(4, im.getUser_id());
			pst.setInt(5,im.getSeller_id());
			pst.setDate(6, im.getOrder_date());
			pst.setDate(7,im.getDue_date());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			
			log.error("Unable to insert",e);
			
			throw new RuntimeException();
		}
	}
	
//	public void updateValue(InvoiceModel im) {     //update
//		
//		
//		
//		String query = "update invoice set Product_Id =?,Amount=?,User_Id=?,Seller_Id=? where Invoice_no=?";
//
//		try {
//			Connection con = dataSource.getConnection();
//			PreparedStatement pst = con.prepareStatement(query);
//			pst.setInt(1, im.getProduct_id());
//			pst.setDouble(2, im.getAmount());
//			pst.setInt(3, im.getUser_id());
//			pst.setInt(4, im.getSeller_id());
//			pst.setInt(5, im.getInvoice_no());
//			
//			
//			pst.executeUpdate();
//			con.close();
//		} catch (Exception e) {
//			
//			log.error("Unable to update",e);
//			throw new RuntimeException();
//		}
//	}

	
	
	public void deleteById(int Invoice_no) {//delete
//		String url = "jdbc:mysql://localhost:3306/Task1";
//		String userName = "root";
//		String passWord = "Arunraj@45";
		String query2 = "delete  from invoice where Invoice_no=?";

		try {
			
			Connection con=dataSource.getConnection();
			PreparedStatement ps=con.prepareStatement(query2);
			
			
			ps.setInt(1, Invoice_no);
			ps.executeUpdate();
			
		}

		catch (Exception e) {
			
			log.error("Invalid Id "+ Invoice_no,e);
			throw new RuntimeException();
		}
	}

}
	
	
	
	
	
	


