package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
	
	//声明一个数据库连接变量 和 一个结果集对象
	public static Connection connection = null;
	
	//连接数据库并返回这个连接
	public static Connection getConnection(){
    	try {
            Class.forName(Config.DB_DRIVER);
            //创建一个连接对象
            connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }finally{
        	return connection;
        }

	}
	
    //关闭这个连接
    public  static void closeConnection(Connection connection){
        if(connection != null){
            try {
            	connection.close(); // 关闭数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  
     } 

	
}
