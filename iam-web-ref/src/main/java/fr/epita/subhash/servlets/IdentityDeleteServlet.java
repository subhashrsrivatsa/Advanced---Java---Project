/**
 *
 */
package fr.epita.subhash.servlets;

import fr.epita.subhash.datamodel.Identity;
import fr.epita.subhash.services.IdentityJDBCDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author subhash
 */

@WebServlet(name="IdentityDeleteServlet", urlPatterns={"/deleteIdentity"})
public class IdentityDeleteServlet extends HttpServlet{



    @Inject
    IdentityJDBCDAO dao;


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private static final Logger LOGGER = LogManager.getLogger(IdentityDeleteServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        try {
            Identity identity = new Identity();
            identity.setDisplayName(req.getParameter("name"));
            boolean status = dao.delete(identity);

                req.getSession().setAttribute("status", status);
            LOGGER.info("Status : ", status);

        } catch(Exception e){
            LOGGER.info("Exception : ", e);

        }
        resp.sendRedirect("success.jsp");
    }
}
