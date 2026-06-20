class Logger {
    // Private static instance
    private static Logger instance;

    // Private constructor
    private Logger() {
        System.out.println("Logger Instance Created");
    }

    // Public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {

        // Get Logger instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use logger
        logger1.log("Application Started");
        logger2.log("User Logged In");

        // Verify only one instance exists
        if (logger1 == logger2) {
            System.out.println("Only one Logger instance is created (Singleton Pattern Verified).");
        } else {
            System.out.println("Multiple instances exist.");
        }
    }
}