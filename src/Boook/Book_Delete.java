package Boook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Book_Delete {
	private String bisbn;
	
	public String execute(){
		Connection fuck = null;  //创建用于连接数据库的Connection对象 
	   	Statement st;
	   	 
	   	 try {
	         Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
	            
	        fuck = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2library", "l23jk41z5k", "hyxx4li5ikmwww3hz2wz330zmiwk3mz3l3y2h30y");// 创建数据连接           
	     }
	   	 catch (Exception e) {
	            System.out.println("数据库连接失败" + e.getMessage());  
	     }
	   	 
	   	 try {
	            String sql = "delete from book where ISBN = " + bisbn;  
	            st = (Statement) fuck.createStatement(); 
	            
	            int count = st.executeUpdate(sql); 
	              
	            System.out.println("book表中删除 " + count + " 条数据\n"); 
	              
	            fuck.close();   //关闭数据库连接  
	              
	     } 
	   	 catch (SQLException e) {  
	   		 System.out.println("删除数据失败");  
	   		 return "error";
	     }
	   	 return "success";
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}
}
