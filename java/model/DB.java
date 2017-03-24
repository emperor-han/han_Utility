package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
	
	//����һ�����ݿ����ӱ��� �� һ�����������
	public static Connection connection = null;
	
	//�������ݿⲢ�����������
	public static Connection getConnection(){
    	try {
            Class.forName(Config.DB_DRIVER);
            //����һ�����Ӷ���
            connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
            System.out.println("���ݿ����ӳɹ�");
        } catch (Exception e) {
            System.out.println("���ݿ������쳣");
            e.printStackTrace();
        }finally{
        	return connection;
        }

	}
	
    //�ر��������
    public  static void closeConnection(Connection connection){
        if(connection != null){
            try {
            	connection.close(); // �ر����ݿ�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  
     } 

	
}
