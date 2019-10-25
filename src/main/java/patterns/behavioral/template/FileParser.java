package patterns.behavioral.template;

public abstract class FileParser {

    private String fileName;

    public FileParser(final String fileName) {
        this.fileName = fileName;
    }

    public void parse() {
        openFile();
        parseFile();
        countLineNumber();
        closeFile();
    }

    protected abstract void parseFile();

    protected void countLineNumber() {
        System.out.println("Count lines number as default parser: " + getFileName());
    }

    private void openFile() {
        System.out.println("Open file: " + getFileName());
    }

    private void closeFile() {
        System.out.println("Close file: " + getFileName());
    }

    protected String getFileName() {
        return fileName;
    }

}
