package patterns.structural.decorator;

public abstract class PrinterDecorator implements Printer {

    protected Printer printer;

    public PrinterDecorator(final Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print() {
        printer.print();
    }

}
