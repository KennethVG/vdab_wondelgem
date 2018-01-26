package be.oak3.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.oak3.model.StickyBean;
import be.oak3.persistence.StickyDaoImpl;
import be.oak3.service.StickyService;
import be.oak3.service.StickyServiceImpl;

@WebServlet("/sticky")
public class StickyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StickyService service;

	@Resource(name = "myDS")
	private DataSource ds;

	@Override
	public void init() throws ServletException {
		service = new StickyServiceImpl(new StickyDaoImpl(ds));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String language = "";
		// Cookie[] cookies = request.getCookies();
		// if (cookies != null) {
		// for (Cookie cookie : cookies) {
		// if (cookie.getName().equals("language")) {
		// language = cookie.getValue();
		// }
		// }
		// }
		// if (language.equals("") || language == null) {
		// request.getRequestDispatcher("/language").forward(request, response);
		// }

		List<StickyBean> stickies = null;
		stickies = service.getAllStickies();

		request.setAttribute("stickies", stickies);
		request.getRequestDispatcher("/WEB-INF/sticky.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deleteOne = request.getParameter("mySticky");
		String btnToevoegen = request.getParameter("btn_toevoegen");
		String btnWissen = request.getParameter("btn_wissen");

		int result = 0;

		if (btnToevoegen != null) {
			result = service.addSticky(request.getParameter("newsticky"));

		} else if (btnWissen != null) {
			result = service.deleteAllStickies();

		} else if (deleteOne != null) {
			result = service.deleteStickyById(service.getStickyByValue(deleteOne).getId());
		}

		if (result != 0) {
			doGet(request, response);
		}
	}
}
