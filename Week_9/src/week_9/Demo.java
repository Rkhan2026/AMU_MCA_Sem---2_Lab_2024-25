package week_9;

//We use Log4j 2 as suggested by Faraz Sir For Week 9 Questions 
//which involve Log4j 2 and this is a demo class which is used to check
//that Log4j 2 is working and is printing on consoel and writing result to
//log file in logs Folder In Week_9 Project folder in file callled myLog

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
    private static final Logger logger = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        logger.info("Test INFO message");
        logger.error("Test ERROR message");
    }
}
