package demo;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
public class Demo_songs{
	public static void main(String[] args){
		int ff = 1;
		Connection conn;
		Statement stmt;
        ResultSet rs;
        String uri = "jdbc:sqlserver://localhost:1433;DatabaseName=sing;";
        String news="('0001','iiii','001','first','path_1','path_2','��')";
        String sql_1 = "select * from songs";//��ѯ���
        String sql_2 ="update songs set Singer_id = '******' where Song_id='128'";//�������
        String sql_3="insert into songs values"+news;//�������
        String sql_4="delete from songs where Song_id=��001��";//ɾ�����
        try{//�������ݿ�
       	    conn = DriverManager.getConnection(uri, "sa", "123456789");//����Statement����
            stmt = conn.createStatement();//����һ��statement����SQL��䷢�͵����ݿ�
            rs = stmt.executeQuery(sql_1);//ִ�����ݿ��ѯ���
            while (rs.next()){//����
            	  String id = rs.getString("Singer_id");//��ȡ���ж�Ӧ����
                  String name = rs.getString("Singer_name");
                  String s_i = rs.getString("Song_id");
                  String s_name = rs.getString("Song_name");
                  String s_p = rs.getString("Song_path");
                  String l_p = rs.getString("Lyric_path");
                  String style = rs.getString("style");
                  System.out.println("Singer_id:" + id + "\t Singer_name:" + name + "\t Song_id:" + s_i + "\t Song_name:" + s_name + "\t Song_path:" + s_p + "\t Lyric_path:" + l_p + "\t style:" + style);
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
