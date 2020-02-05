package com.my.project.models;

import com.my.project.entity.Link;

import java.util.concurrent.CopyOnWriteArrayList;

/*
* Модель для управления списком ссылок
* */
public class LinkModel {
    private CopyOnWriteArrayList<Link> listLink = new CopyOnWriteArrayList<>();
    private static volatile LinkModel instance = null;

    public static LinkModel getInstance() {
        if (instance == null) {
            synchronized (LinkModel.class) {
                if (instance == null) {
                    instance = new LinkModel();
                }
            }
        }
        return instance;
    }

    public CopyOnWriteArrayList<Link> getListLink() {
        return listLink;
    }

    public void addLink(String name, String url) {
        listLink.add(new Link(name, url));
    }

    public void clearList() {
        listLink.clear();
    }
}
