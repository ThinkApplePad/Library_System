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
   	        Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
   	           
   	       	qushi = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2library", "l23jk41z5k", "hyxx4li5ikmwww3hz2wz330zmiwk3mz3l3y2h30y");// 创建数据连接           
   	   	 }
   	   	 catch (Exception e) {
   	           System.out.println("数据库连接失败" + e.getMessage());  
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
   	   		System.out.println("插入数据失败" + e.getMessage());  
   	   	 	return "error";
   	   	 }
   	   	 
   	   	 if(temp == "0"){
   	   		 
   	   	try {
   	        Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
   	           
   	       	biu = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system", "root", "jackiepiao0120");// 创建数据连接           
   	   	 }
   	   	 catch (Exception e) {
   	           System.out.println("数据库连接失败" + e.getMessage());  
   	  	 }
   	   	
   	       try {
   	       	 String sql = "INSERT INTO author(AuthorID,Name,Age,Country)"  
   	                       + " VALUES ('"+authorid+"','"+authorname+"','"+age+"','"+country+"')"; 
   	            
   	            str = (Statement) biu.createStatement();
   	            
   	            int count = str.executeUpdate(sql);
   	            
   	            System.out.println("向library_system表中插入 " + count + " 条数据");  
   	                 
   	            biu.close(); 
   	                 
   	        } 
   	        catch (SQLException e) {  
   	       	 	System.out.println("插入数据失败" + e.getMessage());  
   	       	 	return "error";
   	        }
   	   	 }
   	   	 
   	   	 try {
   	         Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
   	            
   	        fuck = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system", "root", "jackiepiao0120");// 创建数据连接           
   	     } 
   	   	 catch (Exception e) {
   	            System.out.println("数据库连接失败" + e.getMessage());  
   	     }
   	   	 
   	     try {
   	    	 String sql = "INSERT INTO book(ISBN,Title,AuthorID,Publisher,PublishDate,Price)"  
   	                    + " VALUES ('"+isbn+"','"+title+"','"+authorid+"','"+publisher+"','"+publishdate+"','"+price+"')";  // 插入数据的sql语句  
   	              
   	         st = (Statement) fuck.createStatement();    // 创建用于执行静态sql语句的Statement对象  
   	         
   	         int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  
   	         
   	         System.out.println("向library_system表中插入 " + count + " 条数据"); //输出插入操作的处理结果  
   	              
   	         fuck.close();   //关闭数据库连接  
   	              
   	     } 
   	     catch (SQLException e) {  
   	    	 System.out.println("插入数据失败" + e.getMessage());  
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
