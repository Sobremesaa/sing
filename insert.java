package demo_1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.*;
public class insert {
	public static void main(String[] args) {
	Connection conn;
	Statement stmt;
	String uri = "jdbc:sqlserver://localhost:1433;DatabaseName=sing;";
	try{//�������ݿ�
   	    conn = DriverManager.getConnection(uri, "sa", "123456789");//����Statement����
        stmt = conn.createStatement();//����һ��statement����SQL��䷢�͵����ݿ�    
      
    System.out.println("�Ƿ�������ݣ���-1  ��-0��");
    Scanner scan=new Scanner(System.in);
    int flag=scan.nextInt();
    System.out.println("�������ݱ���:");
    Scanner s1=new Scanner(System.in);
	String ss=s1.nextLine();//����
    while(flag==1) {
    	System.out.println("������Ϣ:");
    	Scanner s=new Scanner(System.in);
    	String news=s.nextLine();//������Ϣ
    	String sqls="insert into "+ss+" values "+news;//�����γ�T-sql�������
		int insert = stmt.executeUpdate(sqls);//���в������
    	System.out.println("�Ƿ��������-1  ��-0��");
    	Scanner scans=new Scanner(System.in);
        int f=scans.nextInt();
        flag=f;
        if(flag==0)
        	System.out.println("��Ϣ�������!");
    }	      
    }
	catch (SQLException e) {
    	e.printStackTrace();            
    	System.out.println("���ݿ�����ʧ��"); 
	}
	}
}


