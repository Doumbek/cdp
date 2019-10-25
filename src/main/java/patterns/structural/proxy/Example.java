package patterns.structural.proxy;

public class Example {

    public static void main(String[] args) {

        final IDBConnection dbConnection = new DBConnection();
        final IDBConnection dbConnectionProxy = new DBConnectionProxy(dbConnection);
        final DBManager dbManager = new DBManager(dbConnectionProxy);

        dbManager.readDataFromDB();
        dbManager.readDataFromDB();

    }

}
