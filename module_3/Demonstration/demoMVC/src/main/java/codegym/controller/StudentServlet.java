package codegym.controller;

import codegym.model.bean.Student;
import codegym.model.bean.StudentClass;
import codegym.model.service.StudentService;
import codegym.model.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                // thêm mới
                save(request,response);
                break;
            case "edit":
                // chỉnh sửa
                break;
            default:
                // hien thi danh sách

        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender =Boolean.getBoolean(request.getParameter("gender"));
        String birthday =request.getParameter("birthday");
        int point =Integer.parseInt(request.getParameter("point"));
//        String account =request.getParameter("account");
        int classId=Integer.parseInt(request.getParameter("classId"));
        String email = request.getParameter("email");
        Student student = new Student(name,gender,birthday,point,classId,email);
        boolean check= studentService.save(student);
        String mess ="";
        if (check){
            mess="Them moi thanh cong";
        }else {
            mess ="Them moi khong thanh cong";
        }
        request.setAttribute("mess", mess);
        List<Student> studentList = studentService.findAll();
        RequestDispatcher  requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        request.setAttribute("studentList", studentList);
        try {
           requestDispatcher.forward(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                // thêm mới
                showFormCreate(request,response);
                break;
            case "edit":
                // chỉnh sửa
                break;
            default:
                showListStudent(request,response);
                // hien thi danh sách

        }
//        RequestDispatcher  requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
//        request.setAttribute("studentList", studentList);
//        request.setAttribute("classList",studentClassList);
//        requestDispatcher.forward(request,response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        boolean gender =Boolean.getBoolean(request.getParameter("gender"));
//        String birthday =request.getParameter("birthday");
//        int point =Integer.parseInt(request.getParameter("point"));;
//        int classId=Integer.parseInt(request.getParameter("classId"));
//        String email = request.getParameter("email");
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentService.findAll();
        RequestDispatcher  requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        request.setAttribute("studentList", studentList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
