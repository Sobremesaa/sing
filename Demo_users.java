package demo;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
public class Demo_users{
	public static void main(String[] args){
		int ff = 1;
		Connection conn;
		Statement stmt;
        ResultSet rs;
        String uri = "jdbc:sqlserver://localhost:1433;DatabaseName=sing;";
        String news="('001','0000','first_user')";
        String sql_1 = "select * from Users";//��ѯ���
        String sql_2 ="update Users set password = '1234' where User_id='001'";//�������
        String sql_3="insert into Users values"+news;//�������
        String sql_4="delete from Users where User_id=��001��";//ɾ�����
        try{//�������ݿ�
       	    conn = DriverManager.getConnection(uri, "sa", "123456789");//����Statement����
            stmt = conn.createStatement();//����һ��statement����SQL��䷢�͵����ݿ�
            rs = stmt.executeQuery(sql_1);//ִ�����ݿ��ѯ���
            while (rs.next()){//����
            	  String id = rs.getString("User_id");//��ȡ���ж�Ӧ����
            	  String pword = rs.getString("password");
                  String name = rs.getString("User_name");
                  System.out.println("User_id:" + id + "\t password:" + pword + "\t User_name:" + name );
        	  }
            System.out.println("���£�1	ɾ����2       ����3");
            while(ff != 0) {
          	  Scanner flag =new Scanner(System.in);
                int f= flag.nextInt();
                if(f==1){
              	  int update = stmt.executeUpdate(sql_2);//���¹���
              	  System.out.println("������ɣ�");
                }
                else if(f==2) {
              	  int delete = stmt.executeUpdate(sql_4);//ɾ������
              	  System.out.println("ɾ����ɣ�");
                }
                else {
              	  int insert = stmt.executeUpdate(sql_3);//������
              	  System.out.println("������ɣ�");
                }
                System.out.println("�Ƿ����(��ֹ��0    ������1)��");
                Scanner flag_0 =new Scanner(System.in);
                ff= flag_0.nextInt();
            }
            if (rs != null) {
            	rs.close();
            	rs = null;
            	}
            if (stmt != null) {
            	stmt.close();
            	stmt = null;	                  
            	}	                  
            if (conn != null) {		              
            	conn.close();	              
            	conn = null;	                  
            	}	                  
            		              
            }
        catch (SQLException e) {
        	e.printStackTrace();            
        	System.out.println("���ݿ�����ʧ��");            
        }	        
        }
	 }
