package com.hanbit.gms.dao;

import java.util.ArrayList;
import java.util.List;
import com.hanbit.gms.constant.DB;
import com.hanbit.gms.constant.SQL;
import com.hanbit.gms.constant.Vendor;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.factory.DatabaseFactory;

import java.sql.*; //0

public class MemberDAOImpl implements MemberDAO{
	
	//public static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();
	}
	private MemberDAOImpl(){}	//생성자를 private로 설정하면 다른곳에서 호출 못함
	
	@Override
	public String insert(MemberBean member) {
		String rs = "";
		try {			
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getSSN());
			rs=String.valueOf(pstmt.executeUpdate());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public String update(MemberBean member) {
		String rs = "";	
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getSSN());
			pstmt.setString(4, member.getId());
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String id) {
		String rs = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs = String.valueOf(pstmt.executeUpdate());
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
			ResultSet rs = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
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
	public String count() {
		String cnt="";
		try {
			ResultSet rs = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT).executeQuery();
			if(rs.next()){
				cnt = rs.getString("cnt");
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
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
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
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
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
