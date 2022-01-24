package reports;

import java.io.File;

import org.apache.log4j.Logger;

public class Log {


private static Logger Log = Logger.getLogger(Log.class.getName());
	
public static void startLog(String classname){
    Log.info("----------------------------------------------------------------");
    Log.info("           Testcase Execution Started For "+ classname           );
    Log.info("----------------------------------------------------------------");
}

//We can use it when ending tests
public static void endLog(){

    Log.info("----------------------------------------------------------------");
    Log.info("                  TestCase Execution Completed                  ");
    Log.info("----------------------------------------------------------------");
}

//Info Level Logs
public static void info (String message) {
    Log.info(message);
}

//Warn Level Logs
public static void warn (String message) {
    Log.warn(message);
}

//Error Level Logs
public static void error (String message) {
    Log.error(message);
}

//Fatal Level Logs
public static void fatal (String message) {
    Log.fatal(message);
}

//Debug Level Logs
public static void debug (String message) {
    Log.debug(message);
}
}
