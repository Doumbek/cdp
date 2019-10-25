package patterns.behavioral.template;

public class WithLineImprovedParser extends FileParser {

    public WithLineImprovedParser(final String fileName) {
        super(fileName);
    }

    @Override
    public void parseFile() {
        System.out.println("Parse file using the third algorithm:" + getFileName());
    }

    @Override
    public void countLineNumber() {
        System.out.println("Count lines number as improved parser: " + getFileName());
    }

}
