package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DB {
	
	//声明一个数据库连接变量 和 一个结果集对象
	private static Connection connection = null;
	private static PreparedStatement  ps = null;
	private static ResultSet rs = null;
	
    //连接数据库并返回一个 PrepareStatement 对象
    public static PreparedStatement connectAndGetStmt(String query){
    	
    	try {
    		//连接数据库并返回一个 PrepareStatement 对象
            Class.forName(Config.DB_DRIVER);
            //创建一个连接对象
            connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }
        
        try{
        	//创建一个 PrepareStatement 对象
        	ps=(PreparedStatement) connection.prepareStatement(query); 
        	return ps;
        }catch(Exception e){
        	e.printStackTrace();
        }
		return ps;
        
    }
    
    //根据 PrepareStatement 对象 返回查询一个结果集
    public static ResultSet getQueryResult(){
    	try {
			return (ResultSet) ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
    }
  
    
    //关闭这个连接
    public  static void closeConnection(){
        if(connection != null){
            try {
            	connection.close(); // 关闭数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  
     } 

	
}
