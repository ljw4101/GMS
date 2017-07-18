package com.hanbit.gms.dao;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.constant.SQL;
import com.hanbit.gms.constant.Vendor;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.factory.DatabaseFactory;

public class ArticleDAOImpl implements ArticleDAO{
	public static ArticleDAOImpl getInstance() {
		return new ArticleDAOImpl();
	}
	private ArticleDAOImpl(){}
	
	@Override
	public String insert(ArticleBean bean) {
		String rs="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_INSERT);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setInt(4, bean.getHitcount());
			rs=String.valueOf(pstmt.executeUpdate());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String update(ArticleBean bean) {
		ArticleBean serach = selectBySeq(bean.getArticleSeq());
		String title = (!bean.getTitle().equals(" "))?bean.getTitle():serach.getTitle();
		String content = (!bean.getContent().equals(" "))?bean.getContent():serach.getContent();
		
		String rs="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bean.getArticleSeq());
			pstmt.setString(4, bean.getId());
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rs;
	}

	@Override
	public String delete(int seq) {
		String rs="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_DELETE);
			pstmt.setInt(1, seq);
			rs = String.valueOf(pstmt.executeUpdate());
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
			ResultSet rs = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_LIST).executeQuery();
			
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
	public String count() {
		String cnt="";
		try {
			ResultSet rs = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_COUNT).executeQuery();
			if(rs.next()){
				cnt = rs.getString("cnt");
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
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_FINDBYSEQ);
			pstmt.setInt(1, seq);
			ResultSet rs = pstmt.executeQuery();
			
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
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
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
