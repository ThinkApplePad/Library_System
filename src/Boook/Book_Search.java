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
		
		 Connection fuck = null;  //���������������ݿ��Connection���� 
	   	 Statement st;
	   	 Statement hy;
	   	 
	   	 try {
	         Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
	            
	        fuck = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2library", "l23jk41z5k", "hyxx4li5ikmwww3hz2wz330zmiwk3mz3l3y2h30y");// ������������           
	     }
	   	 catch (Exception e) {
	            System.out.println("���ݿ�����ʧ��" + e.getMessage());  
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
	   		
	   		String sql = "select * from book where AuthorID = '"+storeauthor[0]+"'";     // ��ѯ���ݵ�sql���  
            st = (Statement) fuck.createStatement();						    //��������ִ�о�̬sql����Statement����st���ֲ�����  
            ResultSet rs = st.executeQuery(sql);   								//ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
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
	   		
	   		fuck.close();   //�ر����ݿ����� 
              
        } catch (SQLException e) {
            System.out.println("��ѯ����ʧ��");  
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
