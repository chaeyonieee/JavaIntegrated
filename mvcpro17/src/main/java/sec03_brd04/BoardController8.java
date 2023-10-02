package sec03_brd04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;


@WebServlet("/board123/*")
public class BoardController8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	BoardService boardService;
	ArticleVO articleVO;

	public void init(ServletConfig config)throws ServletException{
		boardService = new BoardService();
		articleVO = new ArticleVO();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage="";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:"+action);
		try {
			List articlesList = new ArrayList();

		if(action==null) {
			articlesList = boardService.listArticles();
			request.setAttribute("articlesList", articlesList);
			nextPage = "/board_03/listArticles.jsp";
		}else if(action.equals("/listArticles.do")){
			articlesList = boardService.listArticles();
			request.setAttribute("articlesList", articlesList);
			nextPage = "/board_03/listArticles.jsp";	
			
		}else if(action.equals("/articleForm.do")){
			nextPage = "/board_03/articleForm.jsp";
			
		}else if (action.equals("/addArticle.do")) {
			int articleNO =0;
			Map<String, String> articleMap = upload(request,response);
			String title = articleMap.get("title");
			String content = articleMap.get("content");
			String imageFileName = articleMap.get("imageFileName");
			
			articleVO.setParentNO(0);
			articleVO.setId("bbb");
			articleVO.setTitle(title);
			articleVO.setContent(content);
			articleVO.setImageFileName(imageFileName);
			articleNO = boardService.addArticle(articleVO);
			if(imageFileName != null && imageFileName.length()!=0)
			{
				File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
				destDir.mkdir();
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
			}
			PrintWriter pw = response.getWriter();
			pw.print("<script>"+" alert('새글을 추가했습니다.');"
			+" location.href='"
					+request.getContextPath()
			+"/board123/listArticles.do';"+"</script>");
		
			return;
			
		}else if(action.equals("/viewArticle.do")) {
			String articleNO = request.getParameter("articleNO");
			articleVO=boardService.viewArticle(Integer.parseInt(articleNO));
			request.setAttribute("article", articleVO);
			nextPage = "/board_03/viewArticle.jsp";
		
		}else {
			nextPage = "/board_03/listArticles.jsp";
					
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}	
	private Map<String,String>upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> articleMap = new HashMap<String,String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++)
			{
				FileItem fileItem = (FileItem) items.get(i);
				if (fileItem.isFormField())
				{
					System.out.println(fileItem.getFieldName()
							+"="+fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				}else
				{
					System.out.println("파라미터이름:" + fileItem.getFieldName());
					System.out.println("파일이름:" + fileItem.getName());
					System.out.println("파일크기:" +fileItem.getSize()+"bytes");
					
					if(fileItem.getSize()>0)
					{
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx == -1)
						{
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx +1);
						articleMap.put(fileItem.getFieldName(),fileName);
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	return articleMap;
	
	}
}