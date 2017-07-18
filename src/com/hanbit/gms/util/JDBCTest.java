package com.hanbit.gms.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.hanbit.gms.constant.DB;


public class JDBCTest {
	public static void main(String[] args){
		String findName="";
		Connection conn=null;
		
		try {
			Class.forName(DB.ORACLE_DRIVER); 
			//new를 사용하지 않고 동적으로 로딩하면 DriverManager를 사용가능하다.	894p
			conn = DriverManager.getConnection(DB.ORACLE_URL, DB.USERNAME, DB.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql="SELECT * FROM member WHERE id='lee'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				findName = rs.getString("name");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} /*finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} */ //가비지컬렉션(GC)에 의해 자동으로 수행됨 
		
		System.out.println("결과: "+findName);
	}
}
