package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if("admin".equals(usuario) && "123".equals(senha)) {
			HttpSession session = request.getSession();  //criando uma sessão
			session.setAttribute("usuario", usuario);
			response.sendRedirect(request.getContextPath() + "/home.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/erro.jsp");
		}	
	}	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session != null) {
			session.invalidate();
		
		}
		
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}
}