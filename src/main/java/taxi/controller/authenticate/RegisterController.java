package taxi.controller.authenticate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.lib.Injector;
import taxi.model.Driver;
import taxi.service.DriverService;

public class RegisterController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(RegisterController.class);
    private static final String LICENSE_NUMBER = "license_number";
    private static final Injector injector = Injector.getInstance("taxi");
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/cars/drivers/register.jsp").forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        logger.info("RegisterController was called with params: Login "
                + login + " name " + name);
        String licenseNumber = req.getParameter(LICENSE_NUMBER);
        Driver driver = new Driver(name,licenseNumber,login,password);
        driverService.create(driver);
        resp.sendRedirect("/login");
    }
}
