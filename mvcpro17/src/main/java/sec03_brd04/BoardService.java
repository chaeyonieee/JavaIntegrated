package sec03_brd04;

import java.util.List;

public class BoardService {

	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	public List listArticles() {
		List articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}

	public int addArticle(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
	}
	public ArticleVO viewArticle(int articleNO) {
		
		ArticleVO article = null;
		article = boardDAO.selectArticle(articleNO);
		return article;
		
}
}