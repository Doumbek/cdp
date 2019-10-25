package patterns.creational.factorymethod;

public class InkPrinter extends Printer {

    @Override
    protected Cartridge createCartridge() {
        return new InkCartridge();
    }

}
