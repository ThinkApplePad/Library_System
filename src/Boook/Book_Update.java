package Boook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class Book_Update extends ActionSupport{
	
	private String isbn;
	private String title;
	private String authorid;
	private String publisher;
	private String publishdate;
	private String price;
	private String temp = "0";
	
	public String execute(){
   	 Connection conn = null;
   	 Statement st;
   	try {
	        Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
	           
	       	conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2library", "l23jk41z5k", "hyxx4li5ikmwww3hz2wz330zmiwk3mz3l3y2h30y");// ������������           
	   	 }
	   	 catch (Exception e) {
	           System.out.println("���ݿ�����ʧ��" + e.getMessage());  
	  	 }
   	try {
        String sql = "update book set ISBN="+isbn+" AuthorID="+authorid+" Publisher="+publisher+" Publishdate="+publishdate+" Price="+price+" where name = Title="+title;  
          
        st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
          
        int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���  
          
        System.out.println("book���и��� " + count + " ������");      //������²����Ĵ�����  
          
        conn.close();   //�ر����ݿ�����  
          
   		} catch (SQLException e) {  
   			System.out.println("��������ʧ��");  
   		}  
   		return "success";
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
}
