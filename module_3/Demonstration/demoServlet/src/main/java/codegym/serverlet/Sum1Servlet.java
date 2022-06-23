package codegym.serverlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sum1Servlet", urlPatterns = {"/sum1"})
public class Sum1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int first = Integer.parseInt(request.getParameter("first"));
        int second = Integer.parseInt(request.getParameter("second"));
        int sum = first + second;
        request.setAttribute("tong",sum);
        request.setAttribute("soThuNhat", first);
        request.setAttribute("soThuHai", second);
        // trả về tragn ResultSum.jsp và có
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ResultSum.jsp");
        requestDispatcher.forward(request,response);
//        response.setContentType("text/html");
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<h1> Ket Qua :" + sum + " </h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
