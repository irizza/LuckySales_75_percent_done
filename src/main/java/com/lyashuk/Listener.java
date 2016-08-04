package com.lyashuk;



        import javax.servlet.ServletContextEvent;
        import javax.servlet.ServletContextListener;
        import java.io.InputStream;
        import java.util.Properties;


public class Listener implements ServletContextListener {
    private static Properties properties = new Properties();


    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        InputStream is = servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/resources/application.properties");
        try {
            System.out.print(is);
            properties.load(is);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static Properties getProperties(){
        return properties;
    }
}
