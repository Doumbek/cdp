package patterns.structural.proxy;

public class DBManager {

    private IDBConnection dbConnection;

    public DBManager(final IDBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void readDataFromDB() {
        System.out.println(String.format("Actual data from DB is: [%s]",
                dbConnection.readData()));
    }
}
