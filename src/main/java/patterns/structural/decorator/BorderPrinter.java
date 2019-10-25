package patterns.structural.decorator;

public class BorderPrinter extends PrinterDecorator {

    public BorderPrinter(final Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Print the border!");
    }

}
