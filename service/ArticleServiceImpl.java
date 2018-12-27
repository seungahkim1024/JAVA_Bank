package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import domain.ArticleBean;

public class ArticleServiceImpl implements ArticleService{
	private HashMap<String, ArticleBean> map;
	private int seq;
	public ArticleServiceImpl() {
		map = new HashMap<>();
		seq = 1000;
	}

	@Override
	public void createContent(String title, String content, String writer, String pass, int seq) {
		ArticleBean article = new ArticleBean();
		article.setTitle(title);
		article.setContent(content);
		article.setWriter(writer);
		article.setPass(pass);
		article.setSeq(seq);
		map.put(String.valueOf(seq), article);
		seq++;
	}	

	@Override
	public ArrayList<ArticleBean> findAllWriter() {
		//ArrayList<ArticleBean> a = (ArrayList<ArticleBean>) map.values();
		return (ArrayList<ArticleBean>) map.values();
	}

	@Override
	public ArrayList<ArticleBean> findTitle(String writer) {
		ArrayList<ArticleBean> title = new ArrayList<>();
		Set<String> set  = map.keySet();
		for(String key: set){
			if(writer.equals(map.get(key).getWriter())){
				title.add(map.get(key));
			}
		}
		return title;
	}

	@Override
	public ArticleBean findSeq(int seq) {
		
		return map.get(seq);
	}

	@Override
	public int countTitle() {
		
		return map.size();
	}

	@Override
	public boolean existContent(int seq) {
		boolean ok = false;
			if(map.containsKey(seq)){
				ok = true;
			}
		return ok;
	}

	@Override
	public void updateContent(String seq, String writer) {
		
		
	}

	@Override
	public void deleteContent(String seq, String writer) {
		if(map.get(seq).equals(seq)){
			
		}
		
	}

}
