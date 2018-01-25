package be.vdab.guestbook.dao;

import java.util.List;

import be.vdab.guestbook.model.GuestBookBean;

public interface GuestBookDao {

	List<GuestBookBean> getAllMessages();

	int addMessage(GuestBookBean message);

}
