package patterns.structural.adapter;

public class Example {

    public static void main(String[] args) {

        final Client basicClient = new BasicClient();

        final SpecificClient specificClient = new SpecificClient();
        final Client specificClientAdapter = new SpecificClientAdapter(specificClient);

        basicClient.doSomething();

        System.out.println("=================================");

        specificClientAdapter.doSomething();

    }

}
