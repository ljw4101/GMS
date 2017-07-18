package com.hanbit.gms.service;

import java.util.List;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.domain.MemberBean;

public interface ArticleService {
	//setter : 사용자에게 결과후 성공여부 message 반환
	public String write(ArticleBean bean);
	public String modify(ArticleBean bean);
	public String remove(int seq);
	//getter
	public List<ArticleBean> list();
	public int countArticles();
	public ArticleBean findBySeq(int seq);
	public List<ArticleBean> findById(String id);	
}
