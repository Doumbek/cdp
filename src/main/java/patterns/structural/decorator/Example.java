package patterns.structural.decorator;

public class Example {

    public static void main(String[] args) {

        final Printer printer1 = new LinePrinter(new BorderPrinter(new TextBasePrinter()));
        final Printer printer2 = new BorderPrinter(new LinePrinter(new TextBasePrinter()));

        printer1.print();

        System.out.println("==========================");

        printer2.print();
    }

}
