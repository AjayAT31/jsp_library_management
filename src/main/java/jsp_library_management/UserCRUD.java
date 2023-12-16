package jsp_library_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class UserCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root&password=root");
		return connection;
	}

	public int saveUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getPassword());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}

	public String login(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT PASSWORD FROM USER WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		
		String dbpass=null;
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			dbpass=resultSet.getString("password");
		}
		
		connection.close();
		return dbpass;
		
	}

	public List<User> displayUser() throws Exception {
		Connection connection =getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<User> list = new ArrayList<User>();
		
		while (resultSet.next()) {
			
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setPhone(resultSet.getLong("phone"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
		
			list.add(user);
		}
		connection.close();
		return list;
		
	}
	
	
	
	
}
