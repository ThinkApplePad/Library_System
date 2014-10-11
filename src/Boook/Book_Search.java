package Boook;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

public class Book_Search  extends ActionSupport{
	private String authorname;
	private List<String[]> mylist = new ArrayList<String[]>();
	private List<String[]> authorlist = new ArrayList<String[]>();
	private List<String[]> brifeinfo = new ArrayList<String[]>();
    
	public String execute(){
		 String []tempstring = new String[6];
		 String []storeauthor = new String[4];
		 String []brife = new String[2];
		
		 Connection fuck = null;  //创建用于连接数据库的Connection对象 
	   	 Statement st;
	   	 Statement hy;
	   	 
	   	 try {
	         Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
	            
	        fuck = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2library", "l23jk41z5k", "hyxx4li5ikmwww3hz2wz330zmiwk3mz3l3y2h30y");// 创建数据连接           
	     }
	   	 catch (Exception e) {
	            System.out.println("数据库连接失败" + e.getMessage());  
	     }
	   	
	   	 try {
	   		 storeauthor[1] = "0";
	   		 
	   		String findid = "select * from author where Name = '"+authorname+"'";
	   		hy = (Statement) fuck.createStatement();
	   		ResultSet why = hy.executeQuery(findid);
	   		while (why.next()){
	   			storeauthor[0] = why.getString("AuthorID");
	   			storeauthor[1] = why.getString("Name");
	   			storeauthor[2] = why.getString("Age");
	   			storeauthor[3] = why.getString("Country");
	   			
	   			authorlist.add(storeauthor.clone());
	   		}
	   		
	   		String sql = "select * from book where AuthorID = '"+storeauthor[0]+"'";     // 查询数据的sql语句  
            st = (Statement) fuck.createStatement();						    //创建用于执行静态sql语句的Statement对象，st属局部变量  
            ResultSet rs = st.executeQuery(sql);   								//执行sql查询语句，返回查询数据的结果集  
	   		while (rs.next()){
	   		    tempstring[0] = rs.getString("ISBN");
                tempstring[1] = rs.getString("Title");  
                tempstring[2] = rs.getString("AuthorID");
                tempstring[3] = rs.getString("Publisher");
                tempstring[4] = rs.getString("PublishDate");
                tempstring[5] = rs.getString("Price");

	   			brife[0] = tempstring[1];
	   			brife[1] = storeauthor[1];
	   			
	   			mylist.add(tempstring.clone());
	   			brifeinfo.add(brife.clone());
	   		}
	   		
	   		fuck.close();   //关闭数据库连接 
              
        } catch (SQLException e) {
            System.out.println("查询数据失败");  
        }

		if(storeauthor[1] != "0"){
			return "success";
		}
		else {
			return "error";
		}
	}
	
	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public List<String[]> getMylist() {
		return mylist;
	}

	public void setMylist(List<String[]> mylist) {
		this.mylist = mylist;
	}

	public List<String[]> getAuthorlist() {
		return authorlist;
	}

	public void setAuthorlist(List<String[]> authorlist) {
		this.authorlist = authorlist;
	}

	public List<String[]> getBrifeinfo() {
		return brifeinfo;
	}

	public void setBrifeinfo(List<String[]> brifeinfo) {
		this.brifeinfo = brifeinfo;
	}
}
