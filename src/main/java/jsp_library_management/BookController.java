 package jsp_library_management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class BookController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		String author = req.getParameter("author");
		String genre = req.getParameter("genre");
		
		Books books = new Books();
		  books.setId(id);;
		  books.setName(name);
		  books.setAuthor(author);
		  books.setPrice(price);
		  books.setGenre(genre);
		  
		  BookCRUD crud = new BookCRUD();
		  
		  try {
			int result=crud.addBook(books);
			if (result!=0) {
				RequestDispatcher dispatcher =req.getRequestDispatcher("DisplayBook.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			resp.getWriter().print("Book Not Added");
			e.printStackTrace();
		}
	}
}
