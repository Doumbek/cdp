package patterns.behavioral.template;

public class Example {

    public static void main(String[] args) {

        final FileParser withLineParser = new WithLineParser("first_file");
        final FileParser withoutLineParser = new WithoutLineParser("second_file");
        final FileParser withLineImprovedParser = new WithLineImprovedParser("third_file");

        withLineParser.parse();

        System.out.println("=========================");

        withoutLineParser.parse();

        System.out.println("=========================");

        withLineImprovedParser.parse();

    }

}
