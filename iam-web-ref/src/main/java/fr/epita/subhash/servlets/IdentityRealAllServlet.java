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

@WebServlet(name="IdentityReadAllServlet", urlPatterns={"/readIdentity"})
public class IdentityRealAllServlet extends HttpServlet{



    @Inject
    IdentityJDBCDAO dao;


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private static final Logger LOGGER = LogManager.getLogger(IdentityRealAllServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        try {
            Identity identity = new Identity();
            identity.setDisplayName(req.getParameter("name"));
            List<Identity> identities = dao.readAll();
            req.getSession().setAttribute("data", identities);
            req.getSession().setAttribute("size", identities.size());
            LOGGER.info("Results : ", identities.size());

        } catch(Exception e){
            LOGGER.info("Exception : ", e);

        }
        resp.sendRedirect("seeAll.jsp");
    }
}
