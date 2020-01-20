package models.dao;

import models.News;

import java.util.List;

public interface NewsDao {

    //add news item to db
    void addNews(News news);

    //return list of general news items
    List<News> getGeneralNews();

    //return departmental news
    List<News> getDepartmentNews(int departmentId);
}
