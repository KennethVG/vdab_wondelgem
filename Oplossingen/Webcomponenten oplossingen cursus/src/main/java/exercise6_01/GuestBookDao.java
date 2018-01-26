package exercise6_01;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;


public class GuestBookDao {
   private DataSource ds;
   private static final String GET_QUERY = "select Date, Name, Message from GuestBook order by Date asc";
   private static final String UPDATE_QUERY = "insert into GuestBook (Date, Name, Message) values (?,?,?)";

   public void setDataSource(DataSource ds) {
      this.ds = ds;
   }

   public List<GuestBookBean> getGuestBookItems() throws SQLException {
      List<GuestBookBean> messages = new ArrayList<GuestBookBean>();
      try (Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(GET_QUERY);) {
         while (rs.next()) {
            GuestBookBean bean = new GuestBookBean(rs.getTimestamp(1).toLocalDateTime(), rs.getString(2),
                  rs.getString(3));
            messages.add(bean);
         }
         return messages;
      }
   }

   public void addGuestBookItem(GuestBookBean item) throws SQLException {
      try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
         stmt.setTimestamp(1, Timestamp.valueOf(item.getDate()));
         stmt.setString(2, item.getName());
         stmt.setString(3, item.getMessage());
         stmt.executeUpdate();
      }
   }

   private Connection getConnection() throws SQLException {
      return ds.getConnection();
   }

}
