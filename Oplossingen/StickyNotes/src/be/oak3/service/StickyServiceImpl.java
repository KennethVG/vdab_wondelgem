package be.oak3.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import be.oak3.model.StickyBean;
import be.oak3.persistence.StickyDao;

public class StickyServiceImpl implements StickyService {
	
	private StickyDao dao;
	
	public StickyServiceImpl(StickyDao dao) {
		this.dao= dao;
	}
	
	
	@Override
	public int addSticky(String text) {
		int result = 0;
		try {
			result = dao.addSticky(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAllStickies() {
		int result = 0;
		try {
			result = dao.deleteAllStickies();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}



	@Override
	public List<StickyBean> getAllStickies() {
		try {
			return dao.getAllStickies();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}


	@Override
	public int deleteStickyById(int id) {
		try {
			return dao.deleteStickyById(id);
		} catch (SQLException e) {
		
		}
		return 0;
	}


	@Override
	public StickyBean getStickyByValue(String text) {
		try {
			return dao.getStickyByValue(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new StickyBean();
	}

	
	
}
