package Boook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class Book_Add extends ActionSupport{
	
	private String isbn;
	private String title;
	private String authorid;
	private String authorname;
	private String age;
	private String country;
	private String publisher;
	private String publishdate;
	private String price;
	private String temp = "0";
	private String add = "hahahaha";
	
	public String execute(){
   	 Connection qushi = null;
   	 Statement strt;
   	 Connection biu = null;
	 Statement str;
	 Connection fuck = null;   
   	 Statement st;
   	 
   	 if(isbn != null){  // seem unhelpful
   		try {
   	        Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
   	           
   	       	qushi = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2library", "l23jk41z5k", "hyxx4li5ikmwww3hz2wz330zmiwk3mz3l3y2h30y");// ������������           
   	   	 }
   	   	 catch (Exception e) {
   	           System.out.println("���ݿ�����ʧ��" + e.getMessage());  
   	  	 }
   	   	 
   	   	 try {
   	   		 String sql = "select * from author where Name = '"+authorname+"' ";
   	   		 strt = (Statement) qushi.createStatement();
   	   		 ResultSet rs = strt.executeQuery(sql);
   	   		 while(rs.next()){
   	   			 temp = rs.getString("Name");
   	   		 }
   	   		 qushi.close();
   	   	 }
   	   	 catch (Exception e) {
   	   		System.out.println("��������ʧ��" + e.getMessage());  
   	   	 	return "error";
   	   	 }
   	   	 
   	   	 if(temp == "0"){
   	   		 
   	   	try {
   	        Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
   	           
   	       	biu = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system", "root", "jackiepiao0120");// ������������           
   	   	 }
   	   	 catch (Exception e) {
   	           System.out.println("���ݿ�����ʧ��" + e.getMessage());  
   	  	 }
   	   	
   	       try {
   	       	 String sql = "INSERT INTO author(AuthorID,Name,Age,Country)"  
   	                       + " VALUES ('"+authorid+"','"+authorname+"','"+age+"','"+country+"')"; 
   	            
   	            str = (Statement) biu.createStatement();
   	            
   	            int count = str.executeUpdate(sql);
   	            
   	            System.out.println("��library_system���в��� " + count + " ������");  
   	                 
   	            biu.close(); 
   	                 
   	        } 
   	        catch (SQLException e) {  
   	       	 	System.out.println("��������ʧ��" + e.getMessage());  
   	       	 	return "error";
   	        }
   	   	 }
   	   	 
   	   	 try {
   	         Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
   	            
   	        fuck = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system", "root", "jackiepiao0120");// ������������           
   	     } 
   	   	 catch (Exception e) {
   	            System.out.println("���ݿ�����ʧ��" + e.getMessage());  
   	     }
   	   	 
   	     try {
   	    	 String sql = "INSERT INTO book(ISBN,Title,AuthorID,Publisher,PublishDate,Price)"  
   	                    + " VALUES ('"+isbn+"','"+title+"','"+authorid+"','"+publisher+"','"+publishdate+"','"+price+"')";  // �������ݵ�sql���  
   	              
   	         st = (Statement) fuck.createStatement();    // ��������ִ�о�̬sql����Statement����  
   	         
   	         int count = st.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���  
   	         
   	         System.out.println("��library_system���в��� " + count + " ������"); //�����������Ĵ�����  
   	              
   	         fuck.close();   //�ر����ݿ�����  
   	              
   	     } 
   	     catch (SQLException e) {  
   	    	 System.out.println("��������ʧ��" + e.getMessage());  
   	    	 return "error";
   	     }
   			return "success";
   	 }
   	 else {
   		 return "error";
   	 }
    }


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthorid() {
		return authorid;
	}


	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getPublishdate() {
		return publishdate;
	}


	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getAuthorname() {
		return authorname;
	}


	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


}
