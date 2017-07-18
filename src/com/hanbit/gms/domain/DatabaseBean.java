package com.hanbit.gms.domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.factory.DatabaseFactory;

public class DatabaseBean implements Serializable{ //모든 객체는 인터페이스에 대한 구현체여야 한다.
	private static final long serialVersionUID = 1L;
	private String driver, url, username, password;	//vendor사 공통
	private Connection connection;
	
	//생성자에 넣음
	public DatabaseBean(String driver, String url, String username, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("DRIVER load failed");
			e.printStackTrace();
		}
		return connection;
	}
}
