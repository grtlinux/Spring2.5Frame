package kame.spring.chap01;

public class MysqlArticleDao implements ArticleDao {

	@Override
	public void insert(Article article) {
		System.out.println("MysqlArticleDao.insert() ½ÇÇà");
	}

}
