package patterns.structural.facade;

public class Example {

    public static void main(String[] args) {

        final LogDataFacade logDataFacade = new LogDataFacade();

        logDataFacade.logData("I am Vitaliy", "Vitaliy");

        System.out.println("==================");

        logDataFacade.logData("I am Vasya", "Vasya");


    }

}
