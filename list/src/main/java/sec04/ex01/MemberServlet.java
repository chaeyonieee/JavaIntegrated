package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member100")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO(); // SQL문으로 조회할 MemberDAO 객체 생성
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command"); // command 값(<hidden> 태그에서 넘겨준 값)을 받아옴
		
		if (command != null && command.equals("addMember")) // 회원 가입창에서 전송된 command가 addMember이면 전송된 값들을 받아옴
		{
			String _id = request.getParameter("id");		// 회원 가입창에서 전송된 값들을 얻어와 MemberVO 객체에 저장 후 SQL문을 이용해 전달
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			dao.addMember(vo);
	}else if(command != null && command.equals("delMember")){
		String id = request.getParameter("id");
		dao.delMember(id);
	}
	List membersList = dao.listMembers();
	request.setAttribute("membersList", membersList);
	RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
	dispatch.forward(request, response);
		
	}
}
