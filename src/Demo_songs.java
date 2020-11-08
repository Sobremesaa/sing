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
        String news="('0001','iiii','001','first','path_1','path_2','无')";
        String sql_1 = "select * from songs";//查询语句
        String sql_2 ="update songs set Singer_id = '******' where Song_id='128'";//更新语句
        String sql_3="insert into songs values"+news;//增添语句
        String sql_4="delete from songs where Song_id=‘001’";//删除语句
        try{//连接数据库
       	    conn = DriverManager.getConnection(uri, "sa", "123456789");//建立Statement对象
            stmt = conn.createStatement();//创建一个statement对象将SQL语句发送到数据库
            rs = stmt.executeQuery(sql_1);//执行数据库查询语句
            while (rs.next()){//查找
            	  String id = rs.getString("Singer_id");//获取表中对应属性
                  String name = rs.getString("Singer_name");
                  String s_i = rs.getString("Song_id");
                  String s_name = rs.getString("Song_name");
                  String s_p = rs.getString("Song_path");
                  String l_p = rs.getString("Lyric_path");
                  String style = rs.getString("style");
                  System.out.println("Singer_id:" + id + "\t Singer_name:" + name + "\t Song_id:" + s_i + "\t Song_name:" + s_name + "\t Song_path:" + s_p + "\t Lyric_path:" + l_p + "\t style:" + style);
        	  }
            System.out.println("更新：1	删除：2       增添：3");
            while(ff != 0) {
          	  Scanner flag =new Scanner(System.in);
                int f= flag.nextInt();
                if(f==1){
              	  int update = stmt.executeUpdate(sql_2);//更新功能
              	  System.out.println("更新完成！");
                }
                else if(f==2) {
              	  int delete = stmt.executeUpdate(sql_4);//删除功能
              	  System.out.println("删除完成！");
                }
                else {
              	  int insert = stmt.executeUpdate(sql_3);//增添功能
              	  System.out.println("增添完成！");
                }
                System.out.println("是否继续(终止：0    继续：1)：");
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
        	System.out.println("数据库连接失败");            
        }	        
        }
	 }
