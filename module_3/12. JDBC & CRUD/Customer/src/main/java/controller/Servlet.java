package controller;

import model.Customer;
import model.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "Servlet", value = "/Home")
public class Servlet extends HttpServlet {
    @WebFilter(filterName = "encodingFilter", urlPatterns = "/*")
    public static class EncodingFilter implements Filter {
        @Override
        public void init(final FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {
        }
    }

    private Service service;

    public void init() throws ServletException {
        service = new Service();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        try {
            switch (action) {
                case "desc":
                    desc(request, response);
                    break;
                case "asc":
                    asc(request, response);
                    break;
                default:
                    display(service.getAll(), request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        try {
            switch (action) {
                case "save":
                    save(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "search":
                    search(request, response);
                    break;
                default:
                    display(service.getAll(), request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void display(List<Customer> list, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        request.setAttribute("customerList", list);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        display(service.search(request.getParameter("words")), request, response);
    }

    protected void asc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        display(service.asc(), request, response);
    }

    protected void desc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        display(service.desc(), request, response);
    }

    protected void save(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String nation = request.getParameter("nation");
        service.save(new Customer(id, name, email, nation));
        response.sendRedirect("/Home");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        service.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/Home");
    }
}