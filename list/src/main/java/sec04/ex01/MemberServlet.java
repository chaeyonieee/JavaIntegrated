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
		MemberDAO dao = new MemberDAO(); // SQL������ ��ȸ�� MemberDAO ��ü ����
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command"); // command ��(<hidden> �±׿��� �Ѱ��� ��)�� �޾ƿ�
		
		if (command != null && command.equals("addMember")) // ȸ�� ����â���� ���۵� command�� addMember�̸� ���۵� ������ �޾ƿ�
		{
			String _id = request.getParameter("id");		// ȸ�� ����â���� ���۵� ������ ���� MemberVO ��ü�� ���� �� SQL���� �̿��� ����
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
