/*
        Written & Developed by KAJAL Kiran
*/
package core.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JReaders {
   public static Logger logger=null;
    //which  we want to create log file in my case Google is classname
    public static void readLogs() {
   logger = Logger.getLogger("Log4JReaders");
  String loggerpath=System.getProperty("user.dir");

        // configure log4j properties file
        PropertyConfigurator.configure(loggerpath+"/src/main/resources/log4j.properties");
    }

}
