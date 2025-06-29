import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTest {

    // Logger instance
    private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);

    public static void main(String[] args) {
        logger.info("Starting application...");

        try {
            simulateTask();
        } catch (Exception e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }

        logger.warn("This is a warning about deprecated usage.");
        logger.info("Application finished.");
    }

    private static void simulateTask() throws Exception {
        logger.debug("Simulating task...");

        int a = 5;
        int b = 0;

        if (b == 0) {
            throw new ArithmeticException("Division by zero detected.");
        }

        int result = a / b;

        logger.info("Result is: {}", result);
    }
}