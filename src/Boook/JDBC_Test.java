package Boook;  

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
public class JDBC_Test {  
    // ������̬ȫ�ֱ���  
    static Connection conn;  
  
    static Statement st;  
  
    public static void main(String[] args) {  
        insert();   //������Ӽ�¼  
        //update();   //���¼�¼����  
        //delete();   //ɾ����¼  
        //query();    //��ѯ��¼����ʾ  
    }  
    
    /* �������ݼ�¼���������������ݼ�¼��*/  
    public static void insert() {  
          
        conn = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
  
        try {  
//            String sql = "INSERT INTO Book(ISBN, Title, AuthorID, Publisher, PublishDate, Price)"  
//                    + " VALUES ('00000008', '�����һ������', '00000005','������','2014.10.01','��100')";  // �������ݵ�sql���  
//            
        	String sql = "INSERT INTO author(AuthorID, Name, Age, Country)"  
                    + " VALUES ('00000005', 'why_mat', '20','China')";  // �������ݵ�sql���  
            
            st = (Statement) conn.createStatement();    // ��������ִ�о�̬sql����Statement����  
            
            int count = st.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���  
            
            System.out.println("��Book���в��� " + count + " ������"); //�����������Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } 
        catch (SQLException e) {  
            System.out.println("��������ʧ��" + e.getMessage());  
        }  
    }  
      
    /* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ*/  
    public static void update() {  
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
            String sql = "update boollist set isbn='000000' where name = 'test'";// �������ݵ�sql���  
              
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���  
              
            System.out.println("boollist���и��� " + count + " ������");      //������²����Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println("��������ʧ��");  
        }  
    }  
  
    /* ��ѯ���ݿ⣬�������Ҫ��ļ�¼�����*/  
    public static void query() {  
          
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
            String sql = "select * from boollist";     // ��ѯ���ݵ�sql���  
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����  
            System.out.println("���Ĳ�ѯ���Ϊ��");  
            while (rs.next()) { // �ж��Ƿ�����һ������  
                  
                // �����ֶ�����ȡ��Ӧ��ֵ  
                String name = rs.getString("name");  
                String isbn = rs.getString("isbn");  
                String author = rs.getString("author");  
   
                //����鵽�ļ�¼�ĸ����ֶε�ֵ  
                System.out.println(name + " " + isbn + " " + author + " ");  
              
            }  
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println("��ѯ����ʧ��");  
        }  
    }  
  
    /* ɾ������Ҫ��ļ�¼��������*/  
    public static void delete() {  
  
        conn = getConnection(); //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�  
        try {  
            String sql = "delete from boollist  where name = 'test'";// ɾ�����ݵ�sql���  
            st = (Statement) conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����  
              
            int count = st.executeUpdate(sql);// ִ��sqlɾ����䣬����ɾ�����ݵ�����  
              
            System.out.println("boollist����ɾ�� " + count + " ������\n");    //���ɾ�������Ĵ�����  
              
            conn.close();   //�ر����ݿ�����  
              
        } catch (SQLException e) {  
            System.out.println("ɾ������ʧ��");  
        }  
          
    }  
      
    /* ��ȡ���ݿ����ӵĺ���*/  
    public static Connection getConnection() {  
        Connection con = null;  //���������������ݿ��Connection����  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/library_system", "root", "jackiepiao0120");// ������������  
              
        } catch (Exception e) {  
            System.out.println("���ݿ�����ʧ��" + e.getMessage());  
        }  
        return con; //���������������ݿ�����  
    }  
} 
