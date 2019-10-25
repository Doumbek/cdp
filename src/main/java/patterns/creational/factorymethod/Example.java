package patterns.creational.factorymethod;

public class Example {

    public static void main(String[] args) {

        final Printer laserPrinter = new LaserPrinter();
        final Printer inkPrinter = new InkPrinter();

        laserPrinter.print();
        inkPrinter.print();

    }

}
