import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/DiscountServlet")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float Price = Float.parseFloat(request.getParameter("Price"));
        float Percent = Float.parseFloat(request.getParameter("Percent"));
        float Discount = (float) (Price * Percent * 0.01);

        request.setAttribute("Price", Price);
        request.setAttribute("Percent", Percent);
        request.setAttribute("Discount", ("Discount: " + Discount));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
