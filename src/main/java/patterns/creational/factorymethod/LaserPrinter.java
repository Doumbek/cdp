package patterns.creational.factorymethod;

public class LaserPrinter extends Printer {

    @Override
    protected Cartridge createCartridge() {
        return new LaserCartridge();
    }
}
