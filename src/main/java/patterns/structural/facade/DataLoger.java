package patterns.structural.facade;

public class DataLoger {


    public void logData(final String data) {
        System.out.println(String.format("Logging data -> %s", data));
    }
}
