package com.hanbit.gms.controller;

import javax.swing.JOptionPane;
import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;
import com.hanbit.gms.service.ArticleServiceImpl;

public class BoardController {
	public static void main(String[] args){
		Butt[] buttons = {Butt.EXIT, Butt.ADD, Butt.LIST, Butt.FIND_SEQ, Butt.FIND_ID, Butt.COUNT, Butt.UPDATE, Butt.DEL};
		ArticleBean article = null;
		
		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(
					null, 				//frame
					"BOARD",		//frame title
					"SELECT MENU",		//order
					JOptionPane.QUESTION_MESSAGE,	//type
					null,				//icon
					buttons,			//Array of choices
					buttons[1])){		//default
			
					case EXIT:
						JOptionPane.showMessageDialog(null, "Stop");
						return;
					case ADD:						
						article = new ArticleBean(); //초기화
						String[] arr = JOptionPane.showInputDialog("Id/Title/Content").split("/");
						article.setId(arr[0]);
						article.setTitle(arr[1]);
						article.setContent(arr[2]);
						article.setHitcount(0);
						
						JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().write(article));
						break flag;
					case COUNT:
						JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().countArticles());
						break flag;
					case LIST:
						JOptionPane.showMessageDialog(null, "리스트\n"+ArticleServiceImpl.getInstance().list());
						break flag;
					case FIND_SEQ:
						JOptionPane.showMessageDialog(null, "회원정보\n"+ArticleServiceImpl.getInstance().findBySeq(Integer.parseInt(JOptionPane.showInputDialog("seq를 입력하세요"))));
						break flag;
					case FIND_ID:
						JOptionPane.showMessageDialog(null, "리스트\n"+ArticleServiceImpl.getInstance().findById(JOptionPane.showInputDialog("id를 입력하세요")));
						break flag;
					case UPDATE: 
						article = new ArticleBean(); //초기화
						String[] updateArr = JOptionPane.showInputDialog("seq/Id/Title/Content").split("/"); 
						article.setArticleSeq(Integer.parseInt(updateArr[0]));
						article.setId(updateArr[1]);
						article.setTitle(updateArr[2]);
						article.setContent(updateArr[3]);
						
						JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().modify(article));
						break flag;
					case DEL:
						JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().remove(Integer.parseInt(JOptionPane.showInputDialog("삭제할 seq를 입력하세요"))));
						break flag;
			}
		}while(true);
	}
}
