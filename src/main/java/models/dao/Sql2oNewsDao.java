package models.dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oNewsDao implements NewsDao {
    private final Sql2o sql2o;

    public Sql2oNewsDao( Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void addNews(News news) {
        String sql = "INSERT INTO departments (name, description) VALUES (:name, :description)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setNewsId(id);
        }
        catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<News> getGeneralNews() {
        return null;
    }

    @Override
    public List<News> getDepartmentNews(int departmentId) {
        List<News> allDeptNews = new ArrayList<>();
        try (Connection con = sql2o.open()) {
             allDeptNews.add(con.createQuery("SELECT * FROM news WHERE department_id = :id")
                    .addParameter("id", departmentId)
                    .executeAndFetchFirst(News.class));
        }
        return allDeptNews;
    }
}
