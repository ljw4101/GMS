package com.hanbit.gms.dao;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleDAOImpl implements ArticleDAO{
	public static ArticleDAOImpl getInstance() {
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER load failed");
			e.printStackTrace();
		}
		return new ArticleDAOImpl();
	}
	private ArticleDAOImpl(){}
	
	@Override
	public int insert(ArticleBean bean) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("insert into %s(%s, %s, %s, %s, %s, %s)values(article_seq.nextval, '%s', '%s', '%s', %s, SYSDATE)", 
							DB.TABLE_BOARD, DB.BO_SEQ, DB.BO_ID, DB.BO_TITLE, DB.BO_CONTENT, DB.BO_HITCOUNT, DB.BO_REGDATE, bean.getId(), bean.getTitle(), bean.getContent(), bean.getHitcount()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int update(ArticleBean bean) {
		int rs=0;
		try {
			
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("update %s set %s='%s', %s='%s', %s=SYSDATE where %s=%d and %s='%s'", 
							DB.TABLE_BOARD, DB.BO_TITLE, bean.getTitle(), DB.BO_CONTENT, bean.getContent(), DB.BO_REGDATE, DB.BO_SEQ, bean.getArticleSeq(), DB.BO_ID, bean.getId()));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int delete(int seq) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeUpdate(
					String.format("delete from %s where %s=%d", DB.TABLE_BOARD, DB.BO_SEQ, seq));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("select * from %s", DB.TABLE_BOARD));
			while(rs.next()){
				bean = new ArticleBean();
				bean.setArticleSeq(rs.getInt(DB.BO_SEQ));
				bean.setId(rs.getString(DB.BO_ID));
				bean.setTitle(rs.getString(DB.BO_TITLE));
				bean.setContent(rs.getString(DB.BO_CONTENT));
				bean.setHitcount(rs.getInt(DB.BO_HITCOUNT));
				bean.setRegdate(rs.getString(DB.BO_REGDATE));
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
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("select count(*) as cnt from %s", DB.TABLE_BOARD));
			if(rs.next()){
				cnt = Integer.parseInt(rs.getString("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public ArticleBean selectBySeq(int seq) {
		ArticleBean bean = new ArticleBean();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("select * from %s where %s=%d", DB.TABLE_BOARD, DB.BO_SEQ, seq));
			if(rs.next()){
				bean.setArticleSeq(rs.getInt(DB.BO_SEQ));
				bean.setId(rs.getString(DB.BO_ID));
				bean.setTitle(rs.getString(DB.BO_TITLE));
				bean.setContent(rs.getString(DB.BO_CONTENT));
				bean.setHitcount(rs.getInt(DB.BO_HITCOUNT));
				bean.setRegdate(rs.getString(DB.BO_REGDATE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		try {
			bean = new ArticleBean(); 
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD).createStatement().executeQuery(String.format("select * from %s where %s='%s'", DB.TABLE_BOARD, DB.BO_ID, id));
			while(rs.next()){
				bean = new ArticleBean();
				bean.setArticleSeq(rs.getInt(DB.BO_SEQ));
				bean.setId(rs.getString(DB.BO_ID));
				bean.setTitle(rs.getString(DB.BO_TITLE));
				bean.setContent(rs.getString(DB.BO_CONTENT));
				bean.setHitcount(rs.getInt(DB.BO_HITCOUNT));
				bean.setRegdate(rs.getString(DB.BO_REGDATE));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
