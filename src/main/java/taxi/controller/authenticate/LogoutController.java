package taxi.controller.authenticate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LogoutController.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("LogoutController was called");
        req.getSession().invalidate();
        resp.sendRedirect("/index");
    }
}
