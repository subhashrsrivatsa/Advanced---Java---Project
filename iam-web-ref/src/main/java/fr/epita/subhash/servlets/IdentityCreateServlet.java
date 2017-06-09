/**
 *
 */
package fr.epita.subhash.servlets;

import fr.epita.subhash.datamodel.Identity;
import fr.epita.subhash.services.Dao;
import fr.epita.subhash.services.HibernateDAO;
import fr.epita.subhash.services.IdentityJDBCDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.inject.Inject;
import javax.inject.Qualifier;
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
@WebServlet(name="IdentityCreateServlet", urlPatterns={"/createIdentity"})
public class IdentityCreateServlet extends HttpServlet{



    @Inject
    public Dao<Identity> dao;


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private static final Logger LOGGER = LogManager.getLogger(IdentityCreateServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        LOGGER.info("dao instance is : {}", dao);

        LOGGER.info("Results : "+req.getParameter("name")+ req.getParameter("email"));
        Identity identity = new Identity("123", req.getParameter("name"), req.getParameter("email"));

        LOGGER.info(dao);
        try {
            dao.write(identity);
            LOGGER.info("Test save : "+identity.getId());
        } catch(Exception e){
            LOGGER.info("Error : "+e);
        }
        resp.sendRedirect("home.jsp");
    }
}
