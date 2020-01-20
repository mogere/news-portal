import com.google.gson.Gson;
import models.Department;
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
        Sql2oNewsDao news;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "mogere", "password");
        conn = sql2o.open();

        departmentsDao = new Sql2oDepartmentDao(sql2o);


        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentsDao.addDepartment(department);
            res.status(201);
            return gson.toJson(department);
        });




        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
