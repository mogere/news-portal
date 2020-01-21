import com.google.gson.Gson;
import models.Department;
import models.News;
import models.dao.Sql2oDepartmentDao;
import models.dao.Sql2oNewsDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Sql2oDepartmentDao departmentsDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "mogere", "password");
        conn = sql2o.open();

        departmentsDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);

        //add new department
        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentsDao.addDepartment(department);
            res.status(201);
            return gson.toJson(department);
        });

        //get all departments
        get("/departments", "application/json", (req, res) -> {
            return gson.toJson(departmentsDao.allDepartments());//send it back to be displayed
        });

        //add new news item
        post("/news/new", "application/json", (req, res) -> {
            News newsItem = gson.fromJson(req.body(), News.class);
            newsDao.addNews(newsItem);
            res.status(201);
            return gson.toJson(newsItem);
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
