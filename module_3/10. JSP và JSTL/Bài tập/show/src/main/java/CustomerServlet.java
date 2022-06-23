import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "download.jpg"));
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "download.jpg"));
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "download.jpg"));
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "download.jpg"));
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "download.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", customerList);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
