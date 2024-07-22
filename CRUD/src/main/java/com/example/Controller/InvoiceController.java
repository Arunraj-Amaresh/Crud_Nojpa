package com.example.Controller;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.InvoiceModel;
import com.example.Service.InvoiceService;


@RestController
@RequestMapping("/InvoiceApi/Invoice")
public class InvoiceController {
	
	
	@Autowired
	InvoiceService is;

	@GetMapping("getAll/value")
	public List<InvoiceModel> getAllInvoiceValues() throws SQLException {

		return is.getAll();

	}

	@GetMapping("getById/{no}")
	public InvoiceModel getById(@PathVariable int no) throws SQLException {
		return is.getById(no);
	}
	@PostMapping("/add")
	public String insertDetails(@RequestBody InvoiceModel im) throws SQLException {
		return is.insertvalues(im);

	}
	
//	
//	@PutMapping("/update")
//	public String updateDetails(@RequestBody InvoiceModel im) throws SQLException {
//		return is.updateValues(im);
//	}
	
	@DeleteMapping("deleteById/{no}")
	public String deleteEmployee(@PathVariable int no ) throws SQLException {
		return is.deleteValues(no);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
