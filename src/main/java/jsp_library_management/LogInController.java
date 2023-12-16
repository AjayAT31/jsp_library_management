package jsp_library_management;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/login")
public class LogInController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserCRUD crud = new UserCRUD();
		
		try {
			String dbpass=crud.login(email);
			if (password.equals(dbpass)) {
				
				List<User> user =crud.displayUser();
				req.setAttribute("list", user);

				RequestDispatcher dispatcher = req.getRequestDispatcher("Display.jsp");
				dispatcher.forward(req, resp);
				
				
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
