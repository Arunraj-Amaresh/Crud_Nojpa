package com.example.Service;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Model.InvoiceModel;
import com.example.Repository.InvoiceRepo;





@Service 
public class InvoiceService {
	
	@Autowired
	InvoiceRepo  ir;

	public List<InvoiceModel> getAll() throws SQLException {
		return ir.getAll();
	}
	
	public InvoiceModel getById(int no) throws SQLException {
		return ir.getById(no);
	}

	public String insertvalues(InvoiceModel im) throws SQLException {
		ir.insertValue(im);
		return "Inserted Successfuly";
	}

//	public String updateValues(InvoiceModel im) throws SQLException {
//		ir.updateValue(im);
//		return "Updated Successfuly";
//	}
	
	public String deleteValues(int no) throws SQLException {
		ir.deleteById(no);
		return "Deleted Successfuly";
	}
	
	
	

}
