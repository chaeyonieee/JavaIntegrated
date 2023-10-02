package sec03.brd02;

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
	public void addArticle(ArticleVO article) {
		boardDAO.insertNewArticle(article);
		System.out.println("Ãâ·Â");
	}
	
}
