package be.vdab.guestbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.guestbook.dao.GuestBookDao;
import be.vdab.guestbook.dao.impl.GuestBookDaoImpl;
import be.vdab.guestbook.model.GuestBookBean;

@WebServlet("/guestbook")
@ServletSecurity(value=@HttpConstraint(rolesAllowed="tomcat"))
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GuestBookDao dao;

	@Override
	public void init() throws ServletException {
		dao = new GuestBookDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", dao.getAllMessages());
		request.getRequestDispatcher("/WEB-INF/guestbook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PARAMETERS van inputvelden --> guestbook.jsp
		String name = request.getParameter("name");
		String message = request.getParameter("message");

		// In Bean plaatsen:
		GuestBookBean bean = new GuestBookBean(name, message);

		// Toevoegen aan database:
		dao.addMessage(bean);
		doGet(request, response);
	}

}
