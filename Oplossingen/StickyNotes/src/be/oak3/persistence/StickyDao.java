package be.oak3.persistence;

import java.sql.SQLException;
import java.util.List;

import be.oak3.model.StickyBean;

public interface StickyDao {

	List<StickyBean> getAllStickies() throws SQLException;

	int deleteStickyById(int id) throws SQLException;

	int addSticky(String text) throws SQLException;

	int deleteAllStickies() throws SQLException;
	
	StickyBean getStickyByValue(String text) throws SQLException;

}
