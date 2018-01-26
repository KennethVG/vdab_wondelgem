package eu.noelvaes.web;

import java.sql.*;
import java.util.*;
import javax.sql.*;

public class SqlService {
   private DataSource ds;

   public SqlService(DataSource ds) {
      this.ds = ds;
   }

   public List<String[]> getResult(String sql) throws SQLException {
      try (Connection con = ds.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery(sql)) {
         List<String[]> result = new ArrayList<>();
         ResultSetMetaData rsmd = rs.getMetaData();
         int columnCount = rsmd.getColumnCount();
         String[] row = new String[columnCount];
         result.add(row);
         for (int i = 0; i < columnCount; i++) {
            row[i] = rsmd.getColumnLabel(i + 1);
         }
         while (rs.next()) {
            row = new String[columnCount];
            result.add(row);
            for (int i = 0; i < columnCount; i++) {
               row[i] = rs.getString(i + 1);
            }
         }
         return result;
      }
   }
}
