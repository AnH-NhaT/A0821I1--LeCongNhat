package controller;

import model.dto.ProductDTO;
import model.entity.Category;
import model.entity.Product;
import model.service.CategoryService;
import model.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int countRows = productService.countRows() / 9 + 1;
        int[] rows = new int[countRows];
        for (int i = 0; i < countRows; i++) {
            rows[i] = i + 1;
        }

        String isSuccess = request.getParameter("isSuccess");
        String pageNum = request.getParameter("pageNum");
        String mess = "";
        if (isSuccess != null) {
            if (Integer.parseInt(isSuccess) == 0) mess = "false";
            else if (Integer.parseInt(isSuccess) == 1) mess = "true";
            request.setAttribute("mainList", productService.selectAll(0, 9));
            request.setAttribute("subList", categoryService.categoryList());
            request.setAttribute("mess", mess);
            request.setAttribute("rows", rows);
            request.setAttribute("lengthP", rows.length);
            request.setAttribute("pageNum", pageNum);
            request.getRequestDispatcher("view/display.jsp").forward(request, response);
            return;
        }
        if (pageNum != null) {
            request.setAttribute("mainList", getPage(Integer.parseInt(pageNum)));
            request.setAttribute("subList", categoryService.categoryList());
            request.setAttribute("rows", rows);
            request.setAttribute("lengthP", rows.length);
            request.setAttribute("pageNum", pageNum);
            request.getRequestDispatcher("view/display.jsp").forward(request, response);
            return;
        }

        request.setAttribute("mainList", productService.selectAll(0, 9));
        request.setAttribute("subList", categoryService.categoryList());
        request.setAttribute("rows", rows);
        request.setAttribute("lengthP", rows.length);
        request.setAttribute("pageNum", pageNum);
        request.getRequestDispatcher("view/display.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";
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
        }
    }

    protected List<ProductDTO> getPage(int pageNum) {
        return productService.selectAll((pageNum * 9), 9);
    }

    protected void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        String date = request.getParameter("date");
        boolean type = Boolean.parseBoolean(request.getParameter("type"));
        int isSuccess = productService.save(new Product(id, name, price, quantity, color, description, category_id, date, type));
        if (isSuccess == 1) response.sendRedirect("Servlet?isSuccess=1");
        else response.sendRedirect("Servlet?isSuccess=0");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int isSuccess = productService.delete(id);
        if (isSuccess == 1) response.sendRedirect("Servlet?isSuccess=1");
        else response.sendRedirect("Servlet?isSuccess=0");
    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String na = request.getParameter("na");
        String co = request.getParameter("co");
        String ca = request.getParameter("ca");
        request.setAttribute("mainList", productService.search(na, co, ca));
        request.setAttribute("subList", categoryService.categoryList());
        request.getRequestDispatcher("view/display.jsp").forward(request, response);
    }
}
