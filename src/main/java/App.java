import com.google.gson.Gson;
import exception.ApiException;
import models.Department;
import models.News;
import models.User;
import models.dao.Sql2oDepartmentDao;
import models.dao.Sql2oNewsDao;
import models.dao.Sql2oUserDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Sql2oDepartmentDao departmentsDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao usersDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "mogere", "password");
        conn = sql2o.open();

        departmentsDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUserDao(sql2o);

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

        //add new user
        post("/user/new", "application/json", (req, res) -> {
            User newUser = gson.fromJson(req.body(), User.class);
            usersDao.add(newUser);
            res.status(201);
            return gson.toJson(newUser);
        });

        get("/user/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int userId = Integer.parseInt(req.params("id"));
            User userToFind = usersDao.getUserInfo(userId);

            if (userToFind == null){
                throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(userToFind);
        });



        //FILTERS

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });


        after((req, res) ->{
            res.type("application/json");
        });
    }
}
