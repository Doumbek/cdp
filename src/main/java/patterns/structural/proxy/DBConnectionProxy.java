package patterns.structural.proxy;

import java.util.Objects;

public class DBConnectionProxy implements IDBConnection {

    private IDBConnection dbConnection;
    private String cachedData;

    public DBConnectionProxy(final IDBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public String readData() {
        if(Objects.isNull(cachedData)) {
            System.out.println("Save db data to cache.");
            cachedData = dbConnection.readData();
        }
        System.out.println("Read data from cache");
        return cachedData;
    }

}
