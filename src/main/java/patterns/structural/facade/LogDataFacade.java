package patterns.structural.facade;

public class LogDataFacade {

    private AccessVerifier accessVerifier;
    private DataLoger dataLoger;

    public LogDataFacade() {
        this.accessVerifier = new AccessVerifier();
        this.dataLoger = new DataLoger();
    }

    public void logData(final String data, final String userName) {
        if(accessVerifier.hasAccess(userName)) {
            dataLoger.logData(data);
        } else {
            System.out.println("Access denied!");
        }
    }
}
