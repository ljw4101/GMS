package com.hanbit.gms.dao;

import java.util.ArrayList;
import java.util.List;
import com.hanbit.gms.constant.DB;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.domain.MemberBean;
import java.sql.*; //0

public class MemberDAOImpl implements MemberDAO{
	
	//public static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER load failed");
			e.printStackTrace();
		}
		return new MemberDAOImpl();
	}
	private MemberDAOImpl(){}	//생성자를 private로 설정하면 다른곳에서 호출 못함
	
	
	@Override
	public int insert(MemberBean member) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("insert into %s(%s, %s, %s, %s, %s)values('%s', '%s', '%s', '%s', SYSDATE)", DB.TABLE_MEMBER, DB.MEM_ID, DB.MEM_NAME, DB.MEM_PW, DB.MEM_SSN, DB.MEM_REGDATE,
							member.getId(), member.getName(), member.getPw(), member.getSSN()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int update(MemberBean member) {
		int rs = 0;	
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("update %s set %s='%s', %s='%s', %s='%s', %s=SYSDATE where %s = '%s'", 
							DB.TABLE_MEMBER, DB.MEM_NAME, member.getName(), DB.MEM_PW, member.getPw(), DB.MEM_SSN, member.getSSN(), DB.MEM_REGDATE, DB.MEM_ID, member.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int delete(String id) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("delete from %s where %s='%s'", DB.TABLE_MEMBER, DB.MEM_ID, id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();	
		MemberBean bean = null;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("select * from %s", DB.TABLE_MEMBER));
			while(rs.next()){
				bean = new MemberBean(); //new MemberBean(); heap에 넣어지는 주소지가 됨
				bean.setId(rs.getString(DB.MEM_ID));
				bean.setName(rs.getString(DB.MEM_NAME));
				bean.setPw(rs.getString(DB.MEM_PW));
				bean.setSSN(rs.getString(DB.MEM_SSN));
				bean.setRegdate(rs.getString(DB.MEM_REGDATE));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		int cnt=0;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("select count(*) as cnt from %s", DB.TABLE_MEMBER));
			if(rs.next()){
				cnt = Integer.parseInt(rs.getString("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public MemberBean selectByID(String id) {
		MemberBean bean = new MemberBean();
		
		try {
			Connection conn = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM member WHERE id='%s'", id));
			if(rs.next()){	//return값이 한개이므로 if사용
				bean.setId(rs.getString(DB.MEM_ID));
				bean.setName(rs.getString(DB.MEM_NAME));
				bean.setPw(rs.getString(DB.MEM_PW));
				bean.setSSN(rs.getString(DB.MEM_SSN));
				bean.setRegdate(rs.getString(DB.MEM_REGDATE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list = new ArrayList<>();
		MemberBean bean = null;
		
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("select * from %s where %s = '%s'", DB.TABLE_MEMBER, DB.MEM_NAME, name));
			while(rs.next()){
				bean = new MemberBean();
				bean.setId(rs.getString(DB.MEM_ID));
				bean.setName(rs.getString(DB.MEM_NAME));
				bean.setPw(rs.getString(DB.MEM_PW));
				bean.setSSN(rs.getString(DB.MEM_SSN));
				bean.setRegdate(rs.getString(DB.MEM_REGDATE));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
