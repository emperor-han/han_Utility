package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DB {
	
	//����һ�����ݿ����ӱ��� �� һ�����������
	private static Connection connection = null;
	private static PreparedStatement  ps = null;
	private static ResultSet rs = null;
	
    //�������ݿⲢ����һ�� PrepareStatement ����
    public static PreparedStatement connectAndGetStmt(String query){
    	
    	try {
    		//�������ݿⲢ����һ�� PrepareStatement ����
            Class.forName(Config.DB_DRIVER);
            //����һ�����Ӷ���
            connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
            System.out.println("���ݿ����ӳɹ�");
        } catch (Exception e) {
            System.out.println("���ݿ������쳣");
            e.printStackTrace();
        }
        
        try{
        	//����һ�� PrepareStatement ����
        	ps=(PreparedStatement) connection.prepareStatement(query); 
        	return ps;
        }catch(Exception e){
        	e.printStackTrace();
        }
		return ps;
        
    }
    
    //���� PrepareStatement ���� ���ز�ѯһ�������
    public static ResultSet getQueryResult(){
    	try {
			return (ResultSet) ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
    }
  
    
    //�ر��������
    public  static void closeConnection(){
        if(connection != null){
            try {
            	connection.close(); // �ر����ݿ�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  
     } 

	
}
