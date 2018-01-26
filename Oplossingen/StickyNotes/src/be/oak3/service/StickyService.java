package be.oak3.service;

import java.util.List;

import be.oak3.model.StickyBean;

public interface StickyService {

	int addSticky(String text);

	int deleteAllStickies();

	List<StickyBean> getAllStickies();
	
	int deleteStickyById(int id);
	
	StickyBean getStickyByValue(String text);

}
