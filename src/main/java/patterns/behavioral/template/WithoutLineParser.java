package patterns.behavioral.template;

public class WithoutLineParser extends FileParser {

    public WithoutLineParser(final String fileName) {
        super(fileName);
    }

    @Override
    public void parseFile() {
        System.out.println("Parse file using the second algorithm:" + getFileName());
    }

    @Override
    public void countLineNumber() {
    }

}
