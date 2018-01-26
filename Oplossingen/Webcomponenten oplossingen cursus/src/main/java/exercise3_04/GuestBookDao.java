package exercise3_04;

import java.sql.*;
import java.util.*;

public class GuestBookDao {
   private String url;
   private String user;
   private String password;
   private static final String GET_QUERY = "select Date, Name, Message from GuestBook order by Date";
   private static final String UPDATE_QUERY = "insert into GuestBook (Date, Name, Message) values (?,?,?)";

   public void setUrl(String url) {
      this.url = url;
   }

   public void setDriver(String driver) throws ClassNotFoundException {
      Class.forName(driver);
   }

   public void setUser(String user) {
      this.user = user;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public List<GuestBookBean> getGuestBookItems() throws SQLException {
      List<GuestBookBean> messages = new ArrayList<GuestBookBean>();
      try (Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(GET_QUERY);) {
         while (rs.next()) {
            GuestBookBean bean = new GuestBookBean(rs.getTimestamp(1).toLocalDateTime(),
                  rs.getString(2), rs.getString(3));
            messages.add(bean);
         }
         return messages;
      }
   }

   public void addGuestBookItem(GuestBookBean item) throws SQLException {
      try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
         stmt.setTimestamp(1, Timestamp.valueOf(item.getDate()));
         stmt.setString(2, item.getName());
         stmt.setString(3, item.getMessage());
         stmt.executeUpdate();
      }
   }

   private Connection getConnection() throws SQLException {
      return DriverManager.getConnection(url, user, password);
   }

}
