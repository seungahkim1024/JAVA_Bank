package service;

import java.util.ArrayList;

import domain.ArticleBean;

public interface ArticleService {
	//title, content, writer, seq(글번호), pass
		//CREATE
		public void createContent
		(String title, String  content, String  writer, String pass, int seq);
		//READ
		public ArrayList<ArticleBean> findAllWriter();
		public ArrayList<ArticleBean> findTitle(String writer);
		public ArticleBean findSeq(int seq);
		public int countTitle();
		public boolean existContent(int seq);
		
		//UPDATE
		public void updateContent(String writer, String pass);
		//DELETE
		public void deleteContent(String writer, String pass);
}
