package Boook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Book_Delete {
	private String bisbn;
	
	public String execute(){
		Connection fuck = null;  //���������������ݿ��Connection���� 
	   	Statement st;
	   	 
	   	 try {
	         Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
	            
	        fuck = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2library", "l23jk41z5k", "hyxx4li5ikmwww3hz2wz330zmiwk3mz3l3y2h30y");// ������������           
	     }
	   	 catch (Exception e) {
	            System.out.println("���ݿ�����ʧ��" + e.getMessage());  
	     }
	   	 
	   	 try {
	            String sql = "delete from book where ISBN = " + bisbn;  
	            st = (Statement) fuck.createStatement(); 
	            
	            int count = st.executeUpdate(sql); 
	              
	            System.out.println("book����ɾ�� " + count + " ������\n"); 
	              
	            fuck.close();   //�ر����ݿ�����  
	              
	     } 
	   	 catch (SQLException e) {  
	   		 System.out.println("ɾ������ʧ��");  
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
