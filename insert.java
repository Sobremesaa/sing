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
	try{//连接数据库
   	    conn = DriverManager.getConnection(uri, "sa", "123456789");//建立Statement对象
        stmt = conn.createStatement();//创建一个statement对象将SQL语句发送到数据库    
      
    System.out.println("是否插入数据（是-1  否-0）");
    Scanner scan=new Scanner(System.in);
    int flag=scan.nextInt();
    System.out.println("输入数据表名:");
    Scanner s1=new Scanner(System.in);
	String ss=s1.nextLine();//表名
    while(flag==1) {
    	System.out.println("输入信息:");
    	Scanner s=new Scanner(System.in);
    	String news=s.nextLine();//插入信息
    	String sqls="insert into "+ss+" values "+news;//连接形成T-sql插入语句
		int insert = stmt.executeUpdate(sqls);//运行插入语句
    	System.out.println("是否继续（是-1  否-0）");
    	Scanner scans=new Scanner(System.in);
        int f=scans.nextInt();
        flag=f;
        if(flag==0)
        	System.out.println("信息输入完毕!");
    }	      
    }
	catch (SQLException e) {
    	e.printStackTrace();            
    	System.out.println("数据库连接失败"); 
	}
	}
}


