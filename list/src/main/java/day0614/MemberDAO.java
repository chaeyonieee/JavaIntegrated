package day0614;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import sec04.ex01.MemberVO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncoding=utf8",
					"root",
					"1234"
					);	
				}catch(Exception e) {
					e.printStackTrace();
			}
			}
			public List listMembers() {
				List list = new ArrayList();
				try {
					
					String query = "select * from t_member order by joinDate desc ";
					System.out.println("prepareStatement: "+query);
					pstmt = con.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						String id = rs.getString("id");
						String pwd = rs.getString("pwd");
						String name = rs.getString("name");
						String email = rs.getString("email");
						Date joinDate = rs.getDate("joinDate");
						MemberBean vo = new MemberBean();
						vo.setId(id);
						vo.setPwd(pwd);
						vo.setName(name);
						vo.setEmail(email);
						vo.setJoinDate(joinDate);
						list.add(vo);
						
					}
					rs.close();
					pstmt.close();
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
					
				}
				return list;
			}
			public void addMember(MemberBean memberBean) {
				try {
					
					String id = memberBean.getId();
					String pwd = memberBean.getPwd();
					String name = memberBean.getName();
					String email = memberBean.getEmail();
					Date joinDate = memberBean.getJoinDate();
					String query = "insert into t_member";
					query +=" (id,pwd,name,email,joinDate)";
					query += " values(?,?,?,?,now())";
					System.out.println("prppareStatement: "+query);
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, id);
					pstmt.setString(2, pwd);
					pstmt.setString(3, name);
					pstmt.setString(4, email);
				
					pstmt.executeUpdate();
					
					pstmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}

}
