package jsp_library_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookCRUD {
		public Connection getConnection() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root&password=root");
			return connection;
		}

	public int addBook(Books books) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BOOK VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, books.getId());
		preparedStatement.setString(2, books.getName());
		preparedStatement.setInt(3, books.getPrice());
		preparedStatement.setString(4, books.getAuthor());
		preparedStatement.setString(5, books.getGenre());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	
	
	}