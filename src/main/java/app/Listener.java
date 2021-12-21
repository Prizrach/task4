package app;

import app.repository.GoodRepository;
import app.sql.SqlHelper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SqlHelper.initDB();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
