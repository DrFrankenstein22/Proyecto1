package com.example.bookmanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private List<String> books = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Lista de Libros</h1>");
        out.println("<ul>");
        for (String book : books) {
            out.println("<li>" + book + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='addBook.html'>Agregar nuevo libro</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newBook = request.getParameter("book");
        if (newBook != null && !newBook.trim().isEmpty()) {
            books.add(newBook);
        }
        response.sendRedirect("books");
    }
}
