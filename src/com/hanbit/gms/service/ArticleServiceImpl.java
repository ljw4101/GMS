package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.ArticleDAO;
import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleServiceImpl implements ArticleService{
	
	public static ArticleServiceImpl getInstance() {
		return new ArticleServiceImpl();
	}
	private ArticleServiceImpl(){}
	
	@Override
	public String write(ArticleBean bean) {
		String rs = ArticleDAOImpl.getInstance().insert(bean);
		String msg = (rs.equals("1"))?"게시글 등록 성공":"게시글 등록 실패";
		return msg;
	}

	@Override
	public String modify(ArticleBean bean) {
		String rs = ArticleDAOImpl.getInstance().update(bean);
		String msg = (rs.equals("1"))?"게시글 수정 성공":"게시글 수정 실패";
		return msg;
	}

	@Override
	public String remove(int seq) {
		String rs = ArticleDAOImpl.getInstance().delete(seq);
		String msg = (rs.equals("1"))?"게시글 삭제 성공":"게시글 삭제 실패";
		return msg;
	}

	@Override
	public List<ArticleBean> list() {
		return ArticleDAOImpl.getInstance().selectAll();
	}

	@Override
	public String countArticles() {
		return ArticleDAOImpl.getInstance().count();
	}

	@Override
	public ArticleBean findBySeq(int seq) {
		return ArticleDAOImpl.getInstance().selectBySeq(seq);
	}

	@Override
	public List<ArticleBean> findById(String id) {
		return ArticleDAOImpl.getInstance().selectById(id);
	}
}
