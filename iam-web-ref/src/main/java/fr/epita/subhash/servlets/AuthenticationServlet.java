/**
 * 
 */
package fr.epita.subhash.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.epita.subhash.datamodel.Identity;
import fr.epita.subhash.services.Dao;

/**
 * @author subhash
 *
 */

@WebServlet(name="AuthenticationServlet", urlPatterns={"/authenticate"})
public class AuthenticationServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger LOGGER = LogManager.getLogger(AuthenticationServlet.class);
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("pwd");
		LOGGER.info("tried to authenticate with this login {}", login);

		if (login.equals("TOM") && password.equals("TOM")) {
			req.getSession().setAttribute("user", login);
			resp.sendRedirect("home.jsp");
		} else {
			resp.sendRedirect("error.jsp");
		}
	}
}
