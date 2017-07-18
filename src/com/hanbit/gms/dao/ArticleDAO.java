package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;

public interface ArticleDAO {
	//setter void -> int 이유 : setter후 성공여부 반환: 오라클에서 숫자값으로 return함
	public int insert(ArticleBean bean);
	public int update(ArticleBean bean);
	public int delete(int seq);
	//getter
	public List<ArticleBean> selectAll();
	public int count();
	public ArticleBean selectBySeq(int seq); //primary key 리턴타입은 Bean이다.
	public List<ArticleBean> selectById(String id);
}
