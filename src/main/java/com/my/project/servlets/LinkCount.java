package com.my.project.servlets;

import com.my.project.models.LinkModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/*
* Сервлет для получения и поиска ссылок по url
* */
@WebServlet("/main")
public class LinkCount extends HttpServlet {

    private LinkModel linkModel = LinkModel.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("links", linkModel.getListLink());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        linkModel.clearList();
        if (!searchLinksOnSite(req.getParameter("link"))) {                     //Валидация на корректность url
            req.setAttribute("error", "не удалось получить доступ по URL");
        }
        doGet(req, resp);
    }

    public boolean searchLinksOnSite(String url) {
        Document doc;
        try {
            new URL(url);
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        /*
        * Получение ссылок со страницы которые имеют имя и начинаются на http
        * */
        Elements links = doc.select("a[href]");
        for (Element element : links) {
            String href = element.attr("href");
            if (element.text().equals("") || href.length() < 5 || !href.substring(0, 4).contains("http")) continue;
            linkModel.addLink(element.text(), href);
        }
        return true;
    }
}
