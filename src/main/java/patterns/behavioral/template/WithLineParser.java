package patterns.behavioral.template;

public class WithLineParser extends FileParser {

    public WithLineParser(final String fileName) {
        super(fileName);
    }

    @Override
    public void parseFile() {
        System.out.println("Parse file using the first algorithm: " + getFileName());
    }

}
