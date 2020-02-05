package com.my.project.servlets;

import com.my.project.models.LinkModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Сервлет для очистки таблицы
* */
@WebServlet("/clear")
public class ClearList extends HttpServlet {

    private LinkModel linkModel = LinkModel.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        linkModel.clearList();
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
