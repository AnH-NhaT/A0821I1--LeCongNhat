package codegym.serverlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "hellServlet",urlPatterns = {"/xin-chao"})
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("hàm init được gọi");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGe duoc goi ");
        String name = request.getParameter("ten");
        System.out.println("hello "+ name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" doPost duoc goi");
        String name = req.getParameter("ten");
        System.out.println("hello "+ name);
    }

    @Override
    public void destroy() {
        System.out.println(" ham destroy dduocj gọi");
    }
}
