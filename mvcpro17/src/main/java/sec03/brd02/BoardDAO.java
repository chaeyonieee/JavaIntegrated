package sec03.brd02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/servletex");
					
		}catch(Exception e) {
			e.printStackTrace();
	}
	}
	public List selectAllArticles() {
		List articlesList = new ArrayList();
		try {
		    conn = dataFactory.getConnection();
			String query = /* "select * from t_board"; */
					
					"select case when level-1 > 0 then concat(concat(repeat(' ',level-1),'<'), board.title) else board.title end as title, board.articleNO, board.parentNO, result.level, board.content, board.id, board.writeDate"
					 + "  From" + " (select function_hierarchical() as articleNO, @level as level"
					 +" from(select @start_with:=0, @articleNO:=@start_with, @level:=0) tbl join t_board) result"
					 +" join t_board board on board.articleNO = result.articleNO";
			
			
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article);
			
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return articlesList;
	}
	private int getNewArticleNO()
	{
		try
		{
			conn = dataFactory.getConnection();
			String query = "SELECT max(articleNO) from t_board ";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			if(rs.next())
				return(rs.getInt(1) + 1);
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		return 0;
	}
public void insertNewArticle(ArticleVO article)
{
	try
	{
		conn = dataFactory.getConnection();
		int articleNO = getNewArticleNO();
		int parentNO = article.getParentNO();
		String title = article.getTitle();
		String content = article.getContent();
		String id = article.getId();
		String imageFileName = article.getImageFileName();
		String query = "INSERT INTO t_board (articleNO, parentNO, title, content, imageFileName, id)"
				+"  VALUES (?,?,?,?,?,?)";
		System.out.println(query);
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, articleNO);
		pstmt.setInt(2, parentNO);
		pstmt.setString(3, title);
		pstmt.setString(4, content);
		pstmt.setString(5, imageFileName);
		pstmt.setString(6, id);
		pstmt.executeUpdate();
		conn.close();
		
	}catch(Exception e)
	{
	e.printStackTrace();
	}
	}
}


