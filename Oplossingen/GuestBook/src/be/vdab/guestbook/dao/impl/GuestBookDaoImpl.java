package be.vdab.guestbook.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import be.vdab.guestbook.dao.GuestBookDao;
import be.vdab.guestbook.model.GuestBookBean;

public class GuestBookDaoImpl implements GuestBookDao {

	private static final String URL = "jdbc:mysql://noelvaes.eu/GuestBookDB";
	private static final String USER = "student";
	private static final String PASSWORD ="student123";
	
	@Override
	public List<GuestBookBean> getAllMessages() {
		String query = "SELECT  * FROM GuestBook;";
		List<GuestBookBean> list = new ArrayList<>();
		try (Connection con = getConnection();
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(query);) {

			while (resultSet.next()) {
				GuestBookBean bean = new GuestBookBean(resultSet.getString("Name"),resultSet.getString("Message"));
				bean.setDate(resultSet.getTimestamp("Date").toLocalDateTime());
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addMessage(GuestBookBean message) {
		String query = "INSERT INTO GuestBook (Name, Message) VALUES (? , ?);";
		int result = 0;

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, message.getName());
			statement.setString(2, message.getMessage());

			result = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	private Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL,USER, PASSWORD);
	}

}
