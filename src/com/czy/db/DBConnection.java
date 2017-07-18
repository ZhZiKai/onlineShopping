package com.czy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final String Driver = "com.mysql.jdbc.Driver";

	private final String URL = "jdbc:mysql://127.0.0.1:3306/shopping?characterEncoding=utf8&useSSL=true";

	private final String USER = "root";

	private final String PASSWORD = "root";

	private Connection conn = null;

	public DBConnection() throws SQLException {
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public Connection getConnection() {
		return conn;
	}

	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/*测试JDBC连接
	public static void main(String args[])  
    {  
          
            String url = "jdbc:mysql://localhost/mysql";  
            String driver = "com.mysql.jdbc.Driver";  
            try{  
                Class.forName(driver);  
            }catch(Exception e){  
                System.out.println("无法加载驱动");  
            }  
              
    try {  
            Connection con = DriverManager.getConnection(url,"root","root");  
            if(!con.isClosed())  
                System.out.println("success");  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }
    */
}
