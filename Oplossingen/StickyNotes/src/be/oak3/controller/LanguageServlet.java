package be.oak3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/language")
public class LanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LanguageServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/language.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = request.getParameter("language");
		Cookie cookie = new Cookie("language", language);
		cookie.setMaxAge(60000);
		response.addCookie(cookie);
		response.sendRedirect("/StickyNotes");
	}

}
