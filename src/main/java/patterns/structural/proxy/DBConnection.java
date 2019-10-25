package patterns.structural.proxy;

public class DBConnection implements IDBConnection{

    @Override
    public String readData() {
        return "Data from database";
    }
}
