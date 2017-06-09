/**
 *
 */
package fr.epita.subhash.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epita.subhash.services.IdentityJDBCDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.epita.subhash.datamodel.Identity;
import fr.epita.subhash.services.Dao;

/**
 * @author subhash
 */

@WebServlet(name="IdentityReadServlet", urlPatterns={"/searchIdentity"})
public class IdentityReadServlet extends HttpServlet{



    @Inject
    IdentityJDBCDAO dao;


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private static final Logger LOGGER = LogManager.getLogger(IdentityReadServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        try {
            Identity identity = new Identity();
            identity.setDisplayName(req.getParameter("name"));
            List<Identity> identities = dao.search(identity);
            if (identities.size()==1) {
                req.getSession().setAttribute("name", identities.get(0).getDisplayName());
                req.getSession().setAttribute("email", identities.get(0).getEmail());
                req.getSession().setAttribute("size", identities.size());
            }
            LOGGER.info("Results : ", identities.size());

        } catch(Exception e){
            LOGGER.info("Exception : ", e);

        }
        resp.sendRedirect("showOne.jsp");
    }
}
