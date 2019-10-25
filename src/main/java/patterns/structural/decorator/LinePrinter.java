package patterns.structural.decorator;

public class LinePrinter extends PrinterDecorator {

    public LinePrinter(final Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Print the line!");
    }
}
