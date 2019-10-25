package patterns.structural.adapter;

public class SpecificClientAdapter implements Client {

    private SpecificClient client;

    public SpecificClientAdapter(final SpecificClient client){
        this.client = client;
    }


    @Override
    public void doSomething() {
        client.doAsSpecificClient();
    }
}
