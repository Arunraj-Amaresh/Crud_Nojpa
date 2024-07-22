package com.example.Model;

import java.sql.Date;
public class InvoiceModel {
	
@Override
	public String toString() {
		return "InvoiceModel [invoice_no=" + invoice_no + ", product=" + product + ", amount=" + amount
				+ ", user_id=" + user_id + ", seller_id=" + seller + ", order_date=" + order_date + ", due_date="
				+ due_date + "]";
	}
private int invoice_no;	

private	int product;
private double amount;
private int user_id;
private 	int seller;
private Date  order_date;
private Date due_date;





public InvoiceModel (){
	
}


public InvoiceModel(int invoice_no,int product, double amount, Date order_date, Date due_date, int seller, int user_id) {
	super();
	this.invoice_no=invoice_no;
	this.product = product;
	this.amount = amount;
	this.order_date = order_date;
	this.due_date = due_date;
	this.seller = seller;
	this.user_id = user_id;
}

public int getInvoice_no() {
	return invoice_no;
}


public void setInvoice_no(int invoice_no) {
	this.invoice_no = invoice_no;
}


	public int getProduct_id() {
	return product;
}
public void setProduct_id(int product_id) {
	this.product = product_id;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getOrder_date() {
	return order_date;
}
public void setOrder_date(Date order_date) {
	this.order_date = order_date;
}
public Date getDue_date() {
	return due_date;
}
public void setDue_date(Date due_date) {
	this.due_date = due_date;
}
public int getSeller_id() {
	return seller;
}
public void setSeller_id(int seller_id) {
	this.seller = seller_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
	
	
	
	
	

}
