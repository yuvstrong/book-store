package com.js.dto;
//data transfring object
public class Book {
	private int Bid;
	private String Bname;
	private String Bauthor;
	private int Bpage;
	private double Bprice;
	
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public int getBpage() {
		return Bpage;
	}
	public void setBpage(int bpage) {
		Bpage = bpage;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getBauthor() {
		return Bauthor;
	}
	public void setBauthor(String bauthor) {
		Bauthor = bauthor;
	}

	public double getBprice() {
		return Bprice;
	}
	public void setBprice(double bprice) {
		Bprice = bprice;
	}
	@Override
	public String toString() {
		return "Book [Bid=" + Bid + ", Bname=" + Bname + ", Bauthor=" + Bauthor + ", Bpage=" + Bpage + 
				", Bprice=" + Bprice + "]";
	}
	
	
	
	

	
}


